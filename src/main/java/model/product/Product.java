package main.java.model.product;

import java.time.LocalDateTime;

interface Product {
		
	int getProductId();
	void setProductId(int productId);
	int getBrandId();
	void setBrandId(int brandId);	
	int getCount();
	void setCount(int count);	
	String getProductName();
	void setProductName(String productName);
	String getBrand();
	void setBrand(String brand);
	String getCategory();
	void setCategory(String category);
	
}
