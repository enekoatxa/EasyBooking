package EasyBookingKlientea.PL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import EasyBookingKlientea.DLDTO.hegaldiaDTO;

public class pHegaldia extends JPanel {

	private final String pathFondoa = "src/main/resources/pHegaldiaFondoa.png";
	
	public pHegaldia(hegaldiaDTO h) {
		this.setLayout(null);
		Icon fondoa = new ImageIcon(pathFondoa);
		JLabel lfondoa = new JLabel(fondoa);
		lfondoa.setBounds(0, 0, 700, 200);

		JLabel irteera = new JLabel(h.getIrteera().toString().toUpperCase());
		JLabel helmuga = new JLabel(h.getHelmuga().toString().toUpperCase());
		JLabel denbora = new JLabel((Double.toString(h.getDenbora()) + " minutu").toUpperCase());
		JLabel prezioa = new JLabel((Double.toString(h.getPrezioa()) + " euro").toUpperCase());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		JLabel data = new JLabel(format.format(h.getData()));
		JLabel aerolinea = new JLabel(h.getAerolinea().toString().toUpperCase());

		irteera.setBounds(80, 20, 200, 30);
		helmuga.setBounds(320, 20, 200, 30);
		denbora.setBounds(80, 85, 200, 30);
		prezioa.setBounds(560, 45, 100, 30);
		data.setBounds(80, 135, 100, 30);
		aerolinea.setBounds(330, 110, 200, 30);


		lfondoa.add(irteera);
		lfondoa.add(helmuga);
		lfondoa.add(denbora);
		lfondoa.add(prezioa);
		lfondoa.add(data);
		lfondoa.add(aerolinea);
		this.add(lfondoa);
		this.setVisible(true);
	}

}
