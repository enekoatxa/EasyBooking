package EasyBookingKlientea.PL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;

import EasyBookingZerbitzaria.DL.aerolinea;
import EasyBookingZerbitzaria.DL.aireportua;
import EasyBookingZerbitzaria.DL.hegaldia;

public class IOrokor extends JFrame 
{
	private JPanel contentPane;
	private int luzea = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private int altuera = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    private final String pathLogoa = "src/main/resources/logoa.jpg";
	
	public static void main(String[]args)
	{
		
		IOrokor leihoa = new IOrokor();
		leihoa.setVisible(true);
	}
	
	public IOrokor() {
		
		setTitle("Easy Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(luzea, altuera);
		setLocationRelativeTo(null);    
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JDateChooser calendar = new JDateChooser();
		calendar.setBounds(luzea-(luzea/6) ,altuera/18,luzea/10, altuera/30);
		contentPane.add(calendar);
		
		JPanel panD1 = new JPanel();
		panD1.setBounds(0, altuera/18, luzea/12, altuera/12);
		panD1.setOpaque(true);
		panD1.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD1);
		
	
		
		JLabel lblirteera = new JLabel("Irteera Aereportua");
		lblirteera.setBounds(0,altuera/18, luzea/15, altuera/11); 
		panD1.add(lblirteera);
		
		
		JComboBox<String> cIrteera = new JComboBox<String>();
		cIrteera.addItem("Madrid - Barajas");
		cIrteera.addItem("London - Heathrow");
		cIrteera.addItem("Los Angeles - LAX");
		cIrteera.addItem("New York - JFK");
		cIrteera.setBounds(luzea/12 , altuera/18, 50, 50);
		cIrteera.setSize(new Dimension(200, 30));
		contentPane.add(cIrteera);
		
		JPanel panD2 = new JPanel();
		panD2.setBounds(luzea/12, altuera/18, luzea/12, altuera/12);
		panD2.setOpaque(true);
		panD2.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD2);
		

		
		JPanel panD3 = new JPanel();
		panD3.setBounds(luzea/6, altuera/18, luzea/12, altuera/12);
		panD3.setOpaque(true);
		panD3.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD3);
		
		JPanel panD4 = new JPanel();
		panD4.setBounds(luzea/6 + luzea/12, altuera/18, luzea/12, altuera/12);
		panD4.setOpaque(true);
		panD4.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD4);
		
		JLabel lblPrezioaMax = new JLabel("Helmuga Aereportua");
		lblPrezioaMax.setBounds(luzea-(luzea)+(luzea/4), altuera-(altuera)+(altuera/100), luzea/15, altuera/11); 
		panD4.add(lblPrezioaMax);
		
		JComboBox<String> cHelmuga = new JComboBox<String>();
		cHelmuga.addItem("Madrid - Barajas");
		cHelmuga.addItem("London - Heathrow");
		cHelmuga.addItem("Los Angeles - LAX");
		cHelmuga.addItem("New York - JFK");
		cHelmuga.setBounds(luzea/3 , altuera/18, 50, 50);
		cHelmuga.setSize(new Dimension(200, 30));
		contentPane.add(cHelmuga);
		
		JPanel panD5 = new JPanel();
		panD5.setBounds(luzea/3, altuera/18, luzea/12, altuera/12);
		panD5.setOpaque(true);
		panD5.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD5);		
		
		JPanel panD6 = new JPanel();
		panD6.setBounds(luzea/3 + luzea/12, altuera/18, luzea/12, altuera/12);
		panD6.setOpaque(true);
		panD6.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD6);
		
		JPanel panD7 = new JPanel();
		panD7.setBounds(luzea/3 + luzea/6, altuera/18, luzea/12, altuera/12);
		panD7.setOpaque(true);
		panD7.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD7);
		
		JLabel lblbidaiari = new JLabel("Bidaiari kopurua");
		lblbidaiari.setBounds(luzea-(luzea)+(luzea/2), altuera-(altuera)+(altuera/100), luzea/15, altuera/11); 
		panD7.add(lblbidaiari);
		
		SpinnerNumberModel modelKopurua = new SpinnerNumberModel(1, 1, 10, 1);
		JSpinner spinner = new JSpinner(modelKopurua);
		spinner.setBounds(luzea/3 + luzea/6 +luzea/12, altuera/18, 50, 50);
		spinner.setSize(new Dimension(luzea/20, altuera/36));
		contentPane.add(spinner);
		
		
		JPanel panD8 = new JPanel();
		panD8.setBounds(luzea/3 + luzea/6 +luzea/12, altuera/18, luzea/12, altuera/12);
		panD8.setOpaque(true);
		panD8.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD8);
			
		JPanel panD9 = new JPanel();
		panD9.setBounds(luzea/3 + luzea/6 +luzea/6, altuera/18, luzea/12, altuera/12);
		panD9.setOpaque(true);
		panD9.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD9);
		
		JPanel panD10 = new JPanel();
		panD10.setBounds(luzea/3 + luzea/3 +luzea/12, altuera/18, luzea/12, altuera/12);
		panD10.setOpaque(true);
		panD10.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panD10);
		
		JLabel lblIrteeraData = new JLabel("Irteera Data");
		lblIrteeraData.setBounds(luzea/2+(luzea/5), altuera-(altuera)+(altuera/100), luzea/15, altuera/11); 
		panD10.add(lblIrteeraData);
		
		
		
		JButton bBilatu = new JButton("Bilatu");
		bBilatu.setBounds(luzea/3 + luzea/3 +luzea/6+luzea/12, altuera/10, luzea/16, altuera/30);
		contentPane.add(bBilatu);
		
		JLabel tit2 = new JLabel("FILTRATU ZURE HEGALDIA:");
		tit2.setBounds(luzea/100, altuera/6, luzea/5, altuera/20);
		contentPane.add(tit2);
		
		JLabel lblPrezioaMin = new JLabel("Prezio Minimoa");
		lblPrezioaMin.setBounds(luzea/100, altuera/5, luzea/5, altuera/20);
		contentPane.add(lblPrezioaMin);
		
		JSlider sPrezioaMin = new JSlider(0, 1000, 200);
		sPrezioaMin.setBounds(luzea/100, altuera/4, luzea/5, altuera/20);
		sPrezioaMin.setMajorTickSpacing(100);
		sPrezioaMin.setPaintTicks(true);
		sPrezioaMin.setPaintLabels(true);
		sPrezioaMin.setBackground(Color.WHITE);
		contentPane.add(sPrezioaMin);
		

		JLabel lblprezioMax = new JLabel("Prezio Maximoa");
		lblprezioMax.setBounds(luzea/100, altuera/3, luzea/5, altuera/20);
		contentPane.add(lblprezioMax);
		
		JSlider sPrezioaMax = new JSlider(0, 1000, 200);
		sPrezioaMax.setBounds(luzea/100, altuera/3+altuera/20, luzea/5, altuera/20);
		sPrezioaMax.setMajorTickSpacing(100);
		sPrezioaMax.setPaintTicks(true);
		sPrezioaMax.setPaintLabels(true);
		sPrezioaMax.setBackground(Color.WHITE);
		contentPane.add(sPrezioaMax);
		
		JLabel lblDenboraMax = new JLabel("Iraupen Maximoa");
		lblDenboraMax.setBounds(luzea/100, altuera/3+altuera/8+altuera/120, luzea/5, altuera/20);
		contentPane.add(lblDenboraMax);
		
		JSlider sDenboraMax = new JSlider(0, 20, 5);
		sDenboraMax.setBounds(luzea/100, altuera/3+altuera/6+altuera/90, luzea/5, altuera/20);
		sDenboraMax.setMajorTickSpacing(2);
		sDenboraMax.setPaintTicks(true);
		sDenboraMax.setPaintLabels(true);
		sDenboraMax.setBackground(Color.WHITE);
		contentPane.add(sDenboraMax);
			
		JButton bBilatu2 = new JButton("Filtratu");
		bBilatu2.setBounds(luzea/13, altuera-(altuera/6), luzea/16, altuera/30);
		contentPane.add(bBilatu2);
		
		Icon logo = new ImageIcon(pathLogoa);
		JLabel logoa = new JLabel(logo);
		logoa.setBounds(luzea/100, altuera/2+altuera/16, 400, 288);
		contentPane.add(logoa);
		
		JPanel panE = new JPanel();
		panE.setBounds(luzea/100, altuera/6, luzea/5, altuera/2+altuera/5);
		panE.setOpaque(true);
		panE.setBackground(new java.awt.Color(255, 255, 255));
		panE.setLayout(null);
		contentPane.add(panE);
		
		JPanel panBeltza1 = new JPanel();
		panBeltza1.setBounds(luzea/70+luzea/5, altuera/6, luzea/300, altuera/2+altuera/5);
		panBeltza1.setOpaque(true);
		panBeltza1.setBackground(new java.awt.Color(0, 0, 0));
		contentPane.add(panBeltza1);
		
		JPanel panBeltza2 = new JPanel();
		panBeltza2.setBounds(luzea/60+luzea/5, altuera/6, luzea/300, altuera/2+altuera/5);
		panBeltza2.setOpaque(true);
		panBeltza2.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panBeltza2);
		
		JPanel panBeltza3 = new JPanel();
		panBeltza3.setBounds(luzea/2+luzea/5+luzea/260, altuera/6, luzea/300, altuera/2+altuera/5);
		panBeltza3.setOpaque(true);
		panBeltza3.setBackground(new java.awt.Color(0, 0, 0));
		contentPane.add(panBeltza3);
		
		JPanel panBeltza4 = new JPanel();
		panBeltza4.setBounds(luzea/2+luzea/5, altuera/6, luzea/300, altuera/2+altuera/5);
		panBeltza4.setOpaque(true);
		panBeltza4.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(panBeltza4);
		
		
		JPanel panelcentro = new JPanel ();
		panelcentro.setBounds(500,200,770,700);
		contentPane.add(panelcentro);
		panelcentro.setLayout(new BorderLayout(0,0));
		
		
		JPanel PscrollPane= new JPanel ();
		JScrollPane scrollpane= new JScrollPane (PscrollPane);
		panelcentro.add(scrollpane, BorderLayout.CENTER);
		
		scrollpane.setViewportView(PscrollPane);
		scrollpane.getViewport().setView(PscrollPane);
		GridBagLayout g_pscrollpane = new GridBagLayout();
		
