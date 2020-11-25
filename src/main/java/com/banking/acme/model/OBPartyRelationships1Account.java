package com.banking.acme.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * Relationship to the Account resource.
 */
@Schema(description = "Relationship to the Account resource.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-24T20:22:39.797Z[GMT]")


public class OBPartyRelationships1Account   {
  @JsonProperty("Related")
  private String related = null;

  @JsonProperty("Id")
  private String id = null;

  public OBPartyRelationships1Account related(String related) {
    this.related = related;
    return this;
  }

  /**
   * Absolute URI to the related resource.
   * @return related
   **/
  @Schema(required = true, description = "Absolute URI to the related resource.")
      @NotNull

    public String getRelated() {
    return related;
  }

  public void setRelated(String related) {
    this.related = related;
  }

  public OBPartyRelationships1Account id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identification as assigned by the ASPSP to uniquely identify the related resource.
   * @return id
   **/
  @Schema(required = true, description = "Unique identification as assigned by the ASPSP to uniquely identify the related resource.")
      @NotNull

  @Size(min=1,max=40)   public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBPartyRelationships1Account obPartyRelationships1Account = (OBPartyRelationships1Account) o;
    return Objects.equals(this.related, obPartyRelationships1Account.related) &&
        Objects.equals(this.id, obPartyRelationships1Account.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(related, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBPartyRelationships1Account {\n");
    
    sb.append("    related: ").append(toIndentedString(related)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
