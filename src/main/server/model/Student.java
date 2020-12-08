package main.server.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import main.server.model.AdminUserId;

import javax.validation.constraints.*;
import io.swagger.annotations.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public class Student   {
  
  private AdminUserId userId;
  private String pilotLicenseNo;

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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(userId, student.userId) &&
        Objects.equals(pilotLicenseNo, student.pilotLicenseNo);
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

