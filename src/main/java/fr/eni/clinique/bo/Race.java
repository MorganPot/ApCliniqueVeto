package fr.eni.clinique.bo;

public class Race {
	String Race;
	String Espece;
	
	public Race(String race, String espece) {
		super();
		Race = race;
		Espece = espece;
	}
	
	public String getRace() {
		return Race;
	}
	public void setRace(String race) {
		Race = race;
	}
	public String getEspece() {
		return Espece;
	}
	public void setEspece(String espece) {
		Espece = espece;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Race [Race=").append(Race).append(", Espece=").append(Espece).append("]");
		return builder.toString();
	}
	
	
}
