package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.exception.LoginException;
import fr.eni.clinique.bll.factory.LoginFactory;
import fr.eni.clinique.bll.manager.LoginManager;
import fr.eni.clinique.bo.Personnel;

public class ConnexionModel extends Observable{

    private List<Personnel> personnels = new ArrayList<>();

    private LoginManager loginManager = LoginFactory.loginManager();
	
    public Boolean verifLog(String nom, String motPasse) throws LoginException {
    	
		Boolean result = false;
		
		try {
	        
			for (Personnel personnel : loginManager.getPerso()) {
				if(personnel.getNom().equals(nom) && personnel.getMotPasse().equals(motPasse)){
					result = true;
				}
			}
            
        } catch (LoginException e) {
            throw new LoginException("Error getting Articles", e);
        }
		
		return result;
	} 
}
