package main.java.model;

public interface ShoppingCart {
	
	void addToCart(Item item);
	
	void showCart();
	
	void removeFromCart(Item item);
	
	double getTotalAmount();
	
	public double getDiscountedAmount();
	
	void addDiscount(double discount);
	
	void printInvoice();

}
