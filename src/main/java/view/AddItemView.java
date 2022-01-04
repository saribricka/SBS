package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddItemView extends JFrame{

	private JPanel contentPane;
	private JTextField textField_ID;
	private JTextField textField_Quantity;
	private JTextField textField_Price;
	private JTextField textField_Supplier;
	private JTextField textField_ProductName;
	private JTextField textField_ReceivedDate;
	private JTextField textField_ExpiredDate;
	private JTextField textField_CostPrice;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddItemView() {
//		File logoImage = new File("AddItemView.jpg");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Details Of Products");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductId.setBounds(12, 13, 100, 22);
		contentPane.add(lblProductId);
				
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategory.setBounds(12, 54, 100, 16);
		contentPane.add(lblCategory);
		
		JLabel lblFirstName = new JLabel("Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(12, 83, 100, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(12, 118, 100, 16);
		contentPane.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Unit Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(12, 153, 100, 16);
		contentPane.add(lblPrice);
		
		JLabel lblReceivedDate = new JLabel("Received Date:");
		lblReceivedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReceivedDate.setBounds(12, 192, 120, 16);
		contentPane.add(lblReceivedDate);
		
		JLabel lblExpiredDate = new JLabel("Expiration Date:");
		lblExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExpiredDate.setBounds(12, 227, 120, 16);
		contentPane.add(lblExpiredDate);								
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ID.setColumns(10);
		textField_ID.setBounds(134, 13, 116, 22);
		contentPane.add(textField_ID);
		
		JComboBox comboBox_category = new JComboBox();
		comboBox_category.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_category.setModel(new DefaultComboBoxModel(new String[] {"Select", "Bio", "Vegetables", "Fruits", "Canning", "Sauce", "Snacks", "Bakery", "Cleaning", "Beverage", "Spice", "Grain", "Dairy"}));
		comboBox_category.setBounds(134, 48, 116, 25);
		contentPane.add(comboBox_category);		
		
		textField_ProductName = new JTextField();
		textField_ProductName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ProductName.setColumns(10);
		textField_ProductName.setBounds(134, 83, 116, 22);
		contentPane.add(textField_ProductName);
		
		textField_Quantity = new JTextField();
		textField_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Quantity.setColumns(10);
		textField_Quantity.setBounds(134, 118, 116, 22);
		contentPane.add(textField_Quantity);
		
		textField_Price = new JTextField();
		textField_Price.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Price.setColumns(10);
		textField_Price.setBounds(134, 153, 116, 22);
		contentPane.add(textField_Price);
					
		textField_ReceivedDate = new JTextField();
		textField_ReceivedDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ReceivedDate.setColumns(10);
		textField_ReceivedDate.setBounds(134, 192, 116, 22);
		contentPane.add(textField_ReceivedDate);
		
		textField_ExpiredDate = new JTextField();
		textField_ExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ExpiredDate.setColumns(10);
		textField_ExpiredDate.setBounds(134, 227, 116, 22);
		contentPane.add(textField_ExpiredDate);
				
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error please check all filds date must be in fotmat: DD-MM-YYYY");
				}				
			}});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(395, 48, 97, 25);
		contentPane.add(btnAdd);	
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ItemView screen = new ItemView();
				screen.display();
			}			
		});
		btnBack.setBounds(395, 375, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setBackground(Color.WHITE);
//		File AddItemView = new File("AddItemView.jpg");
//		String ProductAddPath = AddItemView.getPath();
//		lblPicture.setIcon(new ImageIcon(ProductAddPath));
		lblPicture.setBounds(267, 13, 525, 462);
		contentPane.add(lblPicture);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);      
        setLocationRelativeTo(null);  
        setMinimumSize(new Dimension(500,500));
    }
}
