package org.openapitools.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.openapitools.model.AircraftScheduleAircraftId;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public class AircraftSchedule   {
  
  private Object flightId = null;
  private AircraftScheduleAircraftId aircraftId;
  private Date schedStart;
  private Date schedEnd;

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("flight_id")
  public Object getFlightId() {
    return flightId;
  }
  public void setFlightId(Object flightId) {
    this.flightId = flightId;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("aircraft_id")
  public AircraftScheduleAircraftId getAircraftId() {
    return aircraftId;
  }
  public void setAircraftId(AircraftScheduleAircraftId aircraftId) {
    this.aircraftId = aircraftId;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("sched_start")
  public Date getSchedStart() {
    return schedStart;
  }
  public void setSchedStart(Date schedStart) {
    this.schedStart = schedStart;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("sched_end")
  public Date getSchedEnd() {
    return schedEnd;
  }
  public void setSchedEnd(Date schedEnd) {
    this.schedEnd = schedEnd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AircraftSchedule aircraftSchedule = (AircraftSchedule) o;
    return Objects.equals(flightId, aircraftSchedule.flightId) &&
        Objects.equals(aircraftId, aircraftSchedule.aircraftId) &&
        Objects.equals(schedStart, aircraftSchedule.schedStart) &&
        Objects.equals(schedEnd, aircraftSchedule.schedEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flightId, aircraftId, schedStart, schedEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AircraftSchedule {\n");
    
    sb.append("    flightId: ").append(toIndentedString(flightId)).append("\n");
    sb.append("    aircraftId: ").append(toIndentedString(aircraftId)).append("\n");
    sb.append("    schedStart: ").append(toIndentedString(schedStart)).append("\n");
    sb.append("    schedEnd: ").append(toIndentedString(schedEnd)).append("\n");
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

