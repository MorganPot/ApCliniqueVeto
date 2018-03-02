package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Button;

public class AccueilVue extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilVue frame = new AccueilVue();
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
	public AccueilVue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 423);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenuFichier = new JMenu("Fichier");
		menuBar.add(mnNewMenuFichier);
		
		JMenu mnDeconnexion = new JMenu("Deconnexion");
		mnNewMenuFichier.add(mnDeconnexion);
		
		JMenu mnFermer = new JMenu("Fermer");
		mnNewMenuFichier.add(mnFermer);
		
		JMenu mnGestionRDV = new JMenu("Gestion rendez-vous");
		menuBar.add(mnGestionRDV);
		
		JMenu mnAgenda = new JMenu("Agenda");
		menuBar.add(mnAgenda);
		
		JMenu mnGestionPersonnel = new JMenu("Gestion peronnel");
		menuBar.add(mnGestionPersonnel);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
}
