package PerCapitaSummFormat;

import PerCapitaInformation.Gender;
import PerCapitaInformation.PerCapitaInfoDAO;

public class SummaryItemDao {
	
	String city;
	Gender gender;
	
	public SummaryItemDao() {}
	
	public SummaryItemDao(String city, String gender) {
		super();
		this.city = city;
		this.gender = new Gender(gender);
	}

	public SummaryItemDao( PerCapitaInfoDAO obj) {
		this.city = obj.getCity();
		this.gender = obj.getGender();
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender.getGender();
	}
	public void setGender(String gender) {
		this.gender.setGender(gender);
	}
}
