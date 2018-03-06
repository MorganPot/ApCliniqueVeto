package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.vueScreen.AjouterPerso;

public class PersonnelModelDynamic extends AbstractTableModel{
   
	private List<Personnel> personnels = new ArrayList<Personnel>();
	private ManagerFactory factory = new ManagerFactory();
	private PersonnelModel model = new PersonnelModel();
    
    private final String[] entetes = {"Nom", "Mot de passe", "Role"};
 
    public PersonnelModelDynamic() {
        super();
        try {
			personnels = factory.personnelManager().getPersonnel();
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    @Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
        case 0:
            return personnels.get(rowIndex).getNom();
        case 1:
            return personnels.get(rowIndex).getMotPasse().replace(personnels.get(rowIndex).getMotPasse(), "**********");
        case 2:
            return personnels.get(rowIndex).getRole();
        default:
            return null; //Ne devrait jamais arriver
		}
    }
    
    public int getRowCount() {
        return personnels.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Personnel getValueAt(int rowIndex) {
    	return personnels.get(rowIndex);
    }
    
    public void refresh() {
		try {
			personnels = model.selectAll();
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fireTableDataChanged();
    }
}
