package fr.eni.clinique;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.model.ConnexionModel;

public class AppliTestBLL {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppliTestBLL.class);
    
	public static void main(String[] args) throws ManagerException {
		// TODO Auto-generated method stub
		ConnexionModel model = new ConnexionModel();
		
		try {
			if(model.verifLog("Test", "test")){
				System.out.println("win");
			}
			else{
				for (Personnel personnel : ManagerFactory.loginManager().getPerso()) {
					System.out.println(personnel.getNom());
					System.out.println(personnel.getMotPasse());
				}
				System.out.println("lose");
			}
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			throw new TechnicalException("Erreur Technique", e);
		}
	}

}
