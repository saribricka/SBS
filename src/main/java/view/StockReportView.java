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

public class StockReportView extends JFrame{

	private static final long serialVersionUID = -5942256959100595530L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public StockReportView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(620, 280, 850, 650);
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
																				 
		JTextArea text_StockReport = new JTextArea();									
		scrollPane.setViewportView(text_StockReport);
		text_StockReport.setEditable(false);
		text_StockReport.setFont(new Font("Tahoma", Font.BOLD, 14));					
		text_StockReport.setText("text area");
	
		
//		text_StockReport.setText(.getStockReport());
		
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
					text_StockReport.print();	
			}
			
			catch (java.awt.print.PrinterException e3)
			{
				System.err.format("No Printer Found", e3.getMessage());
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
