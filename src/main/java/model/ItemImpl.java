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
	
	public ItemImpl(String barcode, String productName, int quantity, double unitPrice, Date receivedDate,
			Date expirationDate, ItemCategory category) {
		this.barcode = barcode;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.receivedDate = receivedDate;
		this.expirationDate = expirationDate;
		this.category = category;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String s = barcode + ATTR_SEP + productName + ATTR_SEP + quantity
				+ ATTR_SEP + unitPrice + ATTR_SEP + receivedDate 
				+ ATTR_SEP + expirationDate + ATTR_SEP + category;
		return s.toLowerCase();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBarcode() {
		return this.barcode;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.productName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemCategory getCategory() {
		return category;
	}
	
	/**
	 * {@inheritDoc}
	 * @param date
	 * @return
	 */
	protected static String dateToString(Date date) {
		String ds = date.toString();
		return ds;
	}
	
	/**
	 * {@inheritDoc}
	 * @param receivedDate
	 * @return
	 */
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
}
