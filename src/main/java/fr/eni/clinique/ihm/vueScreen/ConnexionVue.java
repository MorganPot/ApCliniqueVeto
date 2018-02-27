package fr.eni.clinique.ihm.vueScreen;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.dal.dao.jdbc.ConnexionDAOJdbcImpl;
import fr.eni.clinique.ihm.listener.ConnexionActionListener;



public class ConnexionVue extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6893577698630411035L;
	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private ConnexionDAOJdbcImpl connexion = ConnexionDAOJdbcImpl.getInstance();
    private ConnexionActionListener actionListener;
	
	public ConnexionVue(String title) {

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Action de fermeture
        setSize(600, 500); // Taille de la fenetre
        setResizable(false); // Fenetre pas redimensionnable
        setTitle(title); // Titre de la fenetre
        
        initialize(); // Construct Components.

    }
	
	/**
	 * Launch the application.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 400, 200);
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
		
		ImageIcon icone = new ImageIcon("images/fond_frame.jpg");
		frame.setIconImage(new ImageIcon("images/fond_frame.jpg").getImage());
        frame.setSize(200,200);
        frame.setVisible(true);
		
		
	}

}
