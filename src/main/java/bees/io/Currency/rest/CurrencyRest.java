package bees.io.Currency.rest;

import bees.io.Currency.domain.enums.ECurrency;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class CurrencyRest {

    @Value("${currency-api.key}")
    private String apiKey="API";

    private String baseURL="https://v6.exchangerate-api.com/v6/API_KEY/latest/CURRENCY";

    private final WebClient webClient;


    public String getUrl(ECurrency eCurrency) {
        return baseURL.replace("API_KEY", apiKey).replace("CURRENCY", eCurrency.name());
    }

    public CurrencyAPIResponse getConversionRate(ECurrency currency) {
       return  webClient.get()
                .uri(getUrl(currency))
                .retrieve()
                .bodyToMono(CurrencyAPIResponse.class)
                .block();

    }

}
