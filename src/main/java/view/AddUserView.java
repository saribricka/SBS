package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Optional;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import main.java.controller.ItemController;
import main.java.controller.ItemControllerImpl;
import main.java.controller.UserController;
import main.java.controller.UserControllerImpl;
import main.java.model.ItemCategory;
import main.java.model.ItemImpl;
import main.java.model.User;
import main.java.model.UserImpl;
import main.java.model.UserRole;

public class AddUserView extends JFrame{
	private JPanel contentPane;
	private JTextField textField_Id;
	private JTextField textField_Name;
	private JTextField textField_LastName;
	private JTextField textField_City;
	private JTextField textField_Description;
	private JComboBox comboBox_Role = new JComboBox();

	private String name, lastname, city, description;
	private UserRole role;
	private int id;
	
	public AddUserView() {
//		File logoImage = new File("AddUserView.png");
//		String imagePath = logoImage.getPath();
//		setIconImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		setTitle("Add User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID: *");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(12, 13, 79, 22);
		contentPane.add(lblId);
		
		JLabel lblFirstName = new JLabel("Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(12, 48, 79, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("LastName:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(12, 81, 100, 22);
		contentPane.add(lblLastName);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCity.setBounds(12, 116, 80, 22);
		contentPane.add(lblCity);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRole.setBounds(12, 151, 80, 22);
		contentPane.add(lblRole);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(12, 186, 100, 22);
		contentPane.add(lblDescription);		
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UserView screen = new UserView();
				screen.display();				
			}
		});
		btnBack.setBounds(395, 375, 97, 25);
		contentPane.add(btnBack);
		
		NumberFormatter intFormatter = new NumberFormatter(NumberFormat.getInstance());
		intFormatter.setValueClass(Integer.class);
	    intFormatter.setMinimum(0);
	    intFormatter.setMaximum(Integer.MAX_VALUE);
	    intFormatter.setAllowsInvalid(false);
	    textField_Id = new JFormattedTextField(intFormatter);
		textField_Id.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Id.setColumns(10);
		textField_Id.setBounds(143, 12, 144, 22);
		contentPane.add(textField_Id);		
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Name.setColumns(10);
		textField_Name.setBounds(143, 47, 144, 22);
		contentPane.add(textField_Name);
			
		textField_LastName = new JTextField();
		textField_LastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(143, 80, 144, 22);
		contentPane.add(textField_LastName);
		
		textField_City = new JTextField();
		textField_City.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_City.setColumns(10);
		textField_City.setBounds(143, 115, 144, 22);
		contentPane.add(textField_City);
		
		comboBox_Role.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_Role.setModel(new DefaultComboBoxModel(new String[] {"Select", "Manager", "Cashier", "Customer"}));
		comboBox_Role.setBounds(143, 151, 144, 22);
		contentPane.add(comboBox_Role);
		
		textField_Description = new JTextField();
		textField_Description.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Description.setColumns(10);
		textField_Description.setBounds(143, 186, 144, 50);
		contentPane.add(textField_Description);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					id = Integer.parseInt(textField_Id.getText());
					name = textField_Name.getText();	
					lastname = textField_LastName.getText();	
					city = textField_City.getText();
					role = UserRole.valueOf(String.valueOf(comboBox_Role.getSelectedItem()).toUpperCase());
					description = textField_Description.getText();
					
					UserController controller = new UserControllerImpl();	
					User user = new UserImpl.UserBuilder(id)
							.name(name)
							.lastname(lastname)
			                .city(city)
			                .role(role)
			                .description(description)
			                .build();
					
					if (controller.addUser(user)) {
						textField_Id.setText("0");
						textField_Name.setText("");
						textField_LastName.setText("");
						textField_City.setText("");
						comboBox_Role.setSelectedIndex(0);
						textField_Description.setText("");
						JOptionPane.showMessageDialog(null, "The User was added to the database");
					} else {
						textField_Id.setText("0");					
						JOptionPane.showMessageDialog(null, "The ID is already in the database");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
		});
		btnAdd.setBounds(395, 48, 97, 25);
		contentPane.add(btnAdd);
		
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
