package main.java.controller;

import main.java.model.Item;
import main.java.model.ItemImpl;

public interface ItemController {
	
	void addItem(ItemImpl newItem);
	
	Item searchItem(String barcode);
	
	void updateItem(ItemImpl updatedItem);
	
	void deleteItem(String barcode);

}
