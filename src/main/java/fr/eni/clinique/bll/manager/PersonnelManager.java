package fr.eni.clinique.bll.manager;



import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Personnel;



public interface PersonnelManager {

    /**
     * Retourner un personnel.
     * 
     * @return
     * @throws ManagerException
     */
    List<Personnel> getPersonnel() throws ManagerException;
    
    /**
     * 
     * @param newArticle
     * @throws ManagerException
     */
    Personnel addPersonnel(Personnel newPersonnel) throws ManagerException;
    
    /**
     * Modifier un Personnel.
     * 
     * @param article
     * @throws ManagerException
     */
    void updatePersonnel(int codePers, String password) throws ManagerException;
    
    /**
     * Supprimer un Personnel.
     * @param article
     * @throws ManagerException
     */
    void removePersonnel(int codePers) throws ManagerException;

}
