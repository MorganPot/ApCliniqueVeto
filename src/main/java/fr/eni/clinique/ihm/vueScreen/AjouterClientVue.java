package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.model.ClientModel;
import fr.eni.clinique.ihm.model.PersonnelModel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterClientVue extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCode;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldAdresse2;
	private JTextField textFieldCodePostal;
	private JTextField textFieldVille;
	
	private GestionClientVue vue = new GestionClientVue();
    private ClientModel model;
	final Observer observable = new Observer();

	public AjouterClientVue(ClientModel model,GestionClientVue mafenetre) {
		this.model = model;
		this.observable.addObserver(mafenetre);
		initialize();
	}

	public AjouterClientVue(ClientModel modelCli, RdvVue agendaVue) {
		this.model = modelCli;
		this.observable.addObserver(agendaVue);
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 414, 62);
		contentPane.add(panel);
		panel.setLayout(null);
				
		JLabel lblErreur = new JLabel("Veuillez remplir les champs");
		lblErreur.setBounds(150,132, 300, 23);
		contentPane.add(lblErreur);
		lblErreur.setVisible(false);
		
		JButton btnValider = new JButton("");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNom.getText().length() == 0 || textFieldPrenom.getText().length() == 0
		    || textFieldAdresse.getText().length() == 0 || textFieldCodePostal.getText().length() == 0
		    || textFieldVille.getText().length() == 0)
				{
					lblErreur.setVisible(true);
				}
				else {
					Client client = new Client(textFieldNom.getText(), textFieldPrenom.getText(),
											   textFieldAdresse.getText(), textFieldAdresse2.getText(), 
											   textFieldCodePostal.getText(), textFieldVille.getText(), 
											   false);
					
					model.addClient(client);
//					vue.ajoutClient(client);
					
					observable.changeData(client);
					dispose();
				}
			}
		});
		btnValider.setIcon(new ImageIcon(AjouterClientVue.class.getResource("/image/tick.png")));
		btnValider.setBounds(31, 11, 160, 40);
		panel.add(btnValider);
		
		JButton btnAnnuler = new JButton("");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnAnnuler.setIcon(new ImageIcon(AjouterClientVue.class.getResource("/image/cancel.png")));
		btnAnnuler.setBounds(227, 11, 160, 40);
		panel.add(btnAnnuler);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(96, 167, 46, 14);
		contentPane.add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(189, 164, 153, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(96, 203, 46, 14);
		contentPane.add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(189, 200, 153, 20);
		contentPane.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(96, 239, 58, 14);
		contentPane.add(lblAdresse);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(189, 236, 153, 20);
		contentPane.add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		textFieldAdresse2 = new JTextField();
		textFieldAdresse2.setBounds(189, 261, 153, 20);
		contentPane.add(textFieldAdresse2);
		textFieldAdresse2.setColumns(10);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(96, 313, 83, 14);
		contentPane.add(lblCodePostal);
		
		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(189, 310, 153, 20);
		contentPane.add(textFieldCodePostal);
		textFieldCodePostal.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(96, 349, 46, 14);
		contentPane.add(lblVille);
		
		textFieldVille = new JTextField();
		textFieldVille.setBounds(189, 346, 153, 20);
		contentPane.add(textFieldVille);
		textFieldVille.setColumns(10);
	}

}
