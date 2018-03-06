package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bo.Animal;

public class AnimalModelDynamic extends AbstractTableModel{
	private List<Animal> animaux = new ArrayList<Animal>();
	private ManagerFactory factory = new ManagerFactory();
	private AnimalModel model = new AnimalModel();
    
    private final String[] entetes = {"Numéro", "Nom", "Sexe", "Couleur", "Race", "Espèce", "Tatouage"};
    
    public AnimalModelDynamic() {
        super();
//			animaux = factory.animalManager().getAnimal();
        	refresh();
    }
    
    @Override
  	public Object getValueAt(int rowIndex, int columnIndex) {
  		switch(columnIndex){
          case 0:
              return animaux.get(rowIndex).getCodeAnimal();
          case 1:
              return animaux.get(rowIndex).getNomAnimal();
          case 2:
              return animaux.get(rowIndex).getSexe();
          case 3:
              return animaux.get(rowIndex).getCouleur();
          case 4:
              return animaux.get(rowIndex).getRace();
          case 5:
              return animaux.get(rowIndex).getEspece();
          case 6:
              return animaux.get(rowIndex).getTatouage();
          default:
              return null; //Ne devrait jamais arriver
  		}
      }
    
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
    
	@Override
	public int getColumnCount() {
        return animaux.size();
	}

	@Override
	public int getRowCount() {
        return entetes.length;
	}
    
    public void refresh() {
		try {
			animaux = model.selectAll();
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fireTableDataChanged();
    }
}