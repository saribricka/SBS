package main.java.model;

import java.io.File;
import java.util.Optional;
import java.util.UUID;


public class UserImpl implements User{

	private static final char ATTR_SEP = File.pathSeparatorChar;
	private final String firstname, lastname;
	Optional<String> description;
	Optional<String> address;
	Optional<String> city; 
	private static int id = 0;
	protected final boolean isAdmin, isCustomer;
	
	private UserImpl(UserBuilder builder) {
		this.id = builder.id;
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.city = builder.city;
		this.address = builder.address;
		this.description = builder.description;
		this.isAdmin = builder.isAdmin;
		this.isCustomer = builder.isCustomer;
	}
	
	private static int incrementId() {
		return id++;
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
	public boolean isCustomer() {
		return this.isCustomer;
	}
	
	@Override
	public String toString() {
		String s = "\n" + id + ATTR_SEP + firstname + ATTR_SEP + lastname + ATTR_SEP + description
				+ ATTR_SEP + address + ATTR_SEP + city + ATTR_SEP + id 
				+ ATTR_SEP + isAdmin + ATTR_SEP	+ isCustomer;
		return s.toLowerCase();
	}	

	public static class UserBuilder {
		
		private String firstname, lastname;
		private Optional<String> city  = Optional.empty();
		private Optional<String> address = Optional.empty();
		private Optional<String> description = Optional.empty(); 
		private int id;
		protected boolean isAdmin, isCustomer;
		
		public UserBuilder() {
			this.id = incrementId();
		}
		
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
		
		public UserBuilder isCustomer(boolean isCustomer) {
			this.isCustomer = isCustomer;
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

