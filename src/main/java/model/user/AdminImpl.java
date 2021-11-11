package main.java.model.user;

import main.java.model.ProductImpl;

public class AdminImpl extends UserImpl implements Admin{

	public AdminImpl(int id, String name, String surname, String username, String city, String street, int zipCode, String description) {
		super(id, name, surname, username, city, street, zipCode, description);
		this.isAdmin = true;
	}

	@Override
	public void hireCashier(CashierImpl cashier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cashier getCashierInfo(int cashierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fireCashier(int cashierId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddProduct(int productId, int brandId, float price, String productName, String brand, String category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductImpl getProductInfo(int productId, int brandId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(int productId, int brandId, float price, String productName, String brand,
			String category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int productId, int brandId) {
		// TODO Auto-generated method stub
		
	}

}
