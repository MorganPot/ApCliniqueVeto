package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DossierMedicalVue extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldClient;
	private JTextField textFieldCodeAnim;
	private JTextField textFieldNom;
	private JTextField textFieldCouleur;
	private JTextField textFieldEspece;
	private JTextField textFieldTatoo;
	private JTextField textFieldSexe;
	private JTextField textFieldRace;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DossierMedicalVue frame = new DossierMedicalVue();
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
	public DossierMedicalVue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 600, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(355, 11, 89, 23);
		panel.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnAnnuler.setBounds(472, 11, 89, 23);
		panel.add(btnAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 84, 230, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textFieldClient = new JTextField();
		textFieldClient.setEditable(false);
		textFieldClient.setBounds(10, 19, 152, 20);
		panel_1.add(textFieldClient);
		textFieldClient.setColumns(10);
		
		JLabel lblAnimal = new JLabel("Animal :");
		lblAnimal.setBounds(10, 146, 46, 14);
		contentPane.add(lblAnimal);
		
		textFieldCodeAnim = new JTextField();
		textFieldCodeAnim.setEditable(false);
		textFieldCodeAnim.setBounds(59, 145, 86, 20);
		contentPane.add(textFieldCodeAnim);
		textFieldCodeAnim.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldNom.setBounds(59, 177, 86, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldCouleur = new JTextField();
		textFieldCouleur.setEditable(false);
		textFieldCouleur.setBounds(59, 208, 86, 20);
		contentPane.add(textFieldCouleur);
		textFieldCouleur.setColumns(10);
		
		textFieldEspece = new JTextField();
		textFieldEspece.setEditable(false);
		textFieldEspece.setBounds(59, 239, 86, 20);
		contentPane.add(textFieldEspece);
		textFieldEspece.setColumns(10);
		
		textFieldTatoo = new JTextField();
		textFieldTatoo.setEditable(false);
		textFieldTatoo.setBounds(59, 270, 86, 20);
		contentPane.add(textFieldTatoo);
		textFieldTatoo.setColumns(10);
		
		textFieldSexe = new JTextField();
		textFieldSexe.setEditable(false);
		textFieldSexe.setBounds(154, 208, 86, 20);
		contentPane.add(textFieldSexe);
		textFieldSexe.setColumns(10);
		
		textFieldRace = new JTextField();
		textFieldRace.setEditable(false);
		textFieldRace.setBounds(155, 239, 86, 20);
		contentPane.add(textFieldRace);
		textFieldRace.setColumns(10);
		
		JTextPane textPaneAntecedants = new JTextPane();
		textPaneAntecedants.setBounds(286, 133, 311, 229);
		contentPane.add(textPaneAntecedants);
		
		JLabel lblAntecedantsConsultation = new JLabel("Antecedents / Consultation");
		lblAntecedantsConsultation.setBounds(286, 108, 181, 14);
		contentPane.add(lblAntecedantsConsultation);
	}
}
