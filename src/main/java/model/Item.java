package main.java.model;

public interface Item {

	/**
	 * Get name of selected interface object.
	 * @return a string with the name.
	 */
	String getName();
	
	/**
	 * Get barcode of selected item.
	 * @return a string with the barcode.
	 */
	String getBarcode();
	
	/**
	 * Get quantity of selected item.
	 * @return an int with the quantity.
	 */
	int getQuantity();
	
	/**
	 * Get unit price of selected item.
	 * @return a double with price per unit.
	 */
	double getUnitPrice();
		
	/**
	 * Get category of selected item.
	 * @return category from enum ItemCategory.
	 */
	ItemCategory getCategory();
	
}
