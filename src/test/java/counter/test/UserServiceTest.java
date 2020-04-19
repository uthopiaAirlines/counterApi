package counter.test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import counter.service.UserService;

@SpringBootTest(classes = UserService.class)
public class UserServiceTest {

    UserService userService = new UserService();

    @Test
    void calculateSecretHashTest() {
        assertEquals(String.class, userService.calculateSecretHash("2dlb0mog85rvn43g5inhnqb111", "1v0c8kiahic5pd1td1tb9n7n3ioe3mv43igftp9vs07lv45k4nk2", "userName").getClass());
    }
}