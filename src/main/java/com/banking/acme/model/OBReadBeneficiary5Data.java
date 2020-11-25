package com.banking.acme.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * OBReadBeneficiary5Data
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-24T20:22:39.797Z[GMT]")


public class OBReadBeneficiary5Data   {
  @JsonProperty("Beneficiary")
  @Valid
  private List<OBBeneficiary5> beneficiary = null;

  public OBReadBeneficiary5Data beneficiary(List<OBBeneficiary5> beneficiary) {
    this.beneficiary = beneficiary;
    return this;
  }

  public OBReadBeneficiary5Data addBeneficiaryItem(OBBeneficiary5 beneficiaryItem) {
    if (this.beneficiary == null) {
      this.beneficiary = new ArrayList<>();
    }
    this.beneficiary.add(beneficiaryItem);
    return this;
  }

  /**
   * Get beneficiary
   * @return beneficiary
   **/
  @Schema(description = "")
      @Valid
    public List<OBBeneficiary5> getBeneficiary() {
    return beneficiary;
  }

  public void setBeneficiary(List<OBBeneficiary5> beneficiary) {
    this.beneficiary = beneficiary;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadBeneficiary5Data obReadBeneficiary5Data = (OBReadBeneficiary5Data) o;
    return Objects.equals(this.beneficiary, obReadBeneficiary5Data.beneficiary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beneficiary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadBeneficiary5Data {\n");
    
    sb.append("    beneficiary: ").append(toIndentedString(beneficiary)).append("\n");
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
