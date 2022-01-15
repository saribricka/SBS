package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import main.java.controller.ItemController;
import main.java.controller.ItemControllerImpl;

public class ItemReportView extends JFrame{

	private static final long serialVersionUID = -5942256959100595530L;
	private JPanel contentPane;
	
	private ItemController itemController = new ItemControllerImpl();

	/**
	 * Create the frame.
	 */
	public ItemReportView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(620, 280, 850, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Item Report");
		
		JButton btnCloseReport = new JButton("Close Report");
		btnCloseReport.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCloseReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				}
		});
		btnCloseReport.setBounds(675, 554, 125, 25);
		contentPane.add(btnCloseReport);
		
		JLabel label_top = new JLabel("Item Managment Systems Report");			
		label_top.setFont(new Font("Tahoma", Font.BOLD, 18));					
		label_top.setBounds(50, 10, 320, 30);									
		contentPane.add(label_top);												
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 53, 766, 488);
		contentPane.add(scrollPane);
																				 
		JTextArea Item_Area = new JTextArea();									
		scrollPane.setViewportView(Item_Area);
		Item_Area.setEditable(false);
		Item_Area.setFont(new Font("Tahoma", Font.BOLD, 14));
		String row = "Id" + "\t" + "Product" + "\t" + "Category" + "\t" + "Quantity" + "\t" + "UnitPrice" + "\n\n";
		Item_Area.setText(row);
		Set<String> unsold = itemController.showUnsold();
		for (String u : unsold) {
			Item_Area.append(u);
		}
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Item_Area.print();	
				} catch (PrinterException e3) {
					JOptionPane.showMessageDialog(null, "No Printer Found");
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
