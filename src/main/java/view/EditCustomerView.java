package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

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

import main.java.controller.UserController;
import main.java.controller.UserControllerImpl;
import main.java.model.User;
import main.java.model.UserImpl;
import main.java.model.UserRole;

public class EditCustomerView extends JFrame{

	private static final long serialVersionUID = -5302446014220983539L;
	private JPanel contentPane;
	private JTextField textField_Id;
	private JTextField textField_Psw;
	private JTextField textField_Name;
	private JTextField textField_LastName;
	private JTextField textField_City;
	private JTextField textField_Description;
	private JComboBox<UserRole> comboBox_Role = new JComboBox<>();
	
	private UserController userController = new UserControllerImpl();
	
	private String password, name, lastname, city, description;
	private UserRole role;
	private int id;
	
	/**
	 * Create the frame.
	 */
	public EditCustomerView(final int loggedId) {
			userController.setUserLogged(loggedId);
		setTitle("Edit Customer");
		getContentPane().setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 280, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("ID: *");
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserid.setBounds(10, 43, 80, 22);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(10, 82, 100, 22);
		contentPane.add(lblPassword);
		
		JLabel lblFirstName = new JLabel("Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(10, 115, 80, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(10, 148, 120, 22);
		contentPane.add(lblLastName);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCity.setBounds(10, 185, 80, 22);
		contentPane.add(lblCity);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRole.setBounds(10, 224, 80, 22);
		contentPane.add(lblRole);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(10, 257, 100, 22);
		contentPane.add(lblDescription);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				CustomerView screen = new CustomerView(loggedId);
				screen.display();
			}
		});
		btnBack.setBounds(400, 350, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblComment = new JLabel("Please fill ID and click Search");
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComment.setBounds(10, 11, 240, 22);
		contentPane.add(lblComment);
		
		NumberFormatter intFormatter = new NumberFormatter(NumberFormat.getInstance());
		intFormatter.setValueClass(Integer.class);
	    intFormatter.setMinimum(0);
	    intFormatter.setMaximum(Integer.MAX_VALUE);
	    intFormatter.setAllowsInvalid(false);
	    textField_Id = new JFormattedTextField(intFormatter);
		textField_Id.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Id.setColumns(10);
		textField_Id.setBounds(131, 43, 161, 22);
		contentPane.add(textField_Id);
		
		textField_Psw = new JTextField();
		textField_Psw.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Psw.setEditable(false);
		textField_Psw.setColumns(10);
		textField_Psw.setBounds(131, 80, 161, 22);
		contentPane.add(textField_Psw);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Name.setColumns(10);
		textField_Name.setBounds(131, 111, 161, 22);
		contentPane.add(textField_Name);
		
		textField_LastName = new JTextField();
		textField_LastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(131, 145, 161, 22);
		contentPane.add(textField_LastName);
		
		textField_City = new JTextField();
		textField_City.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_City.setColumns(10);
		textField_City.setBounds(131, 180, 161, 22);
		contentPane.add(textField_City);
		
		comboBox_Role.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_Role.setModel(new DefaultComboBoxModel(UserRole.values()));
		comboBox_Role.setSelectedItem(UserRole.CUSTOMER);
		comboBox_Role.setEnabled(false);
		comboBox_Role.setBounds(131, 217, 161, 22);
		contentPane.add(comboBox_Role);
		
		textField_Description = new JTextField();
		textField_Description.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Description.setColumns(10);
		textField_Description.setBounds(131, 250, 161, 50);
		contentPane.add(textField_Description);
			
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String strId = textField_Id.getText();
					if (!strId.isBlank()) {
						id = Integer.parseInt(strId);
						
						var foundUser = userController.searchUser(id);
						if ((foundUser != null) && (foundUser.getRole().equals(UserRole.CUSTOMER))) {						
							password = textField_Psw.getText();
							name = textField_Name.getText();	
							lastname = textField_LastName.getText();	
							city = textField_City.getText();
							role = UserRole.valueOf(String.valueOf(comboBox_Role.getSelectedItem()).toUpperCase());
							description = textField_Description.getText();
												
							User user = new UserImpl.UserBuilder(id, password)
									.name(name)
									.lastname(lastname)
					                .city(city)
					                .role(role)
					                .description(description)
					                .build();
							
							userController.updateUser(user);
													
							JOptionPane.showMessageDialog(null, "The Customer was updated");
						} else {						
							JOptionPane.showMessageDialog(null, "The Customer was not found");
						}
					} else {						
						JOptionPane.showMessageDialog(null, "The Customer Id must be filled");
					}	
					textField_Id.setText("0");
					textField_Psw.setText("");
					textField_Name.setText("");
					textField_LastName.setText("");
					textField_City.setText("");
					textField_Description.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		}});
		btnUpdate.setBounds(400, 181, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					id = Integer.parseInt(textField_Id.getText());
					
					var foundUser = userController.searchUser(id);
					if ((foundUser != null) && (foundUser.getRole().equals(UserRole.CUSTOMER))) {
						boolean check = userController.deleteUser(id);						
						if(check) {														
							JOptionPane.showMessageDialog(null, "The Customer was successfully deleted");
						}
					} else {
						JOptionPane.showMessageDialog(null, "The Customer was not found");
					}
					textField_Id.setText("0");
					textField_Psw.setText("");
					textField_Name.setText("");
					textField_LastName.setText("");
					textField_City.setText("");
					textField_Description.setText("");
				} catch (Exception ex) {
					ex.printStackTrace();
				}								
			}
		});
		btnDelete.setBounds(400, 249, 89, 23);
		contentPane.add(btnDelete);
		

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					id = Integer.parseInt(textField_Id.getText());
					
					User foundUser = userController.searchUser(id); 
					
					if ((foundUser != null) && (foundUser.getRole().equals(UserRole.CUSTOMER))) {
						textField_Id.setText(String.valueOf(foundUser.getId()));
						textField_Psw.setText(foundUser.getPassword());
						textField_Name.setText(foundUser.getName());
						textField_LastName.setText(foundUser.getLastname());
						textField_City.setText(foundUser.getCity().get());
						textField_Description.setText(foundUser.getDescription().get());
						comboBox_Role.setSelectedItem(UserRole.CUSTOMER);			
					} else {						
						textField_Id.setText("0");
						textField_Psw.setText("");
						textField_Name.setText("");
						textField_LastName.setText("");
						textField_City.setText("");
						textField_Description.setText("");
						JOptionPane.showMessageDialog(null, "The Customer was not found");					
					}																			
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(400, 43, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_Id.setText("0");
				textField_Psw.setText("");
				textField_Name.setText("");
				textField_LastName.setText("");
				textField_City.setText("");
				textField_Description.setText("");
			}
		});
		btnClear.setBounds(400, 115, 89, 23);
		contentPane.add(btnClear);	
	}
	
	public void display() {
        setVisible(true);
        setResizable(true);   
        setLocationRelativeTo(null);     
        setMinimumSize(new Dimension(500,500));
    }
}
