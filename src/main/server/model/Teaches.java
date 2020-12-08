package main.server.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import main.server.model.Instructor;
import main.server.model.Student;

import javax.validation.constraints.*;
import io.swagger.annotations.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public class Teaches   {
  
  private Student studentId;
  private Instructor instructorId;

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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Teaches teaches = (Teaches) o;
    return Objects.equals(studentId, teaches.studentId) &&
        Objects.equals(instructorId, teaches.instructorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentId, instructorId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Teaches {\n");
    
    sb.append("    studentId: ").append(toIndentedString(studentId)).append("\n");
    sb.append("    instructorId: ").append(toIndentedString(instructorId)).append("\n");
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

