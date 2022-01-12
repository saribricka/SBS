package main.java.controller;

import main.java.model.Item;
import main.java.model.ItemImpl;

public interface ItemController {
	
	boolean addItem(Item newItem);
	
	/**
	 * Must be used after the check on the existence
	 * @param barcode
	 * @return the existing Item with the corresponding barcode
	 */
	Item searchItem(String barcode);
	
	void updateItem(Item updatedItem);
	
	boolean deleteItem(String barcode);

}
