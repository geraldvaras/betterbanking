package io.betterbanking.restapi.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Transaction {
    private String accountNumber;
    private String type;
    private String currency;
    private BigDecimal amount;
    private String merchantName;
    private String merchantLogo;

}
