package counter.api;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import counter.model.Flight;
import counter.service.FlightService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@Controller
public class FlightssearchCriterionApiController implements FlightssearchCriterionApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    FlightService flightService;

    @org.springframework.beans.factory.annotation.Autowired
    public FlightssearchCriterionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Flight>> flightssearchCriterionGet(
            @ApiParam(value = "", required = true) @PathVariable("searchCriterion") String searchCriterion) {
        try {
            Integer i = Integer.valueOf(searchCriterion);
            return new ResponseEntity<List<Flight>>(flightService.getFlightsByCriterion(i), HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            // Continue to other types
        }
        try {
            BigDecimal bd = new BigDecimal(searchCriterion);
            return new ResponseEntity<List<Flight>>(flightService.getFlightsByCriterion(bd), HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            // Continue to other types
        }
        try {
            OffsetDateTime odt = OffsetDateTime.parse(searchCriterion);
            return new ResponseEntity<List<Flight>>(flightService.getFlightsByCriterion(odt), HttpStatus.OK);
        } catch (DateTimeParseException dtpe) {
            // Continue to other types
        }
        return new ResponseEntity<List<Flight>>(HttpStatus.BAD_REQUEST);
    }

}
