package main.java.model.product;

public interface CartItem extends Product {
	
	String getBarCode();
	void setBarCode(String barCode);
	float getSellingPricePerUnit();
	void setSellingPricePerUnit(float price);
	float getDiscount();
	void setDiscount(float discount);

}
