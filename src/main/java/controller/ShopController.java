package main.java.controller;

import java.util.Set;

public interface ShopController {
	
	/**
	 * Create and Add a new purchase line to the file.
	 * @param userId
	 * @param tot
	 * @return false if something went wrong
	 */
	boolean addPayment(int userId, Double tot);
	
	/**
	 * Shows all purchases.
	 * @return a Set with every purchase line.
	 */
	Set<String> showPayments();
}
