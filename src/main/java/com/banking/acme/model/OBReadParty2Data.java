package com.banking.acme.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * OBReadParty2Data
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-24T20:22:39.797Z[GMT]")


public class OBReadParty2Data   {
  @JsonProperty("Party")
  private OBParty2 party = null;

  public OBReadParty2Data party(OBParty2 party) {
    this.party = party;
    return this;
  }

  /**
   * Get party
   * @return party
   **/
  @Schema(description = "")
  
    @Valid
    public OBParty2 getParty() {
    return party;
  }

  public void setParty(OBParty2 party) {
    this.party = party;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadParty2Data obReadParty2Data = (OBReadParty2Data) o;
    return Objects.equals(this.party, obReadParty2Data.party);
  }

  @Override
  public int hashCode() {
    return Objects.hash(party);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadParty2Data {\n");
    
    sb.append("    party: ").append(toIndentedString(party)).append("\n");
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
