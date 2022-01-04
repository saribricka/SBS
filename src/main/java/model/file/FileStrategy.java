package main.java.model.file;

import java.io.File;
import java.util.Set;

public interface FileStrategy {

	Set<String> fileReader(String fileName);
	
	boolean writeInFile(final String string);
	
	String searchInFile(String string);
	
	boolean deleteLine(String string);
	
	void emptyFile();
	
	File getFile();
	
	void setFile(String fileName);
}
