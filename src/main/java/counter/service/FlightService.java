package counter.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import counter.model.Flight;
import counter.repository.FlightRepo;

@Service
@Transactional
public class FlightService {

    @Autowired
    FlightRepo flightRepository;

    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getFlightsByCriterion(Object criterion) {
        Integer flightId, airline, arrivalLocation, departureLocation, availableSeats;
        OffsetDateTime arrivalTime, departureTime;
        BigDecimal price;
        if (criterion instanceof Integer) {
            flightId = (Integer) criterion;
            airline = (Integer) criterion;
            arrivalLocation = (Integer) criterion;
            departureLocation = (Integer) criterion;
            availableSeats = (Integer) criterion;
        }
        else {
            flightId = -1;
            airline = -1;
            arrivalLocation = -1;
            departureLocation = -1;
            availableSeats = -1;
        }
        if (criterion instanceof OffsetDateTime) {
            arrivalTime = (OffsetDateTime) criterion;
            departureTime = (OffsetDateTime) criterion;
        }
        else {
            arrivalTime = OffsetDateTime.now().minusYears(40);
            departureTime = OffsetDateTime.now().minusYears(40);
        }
        if (criterion instanceof BigDecimal) {
            price = (BigDecimal) criterion;
        }
        else {
            price = new BigDecimal(-1);
        }
        return flightRepository.findByFlightIdOrAirlineOrArrivalTimeOrArrivalLocationOrDepartureTimeOrDepartureLocationOrAvailableSeatsOrPrice(flightId, airline, arrivalTime, arrivalLocation, departureTime, departureLocation, availableSeats, price);
    }
}