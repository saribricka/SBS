package main.java.model.user;

public interface Cashier extends User {

	/** Cart CRUD functionalities */	
	String getProductInfo(int productId, int brandId);
	void addItemToCart();
	void editCartItem();
	void deleteItemFromCart();	//do i delete the product or cartItem? left!
	
	

}
