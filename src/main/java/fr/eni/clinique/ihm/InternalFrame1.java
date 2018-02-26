package fr.eni.clinique.ihm;

import javax.swing.JInternalFrame;

public class InternalFrame1 extends JInternalFrame {

	private static final long serialVersionUID = -2762909540973030639L;

	public InternalFrame1() {
		//Ecran avec un titre, redimensionable, fermable, agrandissable, iconifiable
		super("Titre Frame 1", true, true, true,true);
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100,400, 200);

	}

}
