package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.dao.PersonnelDao;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.dal.exception.DaoException;

public class PersonnelManagerImpl implements PersonnelManager  {
	private static PersonnelManagerImpl SINGLETON;
	/*
	 * Get Personnel DAO :)
	 */
	private PersonnelDao personnelDAO = DaoFactory.personnelDao();
	
	/*
	 * constructor
	 */
	private PersonnelManagerImpl(){
		
	}
	
	/**
     * Returns a unique PersonnelManagerImpl instance.
     * @return
     */
	public static PersonnelManagerImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new PersonnelManagerImpl();
        }
        return SINGLETON;
    }
	
	
	public List<Personnel> getPersonnel() throws ManagerException {
        
        List<Personnel> personnels = null;
        
        try {
        	personnels = personnelDAO.selectAll();
            
        } catch (DaoException e) {
            throw new ManagerException("Error getting Personnel", e);
        }
        
        return personnels;
    }
	
	
	/*
	 * remove Personnel
	 */
    public void removePersonnel(Personnel personnel) throws ManagerException {
        
        ObjectUtil.checkNotNull(personnel);
        ObjectUtil.checkNotNull(personnel.getCodePers());
        
        try {
            personnelDAO.delete(personnel.getCodePers());
            
        } catch (DaoException e) {
            throw new ManagerException("Error inserting", e);
        }
    }
	
    /*
     * valider personnel
     */
    private void validerPersonnel(Personnel personnel) throws ManagerException {
        
        try {
            ObjectUtil.checkNotNull(personnel);
            ObjectUtil.checkNotBlank(personnel.getNom());
            ObjectUtil.checkNotBlank(personnel.getMotPasse());
            ObjectUtil.checkNotBlank(personnel.getRole());
            
        } catch (IllegalArgumentException e) { // Business Erreur remontant � l'utilisateur
            throw new ManagerException("Un des champs requis n'est pas valoris� !", e); 
        } catch(Exception e) { // Erreur technique suite � un pb li� au code.
            throw new TechnicalException("Erreur Technique", e);
        }
    }
    
    /*
     * add Personnel
     */
    public Personnel addPersonnel(Personnel newPersonnel) throws ManagerException {
    	
        ObjectUtil.checkNotNull(newPersonnel);
        
        Personnel personnel = null;
        try {
            
            validerPersonnel(newPersonnel);
            
            personnel = personnelDAO.insert(newPersonnel);
            
        } catch (DaoException e) {
            throw new ManagerException("Error inserting", e);
        }
        return personnel;
    }
    
    /*
     * Update personnel
     */
    public void updatePersonnel(Personnel personnel) throws ManagerException {
        
        ObjectUtil.checkNotNull(personnel);
        try {

            validerPersonnel(personnel);
            
            personnelDAO.update(personnel);
            
        } catch (DaoException e) {
            throw new ManagerException("Error inserting", e);
        }
    }	
}
