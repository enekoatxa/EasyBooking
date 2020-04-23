package EasyBookingKlientea.PL;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
		lHasi hasi = new lHasi(args[0], args[1], args[2]);
		hasi.setVisible(true);
	}

	public lHasi(String host, String port, String server) {
		konektatuZerbitzarira(host, port, server);
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
		btnSartu.setBounds((pantailaTamaina.width / 4) - (a / 2), this.getHeight() / 2, a, altuera);
		contentPane.add(btnSartu);

		lblIzenaEman = new JLabel("Izena eman");
		a = pantailaTamaina.width / 28;
		lblIzenaEman.setBounds((pantailaTamaina.width / 4) - (a / 2), btnSartu.getY() + btnSartu.getHeight() * 2, a,
				altuera);
		contentPane.add(lblIzenaEman);

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

	private void konektatuZerbitzarira(String host, String port, String server) {
		try {
			Registry registry = LocateRegistry.getRegistry(Integer.valueOf(port));
			String name = "//" + host + ":" + port + "/" + server;
			// stubServer = (IEasyZerbitzaria) java.rmi.Naming.lookup(name);
			stubServer = (IEasyZerbitzaria) registry.lookup(name);

		} catch (Exception e) {
			System.err.println("- Klientean exzepzioa RMI zerbitzarira konektatzean " + e.getMessage());
			e.printStackTrace();
		}
	}
}
