package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.model.AircraftScheduleAircraftId;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AircraftSchedule
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-08T04:12:08.912-07:00[Canada/Mountain]")

public class AircraftSchedule   {
  @JsonProperty("flight_id")
  private Object flightId = null;

  @JsonProperty("aircraft_id")
  private AircraftScheduleAircraftId aircraftId;

  @JsonProperty("sched_start")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime schedStart;

  @JsonProperty("sched_end")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime schedEnd;

  public AircraftSchedule flightId(Object flightId) {
    this.flightId = flightId;
    return this;
  }

  /**
   * Get flightId
   * @return flightId
  */
  @ApiModelProperty(value = "")


  public Object getFlightId() {
    return flightId;
  }

  public void setFlightId(Object flightId) {
    this.flightId = flightId;
  }

  public AircraftSchedule aircraftId(AircraftScheduleAircraftId aircraftId) {
    this.aircraftId = aircraftId;
    return this;
  }

  /**
   * Get aircraftId
   * @return aircraftId
  */
  @ApiModelProperty(value = "")

  @Valid

  public AircraftScheduleAircraftId getAircraftId() {
    return aircraftId;
  }

  public void setAircraftId(AircraftScheduleAircraftId aircraftId) {
    this.aircraftId = aircraftId;
  }

  public AircraftSchedule schedStart(OffsetDateTime schedStart) {
    this.schedStart = schedStart;
    return this;
  }

  /**
   * Get schedStart
   * @return schedStart
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getSchedStart() {
    return schedStart;
  }

  public void setSchedStart(OffsetDateTime schedStart) {
    this.schedStart = schedStart;
  }

  public AircraftSchedule schedEnd(OffsetDateTime schedEnd) {
    this.schedEnd = schedEnd;
    return this;
  }

  /**
   * Get schedEnd
   * @return schedEnd
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getSchedEnd() {
    return schedEnd;
  }

  public void setSchedEnd(OffsetDateTime schedEnd) {
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
    return Objects.equals(this.flightId, aircraftSchedule.flightId) &&
        Objects.equals(this.aircraftId, aircraftSchedule.aircraftId) &&
        Objects.equals(this.schedStart, aircraftSchedule.schedStart) &&
        Objects.equals(this.schedEnd, aircraftSchedule.schedEnd);
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

