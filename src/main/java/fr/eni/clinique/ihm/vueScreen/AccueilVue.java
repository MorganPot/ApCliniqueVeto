package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.ihm.model.ClientModel;
import fr.eni.clinique.ihm.model.PersonnelModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JMenuItem;



public class AccueilVue extends JFrame implements ActionListener {
	private JPanel contentPane;
	private PersonnelVue gestionPersonnelVue;
	private GestionClientVue gestionClientVue;
	private PersonnelModel ModelGestionPersonnel;
	private ClientModel gestionClientsModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilVue frame = new AccueilVue();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 624, 423);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenuFichier = new JMenu("Fichier");
		menuBar.add(mnNewMenuFichier);
		
			JMenu mnDeconnexion = new JMenu("Deconnexion");
			mnDeconnexion.setActionCommand("deconnexion");
			mnDeconnexion.addActionListener(this);
			mnNewMenuFichier.add(mnDeconnexion);
			
			JMenuItem mnFermer = new JMenuItem("Fermer");
			mnFermer.setActionCommand("fermer");
			mnFermer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mnNewMenuFichier.add(mnFermer);
			
		
		
		JMenu mnGestionRDV = new JMenu("Gestion rendez-vous");
		mnGestionRDV.setActionCommand("gestionrdv");
		mnGestionRDV.addActionListener(this);
		menuBar.add(mnGestionRDV);
		
		JMenuItem mnAgenda = new JMenuItem("Agenda");
		mnAgenda.setActionCommand("agenda");
		mnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgendaVue agendaVue = new AgendaVue();
				agendaVue.setVisible(true);
				agendaVue.setResizable(false);
				agendaVue.setLocationRelativeTo(null);
			}
		});
		menuBar.add(mnAgenda);
		
		JMenuItem menuItemGestionPersonnel = new JMenuItem("GestionPersonnel");
		menuBar.add(menuItemGestionPersonnel);
		menuItemGestionPersonnel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonnelVue personnelVue = new PersonnelVue();
				personnelVue.setVisible(true);
				personnelVue.setResizable(false);
				personnelVue.setLocationRelativeTo(null);
			}
		});
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
