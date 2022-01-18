package main.java.controller;

import java.util.Set;

import main.java.model.User;
import main.java.model.UserImpl;
import main.java.model.UserRole;
import main.java.model.file.FileStrategy;
import main.java.model.file.FileUserImpl;
import main.java.utils.StringUtil;
import main.java.utils.StringUtilImpl;

public class UserControllerImpl implements UserController{

	private User user;
	private String password, name, lastname, description, city;
	private UserRole role;
	private int id, loggedId;
	protected boolean isAdmin, isCustomer;
	
	private StringUtil stringUtil = new StringUtilImpl(); 
	private FileStrategy file = new FileUserImpl();
	private static UserControllerImpl single_instance = null;
	
	public static UserControllerImpl getInstance() {
		if(single_instance == null) {
			single_instance = new UserControllerImpl();
		}
		return single_instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addUser(final User newUser) {
		if (!exists(newUser.getId())) {	
			file.writeInFile(newUser.toString());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User searchUser(final int userId) {
		String userLine = file.searchInFile(String.valueOf(userId));
		if (!stringUtil.isNullOrBlank(userLine)) {	
			User u = composeUser(userLine);
			return u;
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUser(final User updatedUser) {
		var id = updatedUser.getId();
		if (exists(id)) {
			deleteUser(id);
		}		
		addUser(updatedUser);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteUser(final int userId) {
		if (exists(userId)) {		
			file.deleteLine(String.valueOf(userId));
			return true;
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 * @param userLine
	 * @return
	 */
	private User composeUser(final String userLine) {
		String[] data = userLine.split(";");
		
		id = Integer.parseInt(data[0]);
		password = data[6];
		name = data[1];
		lastname = data[2];
		description = data[3];
		role = UserRole.valueOf(data[4].toUpperCase());
		city = data[5];
		
		user = new UserImpl.UserBuilder(id, password)
				.name(name)
				.lastname(lastname)
                .city(city)
                .role(role)
                .description(description)
                .build();
		
		return user;		
	}
	
	/**
	 * {@inheritDoc}
	 * @param id
	 * @return
	 */
	private boolean exists(final int id) {
		try {
			String strId = String.valueOf(id);
			String userLine = file.searchInFile(strId);
			if (!stringUtil.isNullOrBlank(userLine)) {	
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<String> getAllId() {
		Set<String> ls = file.getAllId();
		return ls;
	}
	
	/**
     * {@inheritDoc}
     */
    @Override
    public int getIdUserLogged() {
       return this.loggedId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setUserLogged(final int idLogged) {
        this.loggedId = idLogged;
        return true;
    }

}
