package buffet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import buffet.Customer;

public class Home {

	private JFrame frmHome;

	/**
	 * Launch the application.
	 */
	public static void cusHome() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setTitle("Home");
		frmHome.setBounds(100, 100, 683, 400);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E2A\u0E21\u0E32\u0E0A\u0E34\u0E01");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				 Customer gui = new Customer();
				 
			}
		});
		button.setBounds(272, 134, 118, 25);
		frmHome.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\u0E2A\u0E31\u0E48\u0E07\u0E0A\u0E38\u0E14\u0E2D\u0E32\u0E2B\u0E32\u0E23");
		btnNewButton.setBounds(272, 242, 118, 25);
		frmHome.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0E14\u0E39\u0E0A\u0E38\u0E14\u0E2D\u0E32\u0E2B\u0E32\u0E23");
		btnNewButton_1.setBounds(272, 191, 118, 25);
		frmHome.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("\u0E22\u0E34\u0E19\u0E14\u0E35\u0E15\u0E49\u0E2D\u0E19\u0E23\u0E31\u0E1A\u0E25\u0E39\u0E01\u0E04\u0E49\u0E32\u0E17\u0E38\u0E01\u0E17\u0E48\u0E32\u0E19");
		label.setFont(new Font("TH Mali Grade 6", Font.BOLD, 26));
		label.setBounds(246, 66, 176, 35);
		frmHome.getContentPane().add(label);
	}

}
