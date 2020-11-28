package io.betterbanking.web;

import io.betterbanking.entity.Transaction;
import io.betterbanking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    public TransactionController(final TransactionService transactionService){
        this.transactionService = transactionService;
    }

    private final TransactionService transactionService;

    @GetMapping(value = "/{accountNumber}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> findAllByAccountNumber(@PathVariable final String accountNumber){
        return transactionService.findAllByAccountNumber(accountNumber);
    }
}
