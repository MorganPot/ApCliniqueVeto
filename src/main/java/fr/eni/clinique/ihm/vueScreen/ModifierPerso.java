package fr.eni.clinique.ihm.vueScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.model.PersonnelModel;
import fr.eni.clinique.resources.Role;

public class ModifierPerso extends JFrame{
	 
		private static final long serialVersionUID = -5992552815854593655L;
		private List<Personnel> personnels = new ArrayList<Personnel>();
		private ManagerFactory factory = new ManagerFactory();
		private JPasswordField passwordField;
	    private PersonnelModel model;
		final Observer observable = new Observer();
		
		public ModifierPerso(PersonnelModel model,PersonnelVue mafenetre) {
	        try {
				personnels = factory.personnelManager().getPersonnel();
			} catch (ManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.model = model;
			this.observable.addObserver(mafenetre);
			initialize();
		}
		
	    private void showFailureMessage(String message) {
	        JOptionPane.showMessageDialog(ModifierPerso.this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	    }
		
	    private void showSuccessMessage(String message) {
	        JOptionPane.showMessageDialog(ModifierPerso.this, message);
	    }
		
		private void initialize() {
			setBounds(100, 100, 407, 200);
			getContentPane().setLayout(null);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
			JPanel panelButtons = new JPanel();
			panelButtons.setBounds(0, 0, 401, 169);
			getContentPane().add(panelButtons);
			panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelButtons.setLayout(null);
			setTitle("Réinitialisation");
			
			JComboBox comboBox = new JComboBox();
			for (Personnel perso : personnels){
			   comboBox.addItem(perso.getNom());
			}
			comboBox.setBounds(116, 69, 217, 20);
			panelButtons.add(comboBox);
			setResizable(false);
			
			JButton btnModifButton = new JButton("Réinitialiser");
			btnModifButton.setBounds(160, 128, 123, 23);
			btnModifButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Personnel lePerso = new Personnel();
							
					for (Personnel perso : personnels) {
						if(perso.getNom() == comboBox.getSelectedItem().toString()){
							lePerso = perso;
						}
					}
					
					try {
						if( String.valueOf(passwordField.getPassword()).trim().equals("")){
							model.updatePersonnel(lePerso.getCodePers(), lePerso.getMotPasse());;
						}
						else {
							model.updatePersonnel(lePerso.getCodePers(), String.valueOf(passwordField.getPassword()));;
						}
					} catch (ManagerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					observable.changeData(lePerso);
					dispose();
				}	
			});
			
			panelButtons.add(btnModifButton);
			
			
			JLabel labelNom = new JLabel("Nom");
			labelNom.setBounds(33, 72, 105, 14);
			panelButtons.add(labelNom);
			
			JLabel labelPassword = new JLabel("Mot de passe");
			labelPassword.setBounds(33, 97, 105, 14);
			panelButtons.add(labelPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(116, 97, 217, 20);
			panelButtons.add(passwordField);		
		}
}
