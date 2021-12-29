package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddUserView extends JFrame{
	private JPanel contentPane;
	private JTextField textField_WorkerId;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_Email;
	private JTextField textField_Address;
	private JTextField textField_Phone;
	private int JListIndex = 0;

	JComboBox comboBox_Title = new JComboBox();
	JComboBox comboBox_Gender = new JComboBox();
	private JTextField textField_StartedWorkDay;
	private JTextField textField_DateOfBirth;

	
	public AddUserView() {
//		File logoImage = new File("AddUserView.png");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Details Of Users");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 868, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWorkerId = new JLabel("WorkerID:");
		lblWorkerId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWorkerId.setBounds(12, 13, 79, 22);
		contentPane.add(lblWorkerId);
		
		JLabel lblFirstName = new JLabel("FirstName:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(12, 48, 79, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("LastName:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(12, 81, 79, 22);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(12, 116, 79, 22);
		contentPane.add(lblEmail);
		
		JLabel lblStartedWorkDay = new JLabel("Started Work Day:");
		lblStartedWorkDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStartedWorkDay.setBounds(12, 151, 130, 22);
		contentPane.add(lblStartedWorkDay);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfBirth.setBounds(12, 186, 97, 22);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(12, 221, 68, 16);
		contentPane.add(lblAddress);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelephone.setBounds(12, 259, 79, 16);
		contentPane.add(lblTelephone);
		
		JLabel lblJob = new JLabel("Job:");
		lblJob.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJob.setBounds(12, 300, 56, 16);
		contentPane.add(lblJob);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(12, 335, 56, 16);
		contentPane.add(lblGender);
		

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UserView screen = new UserView();
				screen.display();				
			}
		});
		
		btnBack.setBounds(741, 475, 97, 25);
		contentPane.add(btnBack);
		
		textField_WorkerId = new JTextField();
		textField_WorkerId.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_WorkerId.setColumns(10);
		textField_WorkerId.setBounds(143, 12, 144, 22);
		contentPane.add(textField_WorkerId);
		
		
		textField_FirstName = new JTextField();
		textField_FirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_FirstName.setColumns(10);
		textField_FirstName.setBounds(143, 47, 144, 22);
		contentPane.add(textField_FirstName);
	
		
		textField_LastName = new JTextField();
		textField_LastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(143, 80, 144, 22);
		contentPane.add(textField_LastName);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Email.setColumns(10);
		textField_Email.setBounds(143, 115, 144, 22);
		contentPane.add(textField_Email);
		
		textField_Address = new JTextField();
		textField_Address.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Address.setBounds(143, 221, 144, 22);
		contentPane.add(textField_Address);
		
		textField_Phone = new JTextField();
		textField_Phone.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(143, 255, 144, 22);
		contentPane.add(textField_Phone);
		
		
		comboBox_Title.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_Title.setModel(new DefaultComboBoxModel(new String[] {"Select", "Manager", "Cashier", "Usher merchandise", "Stock keeper", "Security guard"}));
		comboBox_Title.setBounds(143, 296, 144, 22);
		contentPane.add(comboBox_Title);
		
		comboBox_Gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_Gender.setModel(new DefaultComboBoxModel(new String[] {"Select", "Male", "Female", "Non-binary"}));
		comboBox_Gender.setBounds(143, 331, 144, 22);
		contentPane.add(comboBox_Gender);
		

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error please check all filds date must be in fotmat: DD-MM-YYYY");
				}
			
			}
		});
		btnAdd.setBounds(12, 378, 97, 25);
		contentPane.add(btnAdd);	
		
		textField_StartedWorkDay = new JTextField();
		textField_StartedWorkDay.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_StartedWorkDay.setColumns(10);
		textField_StartedWorkDay.setBounds(143, 150, 144, 22);
		contentPane.add(textField_StartedWorkDay);
		
		textField_DateOfBirth = new JTextField();
		textField_DateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_DateOfBirth.setColumns(10);
		textField_DateOfBirth.setBounds(143, 185, 144, 22);
		contentPane.add(textField_DateOfBirth);
		
		JLabel lblPicture = new JLabel("");
//		File UsersAdd = new File("AddUserView.png");
//		String UserAddPath = UsersAdd.getPath();
//		lblPicture.setIcon(new ImageIcon(UserAddPath));
		lblPicture.setBounds(299, -3, 551, 465);
		contentPane.add(lblPicture);

	}
	
	public void display() {
        setVisible(true);
        setResizable(true);     
        setLocationRelativeTo(null);   
        setMinimumSize(new Dimension(500,500));
    }
}
