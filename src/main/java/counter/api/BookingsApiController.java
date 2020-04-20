package counter.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import counter.model.Booking;
import counter.service.BookingService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@Controller
public class BookingsApiController implements BookingsApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    BookingService bookingService;

    @org.springframework.beans.factory.annotation.Autowired
    public BookingsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<Void> bookingsBookingIdDelete(@ApiParam(value = "",required=true) @PathVariable("bookingId") Integer bookingId) {
        Integer result = bookingService.deleteBooking(bookingId);
        return new ResponseEntity<Void>(HttpStatus.valueOf(result));
    }

    @Override
    public ResponseEntity<Void> bookingsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Booking body) {
        try {
            bookingService.saveBooking(body);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (IllegalArgumentException ire) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } 
    }

    @Override
    public ResponseEntity<List<Booking>> usersUserIdBookingsGet(@ApiParam(value = "User to find bookings by",required=true) @PathVariable("patron") String patron) {
        List<Booking> bookings = bookingService.getBookingsByPatron(patron);
        if (bookings.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }

}
