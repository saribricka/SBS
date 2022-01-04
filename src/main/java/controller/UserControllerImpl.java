package main.java.controller;

import main.java.model.User;

public class UserControllerImpl implements UserController{

	private static UserControllerImpl single_instance = null;
	
	public static UserControllerImpl getInstance() {
		if(single_instance == null) {
			single_instance = new UserControllerImpl();
		}
		return single_instance;
	}
	
	@Override
	public void addUser(User newUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User searchUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

}
