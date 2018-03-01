package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bo.Client;

public class ClientModel extends Observable	{

    private List<Client> clients = new ArrayList<>();
	private ClientManager clientManager = ManagerFactory.clientManager();
    private int currentIndex;
	
	public void loadArticles(List<Client> clients) {
        this.clients.clear();
        this.clients.addAll(clients);
        
        setChanged();//specifier que la donnée a changer
        notifyObservers();//avertir les observers
        clearChanged();// specifier que la donnée n'est pas changer
        
    }
	
    public void addClient(Client client) {
        clients.add(client);
    }
}
