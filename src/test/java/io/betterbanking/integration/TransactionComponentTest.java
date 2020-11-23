package io.betterbanking.integration;

import io.betterbanking.web.TransactionController;
import io.betterbanking.service.TransactionService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@SpringBootTest
public class TransactionComponentTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testApplicationEndToEnd() {
        given().standaloneSetup(new TransactionController(transactionService))
                .when()
                .get(String.format("http://localhost:%s/api/transactions/1234567", port))
                .then()
                .statusCode(Matchers.is(200));
    }

}
