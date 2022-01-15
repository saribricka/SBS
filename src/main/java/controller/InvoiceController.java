package main.java.controller;

public interface InvoiceController {

	String createInvoiceItem(String itemId, String qty);
	
	Double calculateTotal();
	
	boolean addToCart(String cartLine);
	
	boolean newInvoice();
}
