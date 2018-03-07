package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import fr.eni.clinique.bo.Client;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AnimalVue extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCode;
	private JTextField textFieldNom;
	private JTextField textFieldCouleur;
	private JTextField textFieldTatouage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalVue frame = new AnimalVue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnimalVue() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 557, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(331, 28, 89, 23);
		panel.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(441, 28, 89, 23);
		panel.add(btnAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Client", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 101, 534, 66);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(22, 22, 482, 20);
		panel_1.add(comboBox);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(47, 194, 46, 14);
		contentPane.add(lblCode);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(47, 230, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setBounds(47, 268, 46, 14);
		contentPane.add(lblCouleur);
		
		JLabel lblEspece = new JLabel("Esp\u00E8ce");
		lblEspece.setBounds(47, 310, 46, 14);
		contentPane.add(lblEspece);
		
		JLabel lblTatouage = new JLabel("Tatouage");
		lblTatouage.setBounds(47, 352, 46, 14);
		contentPane.add(lblTatouage);
		
		textFieldCode = new JTextField();
		textFieldCode.setEditable(false);
		textFieldCode.setBounds(103, 191, 281, 20);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(103, 227, 281, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldCouleur = new JTextField();
		textFieldCouleur.setBounds(103, 265, 281, 20);
		contentPane.add(textFieldCouleur);
		textFieldCouleur.setColumns(10);
		
		textFieldTatouage = new JTextField();
		textFieldTatouage.setBounds(103, 349, 281, 20);
		contentPane.add(textFieldTatouage);
		textFieldTatouage.setColumns(10);
		
		JComboBox comboBoxEspece = new JComboBox();
		comboBoxEspece.setBounds(103, 307, 86, 20);
		contentPane.add(comboBoxEspece);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setBounds(259, 310, 46, 14);
		contentPane.add(lblRace);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(298, 307, 86, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBoxSexe = new JComboBox();
		comboBoxSexe.setBounds(434, 227, 93, 20);
		contentPane.add(comboBoxSexe);
	}
}
