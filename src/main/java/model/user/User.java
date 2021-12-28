package main.java.model.user;

abstract class User{
	
	private final String firstname, lastname, username, city, address, description; 
	private final int id;
	protected final boolean isAdmin;
	
	protected User(AbstractUserBuilder<?> builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.city = builder.city;
		this.address = builder.address;
		this.description = builder.description;
		this.isAdmin = builder.isAdmin;
	}

	public void logIn(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	public String logOut() {
		// TODO Auto-generated method stub
		return "succesfully logged out";
	}

	public String updateMyProfile(int id, String firstname, String lastname, String username, String city, String address, String selfDescription) { //TODO Make int? (zip)
		// TODO Auto-generated method stub
		return "profile succesfully updated";
	}
	
	protected String getName() {
		return firstname;
	}

	protected String getSurname() {
		return lastname;
	}

	protected String getUsername() {
		return username;
	}

	protected String getCity() {
		return city;
	}

	protected String getAddress() {
		return address;
	}

	protected String getDescription() {
		return description;
	}

	protected int getId() {
		return id;
	}

	protected boolean isAdmin() {
		return isAdmin;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", city=" + city
				+ ", address=" + address + ", description=" + description + ", id=" + id + ", isAdmin=" + isAdmin + "]";
	}


	public abstract static class AbstractUserBuilder<T extends AbstractUserBuilder<?>> {
		private String firstname, lastname, username, city, address, description; 
		private int id;
		protected boolean isAdmin;
		
		public AbstractUserBuilder<T> name(String firstname) {
			this.firstname = firstname;
			return this;
		}
		
		public AbstractUserBuilder<T> lastname(String lastname) {
			this.lastname = lastname;
			return this;
		}
		
		public AbstractUserBuilder<T> username(String username) {
			this.username = username;
			return this;
		}
		
		public AbstractUserBuilder<T> city(String city) {
			this.city = city;
			return this;
		}
		
		public AbstractUserBuilder<T> address(String address) {
			this.address = address;
			return this;
		}
		
		public AbstractUserBuilder<T> description(String description) {
			this.description = description;
			return this;
		}
		
		public AbstractUserBuilder<T> isAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
			return this;
		}
		
		//Return the constructed object
		abstract User build();
	}
}
