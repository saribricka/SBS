package main.java.model.user;

public class CashierImpl extends UserImpl implements Cashier{

	public CashierImpl(int id, String name, String surname, String city, String street, int zipCode, String description) {
		super(id, name, surname, city, street, zipCode, description);
		this.isAdmin = false;
	}

	@Override
	public String getProductInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
