package main.java.model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FileShopImpl implements FileStrategy {

	private static final String SHOP_FILE = "Shop.txt";
    private Set<String> list = new TreeSet<>();
    
	@Override
	public Set<String> fileReader() {
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
	/**
	 * Disabled in shop payments.
	 */
	public boolean deleteLine(String target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean emptyFile() {
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
