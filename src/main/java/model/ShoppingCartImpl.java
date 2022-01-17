package main.java.model;

import java.util.ArrayList;
import java.util.ListIterator;

public class ShoppingCartImpl implements ShoppingCart {

	ArrayList<Item> items;
	double totalAmount;
	double discountedAmount;
	double discount;
	double tax;
	double toDiscount;
	
	public ShoppingCartImpl() {
		this.items = new ArrayList<Item>();
		this.totalAmount = 0;
		this.discount = 0;
		this.tax = 0.22;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addToCart(Item item) {
		this.items.add(item);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeFromCart(Item itemToDelete) {
		ListIterator<Item> iterator = items.listIterator();
		while(iterator.hasNext()) {
			Item item = iterator.next();
			if (item.getBarcode().equals(itemToDelete.getBarcode())) {
				this.items.remove(itemToDelete);
				break;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getTotalAmount() {
		ListIterator<Item> iterator = items.listIterator();
		this.totalAmount = 0;
		while(iterator.hasNext()) {
			Item item = iterator.next();
			this.totalAmount = this.totalAmount + (item.getUnitPrice() * item.getQuantity());
		}
		return this.totalAmount;
	}
	

}
