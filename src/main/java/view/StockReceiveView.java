package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StockReceiveView extends JFrame{

	private static final long serialVersionUID = 5190408151576761621L;
	private JPanel contentPane;
	private JTextField textField_EnterNewQuantity;
	private JTextField textField_ProductID;
	private JTextField textField_ReceiveDate;
	private JButton btnSave;
	private JTextField textField_ExpiredDate;

	/**
	 * Create the frame.
	 */
	public StockReceiveView() {
//		File logoImage = new File("StockReceiveView.png");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setResizable(false);
		setTitle("Receive Shipment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 868, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterNewQuantity = new JLabel("Quantity:");
		lblEnterNewQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterNewQuantity.setBounds(12, 46, 118, 24);
		contentPane.add(lblEnterNewQuantity);
		
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StockView screen = new StockView();
				screen.display();
			}
			
		});
		btnCancel.setBounds(724, 477, 97, 25);
		contentPane.add(btnCancel);
		
		textField_EnterNewQuantity = new JTextField();
		textField_EnterNewQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_EnterNewQuantity.setBounds(142, 46, 116, 22);
		contentPane.add(textField_EnterNewQuantity);
		textField_EnterNewQuantity.setColumns(10);
		
		JLabel lblSelectedProduct = new JLabel("Product ID:");
		lblSelectedProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectedProduct.setBounds(12, 14, 106, 24);
		contentPane.add(lblSelectedProduct);
		
		textField_ProductID = new JTextField();
		textField_ProductID.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ProductID.setColumns(10);
		textField_ProductID.setBounds(142, 13, 116, 22);
		contentPane.add(textField_ProductID);
		
		JLabel lblReceiveDate = new JLabel("Received Date:");
		lblReceiveDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReceiveDate.setBounds(12, 78, 118, 24);
		contentPane.add(lblReceiveDate);
		
		textField_ReceiveDate = new JTextField();
		textField_ReceiveDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ReceiveDate.setColumns(10);
		textField_ReceiveDate.setBounds(142, 78, 116, 22);
		contentPane.add(textField_ReceiveDate);
		
		JLabel lblExpiredDate = new JLabel("Expiration Date:");
		lblExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExpiredDate.setBounds(12, 112, 118, 24);
		contentPane.add(lblExpiredDate);
		
		textField_ExpiredDate = new JTextField();
		textField_ExpiredDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_ExpiredDate.setColumns(10);
		textField_ExpiredDate.setBounds(142, 112, 116, 22);
		contentPane.add(textField_ExpiredDate);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
//					.saveInventory(textField_ExpiredDate.getText(),textField_ReceiveDate.getText() , 
//							textField_ProductID.getText(), textField_EnterNewQuantity.getText());
//					
//					textField_ExpiredDate.setText("");
//					textField_ReceiveDate.setText("");
//					textField_ProductID.setText("");
//					textField_EnterNewQuantity.setText("");
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error please check all filds date must be in fotmat: DD-MM-YYYY");
				}
			}
		});
		btnSave_1.setBounds(142, 142, 97, 25);
		contentPane.add(btnSave_1);
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setFont(new Font("Tahoma", Font.BOLD, 13));
//		File StockReceiveView = new File("StockReceiveView.png");
//		String InventoryReceivePath = StockReceiveView.getPath();
//		lblPicture.setIcon(new ImageIcon(InventoryReceivePath));
		lblPicture.setBounds(0, 0, 862, 528);
		contentPane.add(lblPicture);		
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);        
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(500,500));
    }
}
