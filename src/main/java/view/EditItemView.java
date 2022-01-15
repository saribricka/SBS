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

public class EditItemView extends JFrame{

	private static final long serialVersionUID = -8607459578719762355L;
	private JTextField textField_Name;
	private JTextField textField_Quantity;
	private JTextField textField_Price;
	private String barcode, name;
	private int quantity;
	private double price;
	private ItemCategory category;
	
	ItemController controller = new ItemControllerImpl();
	Object[] idArray;
	
	JComboBox<Integer> comboBox_ItemId;
	JComboBox<ItemCategory> comboBox_Category;
	/**
	 * Create the frame.
	 */
	public EditItemView() {
//		File logoImage = new File("EditItemView.png");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Edit Product");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 550, 450);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_ProductID = new JLabel("Product ID:");
		label_ProductID.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_ProductID.setBounds(18, 48, 100, 22);
		contentPane.add(label_ProductID);
		
		JLabel label_Category = new JLabel("Category:");
		label_Category.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Category.setBounds(18, 89, 100, 16);
		contentPane.add(label_Category);
		
		JLabel label_Name = new JLabel("Name:");
		label_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Name.setBounds(18, 118, 100, 22);
		contentPane.add(label_Name);
		
		JLabel label_Quantity = new JLabel("Quantity:");
		label_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Quantity.setBounds(18, 156, 100, 16);
		contentPane.add(label_Quantity);
		
		JLabel lblSellPrice = new JLabel("Unit Price:");
		lblSellPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSellPrice.setBounds(18, 189, 100, 23);
		contentPane.add(lblSellPrice);
		
		comboBox_ItemId = new JComboBox<>();
		idArray = controller.getAllId().toArray();
		comboBox_ItemId.setModel(new DefaultComboBoxModel(idArray));
		comboBox_ItemId.setBounds(152, 48, 116, 22);
		contentPane.add(comboBox_ItemId);
		
		comboBox_Category = new JComboBox<>();
		comboBox_Category.setModel(new DefaultComboBoxModel(ItemCategory.values()));
		comboBox_Category.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_Category.setBounds(152, 83, 116, 25);
		contentPane.add(comboBox_Category);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Name.setColumns(10);
		textField_Name.setBounds(152, 121, 116, 22);
		contentPane.add(textField_Name);
		
		NumberFormatter intFormatter = new NumberFormatter(NumberFormat.getInstance());
		intFormatter.setValueClass(Integer.class);
	    intFormatter.setMinimum(0);
	    intFormatter.setMaximum(Integer.MAX_VALUE);
	    intFormatter.setAllowsInvalid(false);
		textField_Quantity = new JFormattedTextField(intFormatter);
		textField_Quantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Quantity.setColumns(10);
		textField_Quantity.setBounds(152, 153, 116, 22);
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
		textField_Price.setBounds(152, 189, 116, 25);		
		contentPane.add(textField_Price);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ItemView screen = new ItemView();
				screen.display();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(395, 375, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				comboBox_ItemId.setSelectedIndex(0);
				comboBox_Category.setSelectedIndex(0);
				textField_Name.setText("");
				textField_Quantity.setText("0");
				textField_Price.setText("0.00");		
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(395, 118, 97, 25);
		contentPane.add(btnClear);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					barcode = String.valueOf(comboBox_ItemId.getSelectedItem());
										
					if(controller.searchItem(barcode) == null) {
						comboBox_ItemId.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "The Product was not found");
					} else { 
						category = ItemCategory.valueOf(String.valueOf(comboBox_Category.getSelectedItem()).toUpperCase());
						name = textField_Name.getText();					
						String strQ = textField_Quantity.getText();
						quantity = (!strQ.isEmpty()) ? Integer.parseInt(strQ) : 0;
						String strP = textField_Price.getText();
						price = (!strP.isEmpty()) ? Double.parseDouble(strP) : 0.0;
						
						ItemImpl itemToAdd = new ItemImpl(barcode, name, quantity, price, null, null, category);
						controller.updateItem(itemToAdd);
																
						comboBox_ItemId.setSelectedIndex(0);
						comboBox_Category.setSelectedIndex(0);
						textField_Name.setText("");
						textField_Quantity.setText("0");
						textField_Price.setText("0.00");
						JOptionPane.showMessageDialog(null, "The Product was updated");
					}								
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(395, 189, 97, 25);
		contentPane.add(btnUpdate);
		
		JLabel lblPleaseFillProduct = new JLabel("Please fill Product ID and click Search");
		lblPleaseFillProduct.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseFillProduct.setBounds(23, 11, 299, 22);
		contentPane.add(lblPleaseFillProduct);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					barcode = String.valueOf(comboBox_ItemId.getSelectedItem());
					
					Item foundItem = controller.searchItem(barcode);
					
					if(foundItem == null) {
						comboBox_ItemId.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "The Product was not found");
					} else {
						textField_Name.setText(foundItem.getName());
						textField_Quantity.setText(String.valueOf(foundItem.getQuantity()));
						textField_Price.setText(String.valueOf(foundItem.getUnitPrice()));
						
						for(int i=0; i<comboBox_Category.getItemCount(); i++) {
							if(comboBox_Category.getItemAt(i).equals(foundItem.getCategory())) {
								comboBox_Category.setSelectedIndex(i);
							}
						}						
					}																			
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(395, 48, 97, 25);
		contentPane.add(btnSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					barcode = String.valueOf(comboBox_ItemId.getSelectedItem());
					
					var check = controller.deleteItem(barcode);

					if(!check) {
						JOptionPane.showMessageDialog(null, "The Product was not found");
					} else {						
						JOptionPane.showMessageDialog(null, "The Product was deleted from the database");
						idArray = controller.getAllId().toArray();
						comboBox_ItemId.setModel(new DefaultComboBoxModel(idArray));
					}	
					comboBox_Category.setSelectedIndex(0);
					textField_Name.setText("");
					textField_Quantity.setText("0");
					textField_Price.setText("0.00");
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
		}});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(395, 257, 97, 25);
		contentPane.add(btnDelete);
		
		JLabel lblPicture = new JLabel("");
//		File EditItemView = new File("EditItemView.png");
//		String ProductEditPath = EditItemView.getPath();
//		lblPicture.setIcon(new ImageIcon(ProductEditPath));
		lblPicture.setBounds(400, 0, 862, 525);
		contentPane.add(lblPicture);	
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);        
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(500,500));
    }
}
