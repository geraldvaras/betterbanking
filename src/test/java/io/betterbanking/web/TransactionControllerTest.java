package io.betterbanking.web;

import io.betterbanking.data.TransactionDataUtils;
import io.betterbanking.integration.OBTransactionAdapter;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    OBTransactionAdapter obTransactionAdapter;

    static MockWebServer mockWebServer;

    @BeforeAll
    public static void beforeClass() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start(8090);
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testFindAllByAccountNumber() throws Exception {
        String transactionResponse = TransactionDataUtils.obTransactionsToJsonString();

        MockResponse mockResponse = new MockResponse()
                .setBody(transactionResponse)
                .addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        mockWebServer.enqueue(mockResponse);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/transactions/abcdef")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(TransactionDataUtils.NUMBER_TXS)))
                .andReturn();
    }
}
