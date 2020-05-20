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

public class lHasi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblErabiltzailea;
	private JLabel lblPasahitza;
	private JButton btnSartu;
	private JLabel lblIzenaEman;
	private JLabel lblHasiHonekin;
	private JRadioButton rdbtnFb;
	private JRadioButton rdbtnGoogle;

	private IEasyZerbitzaria stubServer = null;
	private final String pathFacebook = "src/main/resources/fb.png";
	private final String pathGoogle = "src/main/resources/google.png";
	private ButtonGroup aut;

	JFrame b = this;
	Dimension pantailaTamaina = Toolkit.getDefaultToolkit().getScreenSize();

	public static void main(String[] args) {
		// lHasi hasi = new lHasi();
		// hasi.setVisible(true);
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

	public lHasi() {

		setTitle("Sartu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(pantailaTamaina.width / 2, pantailaTamaina.height / 2);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int altuera = pantailaTamaina.height / 54;

		lblErabiltzailea = new JLabel("Helbide elektronikoa");
		int a = pantailaTamaina.width / 26;
		lblErabiltzailea.setBounds((pantailaTamaina.width / 8) - (a / 2), pantailaTamaina.height / 54, a, altuera);
		contentPane.add(lblErabiltzailea);

		textField = new JTextField();
		a = pantailaTamaina.width / 6;
		textField.setBounds((pantailaTamaina.width / 8) - (a / 2),
				lblErabiltzailea.getY() + lblErabiltzailea.getY() * 2, a, altuera);
		contentPane.add(textField);

		lblPasahitza = new JLabel("Pasahitza");
		a = pantailaTamaina.width / 28;
		lblPasahitza.setBounds((pantailaTamaina.width / 8) - (a / 2), textField.getY() + textField.getY(), a, altuera);
		contentPane.add(lblPasahitza);

		textField_1 = new JTextField();
		a = pantailaTamaina.width / 6;
		textField_1.setBounds((pantailaTamaina.width / 8) - (a / 2),
				lblPasahitza.getY() + (textField.getY() - lblErabiltzailea.getY()), a, altuera);
		contentPane.add(textField_1);

		btnSartu = new JButton("Sartu");
		a = pantailaTamaina.width / 14;
		btnSartu.setBounds((pantailaTamaina.width / 3), this.getHeight() / 2, a, altuera);
		contentPane.add(btnSartu);

		lblIzenaEman = new JLabel("Izena eman");
		a = pantailaTamaina.width / 28;
		lblIzenaEman.setBounds((pantailaTamaina.width / 3) + pantailaTamaina.width / 50,
				btnSartu.getY() + btnSartu.getHeight() * 2, a, altuera);
		contentPane.add(lblIzenaEman);

		lblIzenaEman.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lErregistratu erregis = new lErregistratu();
				erregis.setVisible(true);
			}

		});

		lblHasiHonekin = new JLabel("Hasi honekin:");
		a = pantailaTamaina.width / 16;
		lblHasiHonekin.setBounds((pantailaTamaina.width / (7 / 2)) - (a / 2), lblErabiltzailea.getY(), a, altuera);
		contentPane.add(lblHasiHonekin);

		rdbtnFb = new JRadioButton("Facebook");
		rdbtnFb.setBounds((pantailaTamaina.width / (7 / 2)) - (a / 2), 84, 150, 155);
		Icon logoFacebook = new ImageIcon(pathFacebook);
		rdbtnFb.setIcon(logoFacebook);
		contentPane.add(rdbtnFb);

		rdbtnGoogle = new JRadioButton("Google");
		rdbtnGoogle.setBounds(pantailaTamaina.width / (7 / 2) - (a / 2) + 150, 84, 100, 155);
		Icon logoGoogle = new ImageIcon(pathGoogle);
		rdbtnGoogle.setIcon(logoGoogle);

		contentPane.add(rdbtnGoogle);

		aut = new ButtonGroup();
		aut.add(rdbtnFb);
		aut.add(rdbtnGoogle);

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

		JPanel panD3 = new JPanel();
		panD3.setBounds(500, 0, 450, 600);
		panD3.setOpaque(true);
		panD3.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD3);

		btnSartu.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if ((textField.getText().equals("")) || (textField.getText().equals(" "))
						|| (textField.getText().equals("  "))) {
					JOptionPane.showMessageDialog(lHasi.this, "Helbide elektroniko bat idatzi behar duzu.", "Kontuz",
							1);
				}
				if ((textField_1.getText().equals("")) || (textField_1.getText().equals(" "))
						|| (textField_1.getText().equals("  "))) {
					JOptionPane.showMessageDialog(lHasi.this, "Pasahitza idatzi behar duzu.", "Kontuz", 1);
				}
				/*
				 * Autentikazio zerbitzu bat aukeratu ez duen kasuan
				 */
				if ((rdbtnFb.isSelected() == false) && (rdbtnGoogle.isSelected() == false)) {
					JOptionPane.showMessageDialog(lHasi.this, "Autentikazio zerbitzu bat aukeratu behar duzu.",
							"Kontuz", 1);
				}
				/*
				 * Datuak ongi sartuta dauden kasuan
				 */
				else {
					String autentikazioZerbitzua = "";
					if (rdbtnFb.isSelected()) {
						autentikazioZerbitzua = "facebook";
					}
					if (rdbtnGoogle.isSelected()) {
						autentikazioZerbitzua = "google";
					}
					// Sartu
					try {
						// Imanol: Ez nago seguru horrela den
						stubServer.login(textField.getText(), textField_1.getText(), autentikazioZerbitzua);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

	}

}
