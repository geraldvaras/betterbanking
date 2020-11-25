package io.betterbanking.service;

import io.betterbanking.adapter.OBTransactionAdapter;
import io.betterbanking.entity.Transaction;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RestTransactionApiClientIntegrationTest {

    private final MockWebServer mockWebServer = new MockWebServer();
    private final RestTransactionApiClient restTransactionApiClient = new RestTransactionApiClient(mockWebServer.url("").toString(), new OBTransactionAdapter());

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void getTransactionByAccountNumber() {
        mockWebServer.setDispatcher(dispatcher);
        final List<Transaction> transactionList = restTransactionApiClient.getTransactionByAccountNumber("123");
        assertEquals(1, transactionList.size());
    }

    final Dispatcher dispatcher = new Dispatcher() {
        public MockResponse dispatch (RecordedRequest request) throws InterruptedException {
            switch (request.getPath()) {
                case "/open-banking/v3.1/aisp/accounts/123/transactions":
                    return new MockResponse()
                            .setResponseCode(200)
                            .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                            .setBody("{ \"items\" : { \"AccountId\" : \"1323\" }}"); // need example json
            }
            return new MockResponse().setResponseCode(404);
        }
    };

}
