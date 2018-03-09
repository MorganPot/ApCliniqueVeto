package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgendaVue extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaVue frame = new AgendaVue();
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
	public AgendaVue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "De", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 640, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblVeterinaire = new JLabel("Veterinaire");
		lblVeterinaire.setBounds(23, 32, 83, 14);
		panel.add(lblVeterinaire);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 29, 104, 20);
		panel.add(comboBox);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(255, 32, 46, 14);
		panel.add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(309, 29, 113, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(10, 109, 640, 194);
		contentPane.add(table);
		
		JButton btnDossierMedic = new JButton("Dossier Medical");
		btnDossierMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DossierMedicalVue dossierMediVue = new DossierMedicalVue();
				dossierMediVue.setVisible(true);
				dossierMediVue.setResizable(false);
				dossierMediVue.setLocationRelativeTo(null);
			}
		});
		btnDossierMedic.setBounds(505, 323, 126, 23);
		contentPane.add(btnDossierMedic);
	}
}
