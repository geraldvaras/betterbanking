package io.betterbanking.service;

import io.betterbanking.entity.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {
    public List<Transaction> findAllByAccountNumber(Integer accountNumber){
        return List.of(new Transaction("1","CREDIT","USD",BigDecimal.TEN,"ACME","acme.png"));
    }
}
