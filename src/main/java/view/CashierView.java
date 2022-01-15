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

public class CashierView extends JFrame{

	private static final long serialVersionUID = -392773556724218338L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CashierView() {
		setTitle("Cashier register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 458, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnInvoiceScreen = new JButton("Invoice Screen");
		btnInvoiceScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceView screen = new InvoiceView();
				setVisible(false);
				screen.display();
			}
		});
		btnInvoiceScreen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInvoiceScreen.setBounds(32, 35, 153, 25);
		contentPane.add(btnInvoiceScreen);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				HomeView screen = new HomeView(true);
				screen.display();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(268, 356, 151, 25);
		contentPane.add(btnBack);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);        
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(500,500));
    }

}
