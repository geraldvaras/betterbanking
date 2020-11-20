package io.betterbanking.restapi.integration;

import io.betterbanking.restapi.controller.TransactionController;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionComponentTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void whenGetTransaction() {
        given().standaloneSetup(new TransactionController());
    }

    @BeforeEach
    public void initialiseRestAssuredMockMvcWebApplicationContext() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void givenAccountNumerGetTransactions(){
        String accountNumber = "000000";
        given()
                .when().
                    get("/api/transactions/"+accountNumber)
                        .then()
                            .log().ifValidationFails()
                                .status(HttpStatus.OK);
    }

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void givenGreetURI_whenSendingReq_thenVerifyResponse() {
        given()
                .get("/api/transactions/0000000")
                    .then()
                        .statusCode(200);
    }

}
