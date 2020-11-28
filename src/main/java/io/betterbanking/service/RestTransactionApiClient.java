package io.betterbanking.service;

import com.banking.acme.model.OBReadTransaction6;
import io.betterbanking.entity.Transaction;
import io.betterbanking.integration.OBTransactionAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class RestTransactionApiClient implements TransactionApiClient {

    private WebClient webClient;

    private OBTransactionAdapter obTransactionAdapter;

    public RestTransactionApiClient(OBTransactionAdapter obTransactionAdapter, WebClient.Builder webCliBuilder,
                                    String apiServerEndPoint) {
        this.obTransactionAdapter = obTransactionAdapter;
        this.webClient = webCliBuilder
                .baseUrl(apiServerEndPoint)
                .build();
    }

    @Override
    public List<Transaction> findAllByAccountNumber(String accountNumber) {
        OBReadTransaction6 res = null;

        try {
            res = webClient.get()
                    .uri("accounts/" + accountNumber + "/transactions")
                    .retrieve()
                    .bodyToMono(OBReadTransaction6.class)
                    .block()
            ;
        } catch (Exception ex) {
            log.error("failed to retrieve account information due to the following reason {}", ex.getMessage());
        }

        if (res == null || res.getData() == null) {
            return Collections.emptyList();
        }

        return res.getData()
                .getTransaction()
                .stream()
                .map(obTransactionAdapter::adapt)
                .collect(Collectors.toList());
    }

}
