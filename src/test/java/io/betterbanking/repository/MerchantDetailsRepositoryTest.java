package io.betterbanking.repository;

import io.betterbanking.entity.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
public class MerchantDetailsRepositoryTest {

    @Autowired
    MerchantDetailsRepository merchantDetailsRepository;

    @Test
    public void testFindAllByAccountNumber() {
        final List<Transaction> accountTransactionList = List.of(
                new Transaction("Debit", "123", "GBP", BigDecimal.TEN, "Acme", ""),
                new Transaction("Debit", "456", "USD", BigDecimal.ONE, "Globex", ""));
        accountTransactionList.forEach(transaction -> merchantDetailsRepository.addMerchantLogo(transaction));
        assertThat(accountTransactionList, hasSize(2));
    }

}
