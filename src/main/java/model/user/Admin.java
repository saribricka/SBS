package main.java.model.user;

public interface Admin {
	
	/** Cashier CRUD functionalities */
	void addCashier(CashierImpl cashier);	//TODO read how you can parameterize a class
	
	String getCashierInfo(int id);
	
	void removeCashier(int id);
	
	/** Stocks CRUD functionalities */	
	

}
