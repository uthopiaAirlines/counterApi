package counter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import counter.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{

    List<Flight> findByFlightIdOrAirlineOrArrivalTimeOrArrivalLocationOrDepartureTimeOrDepartureLocationOrAvailableSeatsOrPrice(Integer flightId, Integer airline, OffsetDateTime arrivalTime, Integer arrivalLocation, OffsetDateTime departureTime, Integer departureLocation, Integer availableSeats, BigDecimal price);
}