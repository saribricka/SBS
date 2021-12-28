package main.java.model;

import java.util.UUID;

public class ItemImpl implements Item{
	
	private String barcode;
	private String productName;
	private int quantity;
	private double unitPrice;
	
	public ItemImpl(String productName, int quantity, double unitPrice) {
		this.barcode = UUID.randomUUID().toString();
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public String toString() {
		String s = this.productName + ":";
		s = s + this.quantity + "\n";
		return s;
	}

	@Override
	public String getBarcode() {
		return this.barcode;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public int getQuantity() {
		return this.quantity;
	}

	@Override
	public double getUnitPrice() {
		return this.unitPrice;
	}

	
}
