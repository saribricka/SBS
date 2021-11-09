package main.java.model.user;

public class AdminImpl extends UserImpl implements Admin{

	public AdminImpl(int id, String name, String surname, String city, String street, int zipCode, String description) {
		super(id, name, surname, city, street, zipCode, description);
		this.isAdmin = true;
	}

	@Override
	public void addCashier(CashierImpl cashier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCashierInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCashier(int id) {
		// TODO Auto-generated method stub
		
	}
}
