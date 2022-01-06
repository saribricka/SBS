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
	
	@Override
	public void addToCart(Item item) {
		this.items.add(item);
	}

	@Override
	public void showCart() {
		ListIterator<Item> iterator = items.listIterator();
		while(iterator.hasNext()) {
			Item item1 = iterator.next();
			System.out.println(item1);
		}
	}

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

	@Override
	public double getTotalAmount() {
		ListIterator<Item> iterator = items.listIterator();
		this.totalAmount = 0;
		while(iterator.hasNext()) {
			Item item = iterator.next();
			this.totalAmount = this.totalAmount + (item.getUnitPrice() * item.getQuantity());
		}
		if (this.discount > 0){
			getDiscountedAmount();
		}
		return this.totalAmount;
	}

	@Override
	public double getDiscountedAmount() {
		this.toDiscount = this.totalAmount * this.discount;
		this.discountedAmount = this.totalAmount - this.toDiscount;
		return this.discountedAmount;
	}
	
	@Override
	public void addDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public void printInvoice() {
		ListIterator<Item> iterator = items.listIterator();
		while(iterator.hasNext()) {
			Item item = iterator.next();
			System.out.print(item.getName() + "\t");
			System.out.print(item.getQuantity() + "\t");
			System.out.print(item.getUnitPrice() + "\t");
			System.out.println(item.getUnitPrice() * item.getQuantity());
		}
		this.addDiscount(this.discount);
		this.getTotalAmount();
		System.out.println("\t\t\t" + "Ammount  :  " + this.totalAmount);		
		System.out.println("\t\t\t" + "Discount :  -" + this.toDiscount);
		System.out.println("\t\t\t" + "Tax      :  " + this.tax);
		System.out.println("\t\t\t" + "Total    :  " + this.discountedAmount);
	}

	

}
