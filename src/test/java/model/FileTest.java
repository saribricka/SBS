package test.java.model;

import java.io.File;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.java.model.file.FileItemImpl;
import main.java.model.file.FileStrategy;

public class FileTest {

	@Test
	@DisplayName("Set and Get file test.")
	public void setGetFileTest() {
		final FileStrategy fs = new FileItemImpl();
		fs.setFile("test1");
		File test = fs.getFile();
		
		System.out.println(test.getName());
	}
}
