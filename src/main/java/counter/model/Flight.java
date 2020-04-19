package counter.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModelProperty;

/**
 * Flight
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T22:58:40.224Z[GMT]")
@JacksonXmlRootElement(localName = "Flight")
@XmlRootElement(name = "Flight")
@Entity
@Table(name = "flights")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight implements Serializable {
  private static final long serialVersionUID = 1L;

  public Flight(Integer flightId) {
    this.flightId = flightId;
  }

  public Flight() {

  }

  @JsonProperty("flightId")
  @JacksonXmlProperty(localName = "flightId")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer flightId = null;

  @JsonProperty("airline")
  @JacksonXmlProperty(localName = "airline")
  @Column(name = "airline", nullable = false)
  private Integer airline = null;

  @JsonProperty("arrivalTime")
  @JacksonXmlProperty(localName = "arrivalTime")
  @Column(name = "arrivalTime", nullable = false)
  private OffsetDateTime arrivalTime = null;

  @JsonProperty("arrivalLocation")
  @JacksonXmlProperty(localName = "arrivalLocation")
  @Column(name = "arrivalLocation", nullable = false)
  private Integer arrivalLocation = null;

  @JsonProperty("departureTime")
  @JacksonXmlProperty(localName = "departureTime")
  @Column(name = "departureTime", nullable = false)
  private OffsetDateTime departureTime = null;

  @JsonProperty("departureLocation")
  @JacksonXmlProperty(localName = "departureLocation")
  @Column(name = "departureLocation", nullable = false)
  private Integer departureLocation = null;

  @JsonProperty("availableSeats")
  @JacksonXmlProperty(localName = "availableSeats")
  @Column(name = "availableSeats", nullable = false)
  private Integer availableSeats = null;

  @JsonProperty("price")
  @JacksonXmlProperty(localName = "price")
  @Column(name = "price", nullable = false)
  private BigDecimal price = null;

  public Flight flightId(final Integer flightId) {
    this.flightId = flightId;
    return this;
  }

  /**
   * Get flightId
   * 
   * @return flightId
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getFlightId() {
    return flightId;
  }

  public void setFlightId(final Integer flightId) {
    this.flightId = flightId;
  }

  public Flight airline(final Integer airline) {
    this.airline = airline;
    return this;
  }

  /**
   * Get airline
   * 
   * @return airline
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getAirline() {
    return airline;
  }

  public void setAirline(final Integer airline) {
    this.airline = airline;
  }

  public Flight arrivalTime(final OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  /**
   * Get arrivalTime
   * 
   * @return arrivalTime
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public OffsetDateTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(final OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public Flight arrivalLocation(final Integer arrivalLocation) {
    this.arrivalLocation = arrivalLocation;
    return this;
  }

  /**
   * Get arrivalLocation
   * 
   * @return arrivalLocation
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getArrivalLocation() {
    return arrivalLocation;
  }

  public void setArrivalLocation(final Integer arrivalLocation) {
    this.arrivalLocation = arrivalLocation;
  }

  public Flight departureTime(final OffsetDateTime departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * Get departureTime
   * 
   * @return departureTime
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public OffsetDateTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(final OffsetDateTime departureTime) {
    this.departureTime = departureTime;
  }

  public Flight departureLocation(final Integer departureLocation) {
    this.departureLocation = departureLocation;
    return this;
  }

  /**
   * Get departureLocation
   * 
   * @return departureLocation
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getDepartureLocation() {
    return departureLocation;
  }

  public void setDepartureLocation(final Integer departureLocation) {
    this.departureLocation = departureLocation;
  }

  public Flight availableSeats(final Integer availableSeats) {
    this.availableSeats = availableSeats;
    return this;
  }

  /**
   * Get availableSeats
   * 
   * @return availableSeats
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getAvailableSeats() {
    return availableSeats;
  }

  public void setAvailableSeats(final Integer availableSeats) {
    this.availableSeats = availableSeats;
  }

  public Flight price(final BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * 
   * @return price
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }

  @Override
  public boolean equals(final java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Flight flight = (Flight) o;
    return Objects.equals(this.flightId, flight.flightId) && Objects.equals(this.airline, flight.airline)
        && Objects.equals(this.arrivalTime, flight.arrivalTime)
        && Objects.equals(this.arrivalLocation, flight.arrivalLocation)
        && Objects.equals(this.departureTime, flight.departureTime)
        && Objects.equals(this.departureLocation, flight.departureLocation)
        && Objects.equals(this.availableSeats, flight.availableSeats) && Objects.equals(this.price, flight.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flightId, airline, arrivalTime, arrivalLocation, departureTime, departureLocation,
        availableSeats, price);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class Flight {\n");

    sb.append("    flightId: ").append(toIndentedString(flightId)).append("\n");
    sb.append("    airline: ").append(toIndentedString(airline)).append("\n");
    sb.append("    arrivalTime: ").append(toIndentedString(arrivalTime)).append("\n");
    sb.append("    arrivalLocation: ").append(toIndentedString(arrivalLocation)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    departureLocation: ").append(toIndentedString(departureLocation)).append("\n");
    sb.append("    availableSeats: ").append(toIndentedString(availableSeats)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(final java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
