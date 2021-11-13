package main.java.model.product;

import java.time.LocalDateTime;

public interface StockItem extends Product {

	float getBuyingPricePerUnit();
	void setBuyingPricePerUnit(float price);
	int getSupplierId();
	void setSupplierId(int supplierId);
	int getStockAmount();
	void setStockAmount(int stockAmount);
	String getSupplierName();
	void setSupplierName(String supplierName);
	LocalDateTime getDateArrived();
	void setDateArrived(LocalDateTime dateASdded);
}
