package io.betterbanking.service;

import io.betterbanking.adapter.OBTransactionAdapter;
import io.betterbanking.entity.Transaction;
import io.betterbanking.model.OBTransaction6;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RestTransactionApiClient implements TransactionApiClient{

    private final WebClient webClient;

    private final OBTransactionAdapter obTransactionAdapter;

    public RestTransactionApiClient(@Value("${remoteserver}") String remoteServer, OBTransactionAdapter obTransactionAdapter){
        this.webClient = WebClient.builder().baseUrl(remoteServer).defaultHeader(HttpHeaders.CONTENT_TYPE).build();
        this.obTransactionAdapter = obTransactionAdapter;
    }

    @CircuitBreaker(name = "restTransactionApiClient", fallbackMethod = "fallback")
    @Override
    public List<Transaction> getTransactionByAccountNumber(String accountNumber) {
        List<OBTransaction6> obTransaction6List = webClient
                .get()
                .uri("/open-banking/v3.1/aisp/accounts/{accountNumber}/transactions", accountNumber)
                .retrieve()
                .bodyToFlux(OBTransaction6.class)
                .collectList()
                .block();

        return obTransaction6List.stream()
                .map(obTransactionAdapter::adaptTransaction)
                .collect(Collectors.toList());
    }

    private List<Transaction> fallback(String accountNumber, RuntimeException e) {
        log.debug("fail: "+e.getStackTrace());
        return Collections.EMPTY_LIST;
    }

}
