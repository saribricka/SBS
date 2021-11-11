package main.java.model.user;

class UserImpl implements User{
	
	private String name, surname, username, city, street, description; 
	private int id, zipCode;
	protected boolean isAdmin;
	
	protected UserImpl(int id, String name, String surname, String username, String city, String street, int zipCode, String description) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.description = description;
	}

	@Override
	public void logIn(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String logOut() {
		// TODO Auto-generated method stub
		return "succesfully logged out";
	}

	@Override
	public String updateMyProfile(int id, String name, String surname, String username, String city, String street, int zipCode, String selfDescription) { //TODO Make int? (zip)
		// TODO Auto-generated method stub
		return "profile succesfully updated";
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getSurname() {
		return surname;
	}

	protected void setSurname(String surname) {
		this.surname = surname;
	}

	protected String getUsername() {
		return username;
	}

	protected void setUsername(String username) {
		this.username = username;
	}

	protected String getCity() {
		return city;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	protected String getStreet() {
		return street;
	}

	protected void setStreet(String street) {
		this.street = street;
	}

	protected String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected int getZipCode() {
		return zipCode;
	}

	protected void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	protected boolean isAdmin() {
		return isAdmin;
	}

	protected void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
}
