package com.mherdus.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import feign.hystrix.FallbackFactory;



//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
//@FeignClient(name="netflix-zuul-api-gateway-server", fallbackFactory=ExchangeServiceFallback.class)
//@FeignClient(name="netflix-zuul-api-gateway-server", fallback=HystrixClientFallbvach)
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}

@Component 
class ExchangeServiceFallback implements FallbackFactory<CurrencyConversionBean>{

	@Override
	public CurrencyConversionBean create(Throwable cause) {
		// TODO Auto-generated method stub
		return new CurrencyConversionBean(0L, "NONE", "NONE", BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, 0);
	}
		
}

