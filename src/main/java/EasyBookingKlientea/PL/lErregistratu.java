package EasyBookingKlientea.PL;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import EasyBookingKlientea.DLDTO.aireportuaDTO;
import EasyBookingKlientea.NL.Controller;

public class lErregistratu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JLabel lblHelb;
	private JLabel lblHelb2;
	private JLabel lblHelb3;
	private JLabel lblHelb4;
	private JLabel lblHelb5;
	private JLabel lblAut;
	private JLabel lblOrdainketa;
	private JLabel lblAireportua;
	private JComboBox<aireportuaDTO> aireportua;
	private JButton btnIzEman;
	private JLabel lblSartu;
	private ButtonGroup aut;
	private ButtonGroup ord;

	private JRadioButton rdbtnFb;
	private JRadioButton rdbtnGoogle;
	private JRadioButton rdbtnPp;
	private JRadioButton rdbtnVisa;
	Dimension pantailaTamaina = Toolkit.getDefaultToolkit().getScreenSize();

	private final String pathFacebook = "src/main/resources/fb.png";
	private final String pathGoogle = "src/main/resources/google.png";
	private final String pathpaypal = "src/main/resources//pp.jpg";
	private final String pathvisa = "src/main/resources//visa.jpg";

	JFrame b = this;
	private Controller controller;

	public lErregistratu(Controller cont) {
		controller = cont;
		setTitle("Izena eman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(pantailaTamaina.width / 2, pantailaTamaina.height / 2);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int altuera = pantailaTamaina.height / 54;
		int a = pantailaTamaina.width / 16;

		lblHelb = new JLabel("Helbide elektronikoa");
		a = pantailaTamaina.width / 16;
		lblHelb.setBounds(pantailaTamaina.width / 10, pantailaTamaina.height / 100, pantailaTamaina.width / 5,
				pantailaTamaina.height / 30);
		contentPane.add(lblHelb);

		textField = new JTextField();
		textField.setBounds(pantailaTamaina.width / 50, pantailaTamaina.height / 25, pantailaTamaina.width / 5,
				pantailaTamaina.height / 30);
		contentPane.add(textField);

		lblHelb2 = new JLabel("Izena");
		a = pantailaTamaina.width / 16;
		lblHelb2.setBounds(pantailaTamaina.width / 9, pantailaTamaina.height / 13, pantailaTamaina.width / 5,
				pantailaTamaina.height / 30);
		contentPane.add(lblHelb2);

		textField2 = new JTextField();
		textField2.setBounds(pantailaTamaina.width / 50, pantailaTamaina.height / 9, pantailaTamaina.width / 5,
				pantailaTamaina.height / 30);
		contentPane.add(textField2);

		lblHelb3 = new JLabel("Abizena");
		a = pantailaTamaina.width / 16;
		lblHelb3.setBounds(pantailaTamaina.width / 9, pantailaTamaina.height / 7, pantailaTamaina.width / 5,
				pantailaTamaina.height / 30);
		contentPane.add(lblHelb3);

		textField3 = new JTextField();
		textField3.setBounds(pantailaTamaina.width / 50, pantailaTamaina.height / 6, pantailaTamaina.width / 5,
				pantailaTamaina.height / 30);
		contentPane.add(textField3);

		lblHelb4 = new JLabel("Adina");
		a = pantailaTamaina.width / 16;
		lblHelb4.setBounds(pantailaTamaina.width / 9, pantailaTamaina.height / 5, pantailaTamaina.width / 5,
				pantailaTamaina.height / 30);
		contentPane.add(lblHelb4);

		textField4 = new JTextField();
		textField4.setBounds(pantailaTamaina.width / 50, pantailaTamaina.height / 5 + (pantailaTamaina.height / 30),
				pantailaTamaina.width / 5, pantailaTamaina.height / 30);
		contentPane.add(textField4);

		lblHelb5 = new JLabel("NAN:");
		a = pantailaTamaina.width / 16;
		lblHelb5.setBounds(pantailaTamaina.width / 9, pantailaTamaina.height / 4 + (pantailaTamaina.height / 50),
				pantailaTamaina.width / 5, pantailaTamaina.height / 30);
		contentPane.add(lblHelb5);

		textField5 = new JTextField();
		textField5.setBounds(pantailaTamaina.width / 50, pantailaTamaina.height / 4 + (pantailaTamaina.height / 20),
				pantailaTamaina.width / 5, pantailaTamaina.height / 30);
		contentPane.add(textField5);

		lblAut = new JLabel("Autentikatu zaitez");
		a = pantailaTamaina.width / 14;
		lblAut.setBounds((pantailaTamaina.width / 3) + pantailaTamaina.width / 50, (int) (altuera * 1.5), a, altuera);
		contentPane.add(lblAut);

		rdbtnFb = new JRadioButton("Facebook");
		rdbtnFb.setBounds((pantailaTamaina.width / 4) + pantailaTamaina.width / 20, (int) (altuera * 4), a, altuera);
		Icon logoFacebook = new ImageIcon(pathFacebook);
		rdbtnFb.setIcon(logoFacebook);
		contentPane.add(rdbtnFb);

		rdbtnGoogle = new JRadioButton("Google");
		rdbtnGoogle.setBounds((pantailaTamaina.width / 3) + pantailaTamaina.width / 20, (int) (altuera * 4), a,
				altuera);
		Icon logoGoogle = new ImageIcon(pathGoogle);
		rdbtnGoogle.setIcon(logoGoogle);

		contentPane.add(rdbtnGoogle);

		aut = new ButtonGroup();
		aut.add(rdbtnFb);
		aut.add(rdbtnGoogle);

		lblOrdainketa = new JLabel("Ordainketa metodoa");
		a = pantailaTamaina.width / 14;
		lblOrdainketa.setBounds((pantailaTamaina.width / 3) + pantailaTamaina.width / 80, (int) (altuera * 8), a,
				altuera);
		contentPane.add(lblOrdainketa);

		rdbtnPp = new JRadioButton("Paypal");
		rdbtnPp.setBounds((pantailaTamaina.width / 4) + pantailaTamaina.width / 20, (int) (altuera * 10), a, altuera);
		Icon logopaypal = new ImageIcon(pathpaypal);
		rdbtnPp.setIcon(logopaypal);
		contentPane.add(rdbtnPp);

		rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setBounds((pantailaTamaina.width / 3) + pantailaTamaina.width / 20, (int) (altuera * 10), a, altuera);
		Icon logovisa = new ImageIcon(pathvisa);
		rdbtnVisa.setIcon(logovisa);
		contentPane.add(rdbtnVisa);

		ord = new ButtonGroup();
		ord.add(rdbtnPp);
		ord.add(rdbtnVisa);

		lblAireportua = new JLabel("Gustoko aireportua");
		a = pantailaTamaina.width / 16;
		lblAireportua.setBounds((pantailaTamaina.width / 3) + pantailaTamaina.width / 80, (int) (altuera * 15), a,
				altuera);
		contentPane.add(lblAireportua);

		aireportua = new JComboBox<aireportuaDTO>();
		kargatuAireportuak();
		a = pantailaTamaina.width / 6;
		aireportua.setBounds((pantailaTamaina.width / 4) + pantailaTamaina.width / 20, (int) (altuera * 16.5), a,
				altuera);
		contentPane.add(aireportua);

		btnIzEman = new JButton("Izena eman");
		a = pantailaTamaina.width / 14;
		btnIzEman.setBounds((pantailaTamaina.width / 3) + pantailaTamaina.width / 80, (int) (altuera * 19), a, altuera);
		contentPane.add(btnIzEman);

		lblSartu = new JLabel("Sartu");
		a = pantailaTamaina.width / 28;
		lblSartu.setBounds((pantailaTamaina.width / 3) + pantailaTamaina.width / 24, (int) (altuera * 21), a, altuera);
		contentPane.add(lblSartu);

		lblSartu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}

		});

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

		btnIzEman.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String pasahitz = "";
				String helbidea;
				String Izena;
				String abizena;
				String adina;
				String Nan;
				String nick = " ";
				String pasahitza = " ";

				helbidea = textField.getText();
				Izena = textField2.getText();
				abizena = textField3.getText();
				adina = textField4.getText();
				Nan = textField5.getText();

				if ((textField.getText().equals("")) || (textField.getText().equals(" "))
						|| (textField.getText().equals("  "))) {
					JOptionPane.showMessageDialog(lErregistratu.this, "Helbide elektroniko bat idatzi behar duzu.",
							"Kontuz", 1);
				}
				if ((textField2.getText().equals("")) || (textField2.getText().equals(" "))
						|| (textField2.getText().equals("  "))) {
					JOptionPane.showMessageDialog(lErregistratu.this, "Zure izena jarri behar duzu.", "Kontuz", 1);
				}
				if ((textField3.getText().equals("")) || (textField3.getText().equals(" "))
						|| (textField3.getText().equals("  "))) {
					JOptionPane.showMessageDialog(lErregistratu.this, "Zure abizena jarri behar duzu.", "Kontuz", 1);
				}
				if ((textField4.getText().equals("")) || (textField4.getText().equals(" "))
						|| (textField4.getText().equals("  "))) {
					JOptionPane.showMessageDialog(lErregistratu.this, "Zure adina jarri behar duzu.", "Kontuz", 1);
				}
				if ((textField5.getText().equals("")) || (textField5.getText().equals(" "))
						|| (textField5.getText().equals("  "))) {
					JOptionPane.showMessageDialog(lErregistratu.this, "Zure NAN-a jarri behar duzu.", "Kontuz", 1);
				}

				if ((rdbtnFb.isSelected() == false) && (rdbtnGoogle.isSelected() == false)) {
					JOptionPane.showMessageDialog(b, "Autentikazio zerbitzu bat aukeratu behar duzu!", "Kontuz", 1);

				}
				if ((rdbtnPp.isSelected() == false) && (rdbtnVisa.isSelected() == false)) {
					JOptionPane.showMessageDialog(b, "Ordainketa metodo bat aukeratu behar duzu!", "Kontuz", 1);

				}

				else {
					
					pasahitz = controller.sortuErabiltzailea(helbidea, Izena, abizena, Integer.parseInt(adina), Nan, nick, pasahitza, (aireportuaDTO) aireportua.getSelectedItem());
					if (!pasahitz.equals("")) {
						JOptionPane.showMessageDialog(b, "Erabiltzaile berria gorde da! Hau da zure pasahitza: " + pasahitz +". Alda dezakezu nahi baduzu.", "Sortuta", 1);

					} else {
						JOptionPane.showMessageDialog(b,
								"Arazoak sortu dira erabiltzaile berria sortzean, saiatu berriro mesedez.",
								"Saiatu berriro", 1);
					}
					dispose();
					lHasi hasi = new lHasi(controller);
					hasi.setVisible(true);
				}
			}

		});

	}

	private void kargatuAireportuak() {
		ArrayList<aireportuaDTO> aireportuak = controller.kargatuAireportuak();
		if(aireportuak.size()!=0) {
			for(aireportuaDTO a: aireportuak) {
				aireportua.addItem(a);
			}
			repaint();
		}
	}
}
