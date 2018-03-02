package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class RechercherClientVue extends JFrame {

	private JPanel contentPane;
	private JTextField txtRechercher;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercherClientVue frame = new RechercherClientVue();
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
	public RechercherClientVue() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 535, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtRechercher = new JTextField();
		txtRechercher.setToolTipText("Recherche Client");
		txtRechercher.setForeground(Color.WHITE);
		txtRechercher.setText("");
		txtRechercher.setBounds(48, 22, 208, 20);
		panel.add(txtRechercher);
		txtRechercher.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(397, 21, 103, 23);
		panel.add(btnRechercher);
		
		table = new JTable();
		table.setBounds(31, 278, 496, -176);
		contentPane.add(table);
	}
}
