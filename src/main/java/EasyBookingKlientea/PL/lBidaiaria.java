package EasyBookingKlientea.PL;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import EasyBookingZerbitzaria.DL.bidaiaria;

public class lBidaiaria extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private bidaiaria b;
	private int index;
	private JLabel lblZenbatBidaiariIzango;
	private int kop;
	public IOrokor orokorra;

	/**
	 * Create the frame.
	 */
	public lBidaiaria(int kopurua, IOrokor orokor) {
		setTitle("1.Bidaiariaren datuak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		orokor = orokorra;
		kop = kopurua;
		index = 1;

		lblZenbatBidaiariIzango = new JLabel("1.Bidaiariaren datuak:");
		lblZenbatBidaiariIzango.setBounds(31, 16, 311, 20);
		contentPane.add(lblZenbatBidaiariIzango);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
				"45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61",
				"62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78",
				"79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95",
				"96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110",
				"111", "112", "113", "114", "115", "116", "117", "118", "119", "120" }));
		comboBox.setBounds(165, 163, 58, 26);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Ados");
		btnNewButton.setBounds(274, 176, 115, 29);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(true);

		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setBounds(31, 52, 69, 20);
		contentPane.add(lblIzena);

		textField = new JTextField();
		textField.setBounds(165, 49, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Abizena");
		lblNewLabel.setBounds(31, 88, 69, 20);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 85, 146, 26);
		contentPane.add(textField_1);

		JLabel lblNana = new JLabel("NAN-a");
		lblNana.setBounds(31, 124, 69, 20);
		contentPane.add(lblNana);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 121, 146, 26);
		contentPane.add(textField_2);

		JLabel lblAdina = new JLabel("Adina");
		lblAdina.setBounds(31, 166, 69, 20);
		contentPane.add(lblAdina);
		System.out.println("mmm");

		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				int adina = Integer.parseInt(comboBox.getSelectedItem().toString());
				b = new bidaiaria(textField_2.getText(), textField.getText(), textField_1.getText(), adina);
				orokorra.addBidaiaria(b);
				System.out.println("bai");
				if (index < kop) {
					index = index + 1;
					setTitle(index + ".Bidaiariaren datuak");
					lblZenbatBidaiariIzango.setText(index + ".Bidaiariaren datuak");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				} else {
					lErreserba err = new lErreserba(orokorra);
					err.setVisible(true);
				}

			}
		});

	}
}
