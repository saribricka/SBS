package main.java.model;

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
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
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
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getStockAmount() {
		return stockAmount;
	}
	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
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
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public LocalDateTime getDateAdded() {
		return dateArrived;
	}
	public void setDateAdded(LocalDateTime dateadded) {
		this.dateArrived = dateadded;
	}

	
}
