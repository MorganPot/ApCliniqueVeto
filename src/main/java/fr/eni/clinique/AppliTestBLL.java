package fr.eni.clinique;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.clinique.bll.factory.LoginFactory;
import fr.eni.clinique.bll.manager.LoginManager;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.dal.dao.ConnexionDao;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.DaoFactory;

public class AppliTestBLL {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppliTestBLL.class);

    private LoginManager loginManager = LoginFactory.catalogueManager();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		try {
//			
//			System.out.println(loginManager.);
//			
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			throw new TechnicalException("Erreur Technique", e);
//		}
//	}

}
}
