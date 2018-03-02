package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bo.Personnel;

public class GestionPersonnelModel extends AbstractTableModel{

	private static final long serialVersionUID = -7367707140217469326L;
	
	private List<Personnel> lesPersonnels = new ArrayList<>();
	
	private final String[] entetes = {"Nom", "Password", "Role"};
	
	public void ReinitialiserPersonnel(int codePers){
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
        return lesPersonnels.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
        return entetes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		 switch(columnIndex){
         case 0:
             return lesPersonnels.get(rowIndex).getNom();
         case 1:
             return lesPersonnels.get(rowIndex).getMotPasse();
         case 2:
             return lesPersonnels.get(rowIndex).getRole();
         default:
             return null; //Ne devrait jamais arriver
		 }
     }
	
	public void addPersonnel(Personnel personnel) {
		lesPersonnels.add(personnel);
 
        fireTableRowsInserted(lesPersonnels.size() -1, lesPersonnels.size() -1);
    }
 
    public void removePersonnel(int rowIndex) {
        lesPersonnels.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
