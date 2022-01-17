package main.java.controller;

public interface InvoiceController {

	/**
	 * Create new item line for the shop cart.
	 * @param itemId
	 * @param qty
	 * @return the line created
	 */
	String createInvoiceItem(String itemId, String qty);
	
	 /**
	  * Once the cart is ready to checkout, it calculate the total price.
	  * @return The total price
	  */
	Double calculateTotal();
	
	/**
	 * Add the new invoice line to the cart.
	 * @param cartLine
	 * @return false if something went wrong
	 */
	boolean addToCart(String cartLine);
	
	/**
	 * Removes all the data from the cart.
	 * @return false if something went wrong
	 */
	boolean newInvoice();
	
	/**
	 * For each item in cart, it recalculate the unsold stock.
	 * After that, it cleans the cart.
	 * @return false if something went wrong
	 */
	boolean checkout();
}
