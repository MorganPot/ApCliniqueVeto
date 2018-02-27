package fr.eni.clinique.ihm.vueScreen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.dao.jdbc.ConnexionDAOJdbcImpl;
import fr.eni.clinique.dal.exception.DaoException;



public class ConnexionVue extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7833478608680411934L;
	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private ConnexionDAOJdbcImpl connexion = ConnexionDAOJdbcImpl.getInstance();
	
	public ConnexionVue() {
		initialize();
	}
	
	
	
	/**
	 * Launch the application.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 166);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 31, 91, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel erreur = new JLabel("");
		erreur.setForeground(Color.red);
		erreur.setBounds(10,0, 300, 23);
		frame.getContentPane().add(erreur);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setBounds(10, 65, 91, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(111, 32, 115, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 62, 115, 20);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnLogin = new JButton("Valider");
		btnLogin.setBounds(111, 93, 115, 23);
		frame.getContentPane().add(btnLogin);
		
		
		
	}

}
