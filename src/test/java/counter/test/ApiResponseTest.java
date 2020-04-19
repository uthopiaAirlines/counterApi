package counter.test;

import org.springframework.boot.test.context.SpringBootTest;

import counter.api.ApiResponseMessage;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

@SpringBootTest(classes = ApiResponseMessage.class)
public class ApiResponseTest {

    @Test
    void constructorTest() {
        ApiResponseMessage a = new ApiResponseMessage();
        ApiResponseMessage b = new ApiResponseMessage(1, "error");
        ApiResponseMessage c = new ApiResponseMessage(2, "warning");
        ApiResponseMessage d = new ApiResponseMessage(3, "info");
        ApiResponseMessage e = new ApiResponseMessage(4, "ok");
        ApiResponseMessage f = new ApiResponseMessage(5, "too busy");
        ApiResponseMessage g = new ApiResponseMessage(6, "too busy");
    }

    @Test
    void getTest() {
        ApiResponseMessage b = new ApiResponseMessage(1, "error");
        assertEquals(1, b.getCode());
        assertEquals("error", b.getMessage());
        assertEquals("error", b.getType());
    }
}