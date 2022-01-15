package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ReportView extends JFrame{

	private static final long serialVersionUID = 1066914862981666048L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public ReportView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 500, 850, 650);
		setTitle("Report Screen");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		JButton btnCloseReport = new JButton("Close Report");
		btnCloseReport.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCloseReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				}
		});
		btnCloseReport.setBounds(675, 554, 125, 25);
		contentPane.add(btnCloseReport);
		
		JLabel label_top = new JLabel("HIT Mart Managment Systems");			
		label_top.setFont(new Font("Tahoma", Font.BOLD, 18));					
		label_top.setBounds(51, 9, 285, 31);									
		contentPane.add(label_top);												
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 53, 766, 488);
		contentPane.add(scrollPane);
																				 
		JTextArea text_ReportScreen = new JTextArea();									
		scrollPane.setViewportView(text_ReportScreen);
		text_ReportScreen.setFont(new Font("Tahoma", Font.BOLD, 14));					
		text_ReportScreen.setText("text area");
	
		
//		text_ReportScreen.setText(.getReport());
		
		JButton btnSaveReport = new JButton("Save Report");
		btnSaveReport.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSaveReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveReport.setBounds(429, 554, 125, 25);
		contentPane.add(btnSaveReport);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			{
					text_ReportScreen.print();	
			}
			
			catch (java.awt.print.PrinterException e4)
			{
				System.err.format("No Printer Found", e4.getMessage());
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
				AccountingView screen = new AccountingView();
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
