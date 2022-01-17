package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.java.controller.UserController;
import main.java.controller.UserControllerImpl;
import main.java.model.User;
import main.java.model.UserRole;

import java.awt.event.*;

public class LoginView extends JFrame {

	private static final long serialVersionUID = -72099129895597800L;
	private JPanel contentPane;
	private JTextField JTextField_Username;
	private JPasswordField JPassword;
	private UserController userController = new UserControllerImpl();
	
	public LoginView() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToHitpos = new JLabel("Welcome to SBS");
		lblWelcomeToHitpos.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 20));
		lblWelcomeToHitpos.setBounds(200, 15, 300, 60);
		contentPane.add(lblWelcomeToHitpos);
		
		JLabel lblUsername = new JLabel("User ID");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(175, 115, 100, 45);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(175, 145, 100, 45);
		contentPane.add(lblPassword);
		
		JTextField_Username = new JTextField();
		JTextField_Username.setBounds(250, 120, 120, 25);
		contentPane.add(JTextField_Username);
		JTextField_Username.setColumns(10);
		
		JPassword = new JPasswordField();
		JPassword.setBounds(250, 150, 120, 25);
		contentPane.add(JPassword);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxShowPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			 if(chckbxShowPassword.isSelected())
			 {
				 JPassword.setEchoChar((char)0);
			 }else
			 {
				JPassword.setEchoChar('*');
			 }
			}
		});
		chckbxShowPassword.setBackground(Color.WHITE);
		chckbxShowPassword.setBounds(200, 250, 140, 25);
		contentPane.add(chckbxShowPassword);				
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userId_input = JTextField_Username.getText();
				String psw_input = String.valueOf(JPassword.getPassword());
				boolean checkIdDb = false;
				
				Set<String> ides_db = userController.getAllId();
				for(String strId : ides_db) {
					if (userId_input.equals(strId)) {
						checkIdDb = true;
						int id = Integer.parseInt(strId);
						User u = userController.searchUser(id);
						String psw_db = u.getPassword();
						if (psw_db.equals(psw_input) && (!u.getRole().equals(UserRole.CUSTOMER))) {
							userController.setUserLogged(id);
							HomeView menu =new HomeView(id);
							setVisible(false);
							menu.repaint();
							menu.display();							
						} else {
							JOptionPane.showMessageDialog(null, "No authorization!");
						}
					}
				}
				if(!checkIdDb) {
					JOptionPane.showMessageDialog(null, "User not found!");
				}
			}
		});
		btnLogin.setBounds(140, 320, 120, 40);
		contentPane.add(btnLogin);
		
		
		JButton btnCancel = new JButton("Exit");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			System.exit(0);;
			}
		});
		btnCancel.setBounds(280, 320, 120, 40);
		contentPane.add(btnCancel);
				
		JButton btnHelp = new JButton("?");
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    JLabel resLabel = new JLabel("Please Call Maintenance");
			    String help = "HELP";
			    JOptionPane.showMessageDialog(null, resLabel, help, JOptionPane.QUESTION_MESSAGE);				
			}
		});
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setBackground(Color.BLUE);
		btnHelp.setBounds(533, 13, 50, 50);
		contentPane.add(btnHelp);
	}
	
	public void display() {
		setVisible(true);
        setResizable(true);      
        setLocationRelativeTo(null);  
        setMinimumSize(new Dimension(500,500));
    }
	

}
