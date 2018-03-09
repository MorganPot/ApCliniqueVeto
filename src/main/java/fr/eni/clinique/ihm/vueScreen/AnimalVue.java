package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
//import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import fr.eni.clinique.bll.exception.ManagerException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Race;
import fr.eni.clinique.ihm.model.AnimalModel;
import fr.eni.clinique.ihm.model.PersonnelModel;
import fr.eni.clinique.resources.Sexe;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AnimalVue extends JFrame {

	private static final long serialVersionUID = 5497743199791005308L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField textFieldCode;
	private JTextField textFieldNom;
	private JTextField textFieldCouleur;
	private JTextField textFieldTatouage;
	private AnimalModel model;
	private JComboBox comboBoxEspece;
	private JComboBox comboBoxSexe;
	private JComboBox comboBoxRace;
	private JComboBox comboBoxClient;
	private JLabel lblErreur;
	private List<Client> clients = new ArrayList<Client>();
	private List<Race> races = new ArrayList<Race>();
	private List<Race> especes = new ArrayList<Race>();
	private ManagerFactory factory = new ManagerFactory();
	final Observer observable = new Observer();

	/**
	 * Launch the application.
	 */
	
	public AnimalVue(AnimalModel model,GestionClientVue mafenetre) {
		this.model = model;
		this.observable.addObserver(mafenetre);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalVue frame = new AnimalVue();
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
	public AnimalVue() {
		try {
			clients = factory.clientManager().getClient();
			races = factory.animalManager().getRace();
			especes = factory.animalManager().getEspece();
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 557, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(331, 28, 89, 23);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNom.getText().length() == 0 || textFieldCouleur.getText().length() == 0
		    || textFieldTatouage.getText().length() == 0)
				{
					lblErreur.setVisible(true);
				}
				else {
					System.out.println(textFieldNom.getText()+ comboBoxSexe.getSelectedItem().toString()+""+ textFieldCouleur.getText()+""+comboBoxRace.getSelectedItem().toString()+""+ comboBoxEspece.getSelectedItem().toString()+""+((Animal) comboBoxClient.getSelectedItem()).getCodeClient()+""+textFieldTatouage.getText());
					System.out.println("Toto");
					Animal animal = new Animal(textFieldNom.getText(),comboBoxSexe.getSelectedItem().toString(), textFieldCouleur.getText(),comboBoxRace.getSelectedItem().toString(),comboBoxEspece.getSelectedItem().toString(),((Animal) comboBoxClient.getSelectedItem()).getCodeClient(),textFieldTatouage.getText());
					
					try {
						model.addAnimal(animal);
					} catch (ManagerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					vue.ajoutClient(client);
					
					observable.changeData(animal);
					dispose();
				}
			}
		});
		panel.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(441, 28, 89, 23);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		panel.add(btnAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Client", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 101, 534, 66);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblErreur = new JLabel("Veuillez remplir les champs");
		lblErreur.setBounds(150,20, 300, 23);
		contentPane.add(lblErreur);
		lblErreur.setVisible(false);
		
		comboBoxClient = new JComboBox();
		comboBoxClient.setBounds(22, 22, 482, 20);
		for (Client cli : clients){
			comboBoxClient.addItem(cli.getNomClient());
		}
		panel_1.add(comboBoxClient);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(47, 194, 46, 14);
		contentPane.add(lblCode);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(47, 230, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setBounds(47, 268, 46, 14);
		contentPane.add(lblCouleur);
		
		JLabel lblEspece = new JLabel("Esp\u00E8ce");
		lblEspece.setBounds(47, 310, 46, 14);
		contentPane.add(lblEspece);
		
		JLabel lblTatouage = new JLabel("Tatouage");
		lblTatouage.setBounds(47, 352, 46, 14);
		contentPane.add(lblTatouage);
		
		textFieldCode = new JTextField();
		textFieldCode.setEditable(false);
		textFieldCode.setBounds(103, 191, 281, 20);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(103, 227, 281, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldCouleur = new JTextField();
		textFieldCouleur.setBounds(103, 265, 281, 20);
		contentPane.add(textFieldCouleur);
		textFieldCouleur.setColumns(10);
		
		textFieldTatouage = new JTextField();
		textFieldTatouage.setBounds(103, 349, 281, 20);
		contentPane.add(textFieldTatouage);
		textFieldTatouage.setColumns(10);
		
		comboBoxEspece = new JComboBox();
		comboBoxEspece.setBounds(103, 307, 86, 20);
		for (Race espece : especes){
			comboBoxEspece.addItem(espece.getEspece());
		}
		contentPane.add(comboBoxEspece);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setBounds(259, 310, 46, 14);
		contentPane.add(lblRace);
		
		comboBoxRace = new JComboBox();
		comboBoxRace.setBounds(298, 307, 86, 20);
		for (Race race : races){
			comboBoxRace.addItem(race.getRace());
		}
		contentPane.add(comboBoxRace);
		
		comboBoxSexe = new JComboBox(Sexe.values());
		comboBoxSexe.setBounds(434, 227, 93, 20);
		contentPane.add(comboBoxSexe);
	}
}
