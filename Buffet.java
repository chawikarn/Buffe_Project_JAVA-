package buffet;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Buffet {

	private JFrame frmFoodset;
	private JTextField txtId;
	private JTextField txtSet;
	private JTextPane txtDes;
	private JTextField txtPrice;
	private JTextField txtSearch;
	private JButton btnEdit;
	private JButton btnSave;
	private JButton btnCancle;
	private JButton btnDelete;
	private JButton btnGo;
	private JButton btnPrevious;
	private JButton btnFirst;
	private JButton btnLast;
	private JButton btnNext;
	Statement st;
	Connection con = null;
	ResultSet rsRead;
	String action;
	String sql;
	int confirm;
	String set_name,description,set_id,price;
	private JButton btnClose;
	

	public static void manageBuffet() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buffet window = new Buffet();
					window.frmFoodset.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Buffet() {
		initialize();
	}

	private void initialize() {
		
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/buffetproject", "user1", "itsut");
			 st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 rsRead = st.executeQuery("select * from menu");
			 rsRead.first();
		}catch(SQLException e){
			 System.out.println(e);
		}catch(Exception ex) {
			 System.out.println(ex);
		}
		
		frmFoodset = new JFrame();
		frmFoodset.setTitle("Management Set of Food");
		frmFoodset.setBounds(100, 100, 960, 562);
		frmFoodset.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoodset.getContentPane().setLayout(null);
		
		JLabel lblSetid = new JLabel("set_id");
		lblSetid.setBounds(26, 163, 56, 16);
		frmFoodset.getContentPane().add(lblSetid);
		
		JLabel lblSetname = new JLabel("set_name");
		lblSetname.setBounds(26, 201, 80, 16);
		frmFoodset.getContentPane().add(lblSetname);
		
		JLabel lblDescription = new JLabel("description");
		lblDescription.setBounds(26, 240, 87, 16);
		frmFoodset.getContentPane().add(lblDescription);
		
		JLabel lblSearch = new JLabel("Search ID");
		lblSearch.setBounds(26, 105, 56, 16);
		frmFoodset.getContentPane().add(lblSearch);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(26, 347, 56, 16);
		frmFoodset.getContentPane().add(lblPrice);
		
		frmFoodset.getContentPane().add(getSearchField(),null);
		frmFoodset.getContentPane().add(getSetIdField(),null);
		frmFoodset.getContentPane().add(getSetNameField(),null);
		frmFoodset.getContentPane().add(getPriceField(),null);
		frmFoodset.getContentPane().add(getPreviousButton(),null);
		frmFoodset.getContentPane().add(getNextButton(),null);
		frmFoodset.getContentPane().add(getFirstButton(),null);
		frmFoodset.getContentPane().add(getLastButton(),null);
		frmFoodset.getContentPane().add(getSaveButton(),null);
		frmFoodset.getContentPane().add(getCancelButton(),null);
		frmFoodset.getContentPane().add(getEditButton(),null);
		frmFoodset.getContentPane().add(getDeleteButton(),null);
		frmFoodset.getContentPane().add(getDesField(),null);
		frmFoodset.getContentPane().add(getSearch(),null);
		frmFoodset.getContentPane().add(getBtnClose());
	}
	private JTextField getSetIdField() {
		 if (txtId == null) {
			 txtId = new JTextField();
			 txtId.setEditable(false);
			 txtId.setBounds(118, 160, 116, 22);
			 txtId.setColumns(10);
			 try {
				 txtId.setText(rsRead.getString("set_id"));
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return txtId;
	}
	private JTextField getSetNameField() {
		 if (txtSet == null) {
			 txtSet = new JTextField();
			 txtSet.setEditable(false);
			 txtSet.setBounds(118, 198, 235, 22);
			 txtSet.setColumns(10);
			 try {
				 txtSet.setText(rsRead.getString("set_name"));
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return txtSet;
	}
	
	private JTextPane getDesField() {
		if (txtDes == null) {
			txtDes = new JTextPane();
			txtDes.setEditable(false);
			txtDes.setBounds(118, 240, 349, 91);
			try {
				 txtDes.setText(rsRead.getString("description"));
			}catch (SQLException e) {
				 e.printStackTrace();
			}
		}
		return txtDes;
	}
	
	private JTextField getPriceField() {
		 if (txtPrice == null) {
			 txtPrice = new JTextField();
			 txtPrice.setEditable(false);
			 txtPrice.setBounds(118, 344, 116, 22);
			 txtPrice.setColumns(10);
			 try {
				 txtPrice.setText(rsRead.getString("price"));
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return txtPrice;
	}
	private void setActive() {
		txtId.setEditable(true);
		txtSet.setEditable(true);
		txtDes.setEditable(true);
		txtPrice.setEditable(true);
	}
	
	private void showButton() {
		btnSave.setEnabled(true);
		btnCancle.setEnabled(true);
	}
	
	private void clearData() {
		txtId.setText("");
		txtSet.setText("");
		txtDes.setText("");
		txtPrice.setText("");
	}
	
	private JButton getEditButton() {
		if (btnEdit == null) {
			btnEdit = new JButton();
			btnEdit.setBounds(new Rectangle(502, 159, 97, 25));
			btnEdit.setText("Edit");
			btnEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setActive();
				showButton();
				try {
					rsRead.last();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
					action = "edit";
					set_id = txtId.getText();
					set_name = txtSet.getText();
					description = txtDes.getText();
					price = txtPrice.getText();
				}
			});
		}
		return btnEdit;
	}
	
	private JButton getSaveButton() {
		if (btnSave == null) {
			btnSave = new JButton();
			btnSave.setEnabled(false);
			btnSave.setBounds(new Rectangle(502, 262, 97, 25));
			btnSave.setText("Save");
			btnSave.setVisible(true);
			btnSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					if(action == "add") {
						int setid = Integer.parseInt(txtId.getText());
						int setprice = Integer.parseInt(txtPrice.getText());
						sql = "insert into menu (set_id,set_name,description,price) values('" + setid + "','" + txtSet.getText() + "','" + txtDes.getText() + "'," + setprice +")";
						st.executeUpdate(sql);
					} else if(action == "edit") {
						confirm = JOptionPane.showConfirmDialog(frmFoodset,"คุณยืนยันที่จะแก้ไขข้อมูล");
						if(confirm == 0) {
							try {
								int setid = Integer.parseInt(txtId.getText());
								int setprice = Integer.parseInt(txtPrice.getText());
								String id = txtId.getText();
								sql = "Update menu SET set_id='" + setid + "', set_name='" + txtSet.getText() + "',description='" + txtDes.getText() + "',price=" + setprice +" WHERE set_id = '" + id + "'";
								JOptionPane.showMessageDialog(frmFoodset,sql);
								st.executeUpdate(sql);
							 } catch (SQLException e1) {
								 e1.printStackTrace();
							 }
						}
					}
					rsRead = st.executeQuery("select * from menu");
					rsRead.last();
					updateTextField();
				 } catch (SQLException e1) {
					 e1.printStackTrace();
				 }
				 clearData();
				}
			});
		}
		return btnSave;
	}
	
	private JButton getCancelButton() {
		if (btnCancle == null) {
			btnCancle = new JButton();
			btnCancle.setEnabled(false);
			btnCancle.setBounds(new Rectangle(502, 312, 97, 25));
			btnCancle.setText("Cancel");
			btnCancle.setVisible(true);
			
			btnCancle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(action == "add") {
					clearData();
				} else if(action == "edit") {
					txtId.setText(set_id);
					txtSet.setText(set_name);
					txtDes.setText(description);
					txtPrice.setText(price);
				}
			}
			});
		}
		return btnCancle;
	}
	
	private JButton getDeleteButton() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setEnabled(true);
			btnDelete.setBounds(new Rectangle(502, 211, 97, 25));
			btnDelete.setText("Delete");
			btnDelete.setVisible(true);
			btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					confirm = JOptionPane.showConfirmDialog(frmFoodset,"คุณยืนยันที่จะลบข้อมูล");
					if(confirm == 0) {
							try {
								sql = "DELETE FROM menu WHERE set_id ='" +txtId.getText()+ "'";
								st.executeUpdate(sql);
							 } catch (SQLException e1) {
								 e1.printStackTrace();
							 }
						}
					rsRead = st.executeQuery("select * from menu");
					rsRead.first();
					updateTextField();
				 } catch (SQLException e1) {
					 e1.printStackTrace();
				 }
				}
			});
		}
		return btnDelete;
	}
	
	private JButton getPreviousButton() {
		if (btnPrevious == null) {
			btnPrevious = new JButton();
			btnPrevious.setBounds(new Rectangle(150, 389, 41, 25));
			btnPrevious.setText("<");
			btnPrevious.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setInActive(); 
				hideButton(); 
				try {
					if(rsRead.isFirst()) {
						rsRead.first();
						updateTextField();
					} else {
						rsRead.previous();
						updateTextField();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			});
		}
		return btnPrevious;
	}
	
	private JButton getNextButton() {
		if (btnNext == null) {
			btnNext = new JButton();
			btnNext.setBounds(new Rectangle(203, 389, 41, 25));
			btnNext.setText(">");
			btnNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setInActive(); 
				hideButton(); 
				try {
					if(rsRead.isLast()) {
						rsRead.last();
						updateTextField();
					} else {
						rsRead.next();
						updateTextField();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			});
		}
		return btnNext;
	}
	
	private JButton getFirstButton() {
		if (btnFirst == null) {
			btnFirst = new JButton();
			btnFirst.setBounds(new Rectangle(82, 389, 56, 25));
			btnFirst.setText("<<");
			btnFirst.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setInActive(); 
				hideButton(); 
				try {
					rsRead.first();
					updateTextField();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			});
		}
		return btnFirst;
	}
	
	private JButton getLastButton() {
		if (btnLast == null) {
			btnLast = new JButton();
			btnLast.setBounds(new Rectangle(259, 389, 56, 25));
			btnLast.setText(">>");
			btnLast.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setInActive(); 
				hideButton(); 
				try {
					rsRead.last();
					updateTextField();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			});
		}
		return btnLast;
	}
	
	private void setInActive() {
		txtId.setEditable(false);
		txtSet.setEditable(false);
		txtDes.setEditable(false);
		txtPrice.setEditable(false);
	}
	
	private void hideButton() {
		btnSave.setEnabled(false);
		btnCancle.setEnabled(false);
	}

	private void updateTextField() {
		try {
			String idStr = String.format("%d", rsRead.getInt("set_id"));
			String priceStr = String.format("%d", rsRead.getInt("price"));
			txtId.setText(idStr);
			txtSet.setText(rsRead.getString("set_name"));
			txtDes.setText(rsRead.getString("description"));
			txtPrice.setText(priceStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private JTextField getSearchField() {
		 if (txtSearch == null) {
			 txtSearch = new JTextField();
			 txtSearch.setBounds(94, 102, 87, 22);
			 txtSearch.setColumns(10);
		 }
		 return txtSearch;
	}
	
	private JButton getSearch() {
		if (btnGo == null) {
			btnGo = new JButton();
			btnGo.setBounds(new Rectangle(193, 101, 66, 25));
			btnGo.setText("Go!");
			btnGo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					int setid = Integer.parseInt(txtSearch.getText());
					sql = "select * from menu where set_id='"+ setid +"'";
					rsRead = st.executeQuery(sql);
					rsRead.first();
					updateTextField();
				 } catch (SQLException e1) {
					 e1.printStackTrace();
				 }
				}
			});
		}
		return btnGo;
	}
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmFoodset.setVisible(false);
				}
			});
			btnClose.setBounds(502, 389, 97, 25);
		}
		return btnClose;
	}
}
