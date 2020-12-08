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
 * MXEngineer
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-08T04:12:08.912-07:00[Canada/Mountain]")

public class MXEngineer   {
  @JsonProperty("user_id")
  private AdminUserId userId;

  @JsonProperty("eng_license_no")
  private String engLicenseNo;

  @JsonProperty("rating")
  private String rating;

  public MXEngineer userId(AdminUserId userId) {
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

  public MXEngineer engLicenseNo(String engLicenseNo) {
    this.engLicenseNo = engLicenseNo;
    return this;
  }

  /**
   * Get engLicenseNo
   * @return engLicenseNo
  */
  @ApiModelProperty(value = "")


  public String getEngLicenseNo() {
    return engLicenseNo;
  }

  public void setEngLicenseNo(String engLicenseNo) {
    this.engLicenseNo = engLicenseNo;
  }

  public MXEngineer rating(String rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * @return rating
  */
  @ApiModelProperty(value = "")


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
    return Objects.equals(this.userId, mxEngineer.userId) &&
        Objects.equals(this.engLicenseNo, mxEngineer.engLicenseNo) &&
        Objects.equals(this.rating, mxEngineer.rating);
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

