package EasyBookingKlientea.PL;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class lErregistratu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblHelb;
	private JLabel lblAut;
	private JLabel lblOrdainketa;
	private JLabel lblAireportua;
	private JComboBox<Object> aireportua;
	private JButton btnIzEman;
	private JLabel lblSartu;
	private ButtonGroup aut;
	private ButtonGroup ord;


	private JRadioButton rdbtnFb;
	private JRadioButton rdbtnGoogle;
	private JRadioButton rdbtnPp;
	private JRadioButton rdbtnVisa;
	Dimension pantailaTamaina = Toolkit.getDefaultToolkit().getScreenSize();
	
	JFrame b= this;

	public lErregistratu() {
		setTitle("Izena eman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(pantailaTamaina.width/2, pantailaTamaina.height/2);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int altuera=pantailaTamaina.height/54;
		
		lblHelb = new JLabel("Helbide elektronikoa");
		int a=pantailaTamaina.width/16;
		lblHelb.setBounds((pantailaTamaina.width/4)-(a/2), altuera, a, altuera);
		contentPane.add(lblHelb);
		
		textField = new JTextField();
		a=pantailaTamaina.width/6;
		textField.setBounds((pantailaTamaina.width/4)-(a/2), (int) (altuera*2.5), a, altuera);
		contentPane.add(textField);
		
		lblAut = new JLabel("Autentikazio zerbitzua");
		a=pantailaTamaina.width/14;
		lblAut.setBounds((pantailaTamaina.width/4)-(a/2), (int) (altuera*4.5), a, altuera);
		contentPane.add(lblAut);
		
		rdbtnFb = new JRadioButton("Facebook");
		rdbtnFb.setBounds((pantailaTamaina.width/4)-a, (int) (altuera*5.5), a, altuera*2);
		Image img = new ImageIcon (this.getClass().getResource("/fb.png")).getImage();
		rdbtnFb.setIcon(new ImageIcon(img));
		rdbtnFb.setBorderPainted(true);
		contentPane.add(rdbtnFb);
		
		rdbtnGoogle = new JRadioButton("Google");
		rdbtnGoogle.setBounds((pantailaTamaina.width/4), (int) (altuera*5.5), a, altuera*2);
		Image imag = new ImageIcon (this.getClass().getResource("/google.png")).getImage();
		rdbtnGoogle.setIcon(new ImageIcon(imag));
		rdbtnGoogle.setBorderPainted(true);
		contentPane.add(rdbtnGoogle);		
		
		lblOrdainketa = new JLabel("Ordainketa metodoa");
		a=pantailaTamaina.width/14;
		lblOrdainketa.setBounds((pantailaTamaina.width/4)-(a/2), altuera*8, a, altuera);
		contentPane.add(lblOrdainketa);
		
		rdbtnPp = new JRadioButton("Paypal");
		rdbtnPp.setBounds((pantailaTamaina.width/4)-a, (int) (altuera*9), a, altuera*2);
		Image img1 = new ImageIcon (this.getClass().getResource("/pp.png")).getImage();
		rdbtnPp.setIcon(new ImageIcon(img1));
		rdbtnPp.setBorderPainted(true);
		contentPane.add(rdbtnPp);
		
		rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setBounds((pantailaTamaina.width/4),(int) (altuera*9), a, altuera*2);
		Image imag1 = new ImageIcon (this.getClass().getResource("/visa.png")).getImage();
		rdbtnVisa.setIcon(new ImageIcon(imag1));
		rdbtnVisa.setBorderPainted(true);
		contentPane.add(rdbtnVisa);	
		
		lblAireportua = new JLabel("Gustoko aireportua");
		a=pantailaTamaina.width/16;
		lblAireportua.setBounds((pantailaTamaina.width/4)-(a/2), (int) (altuera*11.5), a, altuera);
		contentPane.add(lblAireportua);
		
		aireportua = new JComboBox<Object>();
		a=pantailaTamaina.width/6;
		aireportua.setBounds((pantailaTamaina.width/4)-(a/2), altuera*13, a, altuera);
		contentPane.add(aireportua);

		
		btnIzEman = new JButton("Izena eman");
		a=pantailaTamaina.width/14;
		btnIzEman.setBounds((pantailaTamaina.width/4)-(a/2), altuera*17, a, altuera);
		contentPane.add(btnIzEman);
		
		lblSartu = new JLabel("Sartu");
		a=pantailaTamaina.width/28;
		lblSartu.setBounds((pantailaTamaina.width/4)-(a/4), (int) (altuera*18.5), a, altuera);
		contentPane.add(lblSartu);
		
		aut = new ButtonGroup();
		aut.add(rdbtnFb);
		aut.add(rdbtnGoogle);
		
		ord = new ButtonGroup();
		ord.add(rdbtnPp);
		ord.add(rdbtnVisa);

		
		btnIzEman.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
          	  if((rdbtnFb.isSelected()==false)&&(rdbtnGoogle.isSelected()==false))
          	  {
  				JOptionPane.showMessageDialog(b , "Autentikazio zerbitzu bat aukeratu behar duzu!","Kontuz",1);

          	  }
          	if((rdbtnPp.isSelected()==false)&&(rdbtnVisa.isSelected()==false))
        	  {
				JOptionPane.showMessageDialog(b , "Ordainketa metodo bat aukeratu behar duzu!", "Kontuz", 1);

        	  }
            }

        });
		  
	}
}

