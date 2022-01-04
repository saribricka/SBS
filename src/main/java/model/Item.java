package main.java.model;

import java.util.Date;

public interface Item {

	public String getBarcode();
	
	public String getProductName();
	
	public int getQuantity();
	
	public double getUnitPrice();
	
	Date getReceivedDate();
	
	Date getExpirationDate();
	
	ItemCategory getCategory();
	
}
