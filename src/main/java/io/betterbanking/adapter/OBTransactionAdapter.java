package io.betterbanking.adapter;

import io.betterbanking.entity.Transaction;
import io.betterbanking.model.OBTransaction6;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

@Service
public class OBTransactionAdapter {

    public Transaction adaptTransaction(OBTransaction6 obTransaction6) {
        BigDecimal amount = BigDecimal.ZERO;
        if (!ObjectUtils.isEmpty(obTransaction6.getAmount()) && !ObjectUtils.isEmpty(obTransaction6.getAmount().getAmount()))
            amount = new BigDecimal(obTransaction6.getAmount().getAmount());

        BigDecimal exchangeRate = BigDecimal.ZERO;
        if (!ObjectUtils.isEmpty(obTransaction6.getCurrencyExchange()) && !ObjectUtils.isEmpty(obTransaction6.getCurrencyExchange().getExchangeRate()))
            exchangeRate = obTransaction6.getCurrencyExchange().getExchangeRate();

        String unitCurrency = "";
        if (!ObjectUtils.isEmpty(obTransaction6.getCurrencyExchange()) && !ObjectUtils.isEmpty(obTransaction6.getCurrencyExchange().getUnitCurrency()))
            unitCurrency = obTransaction6.getCurrencyExchange().getUnitCurrency();

        String type = "";
        if (!ObjectUtils.isEmpty(obTransaction6.getCreditDebitIndicator()))
            type = obTransaction6.getCreditDebitIndicator().toString();

        String merchantName = "";
        if (!ObjectUtils.isEmpty(obTransaction6.getMerchantDetails()) && !ObjectUtils.isEmpty(obTransaction6.getMerchantDetails().getMerchantName()))
            merchantName = obTransaction6.getMerchantDetails().getMerchantName();

        return new Transaction(
                type,
                obTransaction6.getAccountId(),
                unitCurrency,
                amount.multiply(exchangeRate),
                merchantName,
                "");
    }
}
