package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.LoginException;
import fr.eni.clinique.bo.Personnel;

public interface LoginManager {
	
	 List<Personnel> getPerso() throws LoginException;
	    
	 Boolean VerifLogin(String nom, String motPasse) throws LoginException;
}
