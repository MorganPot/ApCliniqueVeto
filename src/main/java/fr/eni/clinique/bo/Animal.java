package fr.eni.clinique.bo;

public class Animal {
	int CodeAnimal;
	String NomAnimal;
	String Sexe; 
	String Couleur;
	String Race; 
	String Espece;
	int CodeClient;
	String Tatouage;
	String Antecedents;
	Boolean Archive;
	
	public Animal(int codeAnimal, String nomAnimal, String sexe, String couleur, String race, String espece,
			int codeClient, String tatouage, String antecedents, Boolean archive) {
		super();
		CodeAnimal = codeAnimal;
		NomAnimal = nomAnimal;
		Sexe = sexe;
		Couleur = couleur;
		Race = race;
		Espece = espece;
		CodeClient = codeClient;
		Tatouage = tatouage;
		Antecedents = antecedents;
		Archive = archive;
	}
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public int getCodeAnimal() {
		return CodeAnimal;
	}
	public void setCodeAnimal(int codeAnimal) {
		CodeAnimal = codeAnimal;
	}
	public String getNomAnimal() {
		return NomAnimal;
	}
	public void setNomAnimal(String nomAnimal) {
		NomAnimal = nomAnimal;
	}
	public String getSexe() {
		return Sexe;
	}
	public void setSexe(String sexe) {
		Sexe = sexe;
	}
	public String getCouleur() {
		return Couleur;
	}
	public void setCouleur(String couleur) {
		Couleur = couleur;
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
	public int getCodeClient() {
		return CodeClient;
	}
	public void setCodeClient(int codeClient) {
		CodeClient = codeClient;
	}
	public String getTatouage() {
		return Tatouage;
	}
	public void setTatouage(String tatouage) {
		Tatouage = tatouage;
	}
	public String getAntecedents() {
		return Antecedents;
	}
	public void setAntecedents(String antecedents) {
		Antecedents = antecedents;
	}
	public Boolean getArchive() {
		return Archive;
	}
	public void setArchive(Boolean archive) {
		Archive = archive;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [CodeAnimal=").append(CodeAnimal).append(", NomAnimal=").append(NomAnimal)
				.append(", Sexe=").append(Sexe).append(", Couleur=").append(Couleur).append(", Race=").append(Race)
				.append(", Espece=").append(Espece).append(", CodeClient=").append(CodeClient).append(", Tatouage=")
				.append(Tatouage).append(", Antecedents=").append(Antecedents).append(", Archive=").append(Archive)
				.append("]");
		return builder.toString();
	}
	
	
}
