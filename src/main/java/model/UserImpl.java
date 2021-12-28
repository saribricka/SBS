package main.java.model;

import java.util.Optional;


public class UserImpl implements User{

	private final String firstname, lastname;
	Optional<String> description;
	Optional<String> address;
	Optional<String> city; 
	private final int id;
	protected final boolean isAdmin;
	
	public UserImpl(UserBuilder builder) {
		this.id = builder.id;
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.city = builder.city;
		this.address = builder.address;
		this.description = builder.description;
		this.isAdmin = builder.isAdmin;
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
	public String updateMyProfile(int id, String firstname, String lastname, String city,
			String address, String selfDescription) {
		// TODO Auto-generated method stub
		return "profile succesfully updated";
	}

	@Override
	public String getName() {
		return this.firstname;
	}

	@Override
	public String getLastname() {
		return this.lastname;
	}

	@Override
	public Optional<String> getCity() {
		return this.city; 
	}

	@Override
	public Optional<String> getAddress() {
		return this.address;
	}

	@Override
	public Optional<String> getDescription() {
		return this.description;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public boolean isAdmin() {
		return this.isAdmin;
	}
	
	@Override
	public String toString() {
		return "UserImpl [firstname=" + firstname + ", lastname=" + lastname + ", description=" + description
				+ ", address=" + address + ", city=" + city + ", id=" + id + ", isAdmin=" + isAdmin + "]";
	}

	public static class UserBuilder{
		
		private String firstname, lastname;
		private Optional<String> city  = Optional.empty();
		private Optional<String> address = Optional.empty();
		private Optional<String> description = Optional.empty(); 
		private int id;
		protected boolean isAdmin;
		
		public UserBuilder name(String firstname) {
			this.firstname = firstname;
			return this;
		}
		
		public UserBuilder lastname(String lastname) {
			this.lastname = lastname;
			return this;
		}
		
		public UserBuilder city(String city) {
			this.city = Optional.ofNullable(city);
			return this;
		}
		
		public UserBuilder address(String address) {
			this.address = Optional.ofNullable(address);
			return this;
		}
		
		public UserBuilder description(String description) {
			this.description = Optional.ofNullable(description);
			return this;
		}
		
		public UserBuilder isAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
			return this;
		}
		
		public User build() throws IllegalStateException{
//			if (this.firstname == null || this.lastname == null){
//				throw new IllegalStateException("");
//			}
			return new UserImpl(this);
		}
		
		
	}
	
}

