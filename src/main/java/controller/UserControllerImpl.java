package main.java.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.platform.commons.util.StringUtils;

import main.java.model.Item;
import main.java.model.ItemCategory;
import main.java.model.ItemImpl;
import main.java.model.User;
import main.java.model.UserImpl;
import main.java.model.UserRole;
import main.java.model.file.FileItemImpl;
import main.java.model.file.FileStrategy;
import main.java.model.file.FileUserImpl;

public class UserControllerImpl implements UserController{

	private User user;
	private String name, lastname, description, city;
	private UserRole role;
	private int id;
	protected boolean isAdmin, isCustomer;
	
	private FileStrategy file = new FileUserImpl();
	private static UserControllerImpl single_instance = null;
	
	public static UserControllerImpl getInstance() {
		if(single_instance == null) {
			single_instance = new UserControllerImpl();
		}
		return single_instance;
	}
	
	@Override
	public boolean addUser(User newUser) {
		if (!exists(newUser.getId())) {	
			file.writeInFile(newUser.toString());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User searchUser(int userId) {
		String userLine = file.searchInFile(String.valueOf(userId));
		if (!StringUtils.isBlank(userLine)) {	
			User u = composeUser(userLine);
			return u;
		} else {
			return null;
		}
	}

	@Override
	public void updateUser(User updatedUser) {
		var id = updatedUser.getId();
		if (exists(id)) {
			deleteUser(id);
		}		
		addUser(updatedUser);
	}

	@Override
	public boolean deleteUser(int userId) {
		if (exists(userId)) {		
			file.deleteLine(String.valueOf(userId));
			return true;
		}
		return false;
	}
	
	private User composeUser(String userLine) {
		String[] data = userLine.split(";");
		
		id = Integer.parseInt(data[0]);
		name = data[1];
		lastname = data[2];
		description = data[3];
		role = UserRole.valueOf(data[4].toUpperCase());
		city = data[5];
		
		user = new UserImpl.UserBuilder(id)
				.name(name)
				.lastname(lastname)
                .city(city)
                .role(role)
                .description(description)
                .build();
		
		return user;		
	}
	
	private boolean exists(int id) {
		try {
			String strId = String.valueOf(id);
			String userLine = file.searchInFile(strId);
			if (!StringUtils.isBlank(userLine)) {	
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Set<String> getAllId() {
		Set<String> ls = file.getAllId();
		return ls;
	}

}
