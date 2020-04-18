/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package counter.api;

import counter.model.Booking;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@Api(value = "bookings", description = "the bookings API")
public interface BookingsApi {

    Logger log = LoggerFactory.getLogger(BookingsApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Delete a booking", nickname = "bookingsBookingIdDelete", notes = "", tags={ "Booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successfully deleted Booking"),
        @ApiResponse(code = 400, message = "Invalid Request", response = String.class),
        @ApiResponse(code = 404, message = "Booking not found") })
    @RequestMapping(value = "/bookings/{bookingId}",
        produces = { "text/plain" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> bookingsBookingIdDelete(@ApiParam(value = "",required=true) @PathVariable("bookingId") Integer bookingId
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BookingsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Create a booking", nickname = "bookingsPost", notes = "", tags={ "Booking", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully created new Booking"),
        @ApiResponse(code = 400, message = "Invalid Request", response = String.class) })
    @RequestMapping(value = "/bookings",
        produces = { "text/plain" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> bookingsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Booking body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BookingsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
