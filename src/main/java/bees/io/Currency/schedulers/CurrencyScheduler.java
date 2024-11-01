package bees.io.Currency.schedulers;

import bees.io.Currency.domain.enums.ECurrency;
import bees.io.Currency.globals.CurrencyGlobal;
import bees.io.Currency.rest.CurrencyAPIResponse;
import bees.io.Currency.rest.CurrencyRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
//https://kurs.resenje.org/doc/#introduction
@Slf4j
public class CurrencyScheduler {


    private final CurrencyRest currencyRest;

    //    @Scheduled(cron = "0 0 8 * * ?")
    @Scheduled(cron = "0 0 9 * * ?")
    public void updateCurrency() {
        log.info("Updating currency rates");

        Map<ECurrency, Map<ECurrency, Double>> conversionRates = new HashMap<>();


        for (ECurrency eCurrency : CurrencyGlobal.targetCurrency) {
            Map<ECurrency, Double> rates = new HashMap<>();

            try {
                CurrencyAPIResponse conversionRate = currencyRest.getConversionRate(eCurrency);
                if (conversionRate == null) {
                    continue;
                }

                for (Map.Entry<String, Double> stringDoubleEntry : conversionRate.getConversionRates().entrySet()) {
                    rates.put(ECurrency.valueOf(stringDoubleEntry.getKey()), stringDoubleEntry.getValue());
                }


                conversionRates.put(eCurrency, rates);
            }catch (Exception e){
                log.error("Error while updating currency rates: {}", e.getMessage());
            }
        }


        System.out.println(conversionRates);
        CurrencyGlobal.conversionRates=conversionRates;

    }

}
