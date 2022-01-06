package test.java.model;

import java.io.File;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.model.Item;
import main.java.model.ItemImpl;
import main.java.model.User;
import main.java.model.UserImpl;
import main.java.model.file.FileItemImpl;
import main.java.model.file.FileStrategy;
import main.java.model.file.FileUserImpl;

public class FileTest {

	@Test
	@DisplayName("Set and Get file test.")
	public void setGetFileTest() {
//		final FileStrategy fs = new FileItemImpl();
//		fs.setFile("test1");
//		File test = fs.getFile();
//		
//		System.out.println(test.getName());
	}
	
	@Test
	public void randomTest() {
		Item i = new ItemImpl("0d5kx", "soya", 0, 2.5, null, null, null);
		System.out.println(i.toString());
	}
	
	@Test
	@DisplayName("FileStrategy Test on creation and writing.")
	public void createWriteTest() {
		var u = new UserImpl.UserBuilder()
				.name("Sara")
				.city("Salvador")
				.isAdmin(false)
				.build();
		
		FileStrategy f = new FileUserImpl();
		f.writeInFile(u.toString());
	}
	
	@Test
	@DisplayName("FileStrategy Test on reading.")
	public void readTest() {
		FileStrategy f = new FileUserImpl();
		f.writeInFile(null);
		System.out.println(f.fileReader());
	}






}
