package EasyBookingKlientea.PL;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class lBidaiariak extends JFrame {

	private JPanel contentPane;
	public IOrokor orokorra;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public lBidaiariak(IOrokor orokor) {
		setTitle("Bidaiariak");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		orokorra = orokor;

		JLabel lblZenbatBidaiariIzango = new JLabel("Zenbat bidaiari izango zarete?");
		lblZenbatBidaiariIzango.setBounds(31, 16, 311, 20);
		contentPane.add(lblZenbatBidaiariIzango);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
		comboBox.setBounds(31, 81, 46, 26);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Ados");
		btnNewButton.setBounds(270, 173, 115, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Atzera");
		btnNewButton_1.setBounds(31, 173, 115, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				orokorra.bidaiariakBF();
				dispose();
			}
		});

		btnNewButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Object aukeraketa0 = comboBox.getSelectedItem();
				int aukeraketa = Integer.parseInt(aukeraketa0.toString());
				lBidaiaria bidaiaria = new lBidaiaria(aukeraketa, orokorra);
				bidaiaria.setVisible(true);
				dispose();
			}
		});
	}

}
