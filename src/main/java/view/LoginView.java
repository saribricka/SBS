package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;

public class LoginView extends JPanel {

	/**
	 * Create the panel.
	 */
	public LoginView() {
		setLayout(new BorderLayout());
		
		JLabel userLbl = new JLabel("Username");
		userLbl.setBounds(100, 25, 70, 25);
		this.add(userLbl);

		JTextField userText = new JTextField();
		userText.setBounds(100, 50, 200, 30);
		this.add(userText);
		
		// Password Label constructor
		JLabel pswLbl = new JLabel("Password");
		pswLbl.setBounds(100, 85, 70, 25);
		this.add(pswLbl);

		JTextField pswText = new JPasswordField();
		pswText.setBounds(100, 110, 200, 30);
		this.add(pswText);
		
		JButton logBtn = new JButton("Login");
		logBtn.setBounds(80, 200, 90, 30);
		logBtn.setBorder(new LineBorder(Color.BLACK));
		logBtn.setForeground(Color.BLACK);
		logBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String username = userText.getText();
				String password = pswText.getText();
				System.out.println(username + password);

				if (username.equals("section.io") && password.equals("123")) {
					JOptionPane.showMessageDialog(null, "Login Successful");
				}					
				else {
					JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
				}					
			}
		});
		this.add(logBtn);
	}
	

}
