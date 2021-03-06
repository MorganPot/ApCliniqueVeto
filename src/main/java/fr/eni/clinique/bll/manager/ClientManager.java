package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Client;

public interface ClientManager {

    List<Client> getClient() throws ManagerException;
    
    Client addClient(Client newClient) throws ManagerException;
    
    void updateClient(Client client) throws ManagerException;
    
    void updateClientArchive(String nomClient) throws ManagerException;
    
    void removeClient(Client client) throws ManagerException;

    List<Client> selectClient(String nom) throws ManagerException;
}