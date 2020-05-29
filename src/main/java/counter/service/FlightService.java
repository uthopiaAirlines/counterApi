package counter.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import counter.model.Flight;
import counter.model.FlightResp;
import counter.repository.FlightRepo;

@Service
@Transactional
public class FlightService {

    @Autowired
    FlightRepo flightRepository;

    public FlightResp getFlights(int pageSize,int currentPage,String filterString,boolean isAsc,String sortItem) {
    	FlightResp resp = new FlightResp();
    	Pageable pageRequest;
    	if(sortItem.equals("flightId")||sortItem.equals("arrivalTime")||sortItem.equals("departureTime")||sortItem.equals("availableSeats")||
    				sortItem.equals("price")) {
	    	if(isAsc == false) 
	    		pageRequest = PageRequest.of(currentPage, pageSize, Sort.by(sortItem).descending());
	    	else
	    		pageRequest = PageRequest.of(currentPage, pageSize, Sort.by(sortItem).ascending());
    	}
    	else if(sortItem.equals("airline")||sortItem.equals("arrivalLocation")||sortItem.equals("departureLocation")) {
    		if(isAsc==false)
    			pageRequest = PageRequest.of(currentPage, pageSize, Sort.by(sortItem +".name").descending());
    		else
    			pageRequest = PageRequest.of(currentPage, pageSize, Sort.by(sortItem +".name"));
    	}
    	else
    		pageRequest = PageRequest.of(currentPage, pageSize);
    	resp.setTotalFlights(flightRepository.count());
    	if(filterString.isEmpty()) {
    		resp.setData(flightRepository.findAll(pageRequest).getContent());
    		resp.setTotalFiltered(resp.getTotalFlights());
    	}
    	else {
    		resp.setData(searchPageableByCriterion(filterString, pageRequest));
    		resp.setTotalFiltered(countOfPageableByCriterion(filterString, pageRequest));
    	}
    	return resp;
    }
    
    private List<Flight> searchPageableByCriterion(String filterString, Pageable pageRequest){
    	Integer flightId, availableSeats;
        OffsetDateTime arrivalTime, departureTime;
        BigDecimal price;
        try {
        	Integer criterion = Integer.valueOf(filterString);
            flightId = criterion;
            availableSeats =  criterion;
        }
        catch(NumberFormatException nfe) {
            flightId = Integer.valueOf(-1);
            availableSeats = Integer.valueOf(-1);
        }
        try {
        	OffsetDateTime criterion = OffsetDateTime.parse(filterString);
            arrivalTime = (OffsetDateTime) criterion;
            departureTime = (OffsetDateTime) criterion;
        }
        catch(DateTimeParseException dtpe) {
            arrivalTime = OffsetDateTime.now().minusYears(40);
            departureTime = OffsetDateTime.now().minusYears(40);
        }
        try {
        	BigDecimal criterion = new BigDecimal(filterString);
            price = (BigDecimal) criterion;
        }
        catch(NumberFormatException nfe) {
            price = new BigDecimal(-1);
        }
		return flightRepository.findByAirlineNameContainsIgnoreCaseOrArrivalTimeOrArrivalLocationNameContainsIgnoreCaseOrDepartureTimeOrDepartureLocationNameContainsIgnoreCaseOrAvailableSeatsOrPrice( 
				filterString, arrivalTime, filterString, departureTime, filterString, availableSeats, price, pageRequest);
    }
    
    private long countOfPageableByCriterion(String filterString, Pageable pageRequest){
    	Integer flightId, availableSeats;
        OffsetDateTime arrivalTime, departureTime;
        BigDecimal price;
        try {
        	Integer criterion = Integer.valueOf(filterString);
            flightId = criterion;
            availableSeats =  criterion;
        }
        catch(NumberFormatException nfe) {
            flightId = Integer.valueOf(-1);
            availableSeats = Integer.valueOf(-1);
        }
        try {
        	OffsetDateTime criterion = OffsetDateTime.parse(filterString);
            arrivalTime = (OffsetDateTime) criterion;
            departureTime = (OffsetDateTime) criterion;
        }
        catch(DateTimeParseException dtpe) {
            arrivalTime = OffsetDateTime.now().minusYears(40);
            departureTime = OffsetDateTime.now().minusYears(40);
        }
        try {
        	BigDecimal criterion = new BigDecimal(filterString);
            price = (BigDecimal) criterion;
        }
        catch(NumberFormatException nfe) {
            price = new BigDecimal(-1);
        }
		return flightRepository.countByAirlineNameContainsIgnoreCaseOrArrivalTimeOrArrivalLocationNameContainsIgnoreCaseOrDepartureTimeOrDepartureLocationNameContainsIgnoreCaseOrAvailableSeatsOrPrice( 
				filterString, arrivalTime, filterString, departureTime, filterString, availableSeats, price);
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
