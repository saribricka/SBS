package main.java.model;

import java.io.File;
import java.util.Optional;
import java.util.UUID;


public class UserImpl implements User{

	private static final char ATTR_SEP = File.pathSeparatorChar;
	private final String firstname, lastname;
	Optional<String> description;
	Optional<String> city; 
	private int id;
	private UserRole role;
	
	private UserImpl(UserBuilder builder) {
		this.id = builder.id;
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.city = builder.city;
		this.role = builder.role;
		this.description = builder.description;
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
	public UserRole getRole() {
		return this.role;
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
	public String toString() {
		String s = String.valueOf(id) + ATTR_SEP + firstname + ATTR_SEP + lastname
				 + ATTR_SEP + description.get() + ATTR_SEP + role + ATTR_SEP + city.get();
		return s.toLowerCase();
	}	

	public static class UserBuilder {
		
		private String firstname, lastname;
		private Optional<String> city  = Optional.empty();
		private UserRole role;
		private Optional<String> description = Optional.empty(); 
		private int id;
		
		public UserBuilder(int id) {
			this.id = id;
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
		
		public UserBuilder role(UserRole role) {
			this.role = role;
			return this;
		}
		
		public UserBuilder description(String description) {
			this.description = Optional.ofNullable(description);
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

