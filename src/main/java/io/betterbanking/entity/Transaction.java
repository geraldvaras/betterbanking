package io.betterbanking.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {
    private String accountNumber;
    private String type;
    private String currency;
    private BigDecimal amount;
    private String merchantName;
    private String merchantLogo;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this).toString();
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = Boolean.FALSE;
        if(object instanceof Transaction) {
            Transaction that = (Transaction) object;
            isEquals = EqualsBuilder.reflectionEquals(this, that);
        }
        return isEquals;
    }


}
