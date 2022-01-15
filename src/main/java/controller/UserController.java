package main.java.controller;

import java.util.Set;

import main.java.model.User;

public interface UserController {

	/**
	 * Add user to the database.
	 * @param newUser
	 * @return false is something went wrong.
	 */
	boolean addUser(User newUser);
	
	/**
	 * Search on the database a substring equal to the arg and return all the line.
	 * @param userId of the user you are looking for.
	 * @return the existing User with the corresponding userId or null if not found.
	 */
	User searchUser(int userId);
	
	/**
	 * If the userId is already in the database, it updates the user.
	 * If not, it creates a new user.
	 * @param updatedUser
	 */
	void updateUser(User updatedUser);
	
	/**
	 * Delete the item with the corresponding userId.
	 * @param userId of the user you want to delete from the database.
	 * @return false is something went wrong.
	 */
	boolean deleteUser(int userId);
	
	/**
	 * Get the id of every user contained in the database
	 * @return a list of strings with all the id
	 */
	Set<String> getAllId();
	
}
