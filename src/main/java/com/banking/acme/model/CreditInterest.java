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
 * Details about the interest that may be payable to the BCA account holders
 */
@Schema(description = "Details about the interest that may be payable to the BCA account holders")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-24T20:22:39.797Z[GMT]")


public class CreditInterest {
    @JsonProperty("TierBandSet")
    @Valid
    private List<CreditInterestTierBandSet> tierBandSet = new ArrayList<>();

    public CreditInterest tierBandSet(List<CreditInterestTierBandSet> tierBandSet) {
        this.tierBandSet = tierBandSet;
        return this;
    }

    public CreditInterest addTierBandSetItem(CreditInterestTierBandSet tierBandSetItem) {
        this.tierBandSet.add(tierBandSetItem);
        return this;
    }

    /**
     * The group of tiers or bands for which credit interest can be applied.
     *
     * @return tierBandSet
     **/
    @Schema(required = true, description = "The group of tiers or bands for which credit interest can be applied.")
    @NotNull
    @Valid
    @Size(min = 1)
    public List<CreditInterestTierBandSet> getTierBandSet() {
        return tierBandSet;
    }

    public void setTierBandSet(List<CreditInterestTierBandSet> tierBandSet) {
        this.tierBandSet = tierBandSet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreditInterest creditInterest = (CreditInterest) o;
        return Objects.equals(this.tierBandSet, creditInterest.tierBandSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tierBandSet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreditInterest {\n");

        sb.append("    tierBandSet: ").append(toIndentedString(tierBandSet)).append("\n");
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
