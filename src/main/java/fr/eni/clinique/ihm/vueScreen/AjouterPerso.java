package fr.eni.clinique.ihm.vueScreen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.model.PersonnelModel;
import fr.eni.clinique.ihm.model.PersonnelModelDynamic;
import fr.eni.clinique.ihm.vueScreen.PersonnelVue;

import fr.eni.clinique.resources.Role;

public class AjouterPerso extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5992552815854593655L;
	private JTextField textFieldNom;
	private JPasswordField passwordField;
    private PersonnelModel model;
	final Observer observable = new Observer();
	
	public AjouterPerso(PersonnelModel model,PersonnelVue mafenetre) {
		this.model = model;
		this.observable.addObserver(mafenetre);
		initialize();
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
		setTitle("Ajout");
		
		JComboBox comboBox = new JComboBox(Role.values());
		comboBox.setBounds(116, 69, 217, 20);
		panelButtons.add(comboBox);
		setResizable(false);
		
		JLabel lblErreur = new JLabel("Veuillez remplir les champs");
		lblErreur.setBounds(150,20, 300, 23);
		panelButtons.add(lblErreur);
		lblErreur.setVisible(false);
		
		JButton btnAddButton = new JButton("Ajouter");
		btnAddButton.setBounds(160, 128, 123, 23);
		btnAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(textFieldNom.getText().length() == 0 || passwordField.getPassword().length == 0)
				{
					lblErreur.setVisible(true);
				}
				else {
					Personnel personnel = new Personnel(textFieldNom.getText(), String.valueOf(passwordField.getPassword()), comboBox.getSelectedItem().toString(),false);
					
					try {
						model.addPersonnel(personnel);
					} catch (ManagerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					observable.changeData(personnel);
					dispose();
				}
			}
		});
		
		panelButtons.add(btnAddButton);
		
		JLabel labelNom = new JLabel("Nom");
		labelNom.setBounds(33, 47, 105, 14);
		panelButtons.add(labelNom);
		
		JLabel labelRole = new JLabel("Role");
		labelRole.setBounds(33, 72, 105, 14);
		panelButtons.add(labelRole);
		
		JLabel labelPassword = new JLabel("Mot de passe");
		labelPassword.setBounds(33, 97, 105, 14);
		panelButtons.add(labelPassword);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(116, 43, 217, 18);
		panelButtons.add(textFieldNom);
		textFieldNom.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(116, 97, 217, 20);
		panelButtons.add(passwordField);		
	}
}
