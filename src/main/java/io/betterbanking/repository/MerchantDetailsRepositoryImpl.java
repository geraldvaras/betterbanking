package io.betterbanking.repository;

import io.betterbanking.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MerchantDetailsRepositoryImpl implements MerchantDetailsRepository {

    private final static ConcurrentHashMap<String, String> merchantLogo = new ConcurrentHashMap<>();
    static {
        merchantLogo.put("Acme", "acme-logo.png");
        merchantLogo.put("Globex", "globex-logo.jpg");
        merchantLogo.put("Morley", "morley-logo.jpg");
        merchantLogo.put("Contoso", "contoso-logo.jpg");
    }

    @Override
    public Transaction addMerchantLogo(Transaction transaction) {
        transaction.setMerchantLogo(merchantLogo.getOrDefault(transaction.getMerchantName(), "default-logo.jpg"));
        return transaction;
    }
}
