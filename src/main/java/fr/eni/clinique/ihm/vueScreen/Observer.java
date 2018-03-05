package fr.eni.clinique.ihm.vueScreen;

import java.util.Observable;

public class Observer extends Observable{
    
	public Observer() {	
        super();
    }
    public void changeData(Object data) {
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
    }	
}
