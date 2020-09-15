package PerCapitaInformation;

public class Gender {
	boolean gender;

	public Gender(String gender) {

		this.gender = gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("male");
	}

	public String getGender() {
		if (this.gender)
			return "M";
		return "F";
	}

	public void setGender(String gender) {
		this.gender = gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("male");
	}
}
