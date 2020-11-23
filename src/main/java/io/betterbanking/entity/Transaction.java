package io.betterbanking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private Integer accountNumber;
    private String type;
    private String currency;
    private BigDecimal amount;
    private String merchantName;
    private String merchantLogo;
}
