package main.java.model;

import main.java.model.product.ProductImpl;

interface Discount {
	
	float getDiscount(ProductImpl item);
	
	/**
	 * Set the discount in percentage.
	 * @param amount read as the value before %.
	 */
	void setDiscount(float amount);
	
}
