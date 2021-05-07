package buffet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login {
	Statement st;
	Connection con = null;
	ResultSet rsRead;
	String action;
	String sql;
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(98, 69, 83, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(98, 101, 83, 16);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUsername.getText();
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();;
					try{
						 Class.forName("com.mysql.jdbc.Driver");
						 con = DriverManager.getConnection("jdbc:mysql://localhost/buffetproject", "user1", "itsut");
						 st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						 rsRead = st.executeQuery("select * from employee where username='"+username+"'and password='"+password+"'");
						 if(rsRead.next()){
							 EmpHome empscreen = new EmpHome();
							 empscreen.empHome();
						 }
					}catch(SQLException e){
						 System.out.println(e);
					}catch(Exception ex) {
						 System.out.println(ex);
					}
			}
		});
		btnLogin.setBounds(203, 190, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(193, 66, 192, 22);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(193, 95, 192, 22);
		frame.getContentPane().add(txtPassword);
	
	}
}
