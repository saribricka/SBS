package main.java.controller;

import main.java.model.Model;
import main.java.view.View;

public class AbstractController implements Controller {
	
	private View view;
    private Model model;

	@Override
	public View getView() {
		return this.view;
	}

	@Override
	public void setView(View view) {
		this.view = view;
	}

	@Override
	public Model getModel() {
		return this.model;
	}

	@Override
	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public void logout() {
		this.getModel().unsetCurrentUser();
	}
	
	/**
     * 
     * @return true if a user is logged
     */
    protected boolean isUserLogged() {
        return this.getModel().getLoggedUser().isPresent();
    }
    
	 

}
