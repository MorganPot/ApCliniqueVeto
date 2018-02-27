package fr.eni.clinique.ihm.event;

import fr.eni.clinique.bo.Personnel;

public class ConnexionActionEvent {
	  private Personnel personnel;

	    /**
	     * @param article
	     */
	    public ConnexionActionEvent(Personnel personnel) {
	        super();
	        this.personnel = personnel;
	    }

	    /**
	     * @return the article
	     */
	    public Personnel getPersonnel() {
	        return personnel;
	    }
}
