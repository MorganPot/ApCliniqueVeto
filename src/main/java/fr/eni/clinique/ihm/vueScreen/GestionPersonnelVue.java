package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.ihm.model.GestionPersonnelModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class GestionPersonnelVue extends JFrame {
	
	private static final long serialVersionUID = -773311085041102251L;
	
	private JPanel contentPane;
	private static JTable table;
	private GestionPersonnelModel modelPersonnel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPersonnelVue frame = new GestionPersonnelVue();
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
	public GestionPersonnelVue() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 617, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 581, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(21, 28, 89, 23);
		panel.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(139, 28, 96, 23);
		panel.add(btnSupprimer);
		btnSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            int[] selection = table.getSelectedRows();
	 
	            for(int i = selection.length - 1; i >= 0; i--){
	                modelPersonnel.removePersonnel(selection[i]);
	            }
			}
		});
		
		JButton btnReinitialiser = new JButton("Reinitialiser");
		btnReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReinitialiser.setBounds(261, 28, 109, 23);
		panel.add(btnReinitialiser);
		
		table = new JTable();
		table.setBounds(20, 354, 556, -246);
		contentPane.add(table);
	}

	private void loadTableScreen() {
		TableauScreen tableau = new TableauScreen(AppConstants.APP_NAME, modelPersonnel);
		
		tableau.setVisible(true);
		tableau.setLocationRelativeTo(null);
	}
}
