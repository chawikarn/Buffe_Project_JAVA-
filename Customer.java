package buffet;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer {

	private JFrame frame;
	private JTextField txtAge;
	private JTextField txtDob;
	private JTextField txtName;
	private JTextField txtId;
	private JButton btnRegister;
	private JButton btnCancle;
	private JButton btnClose;
	private JComboBox comboBox;
	
	Statement st;
	Connection con = null;
	ResultSet rsRead;
	String action;
	String sql;

	public static void Customer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Customer() {
		initialize();
	}

	private void initialize() {
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/buffetproject", "user1", "itsut");
			 st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 rsRead = st.executeQuery("select * from customer");
			 rsRead.first();
		}catch(SQLException e){
			 System.out.println(e);
		}catch(Exception ex) {
			 System.out.println(ex);
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMember = new JLabel("Member");
		lblMember.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMember.setBounds(360, 58, 88, 16);
		frame.getContentPane().add(lblMember);
		
		JLabel lblNewLabel = new JLabel("Cus_ID");
		lblNewLabel.setBounds(79, 104, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(79, 149, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(79, 203, 88, 16);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setBounds(79, 250, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPrivileges = new JLabel("Privileges");
		lblPrivileges.setBounds(79, 299, 56, 16);
		frame.getContentPane().add(lblPrivileges);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose Level...", "General", "Silver", "Gold"}));
		comboBox.setBounds(207, 296, 146, 22);
		frame.getContentPane().add(comboBox);
		
		txtAge = new JTextField();
		txtAge.setBounds(207, 247, 116, 22);
		frame.getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		txtDob = new JTextField();
		txtDob.setBounds(207, 200, 116, 22);
		frame.getContentPane().add(txtDob);
		txtDob.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(207, 146, 116, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(207, 101, 116, 22);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				int age = Integer.parseInt(txtAge.getText());
				String value = comboBox.getSelectedItem().toString();
				sql = "insert into customer(cus_id,name,dob,age,level) values('" + id + "','" + txtName.getText()+ "','" + txtDob.getText() + "','" + age + "','"+ value +"')";
				try {
					st.execute(sql);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(226, 375, 97, 25);
		frame.getContentPane().add(btnRegister);
		
		JButton btnCancle_1 = new JButton("cancle");
		btnCancle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtName.setText("");
				txtDob.setText("");
				txtAge.setText("");
				comboBox.setSelectedItem("Choose Level...");
			}
		});
		btnCancle_1.setBounds(360, 375, 97, 25);
		frame.getContentPane().add(btnCancle_1);
		
		JButton btnClose_1 = new JButton("close");
		btnClose_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnClose_1.setBounds(485, 375, 97, 25);
		frame.getContentPane().add(btnClose_1);
		
		
	}
	
	
}
