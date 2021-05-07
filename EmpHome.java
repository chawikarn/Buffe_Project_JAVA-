package buffet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JLabel;

public class EmpHome {

	private JFrame frmEmpHome;

	public static void empHome() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpHome window = new EmpHome();
					window.frmEmpHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public EmpHome() {
		initialize();
	}

	private void initialize() {
		frmEmpHome = new JFrame();
		frmEmpHome.setTitle("Home");
		frmEmpHome.setBounds(100, 100, 831, 510);
		frmEmpHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmpHome.getContentPane().setLayout(null);
		
		JButton btnManageMenu = new JButton("Manage Menu Set");
		btnManageMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnManageMenu.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Buffet empscreen = new Buffet();
				empscreen.manageBuffet();
			}
		});
		btnManageMenu.setBounds(310, 285, 215, 58);
		frmEmpHome.getContentPane().add(btnManageMenu);
		
		JButton btnRedgister = new JButton("Register Member");
		btnRedgister.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRedgister.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				Customer cusScreen = new Customer();
				cusScreen.Customer();
			}
		});
		btnRedgister.setBounds(328, 153, 176, 53);
		frmEmpHome.getContentPane().add(btnRedgister);
		
		JButton btnOrder = new JButton("Place Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order orderScreen = new Order();
				orderScreen.order();
			}
		});
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOrder.setBounds(328, 219, 176, 53);
		frmEmpHome.getContentPane().add(btnOrder);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin!");
		lblWelcomeAdmin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWelcomeAdmin.setBounds(330, 55, 195, 36);
		frmEmpHome.getContentPane().add(lblWelcomeAdmin);
		
		JLabel lblSelectMenuThat = new JLabel("Select Menu that you would like to do.");
		lblSelectMenuThat.setBounds(299, 115, 226, 16);
		frmEmpHome.getContentPane().add(lblSelectMenuThat);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(675, 404, 97, 25);
		frmEmpHome.getContentPane().add(btnExit);
	}
}
