package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginManager;
import fr.eni.clinique.ihm.listener.ConnexionActionListener;
import fr.eni.clinique.ihm.model.ConnexionModel;

public class ConnexionController implements ConnexionActionListener{

    private ConnexionModel model;
    private LoginManager catalogueManager = ManagerFactory.loginManager();

    /**
     * @param model
     */
    public ConnexionController(ConnexionModel model) {
        super();
        this.model = model;
    }

	@Override
	public Boolean verifLog(String nom, String motPasse) throws Exception {
		return model.verifLog(nom, motPasse);
	}
}
