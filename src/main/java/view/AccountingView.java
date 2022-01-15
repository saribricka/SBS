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

public class AccountingView extends JFrame{

	private static final long serialVersionUID = 8308931027188591302L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AccountingView() {
		setTitle("Accounting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 744, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(610, 520, 117, 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagementView screen = new ManagementView();
				setVisible(false);
				screen.display();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCancel);
		
		JButton btnSalaries = new JButton("Purchase Report");
		btnSalaries.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalaries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PurchaseReportView screen= new PurchaseReportView();
				screen.display();
			}
		});
		btnSalaries.setBounds(27, 29, 160, 25);
		contentPane.add(btnSalaries);
		
		JButton btnPaymentMethood = new JButton("Inventory Report");
		btnPaymentMethood.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPaymentMethood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ItemReportView screen= new ItemReportView();
				screen.display();
			}
		});
		btnPaymentMethood.setBounds(27, 66, 160, 25);
		contentPane.add(btnPaymentMethood);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);      
        setLocationRelativeTo(null);  
        setMinimumSize(new Dimension(500,500));
    }
}
