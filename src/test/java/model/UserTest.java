package test.java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.model.User;
import main.java.model.UserImpl;
import main.java.model.UserRole;


public class UserTest {
	
	@Test
    @DisplayName("User Builder working correctly.")
    public void testBuilderFields() {
				
		final User admin = new UserImpl.UserBuilder(2)
				.name("Sara")
				.lastname("Briccoli")
                .city("Faenza")
                .role(UserRole.MANAGER)
                .description(null)
                .build();
		
		final User cashier = new UserImpl.UserBuilder(3)
				.name("Jay")
                .build();
        
		System.out.println(admin.getRole() + " " + admin.getDescription());
		
        assertEquals(admin.getName(), "Sara");
        assertEquals(admin.getLastname(), "Briccoli");
        assertEquals(admin.getCity(), Optional.of("Faenza"));
        assertEquals(admin.getRole(), UserRole.MANAGER); 
        assertEquals(admin.getDescription(), Optional.empty());
        
        assertEquals(cashier.getName(), "Jay");   
    }
	
	@Test
	@DisplayName("toString test.")
	public void toStringTest() {
		final User sara = new UserImpl.UserBuilder(4)
				.name("Sara")
				.lastname("Briccoli")
                .city("Faenza")
                .role(UserRole.MANAGER)
                .description(null)
                .build();
		System.out.println(sara.toString());
	}
}
