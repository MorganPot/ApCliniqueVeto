package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterClientVue extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCode;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldAdresse2;
	private JTextField textFieldCodePostal;
	private JTextField textFieldVille;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterClientVue frame = new AjouterClientVue();
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
	public AjouterClientVue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 414, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnValider = new JButton("");
		btnValider.setIcon(new ImageIcon(AjouterClientVue.class.getResource("/image/tick.png")));
		btnValider.setBounds(31, 11, 160, 40);
		panel.add(btnValider);
		
		JButton btnAnnuler = new JButton("");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnAnnuler.setIcon(new ImageIcon(AjouterClientVue.class.getResource("/image/cancel.png")));
		btnAnnuler.setBounds(227, 11, 160, 40);
		panel.add(btnAnnuler);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(96, 129, 46, 14);
		contentPane.add(lblCode);
		
		textFieldCode = new JTextField();
		textFieldCode.setBounds(189, 126, 153, 20);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(96, 167, 46, 14);
		contentPane.add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(189, 164, 153, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(96, 203, 46, 14);
		contentPane.add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(189, 200, 153, 20);
		contentPane.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(96, 239, 58, 14);
		contentPane.add(lblAdresse);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(189, 236, 153, 20);
		contentPane.add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		textFieldAdresse2 = new JTextField();
		textFieldAdresse2.setBounds(189, 261, 153, 20);
		contentPane.add(textFieldAdresse2);
		textFieldAdresse2.setColumns(10);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(96, 313, 83, 14);
		contentPane.add(lblCodePostal);
		
		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(189, 310, 153, 20);
		contentPane.add(textFieldCodePostal);
		textFieldCodePostal.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(96, 349, 46, 14);
		contentPane.add(lblVille);
		
		textFieldVille = new JTextField();
		textFieldVille.setBounds(189, 346, 153, 20);
		contentPane.add(textFieldVille);
		textFieldVille.setColumns(10);
	}

}
