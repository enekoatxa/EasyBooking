package PL;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import DL.aerolinea;
import DL.aireportua;
import DL.hegaldia;


public class lHasiera extends JFrame{
	
	Dimension pantailaTamaina = Toolkit.getDefaultToolkit().getScreenSize();

	
public lHasiera()
	{
		
		//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		this.setSize(pantailaTamaina.width/2, pantailaTamaina.height/2);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Sartu");
		//Panel orokorra
		JPanel pOrokorra = new JPanel(new BorderLayout());
		JPanel pErdia = new JPanel(new GridLayout(12,12));
		JPanel pGoi = new JPanel(new GridLayout(5,5));
		JPanel pBehe = new JPanel(new GridLayout(5,5));


		JLabel erab = new JLabel("Erabiltzailea");
		erab.setHorizontalAlignment(JLabel.CENTER);
		JTextField erab1 = new JTextField();
		JLabel psht = new JLabel("Pasahitza");
		psht.setHorizontalAlignment(JLabel.CENTER);
		JTextField psht1 = new JTextField();

		pErdia.add(erab);
		pErdia.add(erab1);
		pErdia.add(psht);
		pErdia.add(psht1);

		JButton bSartu = new JButton();
		bSartu.setText("Sartu");
		JLabel izEman = new JLabel("Izena eman");
		izEman.setHorizontalAlignment(JLabel.CENTER);

		
		pBehe.add(bSartu);
		pBehe.add(izEman);

		

		
		pOrokorra.add(pGoi, BorderLayout.NORTH);
		pOrokorra.add(pErdia, BorderLayout.CENTER);
		pOrokorra.add(pBehe, BorderLayout.SOUTH);
		

		this.add(pOrokorra);
		
		
	}
}
