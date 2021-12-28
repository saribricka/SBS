package main.java.model;

import java.util.Optional;


public interface Model {

	/**
     * 
     * @return an optional which is full only if a user is logged
     */
    Optional<User> getLoggedUser();

    /**
     * 
     * @param user the user to be set as current user
     */
    void setCurrentUser(User user);

    /**
     * Un-sets the current user.
     */
    void unsetCurrentUser();

}
