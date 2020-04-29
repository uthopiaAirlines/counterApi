package counter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.GenerationType;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModelProperty;

@Validated
@JacksonXmlRootElement(localName = "Airport")
@XmlRootElement(name = "Airport")
@Entity
@Table(name = "airports")
@XmlAccessorType(XmlAccessType.FIELD)
public class Airport implements Serializable{
    public static final long serialVersionUID= 1L;

    @JsonProperty("airportId")
    @JacksonXmlProperty(localName = "airportId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airportId = null;

    @JsonProperty("name")
    @JacksonXmlProperty(localName = "name")
    private String name = null;

    @JsonProperty("address")
    @JacksonXmlProperty(localName = "address")
    private String address = null;

    @JsonProperty("airportCode")
    @JacksonXmlProperty(localName = "airportCode")
    private String airportCode = null;


    /**
   * Get airportId
   * 
   * @return airportId
   **/
  @ApiModelProperty(required = true, value = "")

  public Integer getAirportId() {
    return airportId;
  }

  public void setAirportId(Integer airportId) {
    this.airportId = airportId;
  }

  public Airport name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * 
   * @return name
   **/
  @ApiModelProperty(required = true, value = "")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Airport address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * 
   * @return address
   **/
  @ApiModelProperty(required = true, value = "")

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Airport flight(String airportCode) {
    this.airportCode = airportCode;
    return this;
  }

  /**
   * Get airportCode
   * 
   * @return airportCode
   **/
  @ApiModelProperty(required = true, value = "")

  public String getAirportCode() {
    return airportCode;
  }

  public void setFlight(String airportCode) {
    this.airportCode = airportCode;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Airport Airport = (Airport) o;
    return Objects.equals(this.airportId, Airport.airportId) && Objects.equals(this.name, Airport.name)
        && Objects.equals(this.address, Airport.address) && Objects.equals(this.airportCode, Airport.airportCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(airportId, name, address, airportCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Airport {\n");

    sb.append("    airportId: ").append(toIndentedString(airportId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    airportCode: ").append(toIndentedString(airportCode)).append("\n");
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