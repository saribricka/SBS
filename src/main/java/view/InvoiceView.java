package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.java.controller.InvoiceController;
import main.java.controller.InvoiceControllerImpl;
import main.java.controller.ItemController;
import main.java.controller.ItemControllerImpl;
import main.java.controller.ShopController;
import main.java.controller.ShopControllerImpl;
import main.java.controller.UserController;
import main.java.controller.UserControllerImpl;
import main.java.model.User;

public class InvoiceView extends JFrame{

	private static final long serialVersionUID = 3240398240332114971L;
	private JPanel contentPane;
	private JTextField textField_TotalPrice;
	private JComboBox<Integer> comboBox_CustomerId;
	private JComboBox<String> comboBox_ItemId;
	private JComboBox<Integer> comboBox_Quantity;

	private UserController userController = new UserControllerImpl();
	private ItemController itemController = new ItemControllerImpl();
	private ShopController shopController = new ShopControllerImpl();
	private InvoiceController invoiceController = new InvoiceControllerImpl();
	
	private Set<Integer> quantityModel;
		
	/**
	 * Create the frame.
	 */	
	public InvoiceView(final int loggedId) {
		userController.setUserLogged(loggedId);
		setTitle("Invoice Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 1300, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		invoiceController.newInvoice();
				
		JTextArea invoiceArea = new JTextArea();
		invoiceArea.setBackground(new Color(211, 211, 211));
		invoiceArea.setEditable(false);
		String row = "Id" + "\t" + "Product" + "\t" + "Quantity" + "\t" + "UnitPrice" + "\n";
		invoiceArea.setText(row);
		
		JScrollPane scrollPane = new JScrollPane(invoiceArea);
		scrollPane.setBounds(15, 15, 345, 420);
		contentPane.add(scrollPane);
		
		JLabel lblComment = new JLabel("Search for CustomerID, check data by clicking 'Check User'");
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComment.setBounds(370, 15, 442, 16);
		contentPane.add(lblComment);
						
		JLabel lblCustomer = new JLabel("User ID:");
		lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCustomer.setBounds(385, 46, 100, 20);
		contentPane.add(lblCustomer);
		
		comboBox_CustomerId = new JComboBox<>();
		comboBox_CustomerId.setModel(new DefaultComboBoxModel(userController.getAllId().toArray()));
		comboBox_CustomerId.setBounds(505, 46, 100, 20);
		contentPane.add(comboBox_CustomerId);
		
		JButton btnCheck = new JButton("Check User");
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int customerId = Integer.parseInt((String) comboBox_CustomerId.getSelectedItem());
										
					User foundUser = userController.searchUser(customerId);
					
					if(foundUser == null) {
						comboBox_CustomerId.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "The User was not found");
					} else {						
						JOptionPane.showMessageDialog(null, "The User is " + foundUser.toString());						
					}																			
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnCheck.setBounds(620, 46, 120, 23);
		contentPane.add(btnCheck);
		
		JLabel lblComment2 = new JLabel("Search for Item ID, choose quantity and click Add");
		lblComment2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComment2.setBounds(370, 84, 442, 16);
		contentPane.add(lblComment2);
		
		comboBox_ItemId = new JComboBox<>();
		comboBox_Quantity = new JComboBox<>();
		comboBox_ItemId.setBounds(370, 122, 120, 23);
		comboBox_ItemId.setModel(new DefaultComboBoxModel(itemController.getAllId().toArray()));
		quantityModel = itemController.fromOneToQuantity(itemController.searchItem(comboBox_ItemId.getSelectedItem().toString()));
		comboBox_ItemId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					quantityModel = itemController.fromOneToQuantity(itemController.searchItem(comboBox_ItemId.getSelectedItem().toString()));
					comboBox_Quantity.setModel(new DefaultComboBoxModel(quantityModel.toArray()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}			
		});
		contentPane.add(comboBox_ItemId);			
		
		comboBox_Quantity.setModel(new DefaultComboBoxModel(quantityModel.toArray()));	
		comboBox_Quantity.setBounds(505, 122, 100, 23);
		contentPane.add(comboBox_Quantity);
		
		JButton btnAdd = new JButton("Add to Cart");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String itemId = comboBox_ItemId.getSelectedItem().toString();
					String itemQty = comboBox_Quantity.getSelectedItem().toString();
					
					String invoiceLine = invoiceController.createInvoiceItem(itemId, itemQty);
					invoiceController.addToCart(invoiceLine);
					
					String tot = String.valueOf(invoiceController.calculateTotal());
					textField_TotalPrice.setText(tot);
					invoiceArea.append(invoiceLine);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnAdd.setBounds(620, 122, 120, 23);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBox_CustomerId.setSelectedIndex(0);
				comboBox_Quantity.setSelectedIndex(0);
				comboBox_ItemId.setSelectedIndex(0);
			}
		});
		btnClear.setBounds(370, 193, 120, 23);
		contentPane.add(btnClear);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				try {
					invoiceArea.print();	
				} catch (PrinterException e1) {
					JOptionPane.showMessageDialog(null, "No Printer Found");
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPrint.setBounds(505, 193, 100, 23);
		contentPane.add(btnPrint);
		
		JButton btnNewInvoice = new JButton("New Invoice");
		btnNewInvoice.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewInvoice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				invoiceController.newInvoice();
				comboBox_CustomerId.setSelectedIndex(0);
				comboBox_Quantity.setSelectedIndex(0);
				comboBox_ItemId.setSelectedIndex(0);
				textField_TotalPrice.setText("");
				invoiceArea.setText(row);
			}
		});
		btnNewInvoice.setBounds(620, 193, 120, 23);
		contentPane.add(btnNewInvoice);

		JLabel lblTotalPrice = new JLabel("Total price:");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalPrice.setBounds(820, 200, 90, 25);
		contentPane.add(lblTotalPrice);
		
		textField_TotalPrice = new JTextField();
		textField_TotalPrice.setEditable(false);
		textField_TotalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_TotalPrice.setColumns(10);
		textField_TotalPrice.setBounds(820, 230, 90, 25);
		contentPane.add(textField_TotalPrice);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String strTot = textField_TotalPrice.getText();
				if(!strTot.isBlank()) {
					Double tot = Double.parseDouble(strTot);
					int userId = Integer.parseInt(String.valueOf(comboBox_CustomerId.getSelectedItem()));				
					boolean payCheck = shopController.addPayment(userId, tot);
					boolean opCheck = invoiceController.checkout();
					if(payCheck && opCheck) {
						JOptionPane.showMessageDialog(null, "Operation ended successfully!");
						comboBox_CustomerId.setSelectedIndex(0);
						comboBox_Quantity.setSelectedIndex(0);
						comboBox_ItemId.setSelectedIndex(0);
						textField_TotalPrice.setText("");
						invoiceArea.setText(row);
					} else {
						JOptionPane.showMessageDialog(null, "Something went wrong! Try again");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Start by adding some items to the cart!");
				}				
			}
		});
		btnPay.setBounds(820, 270, 90, 25);
		contentPane.add(btnPay);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				CashierView screen = new CashierView(loggedId);
				screen.display();
			}
		});
		btnBack.setBounds(820, 400, 90, 25);
		contentPane.add(btnBack);		
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);      
        setLocationRelativeTo(null);  
        setMinimumSize(new Dimension(500,500));
    }
	
}
