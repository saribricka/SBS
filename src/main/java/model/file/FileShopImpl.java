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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FileShopImpl implements FileStrategy {

	private static final String SHOP_FILE = "Shop.txt";
    private Set<String> list = new TreeSet<>();
    
    private File createFile() {
    	try {
    		String filePath = System.getProperty("user.dir") + File.separator + SHOP_FILE;
    	    File myObj = new File(filePath);
    	    myObj.createNewFile();
    	    return myObj;
    	} catch (IOException e) {
    	    e.printStackTrace();
    	    return null;
    	}		
	}
    
	@Override
	public Set<String> fileReader() {
		createFile();
		try(BufferedReader reader = new BufferedReader(new FileReader(SHOP_FILE))) {
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
		createFile();
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(SHOP_FILE, true))) {
			writer.write(objectToString);
			writer.flush();
			writer.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
	@Override
	public String searchInFile(String target) {
		try {       
			createFile();
			Set<String> lines = fileReader();
	        for(String line : lines) {
	        	String[] data = line.split("\t");
	    		String barcode = data[0];
	        	if(barcode.contains(target.toLowerCase())) {
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
		    List<String> out = Files.lines(file.toPath())
		        .filter(line -> !line.split("\t")[0].contains(target.toLowerCase()))
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
		createFile();
		try(PrintWriter writer = new PrintWriter(SHOP_FILE)) {
            writer.print("");
            writer.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public Set<String> getAllId() {
		Set<String> ides = new HashSet<>();
		Set<String> lines = fileReader();
		String id;
		
		for(String line : lines) {
			String[] data = line.split("\t");			
			id = data[0];
			ides.add(id);
		}
		return ides;
	}

}
