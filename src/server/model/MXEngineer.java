package server.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import server.model.AdminUserId;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2020-12-07T20:36:02.839-07:00[Canada/Mountain]")
public class MXEngineer   {
  
  private AdminUserId userId;
  private String engLicenseNo;
  private String rating;

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
  @JsonProperty("eng_license_no")
  public String getEngLicenseNo() {
    return engLicenseNo;
  }
  public void setEngLicenseNo(String engLicenseNo) {
    this.engLicenseNo = engLicenseNo;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("rating")
  public String getRating() {
    return rating;
  }
  public void setRating(String rating) {
    this.rating = rating;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MXEngineer mxEngineer = (MXEngineer) o;
    return Objects.equals(userId, mxEngineer.userId) &&
        Objects.equals(engLicenseNo, mxEngineer.engLicenseNo) &&
        Objects.equals(rating, mxEngineer.rating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, engLicenseNo, rating);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MXEngineer {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    engLicenseNo: ").append(toIndentedString(engLicenseNo)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
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

