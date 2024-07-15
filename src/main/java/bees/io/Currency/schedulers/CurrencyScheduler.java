package bees.io.Currency.schedulers;

import bees.io.Currency.domain.enums.ECurrency;
import bees.io.Currency.globals.CurrencyGlobal;
import bees.io.Currency.rest.CurrencyAPIResponse;
import bees.io.Currency.rest.CurrencyRest;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CurrencyScheduler {


    private final CurrencyRest currencyRest;

    //    @Scheduled(cron = "0 0 8 * * ?")
    @Scheduled(cron = "0 * * * * ?")
    public void updateCurrency() {
        Map<ECurrency, Map<ECurrency, Double>> conversionRates = new HashMap<>();

        Map<ECurrency, Double> rates = new HashMap<>();

            CurrencyAPIResponse conversionRate = currencyRest.getConversionRate(CurrencyGlobal.targetCurrency);
            if (conversionRate == null) {
                return;
            }


            for (Map.Entry<String, Double> element : conversionRate.getConversionRates().entrySet()) {
                rates.put(ECurrency.valueOf(element.getKey()), element.getValue());
            }
            rates.clear();
            conversionRates.put(ECurrency.EUR, rates);



        CurrencyGlobal.conversionRates=conversionRates;

    }

}
