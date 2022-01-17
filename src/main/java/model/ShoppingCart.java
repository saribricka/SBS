package main.java.model;

public interface ShoppingCart {
	
	/**
	 * Add to the shop cart a new Item.
	 * @param item
	 */
	void addToCart(Item item);
	
	/**
	 * Remove the passed Item from shop cart.
	 * @param item
	 */
	void removeFromCart(Item item);
	
	/**
	 * Calculate the total price by iterating all the Cart Items.
	 * @return a double value
	 */
	double getTotalAmount();
	
}
