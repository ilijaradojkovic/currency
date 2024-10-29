package bees.io.Currency;

import bees.io.Currency.globals.CurrencyGlobal;
import bees.io.Currency.schedulers.CurrencyScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@RequiredArgsConstructor
@EnableAspectJAutoProxy
public class CurrencyApplication implements ApplicationRunner {

	private final CurrencyScheduler currencyScheduler;
	public static void main(String[] args) {
		SpringApplication.run(CurrencyApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		currencyScheduler.updateCurrency();
		System.out.println("Currency rates updated");
		System.out.println(CurrencyGlobal.conversionRates);
	}
}
