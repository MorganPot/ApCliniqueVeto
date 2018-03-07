package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.dao.ClientDao;
import fr.eni.clinique.dal.exception.DaoException;
import fr.eni.clinique.dal.factory.DaoFactory;

public class ClientManagerImpl implements ClientManager{

private static ClientManagerImpl SINGLETON;
    
    /**
     * Get Article DAO.
     */
    private ClientDao clientDao = DaoFactory.clientDao();
    
    /**
     * Private constructor to forbid external instanciation.
     */
    private ClientManagerImpl() {
        
    }
    
    /**
     * Returns a unique CatalogueManagerImpl instance.
     * @return
     */
    public static ClientManagerImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new ClientManagerImpl();
        }
        return SINGLETON;
    }
    
    
    /**
     * Returns Articles from DAo
     * Catch Dao Exception to throw ManagerException.
     */
    @Override
    public List<Client> getClient() throws ManagerException {
        
        List<Client> clients = null;
        
        try {
        	clients = clientDao.selectAll();
            
        } catch (DaoException e) {
            throw new ManagerException("Error getting Clients", e);
        }
        
        return clients;
    }
    
    /**
     * Use Method delete() of DAO
     * Catch Dao Exception to throw ManagerException.
     */
    @Override
    public void removeClient(Client client) throws ManagerException {
        
        ObjectUtil.checkNotNull(client);
        ObjectUtil.checkNotNull(client.getCodeClient());
        
        try {
            clientDao.delete(client.getCodeClient());
            
        } catch (DaoException e) {
            throw new ManagerException("Error deleting", e);
        }
    }
   
    /**
     * Validate an Article.
     * 
     * @param article
     * @throws ManagerException
     */
    private void validerClient(Client client) throws ManagerException {
        
        try {
            ObjectUtil.checkNotNull(client);
            ObjectUtil.checkNotBlank(client.getNomClient());
            ObjectUtil.checkNotBlank(client.getPrenomClient());
            ObjectUtil.checkNotBlank(client.getAdresse1());
            ObjectUtil.checkNotNull(client.getCodePostal());
            ObjectUtil.checkNotNull(client.getVille());
            ObjectUtil.checkNotNull(client.getArchive());
            
        } catch (IllegalArgumentException e) { // Business Erreur remontée à l'utilisateur
            throw new ManagerException("Un des champs requis n'est pas valorisé !", e); 
        } catch(Exception e) { // Erreur technique suite à un pb lié au code.
            throw new TechnicalException("Erreur Technique", e);
        }
    }

    /**
     * Use Method insert() of DAO
     * Throw a ManagerException if newArticle is not valid.
     * Catch Dao Exception to throw ManagerException.
     */
    @Override
    public Client addClient(Client newClient) throws ManagerException {
        
        ObjectUtil.checkNotNull(newClient);
        
        Client client = null;
        try {
            
            validerClient(newClient);
            
            client = clientDao.insert(newClient);
            
        } catch (DaoException e) {
            throw new ManagerException("Error inserting", e);
        }
        return client;
    }

	@Override
	public void updateClient(Client client) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client selectClient(String nom) throws ManagerException {
		// TODO Auto-generated method stub
        ObjectUtil.checkNotNull(nom);
        Client leCli = null;
        try {
        	leCli = clientDao.selectByNom(nom);
            
        } catch (DaoException e) {
            throw new ManagerException("Error select", e);
        }
        return leCli;
	}

    /**
     * Use Method update() of DAO
     * Throw a ManagerException if newArticle is not valid.
     * Catch Dao Exception to throw ManagerException.
     */   
}
