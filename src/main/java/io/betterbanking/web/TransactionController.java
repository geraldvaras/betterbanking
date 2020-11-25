package io.betterbanking.web;

import io.betterbanking.entity.Transaction;
import io.betterbanking.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    public TransactionController(final TransactionService transactionService){
        this.transactionService = transactionService;
    }

    private final TransactionService transactionService;

    @GetMapping(value = "/transactions/{accountNumber}",produces = "application/json")
    public List<Transaction> findAllByAccountNumber(@PathVariable final Integer accountNumber){
        return transactionService.findAllByAccountNumber(accountNumber);
    }
}
