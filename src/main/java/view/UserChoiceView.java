package main.java.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserChoiceView extends JFrame {		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserChoiceView frame = new UserChoiceView();
			frame.pack();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Create the frame.
	 */
	public UserChoiceView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel(new FlowLayout());
		setContentPane(contentPane);
		
		JLabel aminLbl = new JLabel("",JLabel.CENTER );
		
		JButton adminBtn = new JButton("Admin");
		JButton cashierBtn = new JButton("Cashier");
		
		contentPane.add(adminBtn);
		contentPane.add(cashierBtn);
	}

}
