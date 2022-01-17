package test.java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.controller.UserController;
import main.java.controller.UserControllerImpl;
import main.java.model.User;
import main.java.model.UserImpl;
import main.java.model.UserRole;


public class UserTest {
	
	@Test
    @DisplayName("User Builder working correctly.")
    public void testBuilderFields() {
				
		final User admin = new UserImpl.UserBuilder(2, "ciao")
				.name("Sara")
				.lastname("Briccoli")
                .city("Faenza")
                .role(UserRole.MANAGER)
                .description(null)
                .build();
		
		final User cashier = new UserImpl.UserBuilder(3, "promto")
				.name("Jay")
                .build();
		
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
		User grace = new UserImpl.UserBuilder(45, "lucky4")
				.name("Grace")
				.lastname("Lion")
                .city("Ravenna")
                .role(UserRole.CUSTOMER)
                .description(null)
                .build();

		UserController c = new UserControllerImpl();
		
//		assertTrue(c.addUser(grace));
//		assertTrue(c.deleteUser(sara.getId()));
	}
}
