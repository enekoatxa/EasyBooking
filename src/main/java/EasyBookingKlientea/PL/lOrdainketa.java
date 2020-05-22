package EasyBookingKlientea.PL;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import EasyBookingKlientea.NL.IEasyZerbitzaria;
import EasyBookingZerbitzaria.NL.RestClient_konexioa;

public class lOrdainketa  extends JFrame{


		private JLabel lblemaila;
		private JLabel lblcontzeptua;
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JLabel lblErabiltzailea;
		private JLabel lblPasahitza;
		private JButton btnSartu;
		private JLabel lblIzenaEman;
		private JLabel lblHasiHonekin;
		private JRadioButton rdbtnPp;
		private JRadioButton rdbtnVisa;

		private JTextField textField_2;
		private IEasyZerbitzaria stubServer = null;
		private final String pathpaypal = "src/main/resources//pp.jpg";
		private final String pathvisa= "src/main/resources//visa.jpg";
		private ButtonGroup aut;

		
		JFrame b = this;
		Dimension pantailaTamaina = Toolkit.getDefaultToolkit().getScreenSize();

		public static void main(String[] args) {
			lOrdainketa hasi = new lOrdainketa();
			 hasi.setVisible(true);
			System.out.println("Bai");
			RestClient_konexioa konexioa = new RestClient_konexioa("192.168.6.31", "5000");
			try {
				konexioa.makeGetRequest("/Authentication/Log_in");
				System.out.println("Baibai");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Catched exception: " + e.getMessage());
			}

		}

		public lOrdainketa() {

			setTitle("Ordainketa");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(pantailaTamaina.width / 4, pantailaTamaina.height / 2);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(null);

			int altuera = pantailaTamaina.height / 54;

			lblemaila = new JLabel("Emaila");
			int a = pantailaTamaina.width / 26;
			lblemaila.setBounds(20,10,100,20);
			contentPane.add(lblemaila);
			
			textField = new JTextField();
			a = pantailaTamaina.width / 6;
			textField.setBounds(20,40,200,20);
			contentPane.add(textField);

			lblPasahitza = new JLabel("Kantitatea");
			a = pantailaTamaina.width / 28;
			lblPasahitza.setBounds(20,80,100,20);
			contentPane.add(lblPasahitza);

			textField_1 = new JTextField();
			a = pantailaTamaina.width / 6;
			textField_1.setBounds(20,110,200,20);
			contentPane.add(textField_1);
			
			
			lblcontzeptua = new JLabel("Kontzeptua");
			a = pantailaTamaina.width / 28;
			lblcontzeptua.setBounds(20,140,100,20);
			contentPane.add(lblcontzeptua);

			textField_2 = new JTextField();
			a = pantailaTamaina.width / 6;
			textField_2.setBounds(20,170,200,20);
			contentPane.add(textField_2);
		
			
			rdbtnPp = new JRadioButton("Paypal");
			rdbtnPp.setBounds(20,420,40,40);
			Icon logopaypal = new ImageIcon(pathpaypal);
			rdbtnPp.setIcon(logopaypal);
			contentPane.add(rdbtnPp);

			
			rdbtnVisa = new JRadioButton("Visa");
			rdbtnVisa.setBounds(80,420,40,40);
			Icon logovisa = new ImageIcon(pathvisa);
			rdbtnVisa.setIcon(logovisa);
			contentPane.add(rdbtnVisa);

			btnSartu = new JButton("Egin ordaiketa");
			a = pantailaTamaina.width / 14;
			btnSartu.setBounds(300,450,140,30);
			contentPane.add(btnSartu);

			aut = new ButtonGroup();
			aut.add(rdbtnPp);
			aut.add(rdbtnVisa);

			JPanel panD1 = new JPanel();
			panD1.setBounds(0, 0, 450, 600);
			panD1.setOpaque(true);
			panD1.setBackground(new java.awt.Color(131, 214, 247));
			contentPane.add(panD1);

			JPanel panD2 = new JPanel();
			panD2.setBounds(450, 0, 50, 600);
			panD2.setOpaque(true);
			panD2.setBackground(new java.awt.Color(247, 245, 247));
			contentPane.add(panD2);

			btnSartu.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					if ((textField.getText().equals("")) || (textField.getText().equals(" "))
							|| (textField.getText().equals("  "))) {
						JOptionPane.showMessageDialog(lOrdainketa.this, "Helbide elektroniko bat idatzi behar duzu.", "Kontuz",
								1);
					}
					if ((textField_1.getText().equals("")) || (textField_1.getText().equals(" "))
							|| (textField_1.getText().equals("  "))) {
						JOptionPane.showMessageDialog(lOrdainketa.this, "Kantitatea idatzi behar duzu.", "Kontuz", 1);
					}				
					else {
						try {
							
							String flo = textField_1.getText(); 
							 float f = Float.parseFloat(flo);
							
							stubServer.ordaindu(textField.getText(), f, textField_2.getText());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

		
	}
}
