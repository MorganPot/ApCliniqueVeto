package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bll.exception.LoginException;
import fr.eni.clinique.bll.manager.LoginManager;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.dao.ConnexionDao;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.DaoFactory;

public class LoginManagerImpl implements LoginManager {
    
    private static LoginManagerImpl SINGLETON;
    
    /**
     * Get Connexion DAO.
     */
    private ConnexionDao connexionDao = DaoFactory.connexionDao();
    
    /**
     * Private constructor to forbid external instanciation.
     */
    private LoginManagerImpl() {

    }
    
    /**
     * Returns a unique LoginManagerImpl instance.
     * @return
     */
    public static LoginManagerImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new LoginManagerImpl();
        }
        return SINGLETON;
    }

	@Override
	public List<Personnel> getPerso() throws LoginException {
    	
    	List<Personnel> personnels = null;
        
        try {
            personnels = connexionDao.selectAll();
            
        } catch (DaoException e) {
            throw new LoginException("Error getting Articles", e);
        }
        
        return personnels;
	}

	@Override
	public Boolean VerifLogin(String nom, String motPasse) throws LoginException {
		
		Boolean result = false;
		
		try {
	        
			for (Personnel personnel : this.getPerso()) {
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
