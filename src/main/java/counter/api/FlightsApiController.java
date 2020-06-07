package counter.api;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import counter.model.FlightResp;
import counter.service.FlightService;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@CrossOrigin(origins = "https://www.utopiaairlines.com")
@Controller
public class FlightsApiController implements FlightsApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    FlightService flightService;

    @org.springframework.beans.factory.annotation.Autowired
    public FlightsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    @CrossOrigin("https://www.utopiaairlines.com")
    public ResponseEntity<FlightResp> flightsGet(@RequestParam(defaultValue = "20") int pageSize, @RequestParam(defaultValue = "1") int currentPage,
    		@RequestParam String filterString, @RequestParam(defaultValue = "true") boolean isAsc, @RequestParam(defaultValue = "flightId") String sortItem) {
    	if(!sortItem.equals("flightId")&&!sortItem.equals("arrivalTime")&&!sortItem.equals("departureTime")&&!sortItem.equals("availableSeats")&&
				!sortItem.equals("price")&&!sortItem.equals("airline")&&!sortItem.equals("arrivalLocation")&&!sortItem.equals("departureLocation"))
    		return new ResponseEntity<FlightResp>(HttpStatus.BAD_REQUEST);
        FlightResp result = flightService.getFlights(pageSize, currentPage, filterString, isAsc, sortItem);
        return new ResponseEntity<FlightResp>(result, HttpStatus.OK);
    }

}
