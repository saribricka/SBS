package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomeView extends JFrame{

	private static final long serialVersionUID = 6847662332522983305L;
	private static final double PERCENT = 0.6;
	private JPanel contentPane;
	boolean visible=false;
	
	/**
	 * Create the frame.
	 */
	public HomeView(boolean faded) {
		setFont(new Font("Dialog", Font.PLAIN, 6));
		setTitle("Main Menu");
		setBackground(Color.WHITE);
//		File logoImage = new File("mainView.jpg");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 653, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCashier = new JButton("Cash register");
		btnCashier.setEnabled(faded);
		btnCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			CashierView cash=new CashierView();
			cash.display();
			}
		});
		
		JButton button = new JButton("");
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jopt = new JOptionPane();
			    String result;
			    result = "Developed by Sara Briccoli";
			    JLabel resLabel = new JLabel(result);
			    resLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
			    jopt.showMessageDialog( null, resLabel);
			}
		});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginView login = new LoginView();
				login.display();
			}
		});
		btnLogin.setFont(new Font("Serif", Font.BOLD, 15));
		btnLogin.setBounds(12, 13, 79, 29);
		contentPane.add(btnLogin);
//		button.setIcon(new ImageIcon(HomeView.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		button.setForeground(Color.RED);
		button.setBackground(Color.WHITE);
		button.setBounds(585, 13, 50, 50);
		contentPane.add(button);
		btnCashier.setFont(new Font("Serif", Font.BOLD, 15));
		btnCashier.setBounds(194, 272, 129, 54);
		contentPane.add(btnCashier);
		
		JButton btnManagement = new JButton("Management");
		btnManagement.setEnabled(faded);
		btnManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementView manage = new ManagementView();
				setVisible(false);
				manage.display();				
			}
		});
		btnManagement.setFont(new Font("Serif", Font.BOLD, 15));
		btnManagement.setBounds(387, 272, 129, 54);
		contentPane.add(btnManagement);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		btnExit.setFont(new Font("Serif", Font.BOLD, 15));
		btnExit.setBounds(12, 55, 79, 29);
		contentPane.add(btnExit);
		
//		JLabel lblPicture = new JLabel("");
//		File MainMenuImage = new File("main_menu.jpg");
//		String MainMenuPath = MainMenuImage.getPath();
//		lblPicture.setIcon(new ImageIcon(MainMenuPath));
//		lblPicture.setBounds(0, 0, 647, 339);
//		contentPane.add(lblPicture);
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);        
        setMinimumSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (dimension.getWidth()*(HomeView.PERCENT)) , (int)(dimension.getHeight() * HomeView.PERCENT));
    }

}
