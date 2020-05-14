package counter.api;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import counter.model.AwsUser;
import counter.model.User;
import counter.api.UsersApi;
import counter.service.UserService;
import io.swagger.annotations.ApiParam;
import software.amazon.awssdk.core.exception.SdkException;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@CrossOrigin("https://www.utopiaairlines.com")
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
    @CrossOrigin("https://www.utopiaairlines.com")
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
    @CrossOrigin("https://www.utopiaairlines.com")
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
    @CrossOrigin("https://www.utopiaairlines.com")
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
    
    @CrossOrigin("https://www.utopiaairlines.com")
    @RequestMapping(value = "/v2/counter/users", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<AwsUser>>getUsers(){
    	try {
    		List<AwsUser> response = userService.getAllUsers();
    		return new ResponseEntity<List<AwsUser>>(response, HttpStatus.OK);
    	}catch(Exception e) {
    		System.out.println(e);
    		return new ResponseEntity<List<AwsUser>>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
