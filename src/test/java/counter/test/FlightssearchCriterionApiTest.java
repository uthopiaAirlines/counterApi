package counter.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import counter.api.FlightssearchCriterionApiController;
import counter.model.Flight;
import counter.service.FlightService;

@TestInstance(Lifecycle.PER_CLASS)
@OverrideAutoConfiguration(enabled = true)
@WebMvcTest(FlightssearchCriterionApiController.class)
public class FlightssearchCriterionApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightService flightService;

    @Test
    void whenValidIntegerGetRequestExpectOK() throws Exception{
        ArrayList<Flight> arrayList = new ArrayList<Flight>(Arrays.asList(new Flight(1)));
        when(flightService.getFlightsByCriterion(Integer.valueOf(1))).thenReturn(arrayList);
        mockMvc.perform(get("/flights:{searchCriterion}", Integer.valueOf(1)).accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidBigDecimalGetRequestExpectOK() throws Exception{
        ArrayList<Flight> arrayList = new ArrayList<Flight>(Arrays.asList(new Flight(1)));
        when(flightService.getFlightsByCriterion(BigDecimal.valueOf(15.99))).thenReturn(arrayList);
        mockMvc.perform(get("/flights:{searchCriterion}", BigDecimal.valueOf(15.99)).accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidOffsetDateTimeGetRequestExpectOK() throws Exception{
        ArrayList<Flight> arrayList = new ArrayList<Flight>(Arrays.asList(new Flight(1)));
        OffsetDateTime odt = OffsetDateTime.now();
        when(flightService.getFlightsByCriterion(odt)).thenReturn(arrayList);
        mockMvc.perform(get("/flights:{searchCriterion}", odt).accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void whenInvalidIntegerGetRequestExpectOK() throws Exception{
        ArrayList<Flight> arrayList = new ArrayList<Flight>(Arrays.asList(new Flight(1)));
        when(flightService.getFlightsByCriterion(Integer.valueOf(1))).thenReturn(arrayList);
        mockMvc.perform(get("/flights:{searchCriterion}", Integer.valueOf(2)).accept(MediaType.ALL_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenInvalidBigDecimalGetRequestExpectOK() throws Exception{
        ArrayList<Flight> arrayList = new ArrayList<Flight>(Arrays.asList(new Flight(1)));
        when(flightService.getFlightsByCriterion(BigDecimal.valueOf(17.99))).thenReturn(arrayList);
        mockMvc.perform(get("/flights:{searchCriterion}", BigDecimal.valueOf(15.99)).accept(MediaType.ALL_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenInvalidOffsetDateTimeGetRequestExpectOK() throws Exception{
        ArrayList<Flight> arrayList = new ArrayList<Flight>(Arrays.asList(new Flight(1)));
        OffsetDateTime odt = OffsetDateTime.now();
        when(flightService.getFlightsByCriterion(OffsetDateTime.now().minusDays(100))).thenReturn(arrayList);
        mockMvc.perform(get("/flights:{searchCriterion}", odt).accept(MediaType.ALL_VALUE))
                .andExpect(status().isNotFound());
    }
}