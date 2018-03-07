package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.model.AnimalModelDynamic;
import fr.eni.clinique.ihm.model.ClientModel;

public class GestionClientVue extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 996804950040668625L;
	private JPanel contentPane;
	private JTextField textFieldCode;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldCodePostal;
	private JTextField textFieldVille;
	private JTextField textFieldAdresse2;
	private JTable table;
	private AnimalModelDynamic model = new AnimalModelDynamic();
    private ClientModel modelCli = new ClientModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionClientVue frame = new GestionClientVue();
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
	public GestionClientVue() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 845, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(32, 31, 762, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RechercherClientVue rechercherClientVue = new RechercherClientVue(modelCli);
				rechercherClientVue.setVisible(true);
				rechercherClientVue.setResizable(false);
				rechercherClientVue.setLocationRelativeTo(null);
			}
		});
		btnRechercher.setBounds(21, 21, 109, 23);
		panel.add(btnRechercher);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterClientVue ajouterClientVue = new AjouterClientVue(modelCli, GestionClientVue.this);
					ajouterClientVue.setVisible(true);
					ajouterClientVue.setResizable(false);
					ajouterClientVue.setLocationRelativeTo(null);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAjouter.setBounds(275, 21, 89, 23);
		panel.add(btnAjouter);
		
		JButton btnSuppimer = new JButton("Supprimer");
		btnSuppimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSuppimer.setBounds(375, 21, 99, 23);
		panel.add(btnSuppimer);
		
		JButton btnValider = new JButton("");
		btnValider.setIcon(new ImageIcon(GestionClientVue.class.getResource("/image/tick.png")));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValider.setBounds(608, 11, 49, 44);
		panel.add(btnValider);
		
		JButton btnAnnuler = new JButton("");
		btnAnnuler.setIcon(new ImageIcon(GestionClientVue.class.getResource("/image/cancel.png")));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnAnnuler.setBounds(679, 11, 49, 44);
		panel.add(btnAnnuler);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(32, 142, 46, 14);
		contentPane.add(lblCode);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(32, 182, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(32, 223, 46, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(32, 284, 62, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(32, 351, 79, 14);
		contentPane.add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(32, 387, 46, 14);
		contentPane.add(lblVille);
		
		textFieldCode = new JTextField();
		textFieldCode.setBounds(121, 139, 178, 20);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(121, 179, 178, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(121, 220, 178, 20);
		contentPane.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(121, 281, 178, 20);
		contentPane.add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(121, 348, 178, 20);
		contentPane.add(textFieldCodePostal);
		textFieldCodePostal.setColumns(10);
		
		textFieldVille = new JTextField();
		textFieldVille.setBounds(121, 384, 178, 20);
		contentPane.add(textFieldVille);
		textFieldVille.setColumns(10);
		
		textFieldAdresse2 = new JTextField();
		textFieldAdresse2.setBounds(121, 312, 178, 20);
		contentPane.add(textFieldAdresse2);
		textFieldAdresse2.setColumns(10);
		
		table = new JTable(model);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		JPanel panT = new JPanel();
		panT.setBounds(320, 135, 500, 200);
		panT.add(new JScrollPane(table));
		contentPane.add(panT);
		
		JButton btnAjouterAnimal = new JButton("");
		btnAjouterAnimal.setIcon(new ImageIcon(GestionClientVue.class.getResource("/image/add-button.png")));
		btnAjouterAnimal.setBounds(494, 384, 23, 23);
		contentPane.add(btnAjouterAnimal);
		
		JButton btnSupprimerAnimal = new JButton("");
		btnSupprimerAnimal.setIcon(new ImageIcon(GestionClientVue.class.getResource("/image/open-trash-can.png")));
		btnSupprimerAnimal.setBounds(543, 384, 23, 23);
		contentPane.add(btnSupprimerAnimal);
		
		JButton btnEditerAnimal = new JButton("");
		btnEditerAnimal.setIcon(new ImageIcon(GestionClientVue.class.getResource("/image/election-checklist-symbol.png")));
		btnEditerAnimal.setBounds(589, 384, 23, 23);
		contentPane.add(btnEditerAnimal);
	}
	
	@Override
	public void update(Observable o, Object client) {
		
		textFieldNom.setText(((Client) client).getNomClient());
		textFieldPrenom.setText(((Client) client).getPrenomClient());
		textFieldAdresse.setText(((Client) client).getAdresse1());
		textFieldAdresse2.setText(((Client) client).getAdresse2());
		textFieldCodePostal.setText(((Client) client).getCodePostal());
		textFieldVille.setText(((Client) client).getVille());
	}
}
