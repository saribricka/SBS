package main.java.model.user;

class UserImpl implements User{
	
	private String name, surname, city, street, description; 
	private int id, zipCode;
	protected boolean isAdmin;
	
	public UserImpl(int id, String name, String surname, String city, String street, int zipCode, String description) {
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
	public String updateMyProfile(String name, String surname, String city, String street, String selfDescription, int id, int zipCode) { //TODO Make int? (zip)
		// TODO Auto-generated method stub
		return "profile succesfully updated";
	}

}
