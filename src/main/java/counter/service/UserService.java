package counter.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import counter.model.User;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminConfirmSignUpRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminDeleteUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminInitiateAuthRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminInitiateAuthResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.SignUpRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.SignUpResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.UpdateUserAttributesRequest;

@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);
    CognitoIdentityProviderClient client = CognitoIdentityProviderClient.create();

    public void saveUser(User user) {
        AttributeType aType1 = AttributeType.builder().name("email").value(user.getEmail()).build();

        AttributeType aType2 = AttributeType.builder().name("phone_number").value(user.getPhone()).build();

        AttributeType aType3 = AttributeType.builder().name("name").value(user.getName()).build();

        SignUpRequest signUpRequest = SignUpRequest.builder().username(user.getUsername()).password(user.getPassword())
                .clientId("2dlb0mog85rvn43g5inhnqb111")
                .secretHash(calculateSecretHash("2dlb0mog85rvn43g5inhnqb111",
                        "1v0c8kiahic5pd1td1tb9n7n3ioe3mv43igftp9vs07lv45k4nk2", user.getUsername()))
                .userAttributes(new AttributeType[] { aType1, aType2, aType3 }).build();
        AdminConfirmSignUpRequest confirmSignUpRequest = AdminConfirmSignUpRequest.builder()
                .username(user.getUsername()).userPoolId("us-east-1_iPhgdkopW").build();
        try {
            SignUpResponse result = client.signUp(signUpRequest);
            client.adminConfirmSignUp(confirmSignUpRequest);
            log.info(result.toString());
        } catch (SdkException e) {
            log.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
            throw e;
        }
    }

    public void updateUser(String username, User user) {
        Map<String, String> authParameters = new HashMap<String, String>();
        authParameters.put("USERNAME", username);
        authParameters.put("PASSWORD", user.getPassword());
        authParameters.put("SECRET_HASH", calculateSecretHash("2dlb0mog85rvn43g5inhnqb111",
                "1v0c8kiahic5pd1td1tb9n7n3ioe3mv43igftp9vs07lv45k4nk2", user.getUsername()));
        AdminInitiateAuthRequest authRequest = AdminInitiateAuthRequest.builder().authFlow("ADMIN_USER_PASSWORD_AUTH")
                .authParameters(authParameters).clientId("2dlb0mog85rvn43g5inhnqb111").userPoolId("us-east-1_iPhgdkopW")
                .build();
        String accessToken;
        try {
            AdminInitiateAuthResponse authResponse = client.adminInitiateAuth(authRequest);
            accessToken = authResponse.authenticationResult().accessToken();
        } catch (SdkException e) {
            log.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
            throw e;
        }
        AttributeType aType1 = AttributeType.builder().name("email").value(user.getEmail()).build();

        AttributeType aType2 = AttributeType.builder().name("phone_number").value(user.getPhone()).build();

        AttributeType aType3 = AttributeType.builder().name("name").value(user.getName()).build();

        UpdateUserAttributesRequest updateUserAttributesRequest = UpdateUserAttributesRequest.builder()
                .accessToken(accessToken).userAttributes(new AttributeType[] { aType1, aType2, aType3 }).build();
        try {
            client.updateUserAttributes(updateUserAttributesRequest);
        } catch (SdkException e) {
            log.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
            throw e;
        }
    }

    public void deleteUser(String username) {
        AdminDeleteUserRequest adminDeleteUserRequest = AdminDeleteUserRequest.builder()
                .userPoolId("us-east-1_iPhgdkopW").username(username).build();
        try {
            client.adminDeleteUser(adminDeleteUserRequest);
        } catch (SdkException e) {
            log.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
            throw e;
        }
    }

    private String calculateSecretHash(String userPoolClientId, String userPoolClientSecret, String userName) {
        final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

        SecretKeySpec signingKey = new SecretKeySpec(userPoolClientSecret.getBytes(StandardCharsets.UTF_8),
                HMAC_SHA256_ALGORITHM);
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            mac.init(signingKey);
            mac.update(userName.getBytes(StandardCharsets.UTF_8));
            byte[] rawHmac = mac.doFinal(userPoolClientId.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(rawHmac);
        } catch (Exception e) {
            throw new RuntimeException("Error while calculating ");
        }
    }
}