package fr.eni.clinique.dal.factory;

import fr.eni.clinique.dal.dao.AnimalDao;
import fr.eni.clinique.dal.dao.ClientDao;
import fr.eni.clinique.dal.dao.ConnexionDao;
import fr.eni.clinique.dal.dao.PersonnelDao;
import fr.eni.clinique.dal.dao.jdbc.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.dao.jdbc.ClientDAOJdbcImpl;
import fr.eni.clinique.dal.dao.jdbc.ConnexionDAOJdbcImpl;
import fr.eni.clinique.dal.dao.jdbc.PersonnelDAOJdbcImpl;

/**
 * DAO Fabric.
 * 
 * @author externe
 *
 */
public class DaoFactory {
   
    /**
     * Returns ConnexionDao.
     *  
     * @return
     */
    public static ConnexionDao connexionDao() {
        return ConnexionDAOJdbcImpl.getInstance();
    }
    
    public static PersonnelDao personnelDao() {
    	return PersonnelDAOJdbcImpl.getInstance();
    }
    
    public static ClientDao clientDao() {
    	return ClientDAOJdbcImpl.getInstance();
    }
    
    public static AnimalDao animalDao() {
    	return AnimalDAOJdbcImpl.getInstance();
    }
}
