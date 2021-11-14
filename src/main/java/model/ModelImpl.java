package main.java.model;

import java.util.Optional;

import main.java.model.user.User;

public class ModelImpl implements Model {
	
	private Optional<User> currentUser = Optional.empty();

	@Override
	public Optional<User> getLoggedUser() {
		return this.currentUser;
	}

	@Override
	public void setCurrentUser(User user) {
		this.currentUser = Optional.of(user);
	}

	@Override
	public void unsetCurrentUser() {
		this.currentUser = Optional.empty();
	}

}
