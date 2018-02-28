package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Client;

public interface ClientManager {

    List<Client> getClient() throws ManagerException;
    
    Client addClient(Client newClient) throws ManagerException;
    
    void updateClient(Client client) throws ManagerException;
    
    void removeClient(Client Client) throws ManagerException;
}