package PL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;

public class LHASI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Dimension pantailaTamaina = Toolkit.getDefaultToolkit().getScreenSize();
	

	public LHASI() {
		setTitle("Sartu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(pantailaTamaina.width/2, pantailaTamaina.height/2);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea");
		int a=pantailaTamaina.width/26;
		lblErabiltzailea.setBounds((pantailaTamaina.width/4)-(a/2), 20, a, 20);
		contentPane.add(lblErabiltzailea);
		
		textField = new JTextField();
		a=pantailaTamaina.width/6;
		textField.setBounds((pantailaTamaina.width/4)-(a/2), 50, a, 20);
		contentPane.add(textField);
		
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		a=pantailaTamaina.width/28;
		lblPasahitza.setBounds((pantailaTamaina.width/4)-(a/2), 120, a, 20);
		contentPane.add(lblPasahitza);
		
		textField_1 = new JTextField();
		a=pantailaTamaina.width/6;
		textField_1.setBounds((pantailaTamaina.width/4)-(a/2), 150, a, 20);
		contentPane.add(textField_1);
		
		JButton btnSartu = new JButton("Sartu");
		a=pantailaTamaina.width/14;
		btnSartu.setBounds((pantailaTamaina.width/4)-(a/2), 270, a, 20);
		contentPane.add(btnSartu);
		
		btnSartu.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
          	  lOrokorra leihoa = new lOrokorra();
          	  leihoa.setVisible(true);
            }

        });
		
		JLabel lblIzenaEman = new JLabel("Izena eman");
		a=pantailaTamaina.width/28;
		lblIzenaEman.setBounds((pantailaTamaina.width/4)-(a/2), 300, a, 20);
		contentPane.add(lblIzenaEman);
		
		 lblIzenaEman.addMouseListener(new MouseAdapter() {
	            
             public void mouseClicked(MouseEvent e) {
           	  LERREG leihoa = new LERREG();
           	  leihoa.setVisible(true);
             }

         });
		  
	}
}
