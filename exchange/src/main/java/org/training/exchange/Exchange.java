package org.training.exchange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exchange {

    private static final Map<String, Double> PRICE_REPO = new HashMap<>();

    static {
        PRICE_REPO.put("USD_EUR", 0.9);
        PRICE_REPO.put("ETH_EUR", 2010.4);
        PRICE_REPO.put("ETH_BTC", 0.11);
        PRICE_REPO.put("ETH_USD", 2100.0);
        PRICE_REPO.put("BTC_USD", 42233.0);
    }

    public static record Liquidity(double value, String ticker) {}

    public static record Wallet(List<Liquidity> liquidityList) {}

    public Double getEstimatedPrice(String subjectTicker, String referenceTicker) {
        return 0.0;
    }

    public Double computeWalletValue(Wallet wallet, String tokenOut) {
        return 0.0;
    }
}
