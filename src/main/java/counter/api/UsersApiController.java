package counter.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import counter.model.User;
import counter.service.UserService;
import io.swagger.annotations.ApiParam;
import software.amazon.awssdk.core.exception.SdkException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@CrossOrigin
@Controller
public class UsersApiController implements UsersApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    UserService userService;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Void> usersPost(@ApiParam(value = "", required = true) @Valid @RequestBody User body) {
        try {
            userService.saveUser(body);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (SdkException e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Void> usersUserIdPut(@ApiParam(value = "", required = true) @Valid @RequestBody User body,
            @ApiParam(value = "", required = true) @PathVariable("username") String username) {
        try {
            userService.updateUser(username, body);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (SdkException e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Void> usersUserIdDelete(
            @ApiParam(value = "", required = true) @PathVariable("username") String username) {
        try {
            userService.deleteUser(username);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (SdkException e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
