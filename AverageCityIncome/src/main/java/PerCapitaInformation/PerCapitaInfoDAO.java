package PerCapitaInformation;

public class PerCapitaInfoDAO {

	String city;
	Gender gender;
	String currency;
	Float amount;
	AmountInUSD amntInUSD;

	public PerCapitaInfoDAO() {

	}

	public PerCapitaInfoDAO(String[] input) {
		super();
		this.city = input[0];
		this.gender = new Gender(input[2]);
		this.currency = input[3];
		this.amount = Float.parseFloat(input[4]);
		this.amntInUSD = new AmountInUSD(this.currency, this.amount);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public AmountInUSD getAmntInUSD() {
		return amntInUSD;
	}

	public void setAmntInUSD(AmountInUSD amntInUSD) {
		this.amntInUSD = amntInUSD;
	}

}