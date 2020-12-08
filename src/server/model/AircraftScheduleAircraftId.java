package server.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public class AircraftScheduleAircraftId   {
  
  private Long id;
  private String registration;
  private String type;
  private String serialNo;

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("registration")
  public String getRegistration() {
    return registration;
  }
  public void setRegistration(String registration) {
    this.registration = registration;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("type")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("serial_no")
  public String getSerialNo() {
    return serialNo;
  }
  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AircraftScheduleAircraftId aircraftScheduleAircraftId = (AircraftScheduleAircraftId) o;
    return Objects.equals(id, aircraftScheduleAircraftId.id) &&
        Objects.equals(registration, aircraftScheduleAircraftId.registration) &&
        Objects.equals(type, aircraftScheduleAircraftId.type) &&
        Objects.equals(serialNo, aircraftScheduleAircraftId.serialNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, registration, type, serialNo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AircraftScheduleAircraftId {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    registration: ").append(toIndentedString(registration)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    serialNo: ").append(toIndentedString(serialNo)).append("\n");
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

