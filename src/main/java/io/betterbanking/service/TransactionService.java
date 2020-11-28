package io.betterbanking.service;

import io.betterbanking.entity.Transaction;
import io.betterbanking.repository.MerchantDetailsRepository;

import java.math.BigDecimal;
import java.util.List;

public class TransactionService {

    private TransactionApiClient transactionApiClient;
    private MerchantDetailsRepository merchantDetailsRepository;

    public TransactionService(TransactionApiClient transactionApiClient, MerchantDetailsRepository merchantDetailsRepository) {
        this.transactionApiClient = transactionApiClient;
        this.merchantDetailsRepository = merchantDetailsRepository;
    }

    public List<Transaction> findAllByAccountNumber(String accountNumber){
        return List.of(new Transaction("1","CREDIT","USD",BigDecimal.TEN,"ACME",null));
    }
}
