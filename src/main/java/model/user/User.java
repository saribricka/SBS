package main.java.model.user;

public interface User {

	/**
	 * 
	 * @param username
	 * @param password
	 */
	void logIn(String username, String password);
	
	/**
	 * 
	 * @return
	 */
	String logOut();
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param surname
	 * @param username
	 * @param city
	 * @param street
	 * @param zipCode
	 * @param selfDescription
	 * @return
	 */
	String updateMyProfile(int id, String name, String surname, String username, String city, String street, int zipCode, String selfDescription);
		
	
	public enum UserType{        
    /**
     * The user is a cashier
     */
    CASHIER,
    /**
     * The user is an admin
     */
    ADMIN
    }
}
