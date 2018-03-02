package fr.eni.clinique.ihm.vueScreen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.model.GestionPersonnelModel;

import java.awt.Color;
import javax.swing.border.LineBorder;

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
		
		table = new JTable(modelPersonnel);
		table.setForeground(Color.WHITE);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.GRAY);
		table.setBorder(UIManager.getBorder("Button.border"));
		table.setBounds(41, 359, 498, -235);
		frame.getContentPane().add(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 566, 84);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(35, 30, 69, 23);
		panel.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(159, 30, 89, 23);
		panel.add(btnSupprimer);
		
		JButton btnReset = new JButton("Reinitialiser");
		btnReset.setBounds(311, 30, 89, 23);
		panel.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            int[] selection = table.getSelectedRows();
	 
	            for(int i = selection.length - 1; i >= 0; i--){
	                modelPersonnel.removePersonnel(selection[i]);
	            }
			}
		});
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
		frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.GRAY);
		table.setBorder(UIManager.getBorder("Button.border"));
		table.setBounds(41, 336, 498, -247);
		frame.getContentPane().add(table);
	}
}
