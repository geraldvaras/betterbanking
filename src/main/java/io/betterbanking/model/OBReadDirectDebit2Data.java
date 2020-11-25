package io.betterbanking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * OBReadDirectDebit2Data
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-24T20:22:39.797Z[GMT]")


public class OBReadDirectDebit2Data   {
  @JsonProperty("DirectDebit")
  @Valid
  private List<OBReadDirectDebit2DataDirectDebit> directDebit = null;

  public OBReadDirectDebit2Data directDebit(List<OBReadDirectDebit2DataDirectDebit> directDebit) {
    this.directDebit = directDebit;
    return this;
  }

  public OBReadDirectDebit2Data addDirectDebitItem(OBReadDirectDebit2DataDirectDebit directDebitItem) {
    if (this.directDebit == null) {
      this.directDebit = new ArrayList<>();
    }
    this.directDebit.add(directDebitItem);
    return this;
  }

  /**
   * Get directDebit
   * @return directDebit
   **/
  @Schema(description = "")
      @Valid
    public List<OBReadDirectDebit2DataDirectDebit> getDirectDebit() {
    return directDebit;
  }

  public void setDirectDebit(List<OBReadDirectDebit2DataDirectDebit> directDebit) {
    this.directDebit = directDebit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadDirectDebit2Data obReadDirectDebit2Data = (OBReadDirectDebit2Data) o;
    return Objects.equals(this.directDebit, obReadDirectDebit2Data.directDebit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directDebit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadDirectDebit2Data {\n");
    
    sb.append("    directDebit: ").append(toIndentedString(directDebit)).append("\n");
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
