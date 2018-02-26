package fr.eni.clinique;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.dal.exception.DaoException;

public class AppliTestDAL {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppliTestDAL.class);

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client leClient = new Client();
		
		try {
			System.out.println(leClient.getlistClient());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new TechnicalException("Erreur Technique", e);
		}
	}

}
