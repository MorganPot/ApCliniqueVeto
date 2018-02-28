package fr.eni.clinique.ihm.vueScreen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.model.GestionPersonnelModel;

import java.awt.Color;

public class GestionPersonnelVue extends JFrame {

	private JFrame frame;
	private JTable table;
	private GestionPersonnelModel modelPersonnel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPersonnelVue window = new GestionPersonnelVue();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionPersonnelVue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 602, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterPersonnelsVue ajouterPersonneVue = new AjouterPersonnelsVue();
					ajouterPersonneVue.setVisible(true);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAjouter.setBounds(41, 11, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimer.setBounds(167, 11, 89, 23);
		frame.getContentPane().add(btnSupprimer);
		
		JButton btnReset = new JButton("Réinitialiser");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBounds(300, 11, 89, 23);
		frame.getContentPane().add(btnReset);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.GRAY);
		table.setBorder(UIManager.getBorder("Button.border"));
		table.setBounds(41, 336, 498, -247);
		frame.getContentPane().add(table);
		
		
		
		
	}
}
