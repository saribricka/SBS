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

public class UserView extends JFrame{

	private static final long serialVersionUID = 4193666446055665724L;
	private JPanel contentPane;
	private UserController userController = new UserControllerImpl(); 
	
	public UserView(final int loggedId) {
		userController.setUserLogged(loggedId);
		setTitle("Users");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 788, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddUserView screen = new AddUserView(loggedId);
				setVisible(false);
				screen.display();			
			}
		});
		btnAddUser.setBounds(12, 13, 117, 25);
		contentPane.add(btnAddUser);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagementView screen = new ManagementView(loggedId);
				setVisible(false);
				screen.display();
			}
		});
		btnCancel.setBounds(653, 439, 117, 25);
		contentPane.add(btnCancel);
		
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EditUserView screen = new EditUserView(loggedId);
				screen.display();
			}
		});
		btnEditUser.setBounds(12, 51, 117, 25);
		contentPane.add(btnEditUser);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);        
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(500,500));
    }
}
