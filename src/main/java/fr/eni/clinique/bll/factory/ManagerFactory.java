package fr.eni.clinique.bll.factory;

import fr.eni.clinique.bll.manager.AnimalManager;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bll.manager.LoginManager;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.bll.manager.impl.AnimalManagerImpl;
import fr.eni.clinique.bll.manager.impl.ClientManagerImpl;
import fr.eni.clinique.bll.manager.impl.LoginManagerImpl;
import fr.eni.clinique.bll.manager.impl.PersonnelManagerImpl;

/**
 * Manager Factory.
 * 
 * @author externe
 *
 */
public class ManagerFactory {
   
    /**
     * Get catalogue Manager.
     * 
     * @return
     */
    public static LoginManager loginManager() {
        return LoginManagerImpl.getInstance();
    }
    
    public static ClientManager clientManager() {
        return ClientManagerImpl.getInstance();
    }
    
    public static PersonnelManager personnelManager() {
        return PersonnelManagerImpl.getInstance();
    }
    
    public static AnimalManager animalManager() {
        return AnimalManagerImpl.getInstance();
    }
}
