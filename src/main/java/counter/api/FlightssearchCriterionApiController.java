package counter.api;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import counter.model.Flight;
import counter.service.FlightService;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@CrossOrigin
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
    @CrossOrigin
    public ResponseEntity<List<Flight>> flightssearchCriterionGet(
            @ApiParam(value = "", required = true) @PathVariable("searchCriterion") String searchCriterion) {
        try {
            Integer i = Integer.valueOf(searchCriterion);
            List<Flight> result = flightService.getFlightsByCriterion(i);
            if (result.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Flight>>(result, HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            // Continue to other types
        }
        try {
            BigDecimal bd = new BigDecimal(searchCriterion);
            List<Flight> result = flightService.getFlightsByCriterion(bd);
            if (result.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Flight>>(result, HttpStatus.OK);
        } catch (NumberFormatException nfe) {
            // Continue to other types
        }
        try {
            OffsetDateTime odt = OffsetDateTime.parse(searchCriterion);
            List<Flight> result = flightService.getFlightsByCriterion(odt);
            if (result.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<Flight>>(result, HttpStatus.OK);
        } catch (DateTimeParseException dtpe) {
            // Continue to other types
        }
        return new ResponseEntity<List<Flight>>(HttpStatus.BAD_REQUEST);
    }

}
