package fr.eni.clinique.ihm.vueScreen;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.dao.jdbc.ConnexionDAOJdbcImpl;
import fr.eni.clinique.ihm.controller.ConnexionController;
import fr.eni.clinique.ihm.listener.ConnexionActionListener;
import fr.eni.clinique.ihm.model.ConnexionModel;



public class ConnexionVue extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7833478608680411934L;
	
	private ConnexionDAOJdbcImpl connexion = ConnexionDAOJdbcImpl.getInstance();
    private ConnexionActionListener actionListener;
	private ConnexionModel model = new ConnexionModel();
	private ConnexionController controller = new ConnexionController(model);
	
    
	public 	JPanel panel;
	private JLabel lblNom;
	private JTextField textField;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	
	private JButton btnLogin;
	
    private Font defaultLabelFont = new Font("Arial", Font.BOLD, 14); // Font
    private Font defaultFont = new Font("Arial", Font.PLAIN, 14); // Other
    
    public ConnexionVue() {
    }
    
	public ConnexionVue(String title) {

        setDefaultCloseOperation(EXIT_ON_CLOSE); // Action de fermeture
        setSize(250, 175); // Taille de la fenetre
        setResizable(false); // Fenetre pas redimensionnable
        setTitle(title); // Titre de la fenetre
        
        initialize(); // Construct Components.

    }
	
    private void showFailureMessage(String message) {
        JOptionPane.showMessageDialog(ConnexionVue.this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }
	
    private void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(ConnexionVue.this, message);
    }
    
	/**
	 * Launch the application.
	 */
	private void initialize() {
		
		panel = new JPanel();
        panel.setOpaque(true);
        
        setContentPane(panel);
        
        panel.setLayout(new GridBagLayout());
		
        lblNom = createLabel("Nom");
        textField = createTextField(null, "Entrez le nom");
        
        lblPassword = createLabel("Password");
        passwordField = createPasswordField(null, "Entrez le mot de passe");
     
        GridBagConstraints gridBagConstraints = createGridBagConstraints();
        
        addComponentOnGrid(panel, lblNom, gridBagConstraints, 1, 1, 0.15);
        addComponentOnGrid(panel, textField, gridBagConstraints, 2, 1, 0.85);
        addComponentOnGrid(panel, lblPassword, gridBagConstraints, 1, 2, 0.15);
        addComponentOnGrid(panel, passwordField, gridBagConstraints, 2, 2, 0.85);
        addComponentOnGrid(panel, createButtonBar(), gridBagConstraints, 2, 3, 0.15);
        
	}

    private void addComponentOnGrid(
            JPanel panel,
            JComponent component,
            GridBagConstraints gridBagConstraints,
            int gridX, int gridY, double weightX) {

        gridBagConstraints.gridx = gridX; // Place on X Axis
        gridBagConstraints.gridy = gridY; // Place on Y Axis
        gridBagConstraints.weightx = weightX; // Weight on X Axis

        panel.add(component, gridBagConstraints);
    }

    private GridBagConstraints createGridBagConstraints() {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL; // Redimensionne
                                                                 // horizontalement
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        return gridBagConstraints;
    }

    private JPanel createButtonBar() {

        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        btnLogin = new JButton("Valider");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller != null) {
                	verifLog();
                }
            }
        });

        addComponentOnGrid(panel, btnLogin, gridBagConstraints, 1, 1, 1);
        
        return panel;
    }
    
    private void verifLog() {

        try {
            if (textField.getText().trim().equals("") || passwordField.getPassword().equals("")) {
                // showArticle(model.lastArticle());
                showFailureMessage("Login/Password incorrect !!");
            } else {
                if(controller.verifLog(textField.getText().trim(), String.valueOf(passwordField.getPassword()).trim())){
                	AccueilVue accueilVue = new AccueilVue(this.getUtilCo());
                	accueilVue.setVisible(true);
                	accueilVue.setResizable(false);
                	accueilVue.setLocationRelativeTo(null);
                }
                else {
                    showFailureMessage("Login/Password incorrect !!");
                }
                // showArticle(model.currentArticle());
            }
        } catch (Exception e) {
            showFailureMessage("Erreur");
        }
    }

    private JComboBox<String> createComboBox(List<String> options, String tooltip) {

        JComboBox<String> combo = new JComboBox<>();
        combo.setToolTipText(tooltip);

        for (String option : options) {
            combo.addItem(option);
        }
        return combo;
    }
    
    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);
        label.setFont(defaultLabelFont);

        return label;
    }

    private JTextField createTextField(String text, String tooltip) {

        JTextField textField = new JTextField(text);
        textField.setFont(defaultFont);
        textField.setToolTipText(tooltip);
        return textField;
    }
    
    private JPasswordField createPasswordField(String text, String tooltip) {

        JPasswordField password = new JPasswordField(text);
        password.setToolTipText(tooltip);
        return password;
    }

    public void removeActionListener() {
        this.actionListener = null;
    }
    
    public Personnel getUtilCo() {
    	return controller.getPerso();
    }
}
