package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginManager;
import fr.eni.clinique.bo.Personnel;

public class ConnexionModel extends Observable{

    private List<Personnel> personnels = new ArrayList<>();

    private LoginManager loginManager = ManagerFactory.loginManager();
    
    private Personnel perso = null;
	
    public Boolean verifLog(String nom, String motPasse) throws ManagerException {
    	
		Boolean result = false;
		
		try {
	        
			for (Personnel personnel : loginManager.getPerso()) {
				if(personnel.getNom().equals(nom) && personnel.getMotPasse().equals(motPasse)){
					perso = personnel;
					result = true;
				}
			}
            
        } catch (ManagerException e) {
            throw new ManagerException("Error getting Articles", e);
        }
		
		return result;
	} 
    
    public Personnel getPerso() {
    	return perso;
    }
    
}
