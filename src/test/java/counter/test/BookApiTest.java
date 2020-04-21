package counter.test;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import counter.api.BookingsApiController;
import counter.model.Booking;
import counter.model.Flight;
import counter.service.BookingService;

@TestInstance(Lifecycle.PER_CLASS)
@OverrideAutoConfiguration(enabled = true)
@WebMvcTest(BookingsApiController.class)
public class BookApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookingService mBookingService;

    Booking booking = new Booking();
    ArrayList<Booking> arrayList = new ArrayList<Booking>();

    @BeforeAll
    void setBookingAndArray() {
        booking.setBookingAgent("fa956c43-f7c6-4da0-ba96-3860d0e4ddf9");
        booking.setBookingId(1);
        booking.setFlight(new Flight(1));
        booking.setNumberOfTickets(1);
        booking.setPatron("466f0f8b-02a3-4b03-8bdd-e82529800ba8");
        booking.setTicketPrice(BigDecimal.valueOf(15.99));
    }

    @BeforeEach
    void addBookingToArray() {
        arrayList.add(booking);
    }

    @AfterEach
    void clearArray() {
        arrayList.clear();
    }

    // @Test
    // void whenValidPostRequestExpectCREATED() throws Exception {
    //     doNothing().when(mBookingService).saveBooking(isA(Booking.class));
    //     mockMvc.perform(post("/bookings").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL_VALUE).content(
    //             "{\"patron\":\"466f0f8b-02a3-4b03-8bdd-e82529800ba8\",\"flight\":1,\"ticketPrice\":15.99,\"numberOfTickets\":1,\"bookingAgent\":\"fa956c43-f7c6-4da0-ba96-3860d0e4ddf9\",\"bookingId\":1}"))
    //             .andExpect(status().isCreated());
    // }

    // @Test
    // void whenInvalidPostRequestExpectBAD_REQUEST() throws Exception {
    //     doNothing().when(mBookingService).saveBooking(isA(Booking.class));
    //     // flight is a string, which is invalid
    //     mockMvc.perform(post("/bookings").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL_VALUE).content(
    //             "{\"patron\":\"466f0f8b-02a3-4b03-8bdd-e82529800ba8\",\"flight\":\"asdf\",\"ticketPrice\":15.99,\"numberOfTickets\":1,\"bookingAgent\":\"fa956c43-f7c6-4da0-ba96-3860d0e4ddf9\",\"bookingId\":1}"))
    //             .andExpect(status().isBadRequest());
    // }

    // @Test
    // void whenInvalidPostRequestServiceExpectBAD_REQUEST() throws Exception {
    //     doThrow(IllegalArgumentException.class).when(mBookingService).saveBooking(isA(Booking.class));
    //     mockMvc.perform(post("/bookings").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL_VALUE).content(
    //             "{\"patron\":\"466f0f8b-02a3-4b03-8bdd-e82529800ba8\",\"flight\":1,\"ticketPrice\":15.99,\"numberOfTickets\":1,\"bookingAgent\":\"fa956c43-f7c6-4da0-ba96-3860d0e4ddf9\",\"bookingId\":1}"))
    //             .andExpect(status().isBadRequest());
    // }

    @Test
    void whenValidDeleteRequestExpectNO_CONTENT() throws Exception {
        when(mBookingService.deleteBooking(isA(Integer.class))).thenReturn(204);
        mockMvc.perform(delete("/bookings/{bookingId}", 1).accept(MediaType.ALL_VALUE))
                .andExpect(status().isNoContent());
    }

    @Test
    void whenValidGetRequestExpectOK() throws Exception {
        when(mBookingService.getBookingsByPatron(isA(String.class))).thenReturn(arrayList);
        mockMvc.perform(get("/bookings/{patron}", "466f0f8b-02a3-4b03-8bdd-e82529800ba8").accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string(containsString("466f0f8b-02a3-4b03-8bdd-e82529800ba8")));
    }

    @Test
    void whenInvalidGetRequestExpectNOT_FOUND() throws Exception {
        when(mBookingService.getBookingsByPatron(isA(String.class))).thenReturn(new ArrayList<Booking>());
        mockMvc.perform(get("/bookings/{patron}", "466f0f8b-02a3-4b03-8bdd-e82529800ba8").accept(MediaType.ALL_VALUE))
                .andExpect(status().isNotFound());
    }
}