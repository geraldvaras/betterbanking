package io.betterbanking.restapi.controller;

import io.betterbanking.restapi.entity.Transaction;
import io.betterbanking.restapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transactions/{accountNumber}",produces = "application/json")
    public List<Transaction> findAllByAccountNumber(@PathVariable String accountNumber){
        return transactionService.findAllByAccountNumber(accountNumber);
    }
}
