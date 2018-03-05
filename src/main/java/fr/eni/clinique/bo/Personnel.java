package fr.eni.clinique.bo;

public class Personnel {
	int CodePers;
	String Nom;
	String MotPasse;
	String Role;
	Boolean Archive;
	
	public Personnel() {
	}
		
	public Personnel(int codePers, String nom, String motPasse, String role, Boolean archive) {
		super();
		CodePers = codePers;
		Nom = nom;
		MotPasse = motPasse;
		Role = role;
		Archive = archive;
	}
	
	public int getCodePers() {
		return CodePers;
	}
	public void setCodePers(int codePers) {
		CodePers = codePers;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getMotPasse() {
		return MotPasse;
	}
	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
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
		builder.append("Personnel [CodePers=").append(CodePers).append(", Nom=").append(Nom).append(", MotPasse=")
				.append(MotPasse).append(", Role=").append(Role).append(", Archive=").append(Archive).append("]");
		return builder.toString();
	}	
}
