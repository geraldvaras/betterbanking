package io.betterbanking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Set of elements used to fully identify the type of underlying transaction resulting in an entry.
 */
@Schema(description = "Set of elements used to fully identify the type of underlying transaction resulting in an entry.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-24T20:22:39.797Z[GMT]")


public class OBBankTransactionCodeStructure1   {
  @JsonProperty("Code")
  private String code = null;

  @JsonProperty("SubCode")
  private String subCode = null;

  public OBBankTransactionCodeStructure1 code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Specifies the family within a domain.
   * @return code
   **/
  @Schema(required = true, description = "Specifies the family within a domain.")
      @NotNull

  @Size(min=1,max=4)   public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public OBBankTransactionCodeStructure1 subCode(String subCode) {
    this.subCode = subCode;
    return this;
  }

  /**
   * Specifies the sub-product family within a specific family.
   * @return subCode
   **/
  @Schema(required = true, description = "Specifies the sub-product family within a specific family.")
      @NotNull

  @Size(min=1,max=4)   public String getSubCode() {
    return subCode;
  }

  public void setSubCode(String subCode) {
    this.subCode = subCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBBankTransactionCodeStructure1 obBankTransactionCodeStructure1 = (OBBankTransactionCodeStructure1) o;
    return Objects.equals(this.code, obBankTransactionCodeStructure1.code) &&
        Objects.equals(this.subCode, obBankTransactionCodeStructure1.subCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, subCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBBankTransactionCodeStructure1 {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    subCode: ").append(toIndentedString(subCode)).append("\n");
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
