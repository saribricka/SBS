package main.java.model;

import main.java.model.product.ProductImpl;

public interface Cart {
	
	float getTotalItem(ProductImpl item, int quantity);
	

}
