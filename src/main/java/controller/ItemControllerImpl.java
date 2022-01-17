package main.java.controller;

import java.util.HashSet;
import java.util.Set;

import org.junit.platform.commons.util.StringUtils;

import main.java.model.Item;
import main.java.model.ItemCategory;
import main.java.model.ItemImpl;
import main.java.model.file.FileItemImpl;
import main.java.model.file.FileStrategy;
import main.java.utils.StringUtil;
import main.java.utils.StringUtilImpl;

public class ItemControllerImpl implements ItemController{

	private Item item;
	private String barcode, name;
	private int quantity;
	private double price;
	private ItemCategory category;
	
	private StringUtil stringUtil = new StringUtilImpl(); 
	private FileStrategy file = new FileItemImpl();
	private static ItemControllerImpl single_instance = null;
	
	public static ItemControllerImpl getInstance() {
		if(single_instance == null) {
			single_instance = new ItemControllerImpl();
		}
		return single_instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addItem(Item newItem) {	
		if (!exists(newItem.getBarcode())) {	
			file.writeInFile(newItem.toString());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Item searchItem(String barcode) {
		String itemLine = file.searchInFile(barcode.toLowerCase());
		if (!stringUtil.isNullOrBlank(itemLine)) {	
			Item i = composeItem(itemLine);
			return i;
		} else {
			return null;
		}			
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateItem(Item updatedItem) {
		var id = updatedItem.getBarcode();
		if (exists(id)) {
			deleteItem(id);
		}		
		addItem(updatedItem);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteItem(String barcode) {
		if (exists(barcode)) {		
			file.deleteLine(barcode);
			return true;
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 * @param itemLine
	 * @return
	 */
	private Item composeItem(String itemLine) {
		String[] data = itemLine.split(";");
		
		barcode = data[0];
		name = data[1];						
		quantity = Integer.parseInt(data[2]);
		price = Double.parseDouble(data[3]);
		category = ItemCategory.valueOf(data[6].toUpperCase());
		
		item = new ItemImpl(barcode, name, quantity, price, null, null, category);
		
		return item;		
	}
	
	/**
	 * {@inheritDoc}
	 * @param barcode
	 * @return
	 */
	private boolean exists(String barcode) {
		try {
			String itemLine = file.searchInFile(barcode.toLowerCase());
			if (!stringUtil.isNullOrBlank(itemLine)) {	
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<String> getAllId() {
		Set<String> ls = file.getAllId();
		return ls;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Integer> fromOneToQuantity(Item item) {
		Set<Integer> qtys = new HashSet<>();
		int quantity = item.getQuantity();
		for(int i=1; i<=quantity; i++) {
			qtys.add(i);
		}
		return qtys;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void recalculateQuantity(String barcode, int nSold) {
		Item i = searchItem(barcode);
		int oldQty = i.getQuantity();
		int newQty = oldQty - nSold;
		
		Item itemToUpdate = new ItemImpl(i.getBarcode(), i.getName(), newQty, i.getUnitPrice(), null, null, i.getCategory());
		updateItem(itemToUpdate);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<String> showUnsold() {
		Set<String> ides = getAllId();
		Set<String> rows = new HashSet<>();
		for(String id : ides) {
			Item i = searchItem(id);
			
			String barcode = i.getBarcode();
			String name = i.getName();
			ItemCategory cat = i.getCategory();
			int qty = i.getQuantity();
			Double price = i.getUnitPrice();
			
			String row = barcode + "\t" + name + "\t" + cat + "\t" + qty + "\t" + price + "\n";
			rows.add(row);
		}
		return rows;
	}
}
