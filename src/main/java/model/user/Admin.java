package main.java.model.user;

import main.java.model.ProductImpl;

public interface Admin {
	
	/** Cashier CRUD functionalities */
	
	/**
	 * Method to add a cashier to the system.
	 * @param cashier
	 */
	void hireCashier(CashierImpl cashier);	//TODO read how you can parameterize a class
	
	/**
	 * Given a cashier id it returns all the cashier info.
	 * @param id
	 * @return
	 */
	Cashier getCashierInfo(int cashierId);
	 /**
	  * Method to remove a cashier from the system.
	  * @param id
	  */
	void fireCashier(int cashierId);
	
	
	/** Stocks CRUD functionalities */	
	
	/**
	 * Method to add a product to the store.
	 * @param productId
	 * @param brandId
	 * @param price
	 * @param productName
	 * @param brand
	 * @param category
	 */
	void AddProduct(int productId, int brandId, float price, String productName, String brand, String category);
	
	/**
	 * 
	 * @param productId
	 * @param brandId
	 * @return
	 */
	ProductImpl getProductInfo(int productId, int brandId);
	
	/**
	 * Method to update a specific product details.
	 * @param productId
	 * @param brandId
	 * @param price
	 * @param productName
	 * @param brand
	 * @param category
	 */
	void updateProduct(int productId, int brandId, float price, String productName, String brand, String category);
	
	/**
	 * Method to delete a product from the store.
	 * @param productId
	 * @param brandId
	 */
	void deleteProduct(int productId, int brandId);

}
