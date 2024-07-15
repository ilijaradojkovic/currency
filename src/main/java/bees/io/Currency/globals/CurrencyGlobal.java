package bees.io.Currency.globals;

import bees.io.Currency.domain.enums.ECurrency;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class CurrencyGlobal {


    public  static  Map<ECurrency, Map<ECurrency, Double>> conversionRates = new HashMap<>();


    public static ECurrency targetCurrency=ECurrency.EUR;

}
