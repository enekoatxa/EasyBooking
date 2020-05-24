package EasyBookingKlientea.PL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EasyBookingKlientea.NL.Controller;

public class lpasahitzAldaketa extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	
	/**
	 * Create the frame.
	 */
	public lpasahitzAldaketa(Controller cont) {
		controller=cont;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(650, 270, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHegaldiarenId = new JLabel("Pasahitza zuzen aldatu da!");
		lblHegaldiarenId.setBounds(15, 35, 300, 20);
		contentPane.add(lblHegaldiarenId);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(233, 35, 109, 20);
		contentPane.add(lblNewLabel);
		
		JButton bborratuE = new JButton("Ados");
		bborratuE.setBounds(65, 200, 140, 25);
		contentPane.add(bborratuE);
		
		bborratuE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//ez dakit zer egiten duen
			dispose();
			}

		});
		
		
}}