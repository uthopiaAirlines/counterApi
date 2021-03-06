/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package counter.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import counter.model.Flight;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@CrossOrigin("https://www.utopiaairlines.com")
@Api(value = "flights:{searchCriterion}", description = "the flights:{searchCriterion} API")
public interface FlightssearchCriterionApi {

    Logger log = LoggerFactory.getLogger(FlightssearchCriterionApi.class);

    @CrossOrigin("https://www.utopiaairlines.com")
    @ApiOperation(value = "Get all the flights that have the search criterion within them", nickname = "flightssearchCriterionGet", notes = "", response = Flight.class, tags = {
            "Flight", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully got the list of flights by search criterion", response = Flight.class),
            @ApiResponse(code = 400, message = "Invalid Request", response = String.class) })
    @RequestMapping(value = "/v2/counter/flights:{searchCriterion}", produces = { "application/json",
            "text/plain" }, method = RequestMethod.GET)
    default ResponseEntity<List<Flight>> flightssearchCriterionGet(
            @ApiParam(value = "", required = true) @PathVariable("searchCriterion") String searchCriterion) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
