package test.java.model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.controller.ItemController;
import main.java.controller.ItemControllerImpl;
import main.java.model.Item;
import main.java.model.ItemCategory;
import main.java.model.ItemImpl;
import main.java.model.UserImpl;
import main.java.model.file.FileItemImpl;
import main.java.model.file.FileStrategy;
import main.java.model.file.FileUserImpl;

public class FileTest {
	
	/**
	 * These test were useful when developing the file writing and reading methods. 
	 */
	
	@Test
	public void toStringTest() {
		Item i = new ItemImpl("0d5kx", "soya", 0, 2.5, null, null, null);
		System.out.println(i.toString());
	}
	
	@Test
	@DisplayName("FileStrategy Test on creation and writing.")
	public void createWriteTest() {
		var u = new UserImpl.UserBuilder(5, "jko")
				.name("Sara")
				.city("Salvador")
				.build();
		
		FileStrategy f = new FileUserImpl();
		f.writeInFile(u.toString());
	}
	
	@Test
	@DisplayName("FileStrategy Test on reading.")
	public void readTest() {
		FileStrategy f = new FileItemImpl();
		Item i = new ItemImpl("0d5kx", "soya", 50, 2.5, null, null, ItemCategory.BIO);
		f.writeInFile(i.toString());
		System.out.println(f.fileReader());
	}

	@Test
	@DisplayName("Add, Delete, Update and Search Item test.")
	public void itemsOperationsTest() {
		ItemController c = new ItemControllerImpl();
		
		Item i = new ItemImpl("FGH0", "leek", 10, 0.2, null, null, ItemCategory.VEGETABLES);
		c.addItem(i);
		
		Item iv2 = new ItemImpl("FGH0", "leek", 50, 0.4, null, null, ItemCategory.VEGETABLES);
		c.updateItem(iv2);
		
		Item r = c.searchItem(iv2.getBarcode());

		if(iv2.toString().equals(r.toString())) {
			System.out.println("Item check ok");
		} else {
			System.out.println("Something is not working");
		}
	}




}
