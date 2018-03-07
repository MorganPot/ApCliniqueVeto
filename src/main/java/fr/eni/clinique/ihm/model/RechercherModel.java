package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bo.Client;

public class RechercherModel extends AbstractTableModel{

	private static final long serialVersionUID = 12825510527774507L;
	
	private List<Client> clients = new ArrayList<Client>();
    
    private final String[] entetes = {"Nom", "Prénom", "Code Postal", "Ville"};
 
    public RechercherModel() {
        super();
    }
 
    @Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
        case 0:
            return clients.get(rowIndex).getNomClient();
        case 1:
            return clients.get(rowIndex).getPrenomClient();
        case 2:
            return clients.get(rowIndex).getCodePostal();
        case 3:
            return clients.get(rowIndex).getVille();
        default:
            return null; //Ne devrait jamais arriver
		}
    }
    
    public int getRowCount() {
        return clients.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
    
    public void refresh(List<Client> listeCli) {
    	for (Client cli : listeCli) {
    		clients.add(cli);
		}
        fireTableRowsInserted(clients.size() -1, clients.size() -1);
		fireTableDataChanged();
    }
}
