package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Personnel;

public class GestionPersonnelModel extends Observable{
	private List<Personnel> lesPersonnels = new ArrayList<>();
	
	public void chargerPersonnel(List<Personnel> lesPersonnels) {
		this.lesPersonnels.clear();
        this.lesPersonnels.addAll(lesPersonnels);
        
        setChanged();
        notifyObservers();
        clearChanged();
	}
	
	public void addPersonnel(Personnel personnel) {
        lesPersonnels.add(personnel);
    }
	
	public void R�initialiserPersonnel(int codePers){
		
	}
}
