package main.java.model;

public interface ShoppingCart {
	
	void addToCart(Item item);
	
	void showCart();
	
	void removeFromCart(Item item);
	
	double getTotalAmount();
	
	void addDiscount(double discount);
	
	void printInvoice();

}
