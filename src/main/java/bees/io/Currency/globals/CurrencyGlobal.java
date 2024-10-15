package bees.io.Currency.globals;

import bees.io.Currency.domain.enums.ECurrency;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CurrencyGlobal {


    public  static  Map<ECurrency, Map<ECurrency, Double>> conversionRates = new HashMap<>();
    public static ECurrency baseCurrency=ECurrency.EUR;
    public static List<ECurrency> targetCurrency=new LinkedList<>(){{
        //Ovo daje koliko je 1 EUR u ostalim valutama pa nam zato treba samo EUR
        add(ECurrency.EUR);

    }};

}
