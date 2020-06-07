package counter.test.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import counter.model.Flight;
import counter.repository.FlightRepo;

@SpringBootTest
@AutoConfigureMockMvc
class FlightRepoTest {

	@Autowired
	private FlightRepo flightRepo;
	
	@Test
	void customFlightTest1() {
		Pageable reqPage = PageRequest.of(0, 6);
		OffsetDateTime testDate = OffsetDateTime.now();
		List<Flight> flightList = flightRepo.findByAirlineNameContainsIgnoreCaseOrArrivalTimeOrArrivalLocationNameContainsIgnoreCaseOrDepartureTimeOrDepartureLocationNameContainsIgnoreCaseOrAvailableSeatsOrPrice("a", testDate, "a", testDate, "a", Integer.valueOf(1), new BigDecimal("230.24"), reqPage);
		assertTrue(flightList.size() > 0 && flightList.size() <= 6);
		flightList.forEach(flight ->{
			assertTrue((flight.getAirline().getName().contains("a")||flight.getArrivalLocation().getName().contains("a")
					||flight.getDepartureLocation().getName().contains("a")||flight.getArrivalTime().equals(testDate)
					||flight.getArrivalTime().equals(testDate)||flight.getAvailableSeats().equals(1)
					||flight.getPrice().equals(new BigDecimal("230.24"))));
		});
		assertEquals(Flight.class, flightList.get(0).getClass());
	}
	
	@Test
	void customFlightTest2() {
		assertTrue(flightRepo.countByAirlineNameContainsIgnoreCaseOrArrivalTimeOrArrivalLocationNameContainsIgnoreCaseOrDepartureTimeOrDepartureLocationNameContainsIgnoreCaseOrAvailableSeatsOrPrice(
				"a", OffsetDateTime.now(), "a", OffsetDateTime.now(), "a", Integer.valueOf(1), new BigDecimal("230.24"))>0);
	}

}
