package io.betterbanking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
/**
 * OBReadDataStatement2
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-24T20:22:39.797Z[GMT]")


public class OBReadDataStatement2   {
  @JsonProperty("Statement")
  @Valid
  private List<OBStatement2> statement = null;

  public OBReadDataStatement2 statement(List<OBStatement2> statement) {
    this.statement = statement;
    return this;
  }

  public OBReadDataStatement2 addStatementItem(OBStatement2 statementItem) {
    if (this.statement == null) {
      this.statement = new ArrayList<>();
    }
    this.statement.add(statementItem);
    return this;
  }

  /**
   * Get statement
   * @return statement
   **/
  @Schema(description = "")
      @Valid
    public List<OBStatement2> getStatement() {
    return statement;
  }

  public void setStatement(List<OBStatement2> statement) {
    this.statement = statement;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadDataStatement2 obReadDataStatement2 = (OBReadDataStatement2) o;
    return Objects.equals(this.statement, obReadDataStatement2.statement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadDataStatement2 {\n");
    
    sb.append("    statement: ").append(toIndentedString(statement)).append("\n");
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
