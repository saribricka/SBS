package main.java.model;

import java.time.LocalDateTime;

interface Product {

	float getPrice();
	void setPrice(float price);
	float getDiscount();
	void setDiscount(float discount);
	int getProductId();
	void setProductId(int productId);
	int getBrandId();
	void setBrandId(int brandId);
	int getSupplierId();
	void setSupplierId(int supplierId);
	int getStockAmount();
	void setStockAmount(int stockAmount);
	int getCount();
	void setCount(int count);
	String getBarCode();
	void setBarCode(String barCode);
	String getProductName();
	void setProductName(String productName);
	String getBrand();
	void setBrand(String brand);
	String getCategory();
	void setCategory(String category);
	String getSupplierName();
	void setSupplierName(String supplierName);
	LocalDateTime getDateAdded();
	void setDateAdded(LocalDateTime dateASdded);
	
	
}
