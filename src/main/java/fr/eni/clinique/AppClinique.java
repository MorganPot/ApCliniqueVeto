package fr.eni.clinique;

import java.awt.EventQueue;

import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.ihm.controller.ConnexionController;
import fr.eni.clinique.ihm.model.ConnexionModel;
import fr.eni.clinique.ihm.vueScreen.ConnexionVue;

public class AppClinique {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionModel model = new ConnexionModel();

                    ConnexionController controller = new ConnexionController(model);
					
					ConnexionVue ecran = new ConnexionVue(AppConstants.APP_NAME);
					ecran.setVisible(true);
					ecran.setLocationRelativeTo(null); // Centré sur l'ecran
                    
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}

}
