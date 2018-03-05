package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.model.PersonnelModel;
import fr.eni.clinique.ihm.model.PersonnelModelDynamic;

public class PersonnelVue extends JFrame implements Observer{
	
    private PersonnelModelDynamic modele = new PersonnelModelDynamic();
    private JTable tableau;
    private PersonnelModel model = new PersonnelModel();
 
    public PersonnelVue() {
        super();
 
        setTitle("JTable avec modèle dynamique");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        tableau = new JTable(modele);
 
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
 
        JPanel boutons = new JPanel();
 
        boutons.add(new JButton(new AddAction()));
        boutons.add(new JButton(new RemoveAction()));
 
        getContentPane().add(boutons, BorderLayout.SOUTH);
 
        pack();
    }
 
    public static void main(String[] args) {
        new PersonnelVue().setVisible(true);
    }
 
    private class AddAction extends AbstractAction {
        private AddAction() {
            super("Ajouter");
        }
 
        public void actionPerformed(ActionEvent e) {
        	AjouterPerso ajouterPerso = new AjouterPerso(model, PersonnelVue.this);
			ajouterPerso.setVisible(true);
        }
    }
 
    private class RemoveAction extends AbstractAction {
        private RemoveAction() {
            super("Supprimer");
        }
 
		@Override
		public void actionPerformed(ActionEvent e) {
			if(getPersonnels() != null){
				
				try {
					model.removePersonnel(getPersonnels().getCodePers());
				} catch (ManagerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				modele.removePersonnel(tableau.getSelectedRow());
				modele.refresh();	
			}
		}
    }
    
    public Personnel getPersonnels() {
		Personnel personnels = null;
		if (tableau.getSelectedRowCount() > 0){
		int[] codePers = tableau.getSelectedRows();
			personnels = modele.getValueAt(codePers[0]);	
		}
		return personnels;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
