package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.model.Aircraft;
import org.openapitools.model.Instructor;
import org.openapitools.model.Student;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Flight
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-07T22:58:45.808-07:00[Canada/Mountain]")

public class Flight   {
  @JsonProperty("flight_id")
  private Long flightId;

  @JsonProperty("aircraft_id")
  private Aircraft aircraftId;

  @JsonProperty("student_id")
  private Student studentId;

  @JsonProperty("instructor_id")
  private Instructor instructorId;

  @JsonProperty("exercise")
  private String exercise;

  @JsonProperty("flight_start")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime flightStart;

  @JsonProperty("flight_end")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime flightEnd;

  public Flight flightId(Long flightId) {
    this.flightId = flightId;
    return this;
  }

  /**
   * Get flightId
   * @return flightId
  */
  @ApiModelProperty(value = "")


  public Long getFlightId() {
    return flightId;
  }

  public void setFlightId(Long flightId) {
    this.flightId = flightId;
  }

  public Flight aircraftId(Aircraft aircraftId) {
    this.aircraftId = aircraftId;
    return this;
  }

  /**
   * Get aircraftId
   * @return aircraftId
  */
  @ApiModelProperty(value = "")

  @Valid

  public Aircraft getAircraftId() {
    return aircraftId;
  }

  public void setAircraftId(Aircraft aircraftId) {
    this.aircraftId = aircraftId;
  }

  public Flight studentId(Student studentId) {
    this.studentId = studentId;
    return this;
  }

  /**
   * Get studentId
   * @return studentId
  */
  @ApiModelProperty(value = "")

  @Valid

  public Student getStudentId() {
    return studentId;
  }

  public void setStudentId(Student studentId) {
    this.studentId = studentId;
  }

  public Flight instructorId(Instructor instructorId) {
    this.instructorId = instructorId;
    return this;
  }

  /**
   * Get instructorId
   * @return instructorId
  */
  @ApiModelProperty(value = "")

  @Valid

  public Instructor getInstructorId() {
    return instructorId;
  }

  public void setInstructorId(Instructor instructorId) {
    this.instructorId = instructorId;
  }

  public Flight exercise(String exercise) {
    this.exercise = exercise;
    return this;
  }

  /**
   * Get exercise
   * @return exercise
  */
  @ApiModelProperty(value = "")


  public String getExercise() {
    return exercise;
  }

  public void setExercise(String exercise) {
    this.exercise = exercise;
  }

  public Flight flightStart(OffsetDateTime flightStart) {
    this.flightStart = flightStart;
    return this;
  }

  /**
   * Get flightStart
   * @return flightStart
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getFlightStart() {
    return flightStart;
  }

  public void setFlightStart(OffsetDateTime flightStart) {
    this.flightStart = flightStart;
  }

  public Flight flightEnd(OffsetDateTime flightEnd) {
    this.flightEnd = flightEnd;
    return this;
  }

  /**
   * Get flightEnd
   * @return flightEnd
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getFlightEnd() {
    return flightEnd;
  }

  public void setFlightEnd(OffsetDateTime flightEnd) {
    this.flightEnd = flightEnd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Flight flight = (Flight) o;
    return Objects.equals(this.flightId, flight.flightId) &&
        Objects.equals(this.aircraftId, flight.aircraftId) &&
        Objects.equals(this.studentId, flight.studentId) &&
        Objects.equals(this.instructorId, flight.instructorId) &&
        Objects.equals(this.exercise, flight.exercise) &&
        Objects.equals(this.flightStart, flight.flightStart) &&
        Objects.equals(this.flightEnd, flight.flightEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flightId, aircraftId, studentId, instructorId, exercise, flightStart, flightEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Flight {\n");
    
    sb.append("    flightId: ").append(toIndentedString(flightId)).append("\n");
    sb.append("    aircraftId: ").append(toIndentedString(aircraftId)).append("\n");
    sb.append("    studentId: ").append(toIndentedString(studentId)).append("\n");
    sb.append("    instructorId: ").append(toIndentedString(instructorId)).append("\n");
    sb.append("    exercise: ").append(toIndentedString(exercise)).append("\n");
    sb.append("    flightStart: ").append(toIndentedString(flightStart)).append("\n");
    sb.append("    flightEnd: ").append(toIndentedString(flightEnd)).append("\n");
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

