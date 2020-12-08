package server.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import server.model.Aircraft;
import server.model.Instructor;
import server.model.Student;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public class Flight   {
  
  private Long flightId;
  private Aircraft aircraftId;
  private Student studentId;
  private Instructor instructorId;
  private String exercise;
  private Date flightStart;
  private Date flightEnd;

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("flight_id")
  public Long getFlightId() {
    return flightId;
  }
  public void setFlightId(Long flightId) {
    this.flightId = flightId;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("aircraft_id")
  public Aircraft getAircraftId() {
    return aircraftId;
  }
  public void setAircraftId(Aircraft aircraftId) {
    this.aircraftId = aircraftId;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("student_id")
  public Student getStudentId() {
    return studentId;
  }
  public void setStudentId(Student studentId) {
    this.studentId = studentId;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("instructor_id")
  public Instructor getInstructorId() {
    return instructorId;
  }
  public void setInstructorId(Instructor instructorId) {
    this.instructorId = instructorId;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("exercise")
  public String getExercise() {
    return exercise;
  }
  public void setExercise(String exercise) {
    this.exercise = exercise;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("flight_start")
  public Date getFlightStart() {
    return flightStart;
  }
  public void setFlightStart(Date flightStart) {
    this.flightStart = flightStart;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("flight_end")
  public Date getFlightEnd() {
    return flightEnd;
  }
  public void setFlightEnd(Date flightEnd) {
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
    return Objects.equals(flightId, flight.flightId) &&
        Objects.equals(aircraftId, flight.aircraftId) &&
        Objects.equals(studentId, flight.studentId) &&
        Objects.equals(instructorId, flight.instructorId) &&
        Objects.equals(exercise, flight.exercise) &&
        Objects.equals(flightStart, flight.flightStart) &&
        Objects.equals(flightEnd, flight.flightEnd);
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

