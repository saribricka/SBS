package main.java.controller;

import main.java.model.Model;
import main.java.view.View;

public interface Controller {

	/**
     * 
     * @return the current view
     */
    View getView();

    /**
     * 
     * @param view the current view
     */
    void setView(View view);

    /**
     * 
     * @return an instance of a model
     */
    Model getModel();

    /**
     * 
     * @param model the model to set
     */
    void setModel(Model model);

    /**
     * Log's out the user.
     */
    void logout();
}
