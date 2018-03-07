package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.model.ClientModel;
import fr.eni.clinique.ihm.model.PersonnelModel;
import fr.eni.clinique.ihm.model.RechercherModel;

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
    private ClientModel model;
    private RechercherModel tableau = new RechercherModel();
	final Observer observable = new Observer();
    List<Client> clients = new ArrayList<Client>();

	public RechercherClientVue(ClientModel model) {
		this.model = model;
//		this.observable.addObserver(mafenetre);
		initialize();
	}
	

	/**
	 * Create the frame.
	 */
	public void initialize() {
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
		txtRechercher.setBounds(48, 22, 208, 20);
		panel.add(txtRechercher);
		txtRechercher.setColumns(10);
		
		JLabel lblErreur = new JLabel("Veuillez rentrez un nom");
		lblErreur.setBounds(48,40, 300, 23);
		panel.add(lblErreur);
		lblErreur.setVisible(false);

		table = new JTable(tableau);
		//table.setBounds(0, 0, 500, 20);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(50, 100, 500, 200);
		contentPane.add(scroll);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(397, 21, 103, 23);

		btnRechercher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtRechercher.getText().length() == 0)
				{
					lblErreur.setVisible(true);
				}
				else {
					clients = model.selectClient(txtRechercher.getText().trim());
					tableau.refresh(clients);
//					observable.changeData(personnel);
				}
			}
		});
		panel.add(btnRechercher);
		
	}
}
