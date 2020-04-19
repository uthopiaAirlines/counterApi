package counter.api;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import counter.model.User;
import counter.service.UserService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
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
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> usersPost(@ApiParam(value = "", required = true) @Valid @RequestBody User body) {
        return new ResponseEntity<Void>(HttpStatus.valueOf(userService.saveUser(body)));
    }

    @Override
    public ResponseEntity<Void> usersUserIdPut(@ApiParam(value = "", required = true) @Valid @RequestBody User body,
            @ApiParam(value = "", required = true) @PathVariable("username") String username) {
        return new ResponseEntity<Void>(HttpStatus.valueOf(userService.updateUser(username, body)));
    }

    public ResponseEntity<Void> usersUserIdDelete(
            @ApiParam(value = "", required = true) @PathVariable("username") String username) {
        return new ResponseEntity<Void>(HttpStatus.valueOf(userService.deleteUser(username)));
    }
}
