package main.java.model.user;

public class CashierImpl extends UserImpl implements Cashier {

	public CashierImpl(int id, String name, String surname, String username, String city, String street, int zipCode, String description) {
		super(id, name, surname, username, city, street, zipCode, description);
		this.isAdmin = false;
	}

	@Override
	public String getProductInfo(int productId, int brandId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItemToCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editCartItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItemFromCart() {
		// TODO Auto-generated method stub
		
	}	
}
