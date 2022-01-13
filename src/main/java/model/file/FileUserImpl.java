package main.java.model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FileUserImpl implements FileStrategy{
	
	private static final String USER_FILE = "User.txt";
    private Set<String> list = new TreeSet<>();
    
	private File createFile() {
		try {
			File myObj = new File(USER_FILE);
  	      	if (myObj.createNewFile()) {
  	      		System.out.println("File created: " + myObj.getName());
  	      	} else {
  	      		System.err.println("File already exists.");
  	      	}
  	      	return myObj;
  	    } catch (IOException e) {
  	    	e.printStackTrace();
  	    	return null;
  	    }			
	}
    
	@Override
	public Set<String> fileReader() {
		try(BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
			String line;
			list.clear();
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
			writer.newLine();
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
	public String searchInFile(String target) {
		try {        	       
			Set<String> lines = fileReader();
	        for(String line : lines) {
	        	if(line.contains(target.toLowerCase())) {
	        		return line;
	        	}
	        }
	        return null;
        } catch(Exception e) {
        	e.printStackTrace();
	        return null;        	
        }
	}

	@Override
	public boolean deleteLine(String target) {
		try {
			File file = createFile();
		    File temp = new File("_temp_");
		    BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
		    List<String> out = Files.lines(file.toPath())
		        .filter(line -> !line.contains(target.toLowerCase()))
		        .collect(Collectors.toList());
		    
			Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public boolean emptyFile() {		
        try(PrintWriter writer = new PrintWriter(USER_FILE)) {
            writer.print("");
            writer.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
	}
	

}
