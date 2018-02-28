package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Personnel;

public interface LoginManager {
	
	 List<Personnel> getPerso() throws ManagerException;
}
