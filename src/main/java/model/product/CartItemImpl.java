package main.java.model.product;

import java.time.LocalDateTime;

public class CartItemImpl extends ProductImpl implements CartItem {

	public CartItemImpl(float price, float discount, int productId, int brandId, int supplierId, int stockAmount,
			int count, String barCode, String productName, String brand, String category, String supplierName,
			LocalDateTime dateArrived) {
		super(price, discount, productId, brandId, supplierId, stockAmount, count, barCode, productName, brand, category,
				supplierName, dateArrived);
	}
	
	public String getBarCode() {
		return barCode;
	}
	
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Override
	public float getSellingPricePerUnit() {
		return price;
	}

	@Override
	public void setSellingPricePerUnit(float price) {
		this.price = price;
	}
	
	public float getDiscount() {
		return discount;
	}
	
	public void setDiscount(float discount) {
		this.discount = discount;
	}

}
