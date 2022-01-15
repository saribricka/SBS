package main.java.controller;

import java.util.Set;

import main.java.model.Item;

public interface ItemController {
	
	/**
	 * Add an item to database.
	 * @param newItem
	 * @return false is something went wrong.
	 */
	boolean addItem(Item newItem);
	
	/**
	 * Search on the database a substring equal to the arg and return all the line.
	 * @param barcode of the item you are looking for.
	 * @return the existing Item with the corresponding barcode or null if not found.
	 */
	Item searchItem(String barcode);
	
	/**
	 * If the barcode is already in the database, it updates the item.
	 * If not, it creates a new item.
	 * @param updatedItem
	 */
	void updateItem(Item updatedItem);
	
	/**
	 * Delete the item with the corresponding barcode.
	 * @param barcode of the item you want to delete from the database.
	 * @return false is something went wrong.
	 */
	boolean deleteItem(String barcode);

	/**
	 * Get the id of every item contained in the database
	 * @return a list of strings with all the id
	 */
	Set<String> getAllId();
	
	/**
	 * Get quantity and all the numbers from one to argument
	 * @param item
	 * @return an array of all the values till quantity
	 */
	Set<Integer> fromOneToQuantity(Item item);
	
	/**
	 * For the sold item, calculate unsold stocks.
	 * @param barcode
	 * @param nSold
	 * @return the new quantity.
	 */
	int recalculateQuantity(String barcode, int nSold);
	
	/**
	 * Show all the stock.
	 * @return all items in stock.
	 */
	Set<String> showUnsold();
}
