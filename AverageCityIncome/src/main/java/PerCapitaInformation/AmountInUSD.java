package PerCapitaInformation;

import java.util.HashMap;

public class AmountInUSD {
	Float amountInUSD;
	HashMap<String, Float> currencyMap;

	public AmountInUSD(String currency, Float amount) {
		currencyMap = new HashMap<String, Float>();
		currencyMap.put("INR", (float) 66);
		currencyMap.put("GBP", (float) 0.67);
		currencyMap.put("SGD", (float) 1.5);
		currencyMap.put("HKD", (float) 8);
		this.amountInUSD = amount / currencyMap.get(currency);
	}

	public AmountInUSD() {
		currencyMap = new HashMap<String, Float>();
		currencyMap.put("INR", (float) 66);
		currencyMap.put("GBP", (float) 0.67);
		currencyMap.put("SGD", (float) 1.5);
		currencyMap.put("HKD", (float) 8);
	}

	public Float getAmountInUSD() {
		return amountInUSD;
	}

	public void setAmountInUSD(Float amountInUSD) {
		this.amountInUSD = amountInUSD;
	}

}
