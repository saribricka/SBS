package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ManagementView extends JFrame{

	private JPanel contentPane;

	public ManagementView() {
		File ManagementScreenImage = new File("ManagementScreenImage.jpg");
		String ManagementScreenPath = ManagementScreenImage.getPath();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagementScreenPath));
		setFont(new Font("Serif", Font.BOLD, 14));
		setTitle("Management Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 458, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Users");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			UserView screen = new UserView();
			screen.display();
			}			
		});
		
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 16));
		btnNewButton.setBounds(98, 85, 111, 31);
		contentPane.add(btnNewButton);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ItemView screen = new ItemView();
				screen.display();
			}
		});
		
		btnProducts.setFont(new Font("Serif", Font.BOLD, 16));
		btnProducts.setBounds(98, 144, 111, 31);
		contentPane.add(btnProducts);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StockView screen = new StockView();
				screen.display();
			}
		});
		
		btnInventory.setFont(new Font("Serif", Font.BOLD, 16));
		btnInventory.setBounds(238, 144, 111, 31);
		contentPane.add(btnInventory);
		
		JButton btnAccounting = new JButton("Accounting");
		btnAccounting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AccountingView screen = new AccountingView();
				screen.display();
			}
		});
		
		btnAccounting.setFont(new Font("Serif", Font.BOLD, 16));
		btnAccounting.setBounds(168, 199, 111, 31);
		contentPane.add(btnAccounting);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CustomerView screen = new CustomerView();
				screen.display();
			}
		});
		
		btnCustomers.setFont(new Font("Serif", Font.BOLD, 16));
		btnCustomers.setBounds(238, 85, 111, 31);
		contentPane.add(btnCustomers);
		
		JButton button_6 = new JButton("Back");
		button_6.setFont(new Font("Serif", Font.BOLD, 16));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView screen =new HomeView(true);{
					screen.repaint();
					setVisible(false);
					screen.display();
				}
			}
		});
		
		button_6.setBounds(168, 256, 111, 25);
		contentPane.add(button_6);
		
		JLabel lblPicture = new JLabel("");
//		File logoImage = new File("rsz_28347664145_cefc72c915_b.jpg");
//		String imagePath = logoImage.getPath();
//		lblPicture.setIcon(new ImageIcon(imagePath));
		lblPicture.setBounds(0, 0, 452, 426);
		contentPane.add(lblPicture);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);     
        setLocationRelativeTo(null);   
        setMinimumSize(new Dimension(500,500));
    }

}