package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.AdminUserId;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Instructor
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-08T04:12:08.912-07:00[Canada/Mountain]")

public class Instructor   {
  @JsonProperty("user_id")
  private AdminUserId userId;

  @JsonProperty("pilot_license_no")
  private String pilotLicenseNo;

  @JsonProperty("instructor_class")
  private String instructorClass;

  public Instructor userId(AdminUserId userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @ApiModelProperty(value = "")

  @Valid

  public AdminUserId getUserId() {
    return userId;
  }

  public void setUserId(AdminUserId userId) {
    this.userId = userId;
  }

  public Instructor pilotLicenseNo(String pilotLicenseNo) {
    this.pilotLicenseNo = pilotLicenseNo;
    return this;
  }

  /**
   * Get pilotLicenseNo
   * @return pilotLicenseNo
  */
  @ApiModelProperty(value = "")


  public String getPilotLicenseNo() {
    return pilotLicenseNo;
  }

  public void setPilotLicenseNo(String pilotLicenseNo) {
    this.pilotLicenseNo = pilotLicenseNo;
  }

  public Instructor instructorClass(String instructorClass) {
    this.instructorClass = instructorClass;
    return this;
  }

  /**
   * Get instructorClass
   * @return instructorClass
  */
  @ApiModelProperty(value = "")


  public String getInstructorClass() {
    return instructorClass;
  }

  public void setInstructorClass(String instructorClass) {
    this.instructorClass = instructorClass;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Instructor instructor = (Instructor) o;
    return Objects.equals(this.userId, instructor.userId) &&
        Objects.equals(this.pilotLicenseNo, instructor.pilotLicenseNo) &&
        Objects.equals(this.instructorClass, instructor.instructorClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, pilotLicenseNo, instructorClass);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Instructor {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    pilotLicenseNo: ").append(toIndentedString(pilotLicenseNo)).append("\n");
    sb.append("    instructorClass: ").append(toIndentedString(instructorClass)).append("\n");
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

