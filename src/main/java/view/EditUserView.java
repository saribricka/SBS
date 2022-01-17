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

import main.java.controller.UserController;
import main.java.controller.UserControllerImpl;
import main.java.model.User;
import main.java.model.UserImpl;
import main.java.model.UserRole;

public class EditUserView extends JFrame{

	private static final long serialVersionUID = 7857713318260675481L;
	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Psw;
	private JTextField textField_LastName;
	private JTextField textField_City;
	private JTextField textField_Description;
	private JComboBox<UserRole> comboBox_Role;
	private JComboBox<Integer> comboBox_UserId;
	
	private UserController controller = new UserControllerImpl();
	private UserController userController = new UserControllerImpl(); 
	
	
	private String name, password, lastname, city, description;
	private UserRole role;
	private int id;
	
	/**
	 * Create the frame.
	 */
	public EditUserView(final int loggedId) {
		userController.setUserLogged(loggedId);
		setTitle("Edit Users");
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
				UserView screen = new UserView(loggedId);
				screen.display();
			}
		});
		btnBack.setBounds(400, 350, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPleaseFillId = new JLabel("Please fill ID and click Search");
		lblPleaseFillId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseFillId.setBounds(10, 11, 240, 22);
		contentPane.add(lblPleaseFillId);
		
		comboBox_UserId = new JComboBox<>();
		Object[] idArray = controller.getAllId().toArray();
		comboBox_UserId.setModel(new DefaultComboBoxModel(idArray));
		comboBox_UserId.setBounds(131, 43, 161, 22);
		contentPane.add(comboBox_UserId);
		
		textField_Psw = new JTextField();
		textField_Psw.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Psw.setEditable(false);
		textField_Psw.setColumns(10);
		textField_Psw.setBounds(131, 77, 161, 22);
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
		textField_City.setBounds(131, 179, 161, 22);
		contentPane.add(textField_City);
		
		comboBox_Role = new JComboBox<>();
		comboBox_Role.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_Role.setModel(new DefaultComboBoxModel(UserRole.values()));
		comboBox_Role.setBounds(131, 213, 161, 22);
		contentPane.add(comboBox_Role);
		
		textField_Description = new JTextField();
		textField_Description.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Description.setColumns(10);
		textField_Description.setBounds(131, 247, 161, 50);
		contentPane.add(textField_Description);
			
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					id = Integer.parseInt(String.valueOf(comboBox_UserId.getSelectedItem()));
					
					if(controller.searchUser(id) == null) {
						comboBox_UserId.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "The User was not found");
					} else {
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
						
						controller.updateUser(user);
						
						comboBox_UserId.setSelectedIndex(0);
						textField_Psw.setText("");
						textField_Name.setText("");
						textField_LastName.setText("");
						comboBox_Role.setSelectedIndex(0);
						textField_City.setText("");
						textField_Description.setText("");
						JOptionPane.showMessageDialog(null, "The User was updated");
					}										
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
					id = Integer.parseInt(String.valueOf(comboBox_UserId.getSelectedItem()));
					
					boolean check = controller.deleteUser(id);
					
					if(!check) {
						JOptionPane.showMessageDialog(null, "The User was not found");
					} else {								
						JOptionPane.showMessageDialog(null, "The User was successfully deleted");
						Object[] idArray = controller.getAllId().toArray();
						comboBox_UserId.setModel(new DefaultComboBoxModel(idArray));
					}	
					comboBox_UserId.setSelectedIndex(0);
					textField_Psw.setText("");
					textField_Name.setText("");
					textField_LastName.setText("");
					comboBox_Role.setSelectedIndex(0);
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
					id = Integer.parseInt(String.valueOf(comboBox_UserId.getSelectedItem()));
					
					User foundUser = controller.searchUser(id);
					
					if(foundUser == null) {
						comboBox_UserId.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "The User was not found");
					} else {
						textField_Psw.setText(foundUser.getPassword());
						textField_Name.setText(foundUser.getName());
						textField_LastName.setText(foundUser.getLastname());
						textField_City.setText(foundUser.getCity().get());
						textField_Description.setText(foundUser.getDescription().get());
						
						for(int i=0; i<comboBox_Role.getItemCount(); i++) {
							if(comboBox_Role.getItemAt(i).equals(foundUser.getRole())) {
								comboBox_Role.setSelectedIndex(i);
							}
						}						
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
				comboBox_UserId.setSelectedIndex(0);
				textField_Psw.setText("");
				textField_Name.setText("");
				textField_LastName.setText("");
				comboBox_Role.setSelectedIndex(0);
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
