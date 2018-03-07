package fr.eni.clinique.bo;

import java.util.List;

import fr.eni.clinique.dal.dao.jdbc.ConnexionDAOJdbcImpl;
import fr.eni.clinique.dal.exception.DaoException;

public class Client {
	int CodeClient;
	String NomClient;
	String PrenomClient;
	String Adresse1;
	String Adresse2;
	String CodePostal;
	String Ville;
	String NumTel;
	String Assurance;
	String Email;
	String Remarque;
	Boolean Archive;
	
	public Client(){
		
	}
	
	public Client(String nomClient, String prenomClient, String adresse1, String adresse2, String codePostal,
			String ville, Boolean archive) {
		super();
		NomClient = nomClient;
		PrenomClient = prenomClient;
		Adresse1 = adresse1;
		Adresse2 = adresse2;
		CodePostal = codePostal;
		Ville = ville;
		Archive = archive;
	}

	public Client(String nomClient, String prenomClient, String adresse1, String adresse2,
			String codePostal, String ville, String numTel, String assurance, String email, String remarque,
			Boolean archive) {
		super();
		NomClient = nomClient;
		PrenomClient = prenomClient;
		Adresse1 = adresse1;
		Adresse2 = adresse2;
		CodePostal = codePostal;
		Ville = ville;
		NumTel = numTel;
		Assurance = assurance;
		Email = email;
		Remarque = remarque;
		Archive = archive;
	}
	
	public int getCodeClient() {
		return CodeClient;
	}
	public void setCodeClient(int codeClient) {
		CodeClient = codeClient;
	}
	public String getNomClient() {
		return NomClient;
	}
	public void setNomClient(String nomClient) {
		NomClient = nomClient;
	}
	public String getPrenomClient() {
		return PrenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		PrenomClient = prenomClient;
	}
	public String getAdresse1() {
		return Adresse1;
	}
	public void setAdresse1(String adresse1) {
		Adresse1 = adresse1;
	}
	public String getAdresse2() {
		return Adresse2;
	}
	public void setAdresse2(String adresse2) {
		Adresse2 = adresse2;
	}
	public String getCodePostal() {
		return CodePostal;
	}
	public void setCodePostal(String codePostal) {
		CodePostal = codePostal;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public String getNumTel() {
		return NumTel;
	}
	public void setNumTel(String numTel) {
		NumTel = numTel;
	}
	public String getAssurance() {
		return Assurance;
	}
	public void setAssurance(String assurance) {
		Assurance = assurance;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getRemarque() {
		return Remarque;
	}
	public void setRemarque(String remarque) {
		Remarque = remarque;
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
		builder.append("Client [CodeClient=").append(CodeClient).append(", NomClient=").append(NomClient)
				.append(", PrenomClient=").append(PrenomClient).append(", Adresse1=").append(Adresse1)
				.append(", Adresse2=").append(Adresse2).append(", CodePostal=").append(CodePostal).append(", Ville=")
				.append(Ville).append(", NumTel=").append(NumTel).append(", Assurance=").append(Assurance)
				.append(", Email=").append(Email).append(", Remarque=").append(Remarque).append(", Archive=")
				.append(Archive).append("]");
		return builder.toString();
	}
	
	
}
