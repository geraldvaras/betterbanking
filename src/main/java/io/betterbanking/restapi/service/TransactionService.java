package io.betterbanking.restapi.service;

import io.betterbanking.restapi.entity.Transaction;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionService {
    public List<Transaction> findAllByAccountNumber(String accountNumber){

        Transaction t1 = new Transaction();
        t1.setAccountNumber("000000");
        t1.setAmount(new BigDecimal(BigInteger.TEN));
        t1.setCurrency("USD");
        t1.setMerchantName("HomerStore");

        Transaction t2 = new Transaction();
        t2.setAccountNumber("000000");
        t2.setAmount(new BigDecimal(BigInteger.TWO));
        t2.setCurrency("USD");
        t2.setMerchantName("MargeStore");

        List<Transaction> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);

        return list;
    }
}
