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

import javax.swing.JButton;

public class LERREG extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Dimension pantailaTamaina = Toolkit.getDefaultToolkit().getScreenSize();
	

	public LERREG() {
		setTitle("Izena eman");
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
		
		JLabel lblHelb = new JLabel("Helbide elektronikoa");
		a=pantailaTamaina.width/16;
		lblHelb.setBounds((pantailaTamaina.width/4)-(a/2), 90, a, 20);
		contentPane.add(lblHelb);
		
		textField_1 = new JTextField();
		a=pantailaTamaina.width/6;
		textField_1.setBounds((pantailaTamaina.width/4)-(a/2), 120, a, 20);
		contentPane.add(textField_1);
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		a=pantailaTamaina.width/28;
		lblPasahitza.setBounds((pantailaTamaina.width/4)-(a/2), 160, a, 20);
		contentPane.add(lblPasahitza);
		
		textField_1 = new JTextField();
		a=pantailaTamaina.width/6;
		textField_1.setBounds((pantailaTamaina.width/4)-(a/2), 190, a, 20);
		contentPane.add(textField_1);
		
		JLabel lblPasahitza1 = new JLabel("Pasahitza errepikatu");
		a=pantailaTamaina.width/16;
		lblPasahitza1.setBounds((pantailaTamaina.width/4)-(a/2), 230, a, 20);
		contentPane.add(lblPasahitza1);
		
		textField_1 = new JTextField();
		a=pantailaTamaina.width/6;
		textField_1.setBounds((pantailaTamaina.width/4)-(a/2), 260, a, 20);
		contentPane.add(textField_1);
		
		JButton btnIzEman = new JButton("Izena eman");
		a=pantailaTamaina.width/14;
		btnIzEman.setBounds((pantailaTamaina.width/4)-(a/2), 340, a, 20);
		contentPane.add(btnIzEman);
		
		JLabel lblSartu = new JLabel("Sartu");
		a=pantailaTamaina.width/28;
		lblSartu.setBounds((pantailaTamaina.width/4)-(a/2), 370, a, 20);
		contentPane.add(lblSartu);
		
		lblSartu.addMouseListener(new MouseAdapter() {
	            
             public void mouseClicked(MouseEvent e) {
           	  LHASI leihoa = new LHASI();
           	  leihoa.setVisible(true);
             }

         });
		  
	}
}
