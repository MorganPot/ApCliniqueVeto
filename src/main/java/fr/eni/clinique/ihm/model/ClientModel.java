package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bo.Client;

public class ClientModel extends Observable	{

	private ClientManager clientManager = ManagerFactory.clientManager();
		
    public void addClient(Client client) {
        try {
			clientManager.addClient(client);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public List<Client> selectClient(String nom) {
        List<Client> clients = new ArrayList<Client>();
        try {
        	clients = clientManager.selectClient(nom);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return clients;
    }
    
    public void updateClientArchive(String nom) {
        try {
        	clientManager.updateClientArchive(nom);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void updateClient(Client client) {
        try {
        	clientManager.updateClient(client);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
