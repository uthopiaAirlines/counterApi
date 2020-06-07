package counter.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import counter.Swagger2SpringBoot;
import counter.model.User;
import counter.model.User.UserRoleEnum;

@SpringBootTest(classes = Swagger2SpringBoot.class)
public class UserTest {

    User user = new User();

    @BeforeEach
    void setUser() {
        user.setAddress("123");
        user.setEmail("a@a.com");
        user.setName("name");
        user.setPassword("password");
        user.setPhone("+11234567891");
        user.setUserId(1);
        user.setUserRole(UserRoleEnum.CUSTOMER);
        user.setUsername("username");
    }

    @Test
    void addressTest() {
        User user1 = user.address("address");
        assertEquals("address", user1.getAddress());
    }

    @Test
    void emailTest() {
        User user1 = user.email("address@emila.com");
        assertEquals("address@emila.com", user1.getEmail());
    }

    @Test
    void nameTest() {
        User user1 = user.name("name1");
        assertEquals("name1", user1.getName());
    }

    @Test
    void passwordTest() {
        User user1 = user.password("address");
        assertEquals("address", user1.getPassword());
    }

    @Test
    void phoneTest() {
        User user1 = user.phone("+11111111111");
        assertEquals("+11111111111", user1.getPhone());
    }

    @Test
    void userIdTest() {
        User user1 = user.userId(2);
        assertEquals(Integer.valueOf(2), user1.getUserId());
    }

    @Test
    void userRoleTest() {
        User user1 = user.userRole(UserRoleEnum.COUNTER);
        assertEquals(UserRoleEnum.COUNTER, user1.getUserRole());
    }

    @Test
    void usernameTest() {
        User user1 = user.username("asdf");
        assertEquals("asdf", user1.getUsername());
    }

    @Test
    public void toStringTest() {
        assertEquals(String.class, user.toString().getClass());
        user.setAddress(null);
        assertEquals(String.class, user.toString().getClass());
    }

    @Test
    void equalsTest() {
        User user1 = new User();
        user1.setAddress("123");
        user1.setEmail("a@a.com");
        user1.setName("name");
        user1.setPassword("password");
        user1.setPhone("+11234567891");
        user1.setUserId(1);
        user1.setUserRole(UserRoleEnum.CUSTOMER);
        user1.setUsername("username");
        assertTrue(user.equals(user1));
        assertEquals(user.hashCode(), user1.hashCode());
        assertTrue(user.equals(user.userId(1)));
        user1.setUserId(10);
        assertFalse(user.equals(user1));
        assertFalse(user.equals(null));
    }

    @Test
    void userRoleEnumTest() {
        UserRoleEnum ure = UserRoleEnum.fromValue("Agent");
        assertEquals(UserRoleEnum.AGENT, ure);
        ure = UserRoleEnum.fromValue("wrong");
        assertEquals(null, ure);
    }
}