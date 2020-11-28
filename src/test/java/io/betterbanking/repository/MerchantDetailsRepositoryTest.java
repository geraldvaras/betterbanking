package io.betterbanking.repository;

import io.betterbanking.entity.Transaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class MerchantDetailsRepositoryTest {

    @Autowired
    MerchantDetailsRepository merchantDetailsRepository;

    @Test
    @DisplayName("Test find by account number")
    public void testFindByAccountNumber() {
        final List<Transaction> accountTransactionList = List.of(
                new Transaction("1","Debit","GBP", BigDecimal.TEN, "acme", null),
                new Transaction("2","Debit","USD", BigDecimal.ONE, "globex", null),
                new Transaction("3","Debit","USD", BigDecimal.ONE, "morley", null));
        assertThat(accountTransactionList, hasSize(3));
    }

    @Test
    @DisplayName(" Test lookup valid logo by merchant name")
    public void testLookupLogoByMerchantNameValid(){
        Transaction transaction = new Transaction("1","Debit","GBP", BigDecimal.TEN, "acme", null);
        Optional<String> logo = merchantDetailsRepository.getMerchantLogo(transaction.getMerchantName());
        transaction.setMerchantLogo(logo.get());
        assertThat(transaction.getMerchantLogo(),equalToIgnoringCase("acme-logo.png"));
    }

    @Test
    @DisplayName(" Test lookup logo by merchant name null")
    public void testLookupDefaultLogoByMerchantNameNull(){
        Transaction transaction = new Transaction("1","Debit","GBP", BigDecimal.TEN, null, null);
        Optional<String> logo = merchantDetailsRepository.getMerchantLogo(transaction.getMerchantName());
        transaction.setMerchantLogo(logo.get());
        assertThat(transaction.getMerchantLogo(),equalToIgnoringCase("default-logo.png"));
    }

    @Test
    @DisplayName(" Test lookup logo by inavalid merchant name")
    public void testLookupDefaultLogoByMerchantNameUnknown(){
        Transaction transaction = new Transaction("1","Debit","GBP", BigDecimal.TEN, "bbva", null);
        Optional<String> logo = merchantDetailsRepository.getMerchantLogo(transaction.getMerchantName());
        transaction.setMerchantLogo(logo.get());
        assertThat(transaction.getMerchantLogo(),equalToIgnoringCase("default-logo.png"));
    }

}
