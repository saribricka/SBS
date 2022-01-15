package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.java.model.Item;
import main.java.model.ItemImpl;

public class EditStockView extends JFrame{

	private static final long serialVersionUID = 4037535832925122455L;
	private JPanel contentPane;
	private JTextField textField_ProductID;
	private JTextField textField_Name;
	private JTextField textField_Supplier;
	private JTextField textField_Quantity;
	private JTextField textField_ReceivedDate;
	private JTextField textField_ExpiredDate;
	
//	private static List<Item> ProductList = loadProductList();
	private JTextField textFieldCategory;

	/**
	 * Create the frame.
	 */
	public EditStockView() {		
//	File logoImage = new File("EditStockView.jpg");
//	String imagePath = logoImage.getPath();
//	setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
	setTitle("Edit Inventory");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(620, 280, 734, 423);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel label_ProductID = new JLabel("Product ID:");
	label_ProductID.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_ProductID.setBounds(10, 48, 97, 22);
	contentPane.add(label_ProductID);
	
	JLabel label_Category = new JLabel("Category:");
	label_Category.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_Category.setBounds(10, 81, 79, 22);
	contentPane.add(label_Category);
	
	JLabel label_Name = new JLabel("Name:");
	label_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_Name.setBounds(10, 116, 79, 22);
	contentPane.add(label_Name);
	
	JLabel label_Supplier = new JLabel("Supplier:");
	label_Supplier.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_Supplier.setBounds(10, 154, 79, 16);
	contentPane.add(label_Supplier);
	
	JLabel label_Quantity = new JLabel("Quantity:");
	label_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_Quantity.setBounds(10, 183, 79, 22);
	contentPane.add(label_Quantity);
	
	JLabel label_ReceivedDate = new JLabel("Received Date:");
	label_ReceivedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_ReceivedDate.setBounds(10, 226, 116, 16);
	contentPane.add(label_ReceivedDate);
	
	JLabel label_ExpiredDate = new JLabel("Expiration Date:");
	label_ExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 14));
	label_ExpiredDate.setBounds(10, 258, 116, 16);
	contentPane.add(label_ExpiredDate);
	
	textField_ProductID = new JTextField();
	textField_ProductID.setFont(new Font("Tahoma", Font.BOLD, 14));
	textField_ProductID.setColumns(10);
	textField_ProductID.setBounds(142, 48, 116, 22);
	contentPane.add(textField_ProductID);
	
	textField_Name = new JTextField();
	textField_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
	textField_Name.setColumns(10);
	textField_Name.setBounds(142, 116, 116, 22);
	contentPane.add(textField_Name);
	
	textField_Supplier = new JTextField();
	textField_Supplier.setFont(new Font("Tahoma", Font.BOLD, 14));
	textField_Supplier.setColumns(10);
	textField_Supplier.setBounds(142, 151, 116, 22);
	contentPane.add(textField_Supplier);
	
	textField_Quantity = new JTextField();
	textField_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
	textField_Quantity.setColumns(10);
	textField_Quantity.setBounds(142, 183, 116, 22);
	contentPane.add(textField_Quantity);
	
	textField_ReceivedDate = new JTextField();
	textField_ReceivedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
	textField_ReceivedDate.setColumns(10);
	textField_ReceivedDate.setBounds(142, 218, 116, 22);
	contentPane.add(textField_ReceivedDate);
	
	textField_ExpiredDate = new JTextField();
	textField_ExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 14));
	textField_ExpiredDate.setColumns(10);
	textField_ExpiredDate.setBounds(142, 252, 116, 22);
	contentPane.add(textField_ExpiredDate);
	
	
	textFieldCategory = new JTextField();
	textFieldCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
	textFieldCategory.setColumns(10);
	textFieldCategory.setBounds(142, 81, 116, 22);
	contentPane.add(textFieldCategory);
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			StockView screen = new StockView();
			screen.display();
		}
	});
	btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnBack.setBounds(619, 358, 97, 25);
	contentPane.add(btnBack);
	
	JButton btnClear = new JButton("Clear");
	btnClear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			textField_ProductID.setText("");
			textField_Name.setText("");
			textField_Supplier.setText("");
			textField_Quantity.setText("");
			textField_ReceivedDate.setText("");
			textField_ExpiredDate.setText("");
			textFieldCategory.setText("");
			
		}
	});
	btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnClear.setBounds(360, 84, 97, 25);
	contentPane.add(btnClear);
	
	JButton btnUpdate = new JButton("Update");
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try
			{
	
//				textField_ProductID.setText("");
//				textField_Name.setText("");
//				textField_Supplier.setText("");
//				textField_Quantity.setText("");
//				textField_ReceivedDate.setText("");
//				textField_ExpiredDate.setText("");
//				textFieldCategory.setText("");
			}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Error please check all filds date must be in fotmat: DD-MM-YYYY");
			}
		}
	});
	btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnUpdate.setBounds(360, 120, 97, 25);
	contentPane.add(btnUpdate);
	
	JLabel lblPleaseFillProduct = new JLabel("Please fill Product ID number and click Search");
	lblPleaseFillProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblPleaseFillProduct.setBounds(10, 13, 299, 22);
	contentPane.add(lblPleaseFillProduct);
	
	JButton btnSearch = new JButton("Search");
	btnSearch.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{	
			try
			{
//				Product newProduct = m_Controller.searchProduct(textField_ProductID.getText());
//				textField_Name.setText(newProduct.getProductName());
//				textField_Supplier.setText(newProduct.getProductSupplier());
//				textField_Quantity.setText(newProduct.getProductQuantity());
//				textField_ReceivedDate.setText(newProduct.getProductReceiveDate());
//				textField_ExpiredDate.setText(newProduct.getProductExpireDate());
//				textFieldCategory.setText(newProduct.getProductCategory());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Error Produt is not in the data base");
			}
	}});
	btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnSearch.setBounds(360, 47, 97, 25);
	contentPane.add(btnSearch);
	
	JLabel lblPicture = new JLabel("");
//	File EditStockView = new File("EditStockView.jpg");
//	String InventoryReceivePath = EditStockView.getPath();
//	lblPicture.setIcon(new ImageIcon(InventoryReceivePath));
	lblPicture.setBounds(0, -23, 862, 451);
	contentPane.add(lblPicture);

	
	}

//	private static List<Item> loadProductList() 
//	{
//		Item TempProduct = new ItemImpl();
//		return TempProduct.loadItemList(); 	
//	}
	
	public void display() {
        setVisible(true);
        setResizable(true);    
        setLocationRelativeTo(null);    
        setMinimumSize(new Dimension(500,500));
    }
}
