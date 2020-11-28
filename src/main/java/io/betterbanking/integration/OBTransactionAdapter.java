package io.betterbanking.integration;

import io.betterbanking.entity.Transaction;
import com.banking.acme.model.OBTransaction6;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public class OBTransactionAdapter {

    public Transaction adapt(final OBTransaction6 transaction6) {
        return transactionFunction.apply(transaction6);
    }

    private Function<OBTransaction6, Transaction> transactionFunction = obTransaction6 -> {
        var t = new Transaction();
        t.setAccountNumber(obTransaction6.getAccountId());

        var amount = lift(obTransaction6, o -> new BigDecimal(o.getAmount().getAmount()));
        var fx = lift(obTransaction6, o -> new BigDecimal(o.getCurrencyExchange().getExchangeRate().doubleValue()));
        t.setAmount(amount.orElse(BigDecimal.ZERO).multiply(fx.orElse(BigDecimal.ONE)));

        lift(obTransaction6, o -> obTransaction6.getCurrencyExchange().getUnitCurrency())
                .ifPresent(t::setCurrency);
        lift(obTransaction6, o -> obTransaction6.getCreditDebitIndicator().toString())
                .ifPresent(t::setType);
        lift(obTransaction6, o -> obTransaction6.getMerchantDetails().getMerchantName())
                .ifPresent(t::setMerchantName);
        return t;
    };

    private <T> Optional<T> lift(final OBTransaction6 transaction6, Function<OBTransaction6, T> func) {
        try {
            return Optional.of(func.apply(transaction6));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
