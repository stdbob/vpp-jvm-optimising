package com.vpp.ch08.catalog;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Price {

	private Map<String,Double> rates;
	private Double value;
	
	public Price(Double value) {
		this.value = value;
		rates = Map.of(
		"USD", 1d,
		"GBP", 0.6,
		"EUR", 0.8);
	}
		
	public Double convert(String toCurrency) {
		
		if (toCurrency.equals("USD")) {
			return value;
		}
		else {
			Double conversion = rates.get("USD") * rates.get(toCurrency);
			value = conversion * value;
			return BigDecimal.valueOf(value).round(new MathContext(4, RoundingMode.HALF_UP)).doubleValue();
		}
	}
	
	public String toString() {
		return this.value.toString();
	}
	
	public Map<String,Double> getRates() {
		return rates;
	}

	public Double getValue() {
		return value;
	}
	
}
