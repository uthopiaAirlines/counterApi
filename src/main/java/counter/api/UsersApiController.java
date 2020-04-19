package counter.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import counter.model.User;
import io.swagger.annotations.ApiParam;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClientBuilder;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminConfirmSignUpRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminConfirmSignUpResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminCreateUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminDeleteUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminInitiateAuthRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminInitiateAuthResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ConfirmSignUpRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.DeleteUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.SignUpRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.SignUpResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.UpdateUserAttributesRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@Controller
public class UsersApiController implements UsersApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private Environment env;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> usersPost(@ApiParam(value = "", required = true) @Valid @RequestBody User body) {
        CognitoIdentityProviderClient client = CognitoIdentityProviderClient.create();
        AttributeType aType1 = AttributeType.builder().name("email").value(body.getEmail()).build();

        AttributeType aType2 = AttributeType.builder().name("phone_number").value(body.getPhone()).build();

        AttributeType aType3 = AttributeType.builder().name("name").value(body.getName()).build();

        SignUpRequest signUpRequest = SignUpRequest.builder().username(body.getUsername()).password(body.getPassword())
                .clientId("2dlb0mog85rvn43g5inhnqb111")
                .secretHash(calculateSecretHash("2dlb0mog85rvn43g5inhnqb111",
                        "1v0c8kiahic5pd1td1tb9n7n3ioe3mv43igftp9vs07lv45k4nk2", body.getUsername()))
                .userAttributes(new AttributeType[] { aType1, aType2, aType3 }).build();
        AdminConfirmSignUpRequest confirmSignUpRequest = AdminConfirmSignUpRequest.builder()
                .username(body.getUsername()).userPoolId("us-east-1_iPhgdkopW").build();
        try {
            SignUpResponse result = client.signUp(signUpRequest);
            client.adminConfirmSignUp(confirmSignUpRequest);
            log.info(result.toString());
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Void> usersUserIdPut(@ApiParam(value = "", required = true) @Valid @RequestBody User body,
            @ApiParam(value = "", required = true) @PathVariable("username") String username) {
        CognitoIdentityProviderClient client = CognitoIdentityProviderClient.create();
        Map<String, String> authParameters = new HashMap<String, String>();
        authParameters.put("USERNAME", username);
        authParameters.put("PASSWORD", body.getPassword());
        authParameters.put("SECRET_HASH", calculateSecretHash("2dlb0mog85rvn43g5inhnqb111",
                "1v0c8kiahic5pd1td1tb9n7n3ioe3mv43igftp9vs07lv45k4nk2", body.getUsername()));
        AdminInitiateAuthRequest authRequest = AdminInitiateAuthRequest.builder().authFlow("ADMIN_USER_PASSWORD_AUTH")
                .authParameters(authParameters).clientId("2dlb0mog85rvn43g5inhnqb111").userPoolId("us-east-1_iPhgdkopW")
                .build();
        String accessToken;
        try {
            AdminInitiateAuthResponse authResponse = client.adminInitiateAuth(authRequest);
            accessToken = authResponse.authenticationResult().accessToken();
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        AttributeType aType1 = AttributeType.builder().name("email").value(body.getEmail()).build();

        AttributeType aType2 = AttributeType.builder().name("phone_number").value(body.getPhone()).build();

        AttributeType aType3 = AttributeType.builder().name("name").value(body.getName()).build();

        UpdateUserAttributesRequest updateUserAttributesRequest = UpdateUserAttributesRequest.builder()
                .accessToken(accessToken).userAttributes(new AttributeType[] { aType1, aType2, aType3})
                .build();
        try {
            client.updateUserAttributes(updateUserAttributesRequest);
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> usersUserIdDelete(
            @ApiParam(value = "", required = true) @PathVariable("username") String username) {
        CognitoIdentityProviderClient client = CognitoIdentityProviderClient.create();
        AdminDeleteUserRequest adminDeleteUserRequest = AdminDeleteUserRequest.builder()
                .userPoolId("us-east-1_iPhgdkopW").username(username).build();
        try {
            client.adminDeleteUser(adminDeleteUserRequest);
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public static String calculateSecretHash(String userPoolClientId, String userPoolClientSecret, String userName) {
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
