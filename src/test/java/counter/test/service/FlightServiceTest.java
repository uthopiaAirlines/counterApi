package counter.test.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import counter.service.FlightService;

@SpringBootTest(classes = FlightService.class)
@AutoConfigureMockMvc
class FlightServiceTest {

	@Test
	void testGetFlights() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFlightsByCriterion() {
		fail("Not yet implemented");
	}

}
