package bees.io.Currency.service;

import bees.io.Currency.domain.enums.ECurrency;

import java.util.Map;

public interface CurrencyService {

    Map<ECurrency, Double> getCurrencies(ECurrency eCurrency);

}
