/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package counter.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import counter.model.Booking;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@Api(value = "bookings", description = "the bookings API")
public interface BookingsApi {

    Logger log = LoggerFactory.getLogger(BookingsApi.class);

    // default Optional<ObjectMapper> getObjectMapper() {
    //     return Optional.empty();
    // }

    // default Optional<HttpServletRequest> getRequest() {
    //     return Optional.empty();
    // }

    // default Optional<String> getAcceptHeader() {
    //     return getRequest().map(r -> r.getHeader("Accept"));
    // }

    @ApiOperation(value = "Delete a booking", nickname = "bookingsBookingIdDelete", notes = "", tags = { "Booking", })
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully deleted Booking"),
            @ApiResponse(code = 400, message = "Invalid Request", response = String.class),
            @ApiResponse(code = 404, message = "Booking not found") })
    @RequestMapping(value = "/bookings/{bookingId}", produces = { "text/plain" }, method = RequestMethod.DELETE)
    default ResponseEntity<Void> bookingsBookingIdDelete(
            @ApiParam(value = "", required = true) @PathVariable("bookingId") Integer bookingId) {
        // if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        // } else {
        //     log.warn(
        //             "ObjectMapper or HttpServletRequest not configured in default BookingsApi interface so no example is generated");
        // }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Create a booking", nickname = "bookingsPost", notes = "", tags = { "Booking", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created new Booking"),
            @ApiResponse(code = 400, message = "Invalid Request", response = String.class) })
    @RequestMapping(value = "/bookings", produces = { "text/plain" }, consumes = {
            "application/json" }, method = RequestMethod.POST)
    default ResponseEntity<Void> bookingsPost(@ApiParam(value = "", required = true) @Valid @RequestBody Booking body) {
        // if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        // } else {
        //     log.warn(
        //             "ObjectMapper or HttpServletRequest not configured in default BookingsApi interface so no example is generated");
        // }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Get all bookings by user", nickname = "usersUserIdBookingsGet", notes = "", response = Booking.class, responseContainer = "List", tags = {
            "Booking", "Users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully returned a list of artists", response = Booking.class, responseContainer = "List") })
    @RequestMapping(value = "/bookings/{patron}", produces = { "application/json" }, method = RequestMethod.GET)
    default ResponseEntity<List<Booking>> usersUserIdBookingsGet(
            @ApiParam(value = "User to find bookings by", required = true) @PathVariable("patron") String patron) {
        // if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        //     if (getAcceptHeader().get().contains("application/json")) {
        //         try {
        //             return new ResponseEntity<>(getObjectMapper().get().readValue(
        //                     "[ {\n  \"bookingAgent\" : 6,\n  \"flight\" : 5,\n  \"patron\" : 1,\n  \"ticketPrice\" : 5.637376656633329,\n  \"numberOfTickets\" : 2,\n  \"bookingId\" : 0\n}, {\n  \"bookingAgent\" : 6,\n  \"flight\" : 5,\n  \"patron\" : 1,\n  \"ticketPrice\" : 5.637376656633329,\n  \"numberOfTickets\" : 2,\n  \"bookingId\" : 0\n} ]",
        //                     List.class), HttpStatus.NOT_IMPLEMENTED);
        //         } catch (IOException e) {
        //             log.error("Couldn't serialize response for content type application/json", e);
        //             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        //         }
        //     }
        // } else {
        //     log.warn(
        //             "ObjectMapper or HttpServletRequest not configured in default UsersApi interface so no example is generated");
        // }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
