package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.model.ClientModel;
import fr.eni.clinique.ihm.model.PersonnelModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class AccueilVue extends JFrame implements ActionListener {
	private JPanel contentPane;
	private PersonnelVue gestionPersonnelVue;
	private GestionClientVue gestionClientVue;
	private PersonnelModel ModelGestionPersonnel;
	private ClientModel gestionClientsModel;
	Personnel persoCo;

    public AccueilVue(Personnel perso){
    	persoCo = perso;
    	initialize();
    }
    
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccueilVue frame = new AccueilVue();
//					frame.setVisible(true);
//					frame.setResizable(false);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	private void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(AccueilVue.this, message);
    }

	/**
	 * Create the frame.
	 */
	public void initialize() {
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
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		if(persoCo.getRole().equals("sec")){
			JButton btnRdv = new JButton("Gestion rendez-vous");
			btnRdv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					RdvVue rdvvue = new RdvVue();
					rdvvue.setVisible(true);
					rdvvue.setResizable(false);
					rdvvue.setLocationRelativeTo(null);
				}
			});
			btnRdv.setBounds(33, 25, 541, 51);
			contentPane.add(btnRdv);
		}
		
		if(persoCo.getRole().equals("sec")){
			JButton btnClientGestion = new JButton("Gestion Client");
			btnClientGestion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestionClientVue gestionClientVue = new GestionClientVue();
					gestionClientVue.setVisible(true);
					gestionClientVue.setResizable(false);
					gestionClientVue.setLocationRelativeTo(null);
				}
			});
			btnClientGestion.setBounds(33, 101, 541, 51);
			contentPane.add(btnClientGestion);
		}
		
		if(persoCo.getRole().equals("vet")){
			JButton btnAgenda = new JButton("Agenda");
			btnAgenda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AgendaVue agenda = new AgendaVue();
					agenda.setVisible(true);
					agenda.setResizable(false);
					agenda.setLocationRelativeTo(null);
					
					showSuccessMessage("En cours");
				}
			});
			btnAgenda.setBounds(33, 260, 541, 51);
			contentPane.add(btnAgenda);
		}
		
		if(persoCo.getRole().equals("adm")){
			JButton btnGestionPersonnel = new JButton("Gestion Personnel");
			btnGestionPersonnel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PersonnelVue persoVue = new PersonnelVue();
					persoVue.setResizable(false);
					persoVue.setLocationRelativeTo(null);
					persoVue.setVisible(true);
				}
			});
			btnGestionPersonnel.setBounds(33, 179, 541, 51);
			contentPane.add(btnGestionPersonnel);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
