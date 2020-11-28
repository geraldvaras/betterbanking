package io.betterbanking.repository;

import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMerchantDetailsRepositoryImpl implements MerchantDetailsRepository {

    @Value("#{${bb.merchant.logos}}")
    private ConcurrentHashMap<String, String> merchantLogoMap;

    @Override
    public Optional<String> getMerchantLogo(final String merchantName) {
        if(merchantName == null){
            return Optional.of("default-logo.png");
        }
        return Optional.of(merchantLogoMap.getOrDefault(merchantName, "default-logo.png"));
    }
}
