package main.java.model;

interface Discount {
	
	float getDiscount(ProductImpl item);
	
	/**
	 * Set the discount in percentage.
	 * @param amount read as the value before %.
	 */
	void setDiscount(float amount);
	
}
