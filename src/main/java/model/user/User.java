package main.java.model.user;

interface User {

	void logIn(String username, String password);
	
	String logOut();
	
	String updateMyProfile(String name, String surname, String city, String street, String selfDescription, int id, int zipCode);
	
	
}
