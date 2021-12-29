package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;

public class LoginView extends JFrame {

	private JFrame frmLogin;
	private JTextField usrname;
	int attempts = 3;
	private JPasswordField psw;
	
	public LoginView() {
		frmLogin = new JFrame();
//		File logoImage = new File("project_logo.png");
//		String imagePath = logoImage.getPath();
//		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		frmLogin.setFont(new Font("Serif", Font.BOLD, 14));
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setBounds(620, 280, 600, 400);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToHitpos = new JLabel("Welcome to SBS");
		lblWelcomeToHitpos.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 20));
		lblWelcomeToHitpos.setBounds(159, 13, 303, 51);
		frmLogin.getContentPane().add(lblWelcomeToHitpos);
		
		JLabel lblPleaseSignIn = new JLabel("Please sign in");
		lblPleaseSignIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPleaseSignIn.setBounds(39, 81, 139, 41);
		frmLogin.getContentPane().add(lblPleaseSignIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(12, 123, 121, 33);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(12, 157, 121, 33);
		frmLogin.getContentPane().add(lblPassword);
		
		usrname = new JTextField();
		usrname.setBounds(107, 128, 116, 22);
		frmLogin.getContentPane().add(usrname);
		usrname.setColumns(10);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 if(chckbxShowPassword.isSelected())
			 {
				 psw.setEchoChar((char)0);
			 }else
			 {
				psw.setEchoChar('*');
			 }
			}
		});
		chckbxShowPassword.setBackground(Color.WHITE);
		chckbxShowPassword.setBounds(107, 200, 139, 25);
		frmLogin.getContentPane().add(chckbxShowPassword);
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Username = usrname.getText();
				String Password = psw.getText();
				while(attempts != 0) 
				{						
				if (Username.equals ("A") && Password.equals ("A"))
				{
					HomeView mMenu =new HomeView(true);{
						frmLogin.setVisible(false);
						mMenu.repaint();
						mMenu.display();
					}
				}
										
				else
				{
					attempts--;
					JOptionPane.showMessageDialog(frmLogin, "Invalid username or password "+ attempts+" attempts remaning");
					if (attempts == 0) 
					{
						JOptionPane.showMessageDialog(frmLogin, "Please Contact maintenance");
						System.exit(0);
					}
				}
				return;
				}
				
				}});
		btnLogin.setBounds(39, 240, 116, 41);
		frmLogin.getContentPane().add(btnLogin);
		
		
		JButton btnCancel = new JButton("Exit");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);;
			}
		});
		btnCancel.setBounds(183, 240, 121, 41);
		frmLogin.getContentPane().add(btnCancel);
		
		JLabel lblPicture = new JLabel("");
//		File logoImage = new File("project_logo.png");
	//	String imagePath = logoImage.getPath();
//		lblPicture.setIcon(new ImageIcon(imagePath));
		lblPicture.setBounds(235, 67, 356, 291);
		frmLogin.getContentPane().add(lblPicture);
		
		psw = new JPasswordField();
		psw.setBounds(105, 158, 118, 22);
		frmLogin.getContentPane().add(psw);
		
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
		frmLogin.getContentPane().add(btnNewButton);
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
		frmLogin.setVisible(true);
		frmLogin.setResizable(true);     
        setLocationRelativeTo(null);   
		frmLogin.setMinimumSize(new Dimension(500,500));
        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frmLogin.setSize((int) (dimension.getWidth()*(0.6)) , (int)(dimension.getHeight() * 0.6));
    }
	

}
