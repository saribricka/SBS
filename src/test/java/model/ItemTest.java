package test.java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.model.Item;
import main.java.model.ItemImpl;
import main.java.model.ShoppingCart;
import main.java.model.ShoppingCartImpl;

public class ItemTest {

	@Test
    @DisplayName("Total Payment test.")
    public void totPayTest() {
		Item i1 = new ItemImpl("20", "Olive Oil Brisighello 1l", 3, 100.0, null, null, null);
	    Item i2 = new ItemImpl("21", "Cheese Slices", 2, 50.0, null, null, null);
	    Item i3 = new ItemImpl("22", "Bread", 1, 5.0, null, null, null);
	    Item i4 = new ItemImpl("23", "Eggs", 50, 10.0, null, null, null);
	    Item i5 = new ItemImpl("24", "Soya Drink", 2, 100.0, null, null, null);
	    
	    ShoppingCart cart = new ShoppingCartImpl();
	    
	    cart.addToCart(i1);
	    cart.addToCart(i2);
	    cart.addToCart(i3);
	    cart.addToCart(i4);
	    cart.addToCart(i5);
	    	    
	    cart.removeFromCart(i1);
	    cart.removeFromCart(i3);
	    cart.removeFromCart(i4);
	    cart.removeFromCart(i5);
	    
	    double totalAmount = cart.getTotalAmount();
	    System.out.println(totalAmount);
	    
	    assertEquals(cart.getTotalAmount(), 100.0);
        
        cart.removeFromCart(i3);
	}
}
