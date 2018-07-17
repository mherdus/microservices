package com.mherdus.microservices.currencyexchangeservice;

import java.math.BigDecimal;

public interface CurrencyService {
	public void addCurrencyExchangeValue(String currency_from, String currency_to, BigDecimal conversionMultiply);
}
