package main.java.model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class FileUserImpl implements FileStrategy{
	
	private static final String USER_FILE = "User.txt";
    private static final String SEP = File.separator;
    private Set<String> list = new TreeSet<>();
    
	private void createFile() {
    	try {
    	      File myObj = new File(USER_FILE);
    	      if (myObj.createNewFile()) {
    	        System.out.println("File created: " + myObj.getName());
    	      } else {
    	        System.out.println("File already exists.");
    	      }
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }
	}
    
	@Override
	public Set<String> fileReader() {
		try(BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.isEmpty()) {	                   
					list.add(line);
				}
	        }
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean writeInFile(String objectToString) {
		createFile(); //it also checks if the file exists
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
			writer.write(objectToString);
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
		    e.printStackTrace();
		    return false;
		}				
	}

	@Override
	public String searchInFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLine(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void emptyFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFile(String fileName) {
		// TODO Auto-generated method stub
		
	}
	

}
