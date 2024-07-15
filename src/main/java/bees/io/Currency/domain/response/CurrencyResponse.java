package bees.io.Currency.domain.response;

import bees.io.Currency.domain.enums.ECurrency;

import java.util.Map;

public record CurrencyResponse(

        Map<ECurrency, Double> data
) {
}
