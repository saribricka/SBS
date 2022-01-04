package test.java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.model.Item;
import main.java.model.ItemImpl;
import main.java.model.ShoppingCart;
import main.java.model.ShoppingCartImpl;

public class ItemTest {

	@Test
    @DisplayName("Amount and Discount test.")
    public void amountAndDiscountTest() {
		Item i1 = new ItemImpl("Olive Oil Brisighello 1l", 3, 100.0, null, null, null);
	    Item i2 = new ItemImpl("Cheese Slices", 2, 50.0, null, null, null);
	    Item i3 = new ItemImpl("Bread", 1, 5.0, null, null, null);
	    Item i4 = new ItemImpl("Eggs", 50, 10.0, null, null, null);
	    Item i5 = new ItemImpl("Soya Drink", 2, 100.0, null, null, null);
	    
	    ShoppingCart cart = new ShoppingCartImpl();
	    
	    cart.addToCart(i1);
	    cart.addToCart(i2);
	    cart.addToCart(i3);
	    cart.addToCart(i4);
	    cart.addToCart(i5);
	    
	    cart.showCart();
	    
	    cart.removeFromCart(i1);
	    cart.removeFromCart(i3);
	    cart.removeFromCart(i4);
	    cart.removeFromCart(i5);
	    
	    cart.showCart();
	    
	    double totalAmount = cart.getTotalAmount();
	    System.out.println(totalAmount);
	    
	    cart.addDiscount(0.1);	    
	    cart.printInvoice();
	    
	    assertEquals(cart.getTotalAmount(), 100.0);
        assertEquals(cart.getDiscountedAmount(), 90.0);
	}
	
	@Test
	@DisplayName("Dates test")
	public void dateTest() throws ParseException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
		
		Item i1 = new ItemImpl(null, 0, 0, new Date(2015, 8, 17), null, null);
		Item i2 = new ItemImpl(null, 0, 0, null, new Date(2021, 1, 4), null);
		
		System.out.println("method: " + i2.getExpirationDate());
		try {
			System.out.println("format: " + dateFormatter.parse("Fri Feb 04 00:00:00 CET 3921"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		assertEquals(i1.getReceivedDate(), new Date(2015, 8, 17));
//		assertEquals(i2.getExpirationDate(), new Date(2021, 12, 4));		
		assertTrue(i2.getExpirationDate().compareTo(dateFormatter.parse("Fri Feb 04 00:00:00 CET 3921")) == 0);
		
	}
}
