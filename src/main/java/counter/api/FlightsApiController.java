package counter.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import counter.model.Flight;
import counter.service.FlightService;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
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

    // @Override
    // public Optional<ObjectMapper> getObjectMapper() {
    //     return Optional.ofNullable(objectMapper);
    // }

    // @Override
    // public Optional<HttpServletRequest> getRequest() {
    //     return Optional.ofNullable(request);
    // }

    @Override
    public ResponseEntity<List<Flight>> flightsGet() {
        List<Flight> result = flightService.getFlights();
        if (result.isEmpty())
            return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<Flight>>(result, HttpStatus.OK);
    }

}
