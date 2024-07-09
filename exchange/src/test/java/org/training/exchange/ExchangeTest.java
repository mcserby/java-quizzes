package org.training.exchange;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExchangeTest {

    Exchange exchange = new Exchange();

    @Test
    void testGetEstimatedPriceOfUSDInEUR() {
        Double estimatedPrice = exchange.getEstimatedPrice("USD", "EUR");
        System.out.println("One USD is " + estimatedPrice + " EUR");
        assertEquals(0.9, estimatedPrice);
    }

    @Test
    void testGetEstimatedPriceOfETHInEUR() {
        Double estimatedPrice = exchange.getEstimatedPrice("ETH", "EUR");
        System.out.println("One ETH is " + estimatedPrice + " EUR");
        assertEquals(2010.4, estimatedPrice);
    }

    // TODO Your test here

    @Test
    void computeWalletValue() {
        Exchange.Wallet wallet = new Exchange.Wallet(List.of(
                new Exchange.Liquidity(100.0, "USD"),
                new Exchange.Liquidity(50.0, "EUR"),
                new Exchange.Liquidity(5.0, "ETH"),
                new Exchange.Liquidity(0.5, "BTC")
        ));
        Double walletValue = exchange.computeWalletValue(wallet, "EUR");
        System.out.println("Wallet value is " + walletValue + " EUR");
        assertEquals(100 * 0.9 + 50 + 5 * 2010.4 + 0.5 * 42233.0, walletValue);
    }
}