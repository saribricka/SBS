package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.NumberFormatter;


import main.java.controller.ItemController;
import main.java.controller.ItemControllerImpl;
import main.java.model.Item;
import main.java.model.ItemCategory;
import main.java.model.ItemImpl;

public class AddItemView extends JFrame{

	private static final long serialVersionUID = -4391439102930446102L;

	ItemController controller = new ItemControllerImpl();
	
	private JPanel contentPane;
	private JTextField textField_ID;
	private JTextField textField_Name;
	private JTextField textField_Quantity;
	private JTextField textField_Price;
	private String barcode, name;
	private int quantity;
	private double price;
	private ItemCategory category;

	/**
	 * Create the frame.
	 */
	public AddItemView() {
//		File logoImage = new File("AddItemView.jpg");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Add Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblProductId = new JLabel("Product ID: *");
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductId.setBounds(12, 13, 100, 22);
		contentPane.add(lblProductId);
				
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategory.setBounds(12, 54, 100, 16);
		contentPane.add(lblCategory);
		
		JLabel lblFirstName = new JLabel("Name: *");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(12, 83, 100, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblQuantity = new JLabel("Quantity: *");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(12, 118, 100, 16);
		contentPane.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Unit Price: *");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(12, 153, 100, 16);
		contentPane.add(lblPrice);						
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ID.setColumns(10);
		textField_ID.setBounds(134, 13, 116, 22);
		contentPane.add(textField_ID);
		
		JComboBox<String> comboBox_category = new JComboBox<>();
		comboBox_category.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_category.setModel(new DefaultComboBoxModel(ItemCategory.values()));
		comboBox_category.setBounds(134, 48, 116, 25);
		contentPane.add(comboBox_category);		
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Name.setColumns(10);
		textField_Name.setBounds(134, 83, 116, 22);
		contentPane.add(textField_Name);
		
		NumberFormatter intFormatter = new NumberFormatter(NumberFormat.getInstance());
		intFormatter.setValueClass(Integer.class);
	    intFormatter.setMinimum(0);
	    intFormatter.setMaximum(Integer.MAX_VALUE);
	    intFormatter.setAllowsInvalid(false);
		textField_Quantity = new JFormattedTextField(intFormatter);
		textField_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Quantity.setColumns(10);
		textField_Quantity.setBounds(134, 118, 116, 22);
		contentPane.add(textField_Quantity);
		
		NumberFormat format = DecimalFormat.getInstance();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		format.setRoundingMode(RoundingMode.HALF_UP);
		InternationalFormatter decFormatter = new InternationalFormatter(format);
		decFormatter.setMinimum(0.0);
		decFormatter.setMaximum(Double.MAX_VALUE);
		decFormatter.setAllowsInvalid(false);
		textField_Price = new JFormattedTextField(decFormatter);
		textField_Price.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Price.setColumns(10);
		textField_Price.setBounds(134, 153, 116, 22);
		contentPane.add(textField_Price);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					barcode = textField_ID.getText();
					category = ItemCategory.valueOf(String.valueOf(comboBox_category.getSelectedItem()).toUpperCase());
					name = textField_Name.getText();
					String strQ = textField_Quantity.getText();
					String strP = textField_Price.getText();
					
					if (!barcode.isBlank() && !name.isBlank() && !strQ.isBlank() && !strP.isBlank()) {
						quantity = Integer.parseInt(strQ);
						price = Double.parseDouble(strP);
						
						Item i = new ItemImpl(barcode, name, quantity, price, null, null, category);					
						
						if (controller.addItem(i)) {
							textField_ID.setText("");
							comboBox_category.setSelectedIndex(0);
							textField_Name.setText("");
							textField_Quantity.setText("0");
							textField_Price.setText("0.00");
							JOptionPane.showMessageDialog(null, "The Product was added to the database");
						} else {
							textField_ID.setText("");					
							JOptionPane.showMessageDialog(null, "The ID is already in the database");
						}
					} else {
						JOptionPane.showMessageDialog(null, "The fields with * must be filled to complete the operation.");
					}
										
				} catch (Exception e) {
					e.printStackTrace();
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
		
//		JLabel lblPicture = new JLabel("");
//		lblPicture.setBackground(Color.WHITE);
//		File AddItemView = new File("AddItemView.jpg");
//		String ProductAddPath = AddItemView.getPath();
//		lblPicture.setIcon(new ImageIcon(ProductAddPath));
//		lblPicture.setBounds(267, 13, 525, 462);
//		contentPane.add(lblPicture);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);      
        setLocationRelativeTo(null);  
        setMinimumSize(new Dimension(500,500));
    }
}
