package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CustomerView extends JFrame{

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public CustomerView() {
//		File logoImage = new File("CustomerScreen.jpg");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Customer Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddUser = new JButton("Add Customer");
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCustomerView screen = new AddCustomerView();
				setVisible(false);
				screen.display();			
			}
		});
		btnAddUser.setBounds(10, 11, 138, 25);
		contentPane.add(btnAddUser);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagementView screen = new ManagementView();
				setVisible(false);
				screen.display();
			}
		});
		btnCancel.setBounds(300, 370, 138, 25);
		contentPane.add(btnCancel);
		
		JButton btnEditUser = new JButton("Edit Customer");
		btnEditUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditCustomerView screen = new EditCustomerView();
				setVisible(false);
				screen.display();	
			}
		});
		btnEditUser.setBounds(10, 51, 138, 25);
		contentPane.add(btnEditUser);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);     
        setLocationRelativeTo(null);   
        setMinimumSize(new Dimension(500,500));
    }
}
