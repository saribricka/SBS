package test.java.model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.model.Item;
import main.java.model.ItemImpl;
import main.java.model.ShoppingCart;
import main.java.model.ShoppingCartImpl;

public class ItemTest {

	@Test
    @DisplayName("Item creation working correctly.")
    public void testItemCreation() {
		Item i1 = new ItemImpl("Olive Oil Brisighello 1l", 3, 100.0);
	    Item i2 = new ItemImpl("Cheese Slices", 2, 50.0);
	    Item i3 = new ItemImpl("Bread", 1, 5.0);
	    Item i4 = new ItemImpl("Eggs", 50, 10.0);
	    Item i5 = new ItemImpl("Soya Drink", 2, 100.0);
	    
	    ShoppingCart cart = new ShoppingCartImpl();
	    
	    /* add the item to the cart */
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
	}
}
