package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.Instructor;
import org.openapitools.model.Student;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Teaches
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-08T04:12:08.912-07:00[Canada/Mountain]")

public class Teaches   {
  @JsonProperty("student_id")
  private Student studentId;

  @JsonProperty("instructor_id")
  private Instructor instructorId;

  public Teaches studentId(Student studentId) {
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

  public Teaches instructorId(Instructor instructorId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Teaches teaches = (Teaches) o;
    return Objects.equals(this.studentId, teaches.studentId) &&
        Objects.equals(this.instructorId, teaches.instructorId);
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

