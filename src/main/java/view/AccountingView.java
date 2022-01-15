package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AccountingView extends JFrame{

	private static final long serialVersionUID = 8308931027188591302L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AccountingView() {
//		File logoImage = new File("Accounting.png");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Accounting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 744, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(609, 527, 117, 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagementView screen = new ManagementView();
				setVisible(false);
				screen.display();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCancel);
		
		JButton btnSalaries = new JButton("Salaries");
		btnSalaries.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalaries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SalaryView screen= new SalaryView();
				screen.display();
			}
		});
		btnSalaries.setBounds(27, 66, 161, 25);
		contentPane.add(btnSalaries);
		
		JButton btnProfitLost = new JButton("Profit Lost");
		btnProfitLost.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProfitLost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ReportView screen= new ReportView();
				screen.display();			
			}
		});
		btnProfitLost.setBounds(27, 29, 161, 25);
		contentPane.add(btnProfitLost);
		
		JButton btnPaymentMethood = new JButton("Inventory Report");
		btnPaymentMethood.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPaymentMethood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StockReportView screen= new StockReportView();
				screen.display();
			}
		});
		btnPaymentMethood.setBounds(27, 105, 161, 25);
		contentPane.add(btnPaymentMethood);
		
		JLabel lblPicture = new JLabel("");
//		File AccountingScreen = new File("Accounting.png");
//		String AccountingScreenPath = AccountingScreen.getPath();
//		lblPicture.setIcon(new ImageIcon(AccountingScreenPath));
		lblPicture.setBounds(200, 0, 526, 534);
		contentPane.add(lblPicture);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);      
        setLocationRelativeTo(null);  
        setMinimumSize(new Dimension(500,500));
    }
}
