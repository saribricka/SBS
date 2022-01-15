package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CashierView extends JFrame{

	private static final long serialVersionUID = -392773556724218338L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CashierView() {
//		File logoImage = new File("SalesScreen.png");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Cashier register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); 

		setBounds(620, 280, 458, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInvoiceLookup = new JButton("Invoice Lookup");
		btnInvoiceLookup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInvoiceLookup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceLookupView screen = new InvoiceLookupView();
				setVisible(false);
				screen.display();
			}			
		});
		btnInvoiceLookup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInvoiceLookup.setBounds(32, 85, 153, 25);
		contentPane.add(btnInvoiceLookup);
		

		
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
		
		JLabel lblNewLabel = new JLabel("");
//		File SalesScreen = new File("SalesScreen.png");
//		String SalesScreenPath = SalesScreen.getPath();
//		lblNewLabel.setIcon(new ImageIcon(SalesScreenPath));
		lblNewLabel.setBounds(-12, 138, 1024, 264);
		contentPane.add(lblNewLabel);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);        
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(500,500));
    }

}
