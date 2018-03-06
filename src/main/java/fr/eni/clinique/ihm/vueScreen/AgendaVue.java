package fr.eni.clinique.ihm.vueScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;


import org.jdatepicker.ComponentFormatDefaults;
import org.jdatepicker.JDatePicker;



import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AgendaVue extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaVue frame = new AgendaVue();
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
	public AgendaVue() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 739, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Pour", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 229, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(38, 34, 46, 14);
		panel.add(lblClient);
		
		JComboBox comboBoxClient = new JComboBox();
		comboBoxClient.setBounds(38, 49, 108, 20);
		panel.add(comboBoxClient);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(38, 80, 46, 14);
		panel.add(lblAnimal);
		
		JComboBox comboBoxAnimal = new JComboBox();
		comboBoxAnimal.setBounds(38, 98, 108, 20);
		panel.add(comboBoxAnimal);
		
		JButton btnClient = new JButton("");
		btnClient.setIcon(new ImageIcon(AgendaVue.class.getResource("/image/add-button.png")));
		btnClient.setBounds(181, 46, 23, 23);
		panel.add(btnClient);
		
		JButton buttonAnimal = new JButton("");
		buttonAnimal.setIcon(new ImageIcon(AgendaVue.class.getResource("/image/add-button.png")));
		buttonAnimal.setBounds(181, 97, 23, 23);
		panel.add(buttonAnimal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Par", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(249, 11, 229, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblVeterinaire = new JLabel("V\u00E9t\u00E9rinaire");
		lblVeterinaire.setBounds(42, 34, 85, 14);
		panel_1.add(lblVeterinaire);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(42, 54, 143, 20);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Quand", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(488, 11, 229, 155);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 10, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		panel_2.add(lblDate, gbc_lblDate);
		
		//Date heure
		ComponentFormatDefaults defaults = ComponentFormatDefaults.getInstance();
		defaults.setFormat(ComponentFormatDefaults.Key.TODAY_SELECTOR, new SimpleDateFormat("EEE dd MM yy"));
        defaults.setFormat(ComponentFormatDefaults.Key.DOW_HEADER, new SimpleDateFormat("EEEE"));
        defaults.setFormat(ComponentFormatDefaults.Key.SELECTED_DATE_FIELD, new SimpleDateFormat("dd/MM/yyyy"));
        defaults.setFormat(ComponentFormatDefaults.Key.MONTH_SELECTOR, new SimpleDateFormat("MMM"));
        
        JDatePicker datePicker = new JDatePicker();
        datePicker.getFormattedTextField().setColumns(1);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 10, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel_2.add(datePicker, gbc_textField);
		
		JLabel lblHeure = new JLabel("Heure");
		GridBagConstraints gbc_lblHeure = new GridBagConstraints();
		gbc_lblHeure.anchor = GridBagConstraints.WEST;
		gbc_lblHeure.insets = new Insets(0, 10, 5, 5);
		gbc_lblHeure.gridx = 0;
		gbc_lblHeure.gridy = 2;
		panel_2.add(lblHeure, gbc_lblHeure);
		
		JComboBox<String> cbxHeure = new JComboBox<String>();
		cbxHeure.setModel(new DefaultComboBoxModel<String>(new String[] {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 10, 0, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 3;
		panel_2.add(cbxHeure, gbc_comboBox);
		
		JLabel labelH = new JLabel("h");
		labelH.setBounds(0, 73, 66, -73);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 3;
		panel_2.add(labelH, gbc_label);
		
		JComboBox<String> cbxMinute = new JComboBox<String>();
		cbxMinute.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "15", "30", "45"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 3;
		panel_2.add(cbxMinute, gbc_comboBox_1);
	}
}