//		g_pscrollpane.columnWidths= new int [] (0);
//		g_pscrollpane.rowHeights= new int [](0);
//		g_pscrollpane.columnWeights= new double[] (Double.MIN_VALUE);
//		g_pscrollpane.rowWeights = new double [] (Double.MIN_VALUE);
		
		PscrollPane.setLayout(g_pscrollpane);		
		
		//Panelak sartzeko probako kodea
		aerolinea lineaProba = new aerolinea("IBER", "Iberia");
		aireportua portuaProba = new aireportua("HTRW", "Heathrow");
		Date dataProba = new Date();
		hegaldia hProba = new hegaldia("ABC", portuaProba, portuaProba, 3, 45, dataProba, 56, lineaProba);
		
		pHegaldia panelProba = new pHegaldia(hProba);
		pHegaldia panelProba2 = new pHegaldia(hProba);
		pHegaldia panelProba3 = new pHegaldia(hProba);
		pHegaldia panelProba4 = new pHegaldia(hProba);
		pHegaldia panelProba5 = new pHegaldia(hProba);
		pHegaldia panelProba6 = new pHegaldia(hProba);
		GridBagConstraints cons = new GridBagConstraints ();
		int y=50;
		cons.ipadx=700;
		cons.ipady=200;
		cons.gridx=0;
		cons.gridy=y;
		y=y+240;
		
		PscrollPane.add(panelProba,cons);
		cons.gridy=y;
		y=y+240;
		PscrollPane.add(panelProba2,cons);
		cons.gridy=y;
		y=y+240;
		PscrollPane.add(panelProba3,cons);
		cons.gridy=y;
		y=y+240;
		PscrollPane.add(panelProba4,cons);
		cons.gridy=y;
		y=y+240;
		PscrollPane.add(panelProba5,cons);
		cons.gridy=y;
		y=y+240;
		PscrollPane.add(panelProba6,cons);
		//Panelak sartzeko probako kodearen amaiera
		
		PscrollPane.repaint();
		scrollpane.repaint();
		
		JPanel pGoikoPanel = new JPanel();
		pGoikoPanel.setBounds(0, 0, luzea/10, altuera/8);
		pGoikoPanel.setOpaque(true);
		pGoikoPanel.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(pGoikoPanel);

		JPanel prelleno1 = new JPanel();
		prelleno1.setBounds(luzea/10, 0, luzea, altuera/18+altuera/12);
		prelleno1.setOpaque(true);
		prelleno1.setBackground(new java.awt.Color(131, 214, 247));
		contentPane.add(prelleno1);
		
		JLabel titulua = new JLabel("EASY BOOKING");
		titulua.setBounds(0,0,luzea/8, altuera/16); 
		titulua.setFont(new Font("Tahona", Font.BOLD, 22));
		pGoikoPanel.add(titulua);
				
	}

	
}
