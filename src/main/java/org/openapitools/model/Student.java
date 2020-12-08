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
 * Student
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-08T04:12:08.912-07:00[Canada/Mountain]")

public class Student   {
  @JsonProperty("user_id")
  private AdminUserId userId;

  @JsonProperty("pilot_license_no")
  private String pilotLicenseNo;

  public Student userId(AdminUserId userId) {
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

  public Student pilotLicenseNo(String pilotLicenseNo) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.userId, student.userId) &&
        Objects.equals(this.pilotLicenseNo, student.pilotLicenseNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, pilotLicenseNo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Student {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    pilotLicenseNo: ").append(toIndentedString(pilotLicenseNo)).append("\n");
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

