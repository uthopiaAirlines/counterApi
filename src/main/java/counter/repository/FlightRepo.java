package counter.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import counter.model.Flight;

@Repository
public interface FlightRepo extends PagingAndSortingRepository<Flight, Integer>{

    List<Flight> findByFlightIdOrAirlineOrArrivalTimeOrArrivalLocationOrDepartureTimeOrDepartureLocationOrAvailableSeatsOrPrice(Integer flightId, Integer airline, OffsetDateTime arrivalTime, Integer arrivalLocation, OffsetDateTime departureTime, Integer departureLocation, Integer availableSeats, BigDecimal price);
    List<Flight> findByAirlineNameContainsIgnoreCaseOrArrivalTimeOrArrivalLocationNameContainsIgnoreCaseOrDepartureTimeOrDepartureLocationNameContainsIgnoreCaseOrAvailableSeatsOrPrice(String airlineName, OffsetDateTime arrivalTime, String arrivalLocationName, OffsetDateTime departureTime, String departureLocationName, Integer availableSeats, BigDecimal price, Pageable page);
    long countByAirlineNameContainsIgnoreCaseOrArrivalTimeOrArrivalLocationNameContainsIgnoreCaseOrDepartureTimeOrDepartureLocationNameContainsIgnoreCaseOrAvailableSeatsOrPrice(String airlineName, OffsetDateTime arrivalTime, String arrivalLocationName, OffsetDateTime departureTime, String departureLocationName, Integer availableSeats, BigDecimal price);
}