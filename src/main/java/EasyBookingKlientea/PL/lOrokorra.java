package EasyBookingKlientea.PL;

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
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;

import EasyBookingZerbitzaria.DL.*;


public class lOrokorra extends JFrame{
	
	Dimension pantailaTamaina = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension filtroTamaina = pantailaTamaina;
	Dimension bilaketaTamaina = pantailaTamaina;
	
	public static void main(String[]args)
	{
		
//		LERREG l= new LERREG();
//		l.setVisible(true);
//		LHASI A= new LHASI();
//		A.setVisible(true);
//		lHasiera login = new lHasiera();
//		login.setVisible(true);
		lOrokorra leihoa = new lOrokorra();
		leihoa.setVisible(true);
	}
	
	public lOrokorra()
	{
		
		//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		this.setSize(pantailaTamaina);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		filtroTamaina.setSize(pantailaTamaina.width/4, pantailaTamaina.height);
		bilaketaTamaina.setSize(pantailaTamaina.width, pantailaTamaina.height/10);
		
		//Panel orokorra
		JPanel pOrokorra = new JPanel(new BorderLayout());
	
		
		//Ezkerrean kokatutako filtrorako konponenteak
		JPanel pFiltroa = new JPanel(new GridLayout(9, 1));
		pFiltroa.setPreferredSize(filtroTamaina);
		JButton bFiltratu = new JButton("Filtratu");
		
		JLabel lblPrezioaMin = new JLabel("Prezio Minimoa");
		JSlider sPrezioaMin = new JSlider(0, 1000, 200);
		sPrezioaMin.setMajorTickSpacing(100);
		sPrezioaMin.setPaintTicks(true);
		sPrezioaMin.setPaintLabels(true);
		
		JLabel lblPrezioaMax = new JLabel("Prezio Maximoa");
		JSlider sPrezioaMax = new JSlider(0,1000, 800);
		sPrezioaMax.setMajorTickSpacing(100);
		sPrezioaMax.setPaintTicks(true);
		sPrezioaMax.setPaintLabels(true);
		
		JLabel lblDenboraMax = new JLabel("Iraupen Maximoa");
		JSlider sDenboraMax = new JSlider(0, 20, 5);
		sDenboraMax.setMajorTickSpacing(2);
		sDenboraMax.setPaintTicks(true);
		sDenboraMax.setPaintLabels(true);
		
		
		
		DefaultListModel<String> aerolineakModel = new DefaultListModel<String>();
		//PROBARAKO
		aerolineakModel.addElement("Ryanair");
		aerolineakModel.addElement("Ryanair");
		aerolineakModel.addElement("Ryanair");
		aerolineakModel.addElement("Ryanair");
		
		JList<String> lAerolineak = new JList<String>(aerolineakModel);
		
		
		pFiltroa.add(bFiltratu);
		pFiltroa.add(lblPrezioaMin);
		pFiltroa.add(sPrezioaMin);
		pFiltroa.add(lblPrezioaMax);
		pFiltroa.add(sPrezioaMax);
		pFiltroa.add(lblDenboraMax);
		pFiltroa.add(sDenboraMax);
		pFiltroa.add(lAerolineak);
		
		//Goian kokatutako bilaketa konponenteak
		JPanel pBilaketa = new JPanel(new GridLayout(1, 10));
		pBilaketa.setPreferredSize(bilaketaTamaina);
		JLabel lIrteera = new JLabel("Irteera aireportua");
		JComboBox<String> cIrteera = new JComboBox<String>();
		cIrteera.addItem("Madrid - Barajas");
		cIrteera.addItem("London - Heathrow");
		cIrteera.addItem("Los Angeles - LAX");
		cIrteera.addItem("New York - JFK");
		JLabel lHelmuga = new JLabel("Helmuga aireportua");
		JComboBox<String> cHelmuga = new JComboBox<String>();
		cHelmuga.addItem("Madrid - Barajas");
		cHelmuga.addItem("London - Heathrow");
		cHelmuga.addItem("Los Angeles - LAX");
		cHelmuga.addItem("New York - JFK");
		JLabel lKopurua = new JLabel("Bidaiari kopurua");
		SpinnerNumberModel modelKopurua = new SpinnerNumberModel(1, 1, 10, 1);
		JSpinner spinner = new JSpinner(modelKopurua);
		JLabel lDataIrt = new JLabel("Irteera data");
		JDateChooser calendar = new JDateChooser();
		
	
		pBilaketa.add(lIrteera);
		pBilaketa.add(cIrteera);
		pBilaketa.add(lHelmuga);
		pBilaketa.add(cHelmuga);
		pBilaketa.add(lKopurua);
		pBilaketa.add(spinner);
		pBilaketa.add(lDataIrt);
		pBilaketa.add(calendar);
		
		//Erdian kokatutako emaitzen panela
		JPanel pErdia = new JPanel(new GridLayout(1,2));
		JPanel pEmaitza = new JPanel(new FlowLayout());
		JPanel pGrafikoak = new JPanel(new FlowLayout());
		pErdia.add(pEmaitza);
		pErdia.add(pGrafikoak);
		
		//probarako sortuttako datuak
		aerolinea lineaProba = new aerolinea("AERO1", "aerolinea1");
		aireportua portuaProba = new aireportua("PORT1", "aireportua1");
		Date dataProba = new Date();
		hegaldia hProba = new hegaldia("ABC", portuaProba, portuaProba, 3, 45, dataProba, 56, lineaProba);
		
		pHegaldia panelProba = new pHegaldia(hProba);
		pHegaldia panelProba2 = new pHegaldia(hProba);
		pHegaldia panelProba3 = new pHegaldia(hProba);

		pEmaitza.add(panelProba);
		pEmaitza.add(panelProba2);
		pEmaitza.add(panelProba3);
		
		
		pOrokorra.add(pErdia, BorderLayout.CENTER);
		pOrokorra.add(pBilaketa, BorderLayout.NORTH);
		pOrokorra.add(pFiltroa, BorderLayout.WEST);
		
		this.add(pOrokorra);
	}
}
	
