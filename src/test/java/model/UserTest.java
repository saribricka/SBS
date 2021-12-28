package test.java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.model.User;
import main.java.model.UserImpl;


public class UserTest {
	
	@Test
    @DisplayName("User Builder working correctly.")
    public void testBuilderFields() {
				
		final User admin = new UserImpl.UserBuilder()
				.name("Sara")
				.lastname("Briccoli")
                .city("Faenza")
                .address("Vittorio Veneto 2/3")
                .description(null)
                .isAdmin(true)
                .build();
		
		final User cashier = new UserImpl.UserBuilder()
				.name("Jay")
                .isAdmin(false)
                .build();
        
		System.out.println(admin.getAddress() + " " + admin.getDescription());
		
        assertEquals(admin.getName(), "Sara");
        assertEquals(admin.getLastname(), "Briccoli");
        assertEquals(admin.isAdmin(), true);
        assertEquals(admin.getCity(), Optional.of("Faenza"));
        assertEquals(admin.getAddress(), Optional.ofNullable("Vittorio Veneto 2/3")); 
        assertEquals(admin.getDescription(), Optional.empty());
        
        assertEquals(cashier.getName(), "Jay");
        assertEquals(cashier.isAdmin(), false);
       
    }
}
