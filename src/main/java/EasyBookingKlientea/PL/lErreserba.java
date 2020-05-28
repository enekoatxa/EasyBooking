package EasyBookingKlientea.PL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EasyBookingKlientea.NL.Controller;

public class lErreserba extends JFrame {

	private JPanel contentPane;
	private IOrokor orokorra;
	private Controller controller;
	private JFrame b = this;

	/**
	 * Create the frame.
	 */
	public lErreserba(IOrokor orok, Controller cont) {
		orokorra = orok;
		controller = cont;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 270, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHegaldiarenId = new JLabel("Hegaldiaren ID");
		lblHegaldiarenId.setBounds(15, 35, 122, 20);
		contentPane.add(lblHegaldiarenId);

		JLabel lblNewLabel = new JLabel(orokorra.getkodea());
		lblNewLabel.setBounds(233, 35, 109, 20);
		contentPane.add(lblNewLabel);

		JLabel lblIrteera = new JLabel("Irteera");
		lblIrteera.setBounds(15, 71, 69, 20);
		contentPane.add(lblIrteera);

		JLabel lblHelmuga = new JLabel("Helmuga");
		lblHelmuga.setBounds(15, 107, 84, 20);
		contentPane.add(lblHelmuga);

		JLabel lblBidaiariKopurua = new JLabel("Bidaiari kopurua");
		lblBidaiariKopurua.setBounds(15, 143, 132, 20);
		contentPane.add(lblBidaiariKopurua);

		JLabel lblOrdainduBeharrekoa = new JLabel("Ordaindu beharrekoa");
		lblOrdainduBeharrekoa.setBounds(15, 179, 159, 20);
		contentPane.add(lblOrdainduBeharrekoa);

		JLabel label = new JLabel("");
		label.setBounds(233, 71, 109, 20);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(233, 107, 109, 20);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel(Integer.toString(orokorra.getBidaiariak().size()));
		label_2.setBounds(233, 143, 109, 20);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel(Integer.toString(orokorra.kalkulatuKopurua()));
		label_3.setBounds(233, 179, 109, 20);
		contentPane.add(label_3);

		JButton btnOrdaindu = new JButton("Ordaindu");
		btnOrdaindu.setBounds(274, 225, 115, 29);
		contentPane.add(btnOrdaindu);

		btnOrdaindu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = null;
				// ordainketa egin
				try {

					float kantitatea = orokorra.kalkulatuKopurua();

					String kontzeptua = Integer.toString(orokorra.getBidaiariak().size()) + " Bidaiarientzako"
							+ " hegazkin bidaia.";

					String email = orokorra.sesioEmaila();

					a = controller.ordaindu(email, kantitatea, kontzeptua);// ordainketa
																			// eginda

				} catch (RemoteException e1) {

					e1.printStackTrace();
				}
				if (a != null) {
					JOptionPane.showMessageDialog(b, "Arazorik gabe egin da ordainketa.", "Ordainduta", 1);
					dispose();
				} else {
					JOptionPane.showMessageDialog(b, "Arazoak egon dira ordaintzean, saiatu berriro mesedez.",
							"Saiatu berriro", 1);
				}

			}
		});

		JButton btnEzeztatu = new JButton("Ezeztatu");
		btnEzeztatu.setBounds(25, 225, 115, 29);
		contentPane.add(btnEzeztatu);

		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
	}

}
