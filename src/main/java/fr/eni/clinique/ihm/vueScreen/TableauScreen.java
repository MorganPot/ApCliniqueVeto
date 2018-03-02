package fr.eni.clinique.ihm.vueScreen;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTable;

import fr.eni.clinique.ihm.model.GestionPersonnelModel;

public class TableauScreen extends JFrame implements Observer{

	private JTable tableau;
	private GestionPersonnelModel model;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
