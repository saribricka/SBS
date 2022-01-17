package main.java.model;

import java.util.Optional;

public interface User {	

	/**
	 * Returns id of calling user.
	 * @return a string with the id.
	 */
	int getId();
	
	/**
	 * Returns password of calling user.
	 * @return
	 */
	String getPassword();
	
	/**
	 * Returns the name of calling user.
	 * @return a string with the name.
	 */
	String getName();
	
	/**
	 * Returns lastname of calling user.
	 * @return
	 */
	String getLastname();

	/**
	 * Returns the city where the calling user lives.
	 * @return
	 */
	Optional<String> getCity();

	/**
	 * Returns the role of calling User.
	 * @return a value from enum UserRole
	 */
	UserRole getRole();

	/**
	 * Returns the description of calling user.
	 * @return
	 */
	Optional<String> getDescription();

	/**
	 * Return the user as string. This is the format that will be used to print on db files.
	 * @return
	 */
	String toString();
}
