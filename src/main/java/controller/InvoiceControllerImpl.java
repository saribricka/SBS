package main.java.controller;

import java.util.Set;

import main.java.model.Item;
import main.java.model.file.FileInvoiceImpl;
import main.java.model.file.FileStrategy;

public class InvoiceControllerImpl implements InvoiceController{

	private FileStrategy fileInvoice = new FileInvoiceImpl();
	private ItemController itemController = new ItemControllerImpl();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String createInvoiceItem(String itemId, String qty) {
		Item item = itemController.searchItem(itemId);
		String itemName = item.getName();
		Double price = item.getUnitPrice();
		String invoiceLine = itemId + "\t" + itemName + "\t" + qty + "\t" + price + "\n";
		return invoiceLine;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double calculateTotal() {
		Double cartTotal = 0.0;
		int qty;
		Double unitPrice, itemTotal;
		Set<String> cartList = fileInvoice.fileReader();
		
		if (!cartList.isEmpty()) {
			for(String line : cartList) {
				String[] data = line.split("\t");
				qty = Integer.parseInt(data[2]);
				unitPrice = Double.parseDouble(data[3]);
				itemTotal = qty * unitPrice;
				cartTotal += itemTotal;
			}
		}		
		cartTotal =  Math.round(cartTotal * 100.0) / 100.0;
		return cartTotal;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addToCart(String cartLine) {
		return fileInvoice.writeInFile(cartLine);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean newInvoice() {
		return fileInvoice.emptyFile();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkout() {
		try {
			Set<String> cartLines = fileInvoice.fileReader();
			for(String line : cartLines) {
				String[] data = line.split("\t");
				String id = data[0];
				int qty = Integer.parseInt(data[2]);
				itemController.recalculateQuantity(id, qty);
			}
			newInvoice();
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
