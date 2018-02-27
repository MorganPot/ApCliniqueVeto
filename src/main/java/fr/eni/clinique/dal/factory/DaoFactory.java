package fr.eni.clinique.dal.factory;

import fr.eni.clinique.dal.dao.ConnexionDao;
import fr.eni.clinique.dal.dao.jdbc.ConnexionDAOJdbcImpl;

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
}
