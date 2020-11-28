package io.betterbanking.service;

import com.banking.acme.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
public class RestTransactionApiClientTest {

    @Autowired
    private TransactionApiClient transactionApiClient;

    public static MockWebServer mockWebServer;

    @BeforeAll
    public static void beforeClass() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start(8090);
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void findAllByAccountNumber() {
        String transactionResponse = this.obTransactionsToJsonString();
        MockResponse mockResponse = new MockResponse()
                .setBody(transactionResponse)
                .addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        mockWebServer.enqueue(mockResponse);
    }

    private String obTransactionsToJsonString() {
        Collection<OBTransaction6> transaction6s = this.buildOBTransaction6();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        try {
            return objectMapper.writeValueAsString(transaction6s);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private Collection<OBTransaction6> buildOBTransaction6() {
        Collection<OBTransaction6> obTransaction6s = new ArrayList<>();

        for(int i = 0; i < 4 ;i++){
            OBTransaction6 obTransaction6 = new OBTransaction6();

            // account id
            obTransaction6.setAccountId(String.format("account%d",i));

            // merchant
            OBMerchantDetails1 obMerchantDetails1 = new OBMerchantDetails1();
            obMerchantDetails1.setMerchantName(String.format("merchant%d",i));
            obTransaction6.setMerchantDetails(obMerchantDetails1);

            // currency exchange
            OBCurrencyExchange5 obCurrencyExchange5 = new OBCurrencyExchange5();
            obCurrencyExchange5.setUnitCurrency("EUR");
            obCurrencyExchange5.setTargetCurrency("GBP");
            obCurrencyExchange5.setSourceCurrency("GBP");
            obCurrencyExchange5.setExchangeRate(new BigDecimal("0.89"));
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
}
