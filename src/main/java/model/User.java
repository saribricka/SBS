package main.java.model;

import java.util.Optional;

public interface User {

	public String getName();

	public String getLastname();

	public Optional<String> getCity();

	public Optional<String> getAddress();

	public Optional<String> getDescription();

	public int getId();

	public boolean isAdmin();
	
	public boolean isCustomer();

	public String toString();
}
