package main.java.model.user;

import main.java.model.user.AdminImpl.AdminBuilder;
import main.java.model.user.User.AbstractUserBuilder;

public class CashierImpl extends User implements Cashier {

	public CashierImpl(CashierBuilder builder) {
		super(builder);
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
	
	public abstract static class CashierBuilder extends AbstractUserBuilder<User.AbstractUserBuilder<CashierBuilder>> {
		
		public CashierBuilder isAdmin() {
			this.isAdmin = false;
			return this;
		}
		
		//Return the constructed object
		@Override
		public CashierImpl build() {
			return new CashierImpl(this);
		}
		
	}
}
