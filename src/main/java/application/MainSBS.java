package main.java.application;

import main.java.view.HomeView;

public class MainSBS {

	public static void main(String[] args) {		
		
		try {
			HomeView home = new HomeView(false);
			home.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
