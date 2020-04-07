package EasyBookingKlientea.PL;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import EasyBookingZerbitzaria.DL.*;

public class pHegaldia extends JPanel{
	
	private Dimension tamaina = new Dimension(300, 300);
	public pHegaldia(hegaldia h)
	{
		this.setBackground(new Color(164, 167, 185));
		this.setMaximumSize(tamaina);
		this.setLayout(new GridLayout(3,1));
		
		JLabel bidea = new JLabel(h.getIrteera().toString() + " --> " + h.getHelmuga().toString());
		bidea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 28));

		JLabel denbora = new JLabel(Double.toString(h.getDenbora()) + " minutu");
		denbora.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 34));
		
		JLabel prezioa = new JLabel(Double.toString(h.getPrezioa()) + " euro");
		prezioa.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 34));
		
		SimpleDateFormat format = new SimpleDateFormat("MM-dd");
		JLabel data = new JLabel(format.format(h.getData()));
		data.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 28));
		
		JLabel aerolinea = new JLabel(h.getAerolinea().toString());
		aerolinea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 28));
		aerolinea.setBackground(new Color(164,167,185));
		
		JPanel info = new JPanel(new GridLayout(1,3));
		info.setBackground(new Color(164,167,185));
		info.add(denbora);
		info.add(prezioa);
		info.add(data);
		
		this.add(bidea);
		this.add(info);
		this.add(aerolinea);
	}

}
