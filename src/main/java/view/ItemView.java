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

public class ItemView extends JFrame{

	private static final long serialVersionUID = -8594745175203264477L;
	private JPanel contentPane;
	private UserController userController = new UserControllerImpl(); 

	/**
	 * Create the frame.
	 */
	public ItemView(final int loggedId) {
		userController.setUserLogged(loggedId);
		setTitle("Product Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 905, 566);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddUser = new JButton("Add Product");
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddItemView screen = new AddItemView(loggedId);
				setVisible(false);
				screen.display();			
			}
		});
		btnAddUser.setBounds(12, 13, 137, 25);
		contentPane.add(btnAddUser);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagementView screen = new ManagementView(loggedId);
				setVisible(false);
				screen.display();
			}
		});
		btnCancel.setBounds(739, 480, 137, 25);
		contentPane.add(btnCancel);
		
		JButton btnEditUser = new JButton("Edit Product");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditItemView screen = new EditItemView(loggedId);
				setVisible(false);
				screen.display();
			}
		});
		btnEditUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditUser.setBounds(12, 51, 137, 25);
		contentPane.add(btnEditUser);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);     
        setLocationRelativeTo(null);   
        setMinimumSize(new Dimension(500,500));
    }
}
