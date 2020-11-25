package com.banking.acme.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Contains details of fees and charges which are not associated with either LoanRepayment or features/benefits
 */
@Schema(description = "Contains details of fees and charges which are not associated with either LoanRepayment or features/benefits")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-24T20:22:39.797Z[GMT]")


public class OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges   {
  @JsonProperty("LoanInterestFeeChargeDetail")
  @Valid
  private List<OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeDetail> loanInterestFeeChargeDetail = new ArrayList<>();

  @JsonProperty("LoanInterestFeeChargeCap")
  @Valid
  private List<OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeCap> loanInterestFeeChargeCap = null;

  public OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges loanInterestFeeChargeDetail(List<OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeDetail> loanInterestFeeChargeDetail) {
    this.loanInterestFeeChargeDetail = loanInterestFeeChargeDetail;
    return this;
  }

  public OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges addLoanInterestFeeChargeDetailItem(OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeDetail loanInterestFeeChargeDetailItem) {
    this.loanInterestFeeChargeDetail.add(loanInterestFeeChargeDetailItem);
    return this;
  }

  /**
   * Get loanInterestFeeChargeDetail
   * @return loanInterestFeeChargeDetail
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
  @Size(min=1)   public List<OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeDetail> getLoanInterestFeeChargeDetail() {
    return loanInterestFeeChargeDetail;
  }

  public void setLoanInterestFeeChargeDetail(List<OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeDetail> loanInterestFeeChargeDetail) {
    this.loanInterestFeeChargeDetail = loanInterestFeeChargeDetail;
  }

  public OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges loanInterestFeeChargeCap(List<OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeCap> loanInterestFeeChargeCap) {
    this.loanInterestFeeChargeCap = loanInterestFeeChargeCap;
    return this;
  }

  public OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges addLoanInterestFeeChargeCapItem(OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeCap loanInterestFeeChargeCapItem) {
    if (this.loanInterestFeeChargeCap == null) {
      this.loanInterestFeeChargeCap = new ArrayList<>();
    }
    this.loanInterestFeeChargeCap.add(loanInterestFeeChargeCapItem);
    return this;
  }

  /**
   * Get loanInterestFeeChargeCap
   * @return loanInterestFeeChargeCap
   **/
  @Schema(description = "")
      @Valid
    public List<OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeCap> getLoanInterestFeeChargeCap() {
    return loanInterestFeeChargeCap;
  }

  public void setLoanInterestFeeChargeCap(List<OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeeChargeCap> loanInterestFeeChargeCap) {
    this.loanInterestFeeChargeCap = loanInterestFeeChargeCap;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges obReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges = (OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges) o;
    return Objects.equals(this.loanInterestFeeChargeDetail, obReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges.loanInterestFeeChargeDetail) &&
        Objects.equals(this.loanInterestFeeChargeCap, obReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges.loanInterestFeeChargeCap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loanInterestFeeChargeDetail, loanInterestFeeChargeCap);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadProduct2DataOtherProductTypeLoanInterestLoanInterestFeesCharges {\n");
    
    sb.append("    loanInterestFeeChargeDetail: ").append(toIndentedString(loanInterestFeeChargeDetail)).append("\n");
    sb.append("    loanInterestFeeChargeCap: ").append(toIndentedString(loanInterestFeeChargeCap)).append("\n");
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
