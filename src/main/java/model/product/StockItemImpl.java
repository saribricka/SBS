package main.java.model.product;

import java.time.LocalDateTime;

public class StockItemImpl extends ProductImpl implements StockItem {

	public StockItemImpl(float price, float discount, int productId, int brandId, int supplierId, int stockAmount,
			int count, String barCode, String productName, String brand, String category, String supplierName,
			LocalDateTime dateArrived) {
		super(price, discount, productId, brandId, supplierId, stockAmount, count, barCode, productName, brand, category,
				supplierName, dateArrived);
	}

	@Override
	public float getBuyingPricePerUnit() {
		return price;
	}

	@Override
	public void setBuyingPricePerUnit(float price) {
		this.price = price;
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
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public LocalDateTime getDateArrived() {
		return dateArrived;
	}
	
	public void setDateArrived(LocalDateTime dateArrived) {
		this.dateArrived = dateArrived;
	}
}
