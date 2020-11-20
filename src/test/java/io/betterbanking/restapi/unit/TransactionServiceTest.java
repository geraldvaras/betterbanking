package io.betterbanking.restapi.unit;

import io.betterbanking.restapi.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void shouldContainTwoElement(){
        assertThat(transactionService.findAllByAccountNumber("00000000"),hasSize(2));
    }
}
