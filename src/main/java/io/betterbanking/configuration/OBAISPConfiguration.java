package io.betterbanking.configuration;

import io.betterbanking.integration.OBTransactionAdapter;
import io.betterbanking.repository.InMemoryMerchantDetailsRepositoryImpl;
import io.betterbanking.repository.MerchantDetailsRepository;
import io.betterbanking.service.RestTransactionApiClient;
import io.betterbanking.service.TransactionApiClient;
import io.betterbanking.service.TransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OBAISPConfiguration {

    @Value("${bb.api_server_endpoint}")
    private String apiServerEndpoint;

    @Bean
    public TransactionService transactionService() {
        return new TransactionService(transactionApiClient(),merchantDetailsRepository());
    }

    @Bean
    public OBTransactionAdapter obTransactionAdapter() {
        return new OBTransactionAdapter();
    }

    @Bean
    public javax.validation.Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public TransactionApiClient transactionApiClient() {
        return new RestTransactionApiClient(obTransactionAdapter(), WebClient.builder(),apiServerEndpoint);
    }

    @Bean
    public MerchantDetailsRepository merchantDetailsRepository() {
        return new InMemoryMerchantDetailsRepositoryImpl();
    }
}
