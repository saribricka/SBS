package main.java.model;

import java.util.Optional;

public interface User {

	public void logIn(String username, String password);

	public String logOut();

	public String updateMyProfile(int id, String firstname, String lastname, String city, String address, String selfDescription);
	
	public String getName();

	public String getLastname();

	public Optional<String> getCity();

	public Optional<String> getAddress();

	public Optional<String> getDescription();

	public int getId();

	public boolean isAdmin();

	public String toString();
}
