package main.java.view;

import main.java.controller.Controller;

public interface View {

	/**
     * 
     * @return the current controller
     */
    Controller getController();

    /**
     * 
     * @param controller the controller to be set
     */
    void setController(Controller controller);

    /**
     * This method is called when the view starts communicating with its controller.
     */
    void start();

    /**
     * 
     * @param message the error message to be displayed.
     */
    void showErrorMessage(String message);

    /**
     * 
     * @param message the information message to be displayed.
     */
    void showInfoMessage(String message);
}
