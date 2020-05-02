package counter.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.stripe.Stripe;
import com.stripe.model.Refund;
import com.stripe.param.RefundCreateParams;

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
        if (bookingRepository.existsById(bookingId)) {
            Stripe.apiKey = "sk_test_nO7vO3qiJLXNPAbw4sO10zx700DuBv1ev6";
            try {
                Refund.create(RefundCreateParams.builder()
                    .setPaymentIntent(getBookingByBookingId(bookingId).getPaymentId())
                    .build());
            } catch (Exception e) {
                return HttpStatusCode.SERVICE_UNAVAILABLE;
            }
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