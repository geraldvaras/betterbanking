package io.betterbanking.data;

import com.banking.acme.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class TransactionDataUtils {

    public static int NUMBER_TXS = 1;

    public static Collection<OBTransaction6> buildOBTransaction6Collection() {
        Collection<OBTransaction6> obTransaction6s = new ArrayList<>();

        for (int i = 0; i < NUMBER_TXS; i++) {

            OBTransaction6 obTransaction6 = new OBTransaction6();

            // accountid
            obTransaction6.setAccountId("account1");

            //merchant
            OBMerchantDetails1 obMerchantDetails1 = new OBMerchantDetails1();
            obMerchantDetails1.setMerchantName("acme");

            obTransaction6.setMerchantDetails(obMerchantDetails1);

            // currency exchange
            OBCurrencyExchange5 obCurrencyExchange5 = new OBCurrencyExchange5();
            obCurrencyExchange5.setUnitCurrency("EUR");
            obCurrencyExchange5.setTargetCurrency("GBP");
            obCurrencyExchange5.setSourceCurrency("GBP");
            obCurrencyExchange5.setExchangeRate(new BigDecimal(0.89));
            obTransaction6.setCurrencyExchange(obCurrencyExchange5);

            obTransaction6.setCreditDebitIndicator(OBCreditDebitCode1.CREDIT);
            obTransaction6.setStatus(OBEntryStatus1Code.BOOKED);
            obTransaction6.setBookingDateTime(OffsetDateTime.now());

            OBActiveOrHistoricCurrencyAndAmount9 obActiveOrHistoricCurrencyAndAmount9 = new OBActiveOrHistoricCurrencyAndAmount9();
            obActiveOrHistoricCurrencyAndAmount9.setAmount("10");
            obActiveOrHistoricCurrencyAndAmount9.setCurrency("EUR");
            obTransaction6.setAmount(obActiveOrHistoricCurrencyAndAmount9);
            obTransaction6s.add(obTransaction6);
        }
        return obTransaction6s;
    }

    public static OBTransaction6 buildOBTransaction6() {
        OBTransaction6 obTransaction6 = new OBTransaction6();

        // accountid
        obTransaction6.setAccountId("myaccountid");

        //merchant
        OBMerchantDetails1 obMerchantDetails1 = new OBMerchantDetails1();
        obMerchantDetails1.setMerchantName("acme");
        obTransaction6.setMerchantDetails(obMerchantDetails1);

        // currency exchange
        OBCurrencyExchange5 obCurrencyExchange5 = new OBCurrencyExchange5();
        obCurrencyExchange5.setUnitCurrency("EUR");
        obCurrencyExchange5.setTargetCurrency("GBP");
        obCurrencyExchange5.setSourceCurrency("GBP");
        obCurrencyExchange5.setExchangeRate(new BigDecimal(0.89));
        obTransaction6.setCurrencyExchange(obCurrencyExchange5);

        obTransaction6.setCreditDebitIndicator(OBCreditDebitCode1.CREDIT);
        obTransaction6.setStatus(OBEntryStatus1Code.BOOKED);
        obTransaction6.setBookingDateTime(OffsetDateTime.now());

        OBActiveOrHistoricCurrencyAndAmount9 obActiveOrHistoricCurrencyAndAmount9 = new OBActiveOrHistoricCurrencyAndAmount9();
        obActiveOrHistoricCurrencyAndAmount9.setAmount("10");
        obActiveOrHistoricCurrencyAndAmount9.setCurrency("EUR");
        obTransaction6.setAmount(obActiveOrHistoricCurrencyAndAmount9);

        return obTransaction6;
    }

    public static String obTransactionsToJsonString() {
        Collection<OBTransaction6> transaction6s = TransactionDataUtils.buildOBTransaction6Collection();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            return objectMapper.writeValueAsString(transaction6s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
