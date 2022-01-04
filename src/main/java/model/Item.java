package main.java.model;

import java.util.Date;

public interface Item {

	/**
	 * Get barcode of selected item.
	 * @return a string with the barcode.
	 */
	public String getBarcode();
	
	/**
	 * Get name of selected item.
	 * @return a string with the name.
	 */
	public String getProductName();
	
	/**
	 * Get quantity of selected item.
	 * @return an int with the quantity.
	 */
	public int getQuantity();
	
	/**
	 * Get unit price of selected item.
	 * @return a double with price per unit.
	 */
	public double getUnitPrice();
	
	/**
	 * Get received date of selected item.
	 * @return Date
	 */
	Date getReceivedDate();
	
	/**
	 * Get expiration date of selected item.
	 * @return Date
	 */
	Date getExpirationDate();
	
	/**
	 * Get category of selected item.
	 * @return category from enum ItemCategory.
	 */
	ItemCategory getCategory();
	
}
