package main.java.controller;

import main.java.model.User;

public interface UserController {

	void addUser(User newUser);
	
	User searchUser(int userId);
	
	void updateUser(User updatedUser);
	
	void deleteUser(int userId);
	
}
