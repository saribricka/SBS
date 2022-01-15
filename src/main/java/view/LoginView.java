package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

public class LoginView extends JFrame {

	private static final long serialVersionUID = -72099129895597800L;
	private JPanel contentPane;
	private JTextField JTextField_Username;
	int attempts = 3;
	private JPasswordField JPassword;
	
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
		
		JLabel lblUsername = new JLabel("Username");
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
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxShowPassword.addActionListener(new ActionListener() {
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
			public void actionPerformed(ActionEvent arg0) {
				String Username = JTextField_Username.getText();
				String Password = JPassword.getText();
				while(attempts != 0) 
				{						
				if (Username.equals ("A") && Password.equals ("A"))
				{
					HomeView mMenu =new HomeView(true);{
						setVisible(false);
						mMenu.repaint();
						mMenu.display();
					}
				}
										
				else
				{
					attempts--;
					JOptionPane.showMessageDialog(null, "Invalid username or password "+ attempts+" attempts remaning");
					if (attempts == 0) 
					{
						JOptionPane.showMessageDialog(null, "Please Contact maintenance");
						System.exit(0);
					}
				}
				return;
				}
				
				}});
		btnLogin.setBounds(140, 320, 120, 40);
		contentPane.add(btnLogin);
		
		
		JButton btnCancel = new JButton("Exit");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);;
			}
		});
		btnCancel.setBounds(280, 320, 120, 40);
		contentPane.add(btnCancel);
		
		JLabel lblPicture = new JLabel("");
//		File logoImage = new File("project_logo.png");
//		String imagePath = logoImage.getPath();
//		lblPicture.setIcon(new ImageIcon(imagePath));
		lblPicture.setBounds(235, 67, 356, 291);
		contentPane.add(lblPicture);
		
		JPassword = new JPasswordField();
		JPassword.setBounds(250, 150, 120, 25);
		contentPane.add(JPassword);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane jopt = new JOptionPane();
			    String result;
			    result = "Please Call Maintenance";
			    JLabel resLabel = new JLabel(result);
			    resLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
			    jopt.showMessageDialog( null, resLabel);
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
//		btnNewButton.setIcon(new ImageIcon(LoginView.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-information.png")));
		btnNewButton.setBounds(533, 13, 37, 41);
		contentPane.add(btnNewButton);
	}
	
	private static boolean login(String Username,String Password)
	{
		File file = new File("UsersLogin.txt");
		try
		{		
			Scanner input = new Scanner (file);
			String data;
			String [] sub_data;
			
			while(input.hasNext())
			{
				data=input.nextLine();
				sub_data = data.split(",");
			
			if (sub_data[0].equals(Username) && sub_data[1].equals(Password))
			{
				return true;
			}
			else 
				return false;
			}
		}
	
		catch (IOException e)
		{
			System.out.println("Error" +e);
		}
		
		return false;
	}
	
	public void display() {
		setVisible(true);
        setResizable(true);      
        setLocationRelativeTo(null);  
        setMinimumSize(new Dimension(500,500));
    }
	

}
