package main.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Home extends JFrame{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
				Home window = new Home();
				window.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}			
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new LoginView();
		frame.setContentPane(panel);
	}

}
