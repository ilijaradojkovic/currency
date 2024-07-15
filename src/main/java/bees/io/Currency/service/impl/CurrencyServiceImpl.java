package bees.io.Currency.service.impl;

import bees.io.Currency.domain.enums.ECurrency;
import bees.io.Currency.globals.CurrencyGlobal;
import bees.io.Currency.rest.CurrencyRest;
import bees.io.Currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private  final CurrencyRest currencyRest;

    @Override
    public Map<ECurrency, Double> getCurrencies(ECurrency eCurrency) {


        return CurrencyGlobal.conversionRates.get(eCurrency);
    }
}
