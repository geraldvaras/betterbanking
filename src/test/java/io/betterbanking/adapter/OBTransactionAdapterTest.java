package io.betterbanking.adapter;

import io.betterbanking.entity.Transaction;
import io.betterbanking.model.OBTransaction6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OBTransactionAdapterTest {

    @InjectMocks
    private OBTransactionAdapter obTransactionAdapter = new OBTransactionAdapter();

    @Mock
    OBTransaction6 obTransaction6;

    @BeforeEach
    void setMockOutput() {
        when(obTransaction6.getAmount()).thenReturn(null);
    }

    @Test
    void testAmountNotNull() {
        Transaction transaction = obTransactionAdapter.adaptTransaction(obTransaction6);
        assertThat(null,is(not(transaction.getAmount())));
    }

}
