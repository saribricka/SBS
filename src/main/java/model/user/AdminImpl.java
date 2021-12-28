package main.java.model.user;

import main.java.model.product.ProductImpl;
import main.java.model.user.User.AbstractUserBuilder;

public class AdminImpl extends User implements Admin{

	public AdminImpl(AdminBuilder builder) {
		super(builder);
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

	public abstract static class AdminBuilder extends AbstractUserBuilder<User.AbstractUserBuilder<AdminBuilder>> {
		
		public AdminBuilder isAdmin() {
			this.isAdmin = true;
			return this;
		}
		
		//Return the constructed object
		@Override
		public AdminImpl build() {
			return new AdminImpl(this);
		}
		
	}
}
