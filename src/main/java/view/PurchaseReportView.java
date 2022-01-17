package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import main.java.controller.ShopController;
import main.java.controller.ShopControllerImpl;
import main.java.controller.UserController;
import main.java.controller.UserControllerImpl;

public class PurchaseReportView extends JFrame{

	private static final long serialVersionUID = -48307813456949410L;
	private JPanel contentPane;
	private ShopController shopController = new ShopControllerImpl();
	private UserController userController = new UserControllerImpl(); 
	
	public PurchaseReportView(final int loggedId) {
		userController.setUserLogged(loggedId);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(620, 280, 850, 650);
		setTitle("Salaries Report");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Purchase Report");
		
		JButton btnCloseReport = new JButton("Close Report");
		btnCloseReport.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCloseReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				}
		});
		btnCloseReport.setBounds(675, 554, 125, 25);
		contentPane.add(btnCloseReport);
		
		JLabel label_top = new JLabel("Purchase Management Systems Report");			
		label_top.setFont(new Font("Tahoma", Font.BOLD, 18));					
		label_top.setBounds(50, 10, 450, 30);									
		contentPane.add(label_top);												
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 53, 766, 488);
		contentPane.add(scrollPane);
																				 
		JTextArea Purchase_Area = new JTextArea();									
		scrollPane.setViewportView(Purchase_Area);
		Purchase_Area.setEditable(false);
		Purchase_Area.setFont(new Font("Tahoma", Font.BOLD, 14));	
		String row = "Date" + "\t\t" + "User Id" + "\t" + "User Fullname" + "\t\t" + "TotPayed" + "\n\n";
		Purchase_Area.setText(row);
		Set<String> purchase = shopController.showPayments();
		for (String u : purchase) {
			Purchase_Area.append(u + "\n");
		}		
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try
				{
						Purchase_Area.print();	
				}
				
				catch (java.awt.print.PrinterException e2)
				{
					System.err.format("No Printer Found", e2.getMessage());
				}

			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPrint.setBounds(566, 554, 97, 25);
		contentPane.add(btnPrint);	
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AccountingView screen = new AccountingView(loggedId);
				screen.display();
			}
		});
		btnBack.setBounds(34, 554, 97, 25);
		contentPane.add(btnBack);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);     
        setLocationRelativeTo(null);   
        setMinimumSize(new Dimension(500,500));
    }
}
