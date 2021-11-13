package main.java.model.product;

import java.time.LocalDateTime;

public class ProductImpl implements Product {

	public float price, discount;
	public int productId, brandId, supplierId, stockAmount, count;
	public String barCode, productName, brand, category, supplierName; 
	public LocalDateTime dateArrived;
	
	public ProductImpl(float price, float discount, int productId, int brandId, int supplierId, int stockAmount,
			int count, String barCode, String productName, String brand, String category, String supplierName,
			LocalDateTime dateArrived) {
		super();
		this.price = price;
		this.discount = discount;
		this.productId = productId;
		this.brandId = brandId;
		this.supplierId = supplierId;
		this.stockAmount = stockAmount;
		this.count = count;
		this.barCode = barCode;
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.supplierName = supplierName;
		this.dateArrived = dateArrived;
	}
		
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getBrandId() {
		return brandId;
	}
	
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}	
}
