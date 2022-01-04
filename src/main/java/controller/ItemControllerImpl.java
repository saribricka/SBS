package main.java.controller;

import main.java.model.Item;
import main.java.model.ItemImpl;

public class ItemControllerImpl implements ItemController{

	private static ItemControllerImpl single_instance = null;
	
	public static ItemControllerImpl getInstance() {
		if(single_instance == null) {
			single_instance = new ItemControllerImpl();
		}
		return single_instance;
	}
	
	@Override
	public void addItem(ItemImpl newItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item searchItem(String barcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateItem(ItemImpl updatedItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(String barcode) {
		// TODO Auto-generated method stub
		
	}

}
