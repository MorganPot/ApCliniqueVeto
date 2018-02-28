package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterPersonnelsVue extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldFonction;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterPersonnelsVue frame = new AjouterPersonnelsVue();
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
	public AjouterPersonnelsVue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(44, 36, 58, 23);
		contentPane.add(lblNom);
		textFieldNom = new JTextField();
		textFieldNom.setBounds(132, 37, 86, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(43, 70, 46, 14);
		contentPane.add(lblPrenom);
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(132, 67, 86, 20);
		contentPane.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		
		JLabel lblFonction = new JLabel("Fonction");
		lblFonction.setBounds(44, 101, 58, 14);
		contentPane.add(lblFonction);
		textFieldFonction = new JTextField();
		textFieldFonction.setColumns(10);
		textFieldFonction.setBounds(132, 98, 86, 20);
		contentPane.add(textFieldFonction);
		
		
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setBounds(44, 132, 58, 14);
		contentPane.add(labelPassword);
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(132, 129, 86, 20);
		contentPane.add(textFieldPassword);
		
		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjouter.setBounds(91, 186, 89, 23);
		contentPane.add(btnAjouter);
	}

}
