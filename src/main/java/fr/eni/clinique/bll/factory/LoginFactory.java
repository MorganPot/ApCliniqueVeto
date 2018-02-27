package fr.eni.clinique.bll.factory;

import fr.eni.clinique.bll.manager.LoginManager;
import fr.eni.clinique.bll.manager.impl.LoginManagerImpl;

/**
 * Manager Factory.
 * 
 * @author externe
 *
 */
public class LoginFactory {
   
    /**
     * Get catalogue Manager.
     * 
     * @return
     */
    public static LoginManager loginManager() {
        return LoginManagerImpl.getInstance();
    }
}
