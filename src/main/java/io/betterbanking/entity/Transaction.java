package io.betterbanking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private String accountNumber;
    private String type;
    private String currency;
    private BigDecimal amount;
    private String merchantName;
    private String merchantLogo;
}
