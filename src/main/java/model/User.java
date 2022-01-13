package main.java.model;

import java.util.Optional;

public interface User {	

	/**
	 * Get id of selected user.
	 * @return a string with the id.
	 */
	public int getId();
	
	/**
	 * Get name of selected interface object.
	 * @return a string with the name.
	 */
	public String getName();
	
	public String getLastname();

	public Optional<String> getCity();

	public UserRole getRole();

	public Optional<String> getDescription();

	public String toString();
}
