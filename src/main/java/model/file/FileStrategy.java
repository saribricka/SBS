package main.java.model.file;

import java.io.File;
import java.util.Set;

public interface FileStrategy {
	
	Set<String> fileReader();
	
	boolean writeInFile(final String objectToString);
	
	String searchInFile(String target);
	
	boolean deleteLine(String target);
	
	boolean emptyFile();
	
	Set<String> getAllId();
}
