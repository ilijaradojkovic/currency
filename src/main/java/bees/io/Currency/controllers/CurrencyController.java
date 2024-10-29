package bees.io.Currency.controllers;

import bees.io.Currency.domain.enums.ECurrency;
import bees.io.Currency.domain.response.CurrencyResponse;
import bees.io.Currency.service.CurrencyService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
@Slf4j
public class CurrencyController
{
    private final CurrencyService currencyService;

    @GetMapping()
    @Retry(name = "currencyController")
    @RateLimiter(name = "currencyController")
    public ResponseEntity<Double> getCurrencies(@RequestParam("targetCurrency") ECurrency eCurrency){
        log.info("Getting currency for target currency: {}", eCurrency);
        Double  currencies = currencyService.getCurrencies(eCurrency);
        return ResponseEntity.ok(currencies);
    }

}
