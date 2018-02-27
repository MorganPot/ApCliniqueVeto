package fr.eni.clinique;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.clinique.bll.exception.LoginException;
import fr.eni.clinique.bll.factory.LoginFactory;
import fr.eni.clinique.bll.manager.LoginManager;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.exception.TechnicalException;

public class AppliTestBLL {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppliTestBLL.class);

    private LoginManager loginManager = LoginFactory.catalogueManager();
	
	public static void main(String[] args) throws LoginException {
		// TODO Auto-generated method stub
		
		try {
			if(LoginFactory.catalogueManager().VerifLogin("Test", "test")){
				System.out.println("win");
			}
			else{
				for (Personnel personnel : LoginFactory.catalogueManager().getPerso()) {
					System.out.println(personnel.getNom());
					System.out.println(personnel.getMotPasse());
				}
				System.out.println("lose");
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			throw new TechnicalException("Erreur Technique", e);
		}
	}

}
