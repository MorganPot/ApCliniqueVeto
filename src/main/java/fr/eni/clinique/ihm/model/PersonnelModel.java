package fr.eni.clinique.ihm.model;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException; 
import fr.eni.clinique.bll.manager.impl.PersonnelManagerImpl;
import fr.eni.clinique.bo.Personnel;

public class PersonnelModel {
	
	private PersonnelManagerImpl personnelM = PersonnelManagerImpl.getInstance();
	
	public PersonnelModel() {
	}
	
	public void addPersonnel(Personnel personnel) throws ManagerException {
		personnelM.addPersonnel(personnel);
	}
	
	public void removePersonnel(int index) throws ManagerException {
		personnelM.removePersonnel(index);
	}
	
	public List<Personnel> selectAll() throws ManagerException {
		return personnelM.getPersonnel();
	}
	
}
