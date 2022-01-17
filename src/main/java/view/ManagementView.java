package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.controller.UserController;
import main.java.controller.UserControllerImpl;

public class ManagementView extends JFrame{

	private static final long serialVersionUID = -9170551248090369195L;
	private JPanel contentPane;
	private UserController userController = new UserControllerImpl(); 
	
	public ManagementView(final int loggedId) {
		userController.setUserLogged(loggedId);
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
			UserView screen = new UserView(loggedId);
			screen.display();
			}			
		});
		
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 16));
		btnNewButton.setBounds(120, 80, 110, 31);
		contentPane.add(btnNewButton);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ItemView screen = new ItemView(loggedId);
				screen.display();
			}
		});
		
		btnProducts.setFont(new Font("Serif", Font.BOLD, 16));
		btnProducts.setBounds(190, 190, 110, 31);
		contentPane.add(btnProducts);
		
		JButton btnAccounting = new JButton("Accounting");
		btnAccounting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AccountingView screen = new AccountingView(loggedId);
				screen.display();
			}
		});
		
		btnAccounting.setFont(new Font("Serif", Font.BOLD, 16));
		btnAccounting.setBounds(180, 135, 130, 31);
		contentPane.add(btnAccounting);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CustomerView screen = new CustomerView(loggedId);
				screen.display();
			}
		});
		
		btnCustomers.setFont(new Font("Serif", Font.BOLD, 16));
		btnCustomers.setBounds(250, 80, 110, 31);
		contentPane.add(btnCustomers);
		
		JButton button_6 = new JButton("Back");
		button_6.setFont(new Font("Serif", Font.BOLD, 16));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView screen =new HomeView(loggedId);{
					screen.repaint();
					setVisible(false);
					screen.display();
				}
			}
		});
		
		button_6.setBounds(200, 256, 90, 28);
		contentPane.add(button_6);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);     
        setLocationRelativeTo(null);   
        setMinimumSize(new Dimension(500,500));
    }

}
