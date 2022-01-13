package main.java.controller;

import main.java.model.Item;
import main.java.model.ItemImpl;

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

}
