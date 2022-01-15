package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StockView extends JFrame{

	private static final long serialVersionUID = 6529781551683213435L;
	private JPanel contentPane;
	
	public StockView() {
//		File logoImage = new File("StockView.jpg");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Inventory Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 868, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ManagementView screen= new ManagementView();
				screen.display();
			}
		});
		btnBack.setBounds(689, 487, 161, 25);
		contentPane.add(btnBack);
		
		JButton btnEditQuantity = new JButton("Edit Inventory");
		btnEditQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditStockView screen = new EditStockView();
				setVisible(false);
				screen.display();						
			}
		});
		btnEditQuantity.setBounds(12, 52, 161, 25);
		contentPane.add(btnEditQuantity);
		
		JButton btnRecieveShipment = new JButton("Receive Shipment");
		btnRecieveShipment.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRecieveShipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockReceiveView screen = new StockReceiveView();
				setVisible(false);
				screen.display();
			}
		});
		btnRecieveShipment.setBounds(12, 13, 161, 25);
		contentPane.add(btnRecieveShipment);
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setFont(new Font("Tahoma", Font.BOLD, 13));
//		File InventoryScreen = new File("StockView.jpg");
//		String InventoryScreenPath = InventoryScreen.getPath();
//		lblPicture.setIcon(new ImageIcon(InventoryScreenPath));
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
