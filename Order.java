package buffet;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;

public class Order {

	private JFrame frmOrder;
	private JTextField Person;
	private JTextField Costmeal;
	private JTextField Costdrink;
	private JTextField Total;
	private JTextField subTotal;
	private JTextField Tax;
	private JTextField txTotal;
	private JTextField qty;
	private JTextField txtBaht;
	private JTextField textField_13;
	String p="";
	Statement st;
	Connection con = null;
	ResultSet rsRead;
	String action;
	String sql;
	private JTextField cusName;
	private JTextField cusPro;
	private JButton btnPromotion_1;
	double c,cvt,amount,exchange=0;
    String sd,cus,um,convert ,Sc,ehg,Sconvert; 
    double drink = 0 ; 
    int index;
    private JTextField Rmoney;
    private JTextField Cmoney;
    private JTextField discount;
	
	
	public static void order() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order();
					window.frmOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Order() {
		initialize();
	}

	@SuppressWarnings("unchecked")
	private void initialize() {
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/buffetproject", "user1", "itsut");
			 st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch(SQLException e){
			 System.out.println(e);
		}catch(Exception ex) {
			 System.out.println(ex);
		}
		frmOrder = new JFrame();
		frmOrder.setTitle("Order");
		frmOrder.setBounds(0, 0, 1373,840);
		frmOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOrder.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.PINK, 4));
		panel_1.setBounds(614, 131, 372, 364);
		frmOrder.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCurrencyConverter = new JLabel("Currency Converter");
		lblCurrencyConverter.setBounds(102, 33, 171, 25);
		lblCurrencyConverter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblCurrencyConverter);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Choose one...", "USA", "Pond", "Yen", "Yuan", "Brazil", "Indonesia", "Philipine"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(35, 71, 290, 36);
		panel_1.add(comboBox_1);
		
		txtBaht = new JTextField();
		txtBaht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBaht.setBounds(118, 138, 207, 46);
		panel_1.add(txtBaht);
		txtBaht.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_13.setColumns(10);
		textField_13.setBounds(118, 213, 207, 46);
		panel_1.add(textField_13);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sconvert = txtBaht.getText();
				exchange = Double.parseDouble(Sconvert);
				convert = (String) comboBox_1.getSelectedItem();
				double[] myList = {0.0321,0.0272,0.0246,3.38,0.217,36.86,0.0436,743.98,472.65,1.56,0};
					switch(convert){
					case "USD-US Dollar":
						index = 0;
						cvt = myList[0];
						amount = cvt * exchange;
						break;
					case "EUR-Euro":
						index = 1;
						cvt = myList[1];
						amount = cvt * exchange;
						break;
					case "GBP-British Pound Sterling":
						index = 2;
						cvt = myList[2];
						amount = cvt * exchange;
						break;
					case "JPY-Japanese":
						index = 3;
						cvt = myList[3];
						amount = cvt * exchange;
						break;
					case "CNY-Chinese Yuan":
						index = 4;
						cvt = myList[4];
						amount = cvt * exchange;
						break;
					case "KRW-South Korean Won":
						index = 5;
						cvt = myList[5];
						amount = cvt * exchange;
						break;
					case "SGD-Singapore":
						index = 6;
						cvt = myList[6];
						amount = cvt * exchange;
						break;
					case "VND-Vietnamese Dong":
						index = 7;
						cvt = myList[7];
						amount = cvt * exchange;
						break;
					case "IDR-Indonesian Rupiah":
						index = 8;
						cvt = myList[8];
						amount = cvt * exchange;
						break;
					case "PHP-Philippine Peso":
						index = 9;
						cvt = myList[9];
						amount = cvt * exchange;
						break;
					default:
						index = 10;
						cvt = myList[10];
						amount = cvt + exchange;
				}	
					String Sc = String.format("%.2f",amount);
					textField_13.setText(Sc);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(132, 291, 108, 36);
		panel_1.add(btnNewButton);
		
		JLabel lblBaht = new JLabel("Baht");
		lblBaht.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBaht.setBounds(50, 154, 56, 16);
		panel_1.add(lblBaht);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTo.setBounds(50, 229, 56, 16);
		panel_1.add(lblTo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.PINK, 4));
		panel_2.setBounds(997, 131, 331, 585);
		frmOrder.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(26, 42, 279, 503);
		panel_2.add(tabbedPane);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Receipt", null, panel_5, null);
		panel_5.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 13, 250, 447);
		panel_5.add(textArea);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Calculator", null, panel_6, null);
		panel_6.setLayout(null);
		
		txTotal = new JTextField();
		txTotal.setBounds(12, 45, 155, 41);
		panel_6.add(txTotal);
		txTotal.setColumns(10);
		
		JLabel lblTotal_1 = new JLabel("TOTAL");
		lblTotal_1.setBounds(12, 13, 56, 16);
		panel_6.add(lblTotal_1);
		
		JLabel lblReceiveMoney = new JLabel("Receive Money");
		lblReceiveMoney.setBounds(12, 113, 85, 16);
		panel_6.add(lblReceiveMoney);
		
		Rmoney = new JTextField();
		Rmoney.setColumns(10);
		Rmoney.setBounds(12, 142, 235, 41);
		panel_6.add(Rmoney);
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setBounds(12, 236, 56, 16);
		panel_6.add(lblChange);
		
		Cmoney = new JTextField();
		Cmoney.setEditable(false);
		Cmoney.setColumns(10);
		Cmoney.setBounds(92, 267, 155, 41);
		panel_6.add(Cmoney);
		
		JButton btnCount = new JButton("Count");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cus_class = cusPro.getText();	
				double income = Double.parseDouble(Total.getText()) ;
				String totalS = String.format("%.2f",income);
				txTotal.setText(totalS) ; 
				double money =  Double.parseDouble(Rmoney.getText());
				double change = money-income ; 
				String to = String.format("%.2f",change);
				Cmoney.setText(to);
				
				
				 Calculator cal = new Calculator() ;
				 cal.calBonus(cus_class,income);
				 String too = String.format("%.2f",cal.getBonus());
				 discount.setText(too);
				
			}
		});
		btnCount.setBounds(92, 339, 85, 25);
		panel_6.add(btnCount);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBounds(12, 387, 56, 16);
		panel_6.add(lblDiscount);
		
		discount = new JTextField();
		discount.setEditable(false);
		discount.setColumns(10);
		discount.setBounds(92, 402, 155, 41);
		panel_6.add(discount);
		
		JButton btnGetprice = new JButton("Get Total");
		btnGetprice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total = Double.parseDouble(Total.getText()) ;
				String total1 = String.format("%.2f",total);
				txTotal.setText(total1);
			}
		});
		btnGetprice.setBounds(177, 53, 85, 25);
		panel_6.add(btnGetprice);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.PINK, 4));
		panel_3.setBounds(603, 519, 372, 197);
		frmOrder.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		Total = new JTextField();
		Total.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Total.setColumns(10);
		Total.setBounds(143, 136, 184, 39);
		panel_3.add(Total);
		
		subTotal = new JTextField();
		subTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subTotal.setColumns(10);
		subTotal.setBounds(143, 84, 184, 39);
		panel_3.add(subTotal);
		
		Tax = new JTextField();
		Tax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Tax.setColumns(10);
		Tax.setBounds(143, 32, 184, 39);
		panel_3.add(Tax);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotal.setBounds(12, 128, 119, 56);
		panel_3.add(lblTotal);
		
		JLabel lblSubTotal = new JLabel("Sub total ");
		lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSubTotal.setBounds(12, 70, 94, 56);
		panel_3.add(lblSubTotal);
		
		JLabel lblTax = new JLabel("VAT 7%");
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTax.setBounds(12, 13, 94, 56);
		panel_3.add(lblTax);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.PINK, 4));
		panel_4.setBounds(36, 519, 528, 197);
		frmOrder.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblCostOfMeal = new JLabel("Cost of Meal");
		lblCostOfMeal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCostOfMeal.setBounds(22, 102, 215, 56);
		panel_4.add(lblCostOfMeal);
		
		JLabel lblCostOfDrink = new JLabel("Cost of Drink");
		lblCostOfDrink.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCostOfDrink.setBounds(22, 33, 172, 56);
		panel_4.add(lblCostOfDrink);
		
		Costmeal = new JTextField();
		Costmeal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Costmeal.setColumns(10);
		Costmeal.setBounds(229, 110, 259, 39);
		panel_4.add(Costmeal);
		
		Costdrink = new JTextField();
		Costdrink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Costdrink.setColumns(10);
		Costdrink.setBounds(229, 41, 259, 39);
		panel_4.add(Costdrink);
		
		JLabel lblBuffeSeafood = new JLabel("ORDER BUFFET :)");
		lblBuffeSeafood.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblBuffeSeafood.setBounds(52, 42, 372, 43);
		frmOrder.getContentPane().add(lblBuffeSeafood);
		
		JList list = new JList();
		list.setBounds(460, 98, 1, 1);
		frmOrder.getContentPane().add(list);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.PINK, 4));
		panel.setBounds(36, 131, 526, 364);
		frmOrder.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setBounds(263, 9, 0, 0);
		panel.add(label);
		
		JLabel lblPersons = new JLabel("Persons");
		lblPersons.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPersons.setBounds(23, 31, 172, 56);
		panel.add(lblPersons);
		
		JLabel lblSet = new JLabel("Set");
		lblSet.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSet.setBounds(23, 107, 151, 56);
		panel.add(lblSet);
		
		Person = new JTextField();
		Person.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Person.setColumns(10);
		Person.setBounds(234, 40, 259, 39);
		panel.add(Person);
		
		JLabel lblDrink = new JLabel("Drink");
		lblDrink.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDrink.setBounds(12, 193, 215, 56);
		panel.add(lblDrink);
		
		JComboBox Setdrink = new JComboBox();
		Setdrink.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Setdrink.setModel(new DefaultComboBoxModel(new String[] {"Choose Drinks...", "Apple juice", "Orange juice", "Tea", "Cola", "Ice Tea"}));
		Setdrink.setBounds(23, 262, 185, 30);
		panel.add(Setdrink);
		
		JLabel lblQty = new JLabel("QTY");
		lblQty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQty.setBounds(239, 195, 172, 56);
		panel.add(lblQty);
		
		qty = new JTextField();
		qty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		qty.setColumns(10);
		qty.setBounds(234, 257, 172, 39);
		panel.add(qty);
		
	
		JComboBox Set = new JComboBox();
		Set.setModel(new DefaultComboBoxModel(new String[] {"Choose Set...", "399", "499", "699"}));
		Set.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Set.setBounds(232, 114, 264, 45);
		panel.add(Set);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(18, 191, 475, 10);
		panel.add(horizontalStrut);
		
		JButton btnNewButton_1 = new JButton("Total ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double set = 0 ,drink = 0,sum=0,tax=0;
				double person = Double.parseDouble(Person.getText());
			    double Mealcost,Drinkcost;
				String summary,taxSum,total;
			    String Pset,Pdrink ;
			    
				if(Set.getSelectedItem().equals ("399"))
				{
				   set = 399 ;
				}
				if(Set.getSelectedItem().equals ("499"))
				{
				   set = 499 ;
				}
				if(Set.getSelectedItem().equals ("699"))
				{
				   set = 699 ;
				}
					
				if(Setdrink.getSelectedItem().equals ("Apple juice"))
				{
					drink = 59 ;
				}
				if(Setdrink.getSelectedItem().equals ("Orange juice"))
				{
					drink = 39 ;
				}
				if(Setdrink.getSelectedItem().equals ("Tea"))
				{
					drink = 49 ;
				}
					
				if(Setdrink.getSelectedItem().equals ("Cola"))
				{
				    drink = 39 ;
				}
				if(Setdrink.getSelectedItem().equals ("Ice Tea"))
				{
					drink = 59 ;
				}
			  String p = cusPro.getText();
			  Mealcost = person * set ;
			  Drinkcost = person * drink ;
			  PromotionFactory promotion = new PromotionFactory();
			  Promotion pro = promotion.createPromotion(p);
			  pro.calSetResult(Mealcost);
			  pro.calDrinkResult(Drinkcost);
			  Pset = String.format("%.2f", pro.getSetResult());
			  Costmeal.setText(Pset); 
			  Pdrink = String.format("%.2f", pro.getDrinkResult());
			  Costdrink.setText(Pdrink) ;
			  summary = String.format("%.2f", pro.getSetResult()+pro.getDrinkResult());
			  subTotal.setText(summary) ; 
			  sum = pro.getSetResult()+pro.getDrinkResult();
			  taxSum = String.format("%.2f", promotion.calTax(sum));
			  Tax.setText(taxSum) ; 
			  total = String.format("%.2f", (promotion.calTax(sum) + pro.getSetResult()+pro.getDrinkResult()));
			  Total.setText(total) ; 
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(782, 729, 113, 43);
		frmOrder.getContentPane().add(btnNewButton_1);
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double person = Double.parseDouble(Person.getText());
				double QTY = Double.parseDouble(qty.getText());				
				String psd = (String) Setdrink.getSelectedItem();	
				String sm = (String) Set.getSelectedItem();
				String valuemeal = Costmeal.getText();
				String valuedrink = Costdrink.getText();
				
				Rescrip res = new Rescrip(person,sm,valuemeal,psd,QTY,valuedrink,textArea);
				res.start();
			}
		});
		btnReceipt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReceipt.setBounds(920, 729, 113, 43);
		frmOrder.getContentPane().add(btnReceipt);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cusName.setText("");
				cusPro.setText("");
				Person.setText("");
				Set.setSelectedItem("Choose Set...");
				Setdrink.setSelectedItem("Choose Drinks...");
				qty.setText("");
				cusName.setText("");
				Costmeal.setText("");
				Costdrink.setText("");
				Tax.setText("");
				subTotal.setText("");
				Total.setText("");
				txtBaht.setText("");
				textField_13.setText("");
				comboBox_1.setSelectedItem("Choose one...");
				textArea.setText("");
				txTotal.setText("");
				Rmoney.setText("");
				Cmoney.setText("");
				discount.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(1045, 729, 113, 43);
		frmOrder.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmOrder.setVisible(false);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(1170, 729, 113, 43);
		frmOrder.getContentPane().add(btnExit);
		
		cusName = new JTextField();
		cusName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cusName.setBounds(708, 42, 296, 41);
		frmOrder.getContentPane().add(cusName);
		cusName.setColumns(10);
		
		JButton btnPromotion = new JButton("Promotion");
			btnPromotion_1 = new JButton();
			btnPromotion_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnPromotion_1.setBounds(new Rectangle(193, 45, 66, 25));
			btnPromotion_1.setText("Promotion");
		btnPromotion_1.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
						sql = "select level from customer where name='"+ cusName.getText() +"'";
						rsRead = st.executeQuery(sql);
						rsRead.first();
						cusPro.setText(rsRead.getString("level"));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
		});

		btnPromotion_1.setBounds(1016, 50, 134, 25);
		frmOrder.getContentPane().add(btnPromotion_1);
		
		cusPro = new JTextField();
		cusPro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cusPro.setBounds(1162, 42, 166, 43);
		frmOrder.getContentPane().add(cusPro);
		cusPro.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerName.setBounds(579, 54, 125, 16);
		frmOrder.getContentPane().add(lblCustomerName);	
	}
	class Rescrip extends Thread{
		
		double set  ;
	    public double mcost ;
	    public String Pset ;
		public double person=0 ; 
		JTextField CostMeal ; 
		public String Setmeal ;
		public double total1 = Double.parseDouble(Costmeal.getText());
		public double total2 = Double.parseDouble(Costdrink.getText());
		public double vat = Double.parseDouble(Tax.getText());
		public double qty=0 ; 
		JTextArea Rs ; 
		public String Setdrink;
		public String output = " ";
		public Rescrip(double person,String Setmeal,String valuemeal,String Setdrink ,double qty,String valuedrink,JTextArea rs ){
			this.person = person;
			this.Setmeal = Setmeal;
			this.Setdrink = Setdrink;
			this.qty =qty ;
			this.Setdrink = Setdrink ;
			this.Rs = rs;
		}                          
		
		public void run(){

			
			output = "Bill"+ "\n "+" Person   " +String.format("%.0f\t",person ) +" Person "+ "\n "+" Set   "+ Setmeal +"   Bath"+ "\n "+ "\n "+"Sub Total   "+String.format("%.2f   ", total1)+"Bath"+"\n " +"\n " +"Drink"+ "\n " + Setdrink + "     ";
			Rs.setText(output);
			output = output +String.format("%.0f\t", qty);
			Rs.setText(output);
			output = output+ "\n "+ "\n "   +"Sub Total\t"+String.format("%.2f\t", total2)+" Bath";
			Rs.setText(output);
			output = output+ "\n"+" \n" + "\n " + "Total\t"+String.format("%.2f\t", total1+total2)+" Bath";
			Rs.setText(output);
			output = output+ "\n"+ "VAT\t"+String.format("%.2f\t", vat)+" Bath";
			Rs.setText(output);
			output = output+ "\n"+ "Total Price\t"+String.format("%.2f\t", vat+total1+total2)+" Bath";
			Rs.setText(output);
		  
		}

		
	     }
}

