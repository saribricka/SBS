package main.java.model;

public class CartImpl implements Cart {
	
	private static final int PERCENTAGE = 100;
	
	
	public float getTotalItem(ProductImpl item, int quantity) {
		float total;
		
		if (item.discount != 0) {
			total = (item.price * quantity) * item.discount / PERCENTAGE;
		} else {
			total = item.price * quantity;
		}		
		return total;
	}


}
