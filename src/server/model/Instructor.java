package org.openapitools.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.AdminUserId;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public class Instructor   {
  
  private AdminUserId userId;
  private String pilotLicenseNo;
  private String instructorClass;

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("user_id")
  public AdminUserId getUserId() {
    return userId;
  }
  public void setUserId(AdminUserId userId) {
    this.userId = userId;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("pilot_license_no")
  public String getPilotLicenseNo() {
    return pilotLicenseNo;
  }
  public void setPilotLicenseNo(String pilotLicenseNo) {
    this.pilotLicenseNo = pilotLicenseNo;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("instructor_class")
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
    return Objects.equals(userId, instructor.userId) &&
        Objects.equals(pilotLicenseNo, instructor.pilotLicenseNo) &&
        Objects.equals(instructorClass, instructor.instructorClass);
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

