package main.java.model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemImpl implements Item{
	
	private static final char ATTR_SEP = File.pathSeparatorChar;
	private String barcode;
	private String productName;
	private int quantity;
	private double unitPrice;
	private Date receivedDate, expirationDate;
	private ItemCategory category;	
	
//	public ItemImpl(ItemBuilder builder) {
//		this.barcode = builder.barcode;
//		this.productName = builder.productName;
//		this.quantity = builder.quantity;
//		this.unitPrice = builder.unitPrice;
//		this.receivedDate = stringToDate(builder.receivedDate);
//	}
	
	public ItemImpl(String barcode, String productName, int quantity, double unitPrice, Date receivedDate,
			Date expirationDate, ItemCategory category) {
//		this.barcode = UUID.randomUUID().toString();
		this.barcode = barcode;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.receivedDate = receivedDate;
		this.expirationDate = expirationDate;
		this.category = category;
	}
	
	@Override
	public String toString() {
		String s = barcode + ATTR_SEP + productName + ATTR_SEP + quantity
				+ ATTR_SEP + unitPrice + ATTR_SEP + receivedDate 
				+ ATTR_SEP + expirationDate + ATTR_SEP + category;
		return s.toLowerCase();
	}

	@Override
	public String getBarcode() {
		return this.barcode;
	}

	@Override
	public String getName() {
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
	
	@Override
	public ItemCategory getCategory() {
		return category;
	}
	
	protected static String dateToString(Date date) {
		String ds = date.toString();
		return ds;
	}
	
	protected static Date stringToDate(String receivedDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(receivedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

//	public static class ItemBuilder {
//		private String barcode;
//		private String productName;
//		private int quantity;
//		private double unitPrice;
//		private Optional<String> receivedDate = Optional.empty();
//		private Optional<String> expirationDate = Optional.empty();
//		private ItemCategory category;	
//		
//		public ItemBuilder barcode(String barcode) {
//			this.barcode = UUID.randomUUID().toString();
//			return this;
//		}
//		
//		public ItemBuilder productName(String name) {
//			this.productName = name;
//			return this;
//		}
//		
//		public ItemBuilder quantity(int quantity) {
//			this.quantity = quantity;
//			return this;
//		}
//		
//		public ItemBuilder unitPrice(double unitPrice) {
//			this.unitPrice = unitPrice;
//			return this;
//		}
//		
//		public ItemBuilder receivedDate(Date receivedDate) {
//			this.receivedDate = Optional.ofNullable(dateToString(receivedDate));
//			return this;
//		}
//		
//		public ItemBuilder expirationDate(Date expirationDate) {
//			this.expirationDate = Optional.ofNullable(dateToString(expirationDate));
//			return this;
//		}
//		
//		public ItemBuilder category(ItemCategory category) {
//			this.category = category;
//			return this;
//		}
//		
//		public Item build() throws IllegalStateException{
////			if (this.firstname == null || this.lastname == null){
////				throw new IllegalStateException("");
////			}
//			return new ItemImpl(this);
//		}
//		
//	}
	
}
