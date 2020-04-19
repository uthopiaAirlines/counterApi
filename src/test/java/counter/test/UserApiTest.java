package counter.test;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import counter.api.UsersApiController;
import counter.model.User;
import counter.service.UserService;

@TestInstance(Lifecycle.PER_CLASS)
@OverrideAutoConfiguration(enabled = true)
@WebMvcTest(UsersApiController.class)
public class UserApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void whenValidPostRequestExpectCREATED() throws Exception {
        doNothing().when(userService).saveUser(isA(User.class));
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL_VALUE).content(
                "{\"name\":\"Sdk Test\",\"phone\":\"+14823689546\",\"email\":\"asdf@fdsa.com\",\"password\":\"Ss@12345\",\"username\":\"sdk_test\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    void whenValidPutRequestExpectNO_CONTENT() throws Exception {
        doNothing().when(userService).updateUser(isA(String.class), isA(User.class));
        mockMvc.perform(put("/users/{username}", "asdf").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL_VALUE).content(
                        "{\"name\":\"Sdk Test\",\"phone\":\"+14823689546\",\"email\":\"asdf@fdsa.com\",\"password\":\"Ss@12345\",\"username\":\"sdk_test\"}"))
                .andExpect(status().isNoContent());
    }

    @Test
    void whenValidDeleteRequestExpectNO_CONTENT() throws Exception {
        doNothing().when(userService).deleteUser(isA(String.class));
        mockMvc.perform(delete("/users/{username}", "asdf").accept(MediaType.ALL_VALUE))
                .andExpect(status().isNoContent());
    }
}