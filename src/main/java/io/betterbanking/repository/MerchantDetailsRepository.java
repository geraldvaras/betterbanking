package io.betterbanking.repository;

import io.betterbanking.entity.Transaction;

public interface MerchantDetailsRepository {
    Transaction addMerchantLogo(Transaction transaction);
}
