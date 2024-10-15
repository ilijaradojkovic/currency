package bees.io.Currency.controllers;

import bees.io.Currency.domain.enums.ECurrency;
import bees.io.Currency.domain.response.CurrencyResponse;
import bees.io.Currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController
{
    private final CurrencyService currencyService;

    @GetMapping()
    public ResponseEntity<Double> getCurrencies(@RequestParam("targetCurrency") ECurrency eCurrency){
        Double  currencies = currencyService.getCurrencies(eCurrency);
        return ResponseEntity.ok(currencies);
    }

}
