package counter.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import counter.model.Booking;
import counter.repository.BookingRepo;
import software.amazon.awssdk.http.HttpStatusCode;

@Service
@Transactional
public class BookingService {

    @Autowired
    BookingRepo bookingRepository;

    public void saveBooking(Booking booking, Jwt principal) {
        System.out.println(booking + " : " + principal.getClaims());
        booking.setBookingAgent(principal.getSubject());
        bookingRepository.save(booking);
    }

    public Integer deleteBooking(Integer bookingId) {
        // TODO 
        // add refund stuff here
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId);
            return HttpStatusCode.NO_CONTENT;
        }
        return HttpStatusCode.NOT_FOUND;
    }

    public Booking getBookingByBookingId(Integer bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent())
            return booking.get();
        return null;
    }

    public List<Booking> getBookingsByPatron(String patron) {
        return bookingRepository.findByPatron(patron);
    }
}