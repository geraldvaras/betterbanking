package io.betterbanking.repository;

import java.util.Optional;

public interface MerchantDetailsRepository {
    Optional<String> getMerchantLogo(final String merchandName);
}
