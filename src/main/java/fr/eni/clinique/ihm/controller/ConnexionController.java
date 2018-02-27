package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bll.factory.LoginFactory;
import fr.eni.clinique.bll.manager.LoginManager;
import fr.eni.clinique.ihm.listener.ConnexionActionListener;
import fr.eni.clinique.ihm.model.ConnexionModel;

public class ConnexionController implements ConnexionActionListener{

    private ConnexionModel model;
    private LoginManager catalogueManager = LoginFactory.loginManager();

    /**
     * @param model
     */
    public ConnexionController(ConnexionModel model) {
        super();
        this.model = model;
    }

	@Override
	public void verifLog(String nom, String motPasse) throws Exception {
		// TODO Auto-generated method stub
		model.verifLog(nom, motPasse);
	}
}