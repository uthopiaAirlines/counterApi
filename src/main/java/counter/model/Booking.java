package counter.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModelProperty;

/**
 * Booking
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@JacksonXmlRootElement(localName = "Booking")
@XmlRootElement(name = "Booking")
@JsonIgnoreProperties(value = {"paymentId"}, allowSetters = true)
@Entity
@Table(name = "bookings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Booking implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("bookingId")
  @JacksonXmlProperty(localName = "bookingId")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer bookingId = null;

  @JsonProperty("paymentId")
  @JacksonXmlProperty(localName = "paymentId")
  private String paymentId = null;

  @JsonProperty("bookingAgent")
  @JacksonXmlProperty(localName = "bookingAgent")
  @Nullable
  private String bookingAgent = null;

  @JsonProperty("patron")
  @JacksonXmlProperty(localName = "patron")
  @NotNull
  private String patron = null;

  @JsonProperty("flight")
  @JacksonXmlProperty(localName = "flight")
  @ManyToOne(optional = false)
  @JoinColumn(name = "flight", nullable = false, updatable = false, referencedColumnName = "flightId")
  private Flight flight = null;

  @JsonProperty("ticketPrice")
  @JacksonXmlProperty(localName = "ticketPrice")
  @NotNull
  private BigDecimal ticketPrice = null;

  @JsonProperty("numberOfTickets")
  @JacksonXmlProperty(localName = "numberOfTickets")
  @NotNull
  private Integer numberOfTickets = null;

  public Booking bookingId(Integer bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Get bookingId
   * 
   * @return bookingId
   **/
  @ApiModelProperty(required = true, value = "")

  public Integer getBookingId() {
    return bookingId;
  }

  public void setBookingId(Integer bookingId) {
    this.bookingId = bookingId;
  }

  public Booking bookingAgent(String bookingAgent) {
    this.bookingAgent = bookingAgent;
    return this;
  }

  /**
   * @param paymentId the paymentId to set
   */
  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public Booking paymentId(String paymentId) {
    this.paymentId = paymentId;
    return this;
  }

  /**
   * Get bookingAgent
   * 
   * @return bookingAgent
   **/
  @ApiModelProperty(required = true, value = "")

  public String getBookingAgent() {
    return bookingAgent;
  }

  public void setBookingAgent(String bookingAgent) {
    this.bookingAgent = bookingAgent;
  }

  public Booking patron(String patron) {
    this.patron = patron;
    return this;
  }

  /**
   * Get patron
   * 
   * @return patron
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getPatron() {
    return patron;
  }

  public void setPatron(String patron) {
    this.patron = patron;
  }

  public Booking flight(Flight flight) {
    this.flight = flight;
    return this;
  }

  /**
   * Get flight
   * 
   * @return flight
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  public Booking ticketPrice(BigDecimal ticketPrice) {
    this.ticketPrice = ticketPrice;
    return this;
  }

  /**
   * Get ticketPrice
   * 
   * @return ticketPrice
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public BigDecimal getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(BigDecimal ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  public Booking numberOfTickets(Integer numberOfTickets) {
    this.numberOfTickets = numberOfTickets;
    return this;
  }

  /**
   * Get numberOfTickets
   * 
   * @return numberOfTickets
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getNumberOfTickets() {
    return numberOfTickets;
  }

  public void setNumberOfTickets(Integer numberOfTickets) {
    this.numberOfTickets = numberOfTickets;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return Objects.equals(this.bookingId, booking.bookingId) && Objects.equals(this.bookingAgent, booking.bookingAgent)
        && Objects.equals(this.patron, booking.patron) && Objects.equals(this.flight, booking.flight)
        && Objects.equals(this.ticketPrice, booking.ticketPrice)
        && Objects.equals(this.numberOfTickets, booking.numberOfTickets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, bookingAgent, patron, flight, ticketPrice, numberOfTickets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");

    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    bookingAgent: ").append(toIndentedString(bookingAgent)).append("\n");
    sb.append("    patron: ").append(toIndentedString(patron)).append("\n");
    sb.append("    flight: ").append(toIndentedString(flight)).append("\n");
    sb.append("    ticketPrice: ").append(toIndentedString(ticketPrice)).append("\n");
    sb.append("    numberOfTickets: ").append(toIndentedString(numberOfTickets)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
