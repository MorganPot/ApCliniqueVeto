package fr.eni.clinique;

import java.awt.EventQueue;

import fr.eni.clinique.ihm.vueScreen.ConnexionVue;

public class AppClinique {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionVue ecran = new ConnexionVue();
					ecran.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}

}
