package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Aircraft
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-12-07T22:58:45.808-07:00[Canada/Mountain]")

public class Aircraft   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("registration")
  private String registration;

  @JsonProperty("type")
  private String type;

  @JsonProperty("serial_no")
  private String serialNo;

  public Aircraft id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Aircraft registration(String registration) {
    this.registration = registration;
    return this;
  }

  /**
   * Get registration
   * @return registration
  */
  @ApiModelProperty(value = "")


  public String getRegistration() {
    return registration;
  }

  public void setRegistration(String registration) {
    this.registration = registration;
  }

  public Aircraft type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @ApiModelProperty(value = "")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Aircraft serialNo(String serialNo) {
    this.serialNo = serialNo;
    return this;
  }

  /**
   * Get serialNo
   * @return serialNo
  */
  @ApiModelProperty(value = "")


  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Aircraft aircraft = (Aircraft) o;
    return Objects.equals(this.id, aircraft.id) &&
        Objects.equals(this.registration, aircraft.registration) &&
        Objects.equals(this.type, aircraft.type) &&
        Objects.equals(this.serialNo, aircraft.serialNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, registration, type, serialNo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Aircraft {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    registration: ").append(toIndentedString(registration)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    serialNo: ").append(toIndentedString(serialNo)).append("\n");
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

