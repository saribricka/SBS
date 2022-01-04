package main.java.controller;

import main.java.model.Item;

public interface ItemController {
	
	void addItem(Item newItem);
	
	Item searchItem(String barcode);
	
	void updateItem(Item updatedItem);
	
	void deleteItem(String barcode);

}
