package io.betterbanking.service;

import io.betterbanking.entity.Transaction;

import java.util.List;

public interface TransactionApiClient {

    List<Transaction> getTransactionByAccountNumber(String accountNumber);
}
