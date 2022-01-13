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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import main.java.controller.ItemControllerImpl;
import main.java.model.ItemCategory;
import main.java.model.ItemImpl;

public class FileItemImpl implements FileStrategy{

    private static final String ITEM_FILE = "Item.txt";
//    private static final String SEP = File.separator;
//    private static final String BAR = "barcode=";
//    private static final String NAME = "productName=";
//    private static final String QTY = "quantity=";
//    private static final String PRICE = "unitPrice=";
//    private static final String RECEIVED = "receivedDate=";
//    private static final String EXPIRATION = "expirationDate=";
//    private static final String CAT = "category=";
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	private File file;
    private Set<String> list = new TreeSet<>();
//    private ItemControllerImpl itemC = ItemControllerImpl.getInstance();
//    private final List<String> barcodeList = new ArrayList<>();
//    private final List<String> nameList = new ArrayList<>();
//    private final List<Integer> quantityList = new ArrayList<>();
//    private final List<Double> unitPriceList = new ArrayList<>();
//    private final List<Date> receivedDateList = new ArrayList<>();
//    private final List<Date> expirationDateList = new ArrayList<>();
//    private final List<ItemCategory> categoryList = new ArrayList<>();
    
    
//    public void load() {
//    	try (BufferedReader reader = new BufferedReader(new FileReader(ITEM_FILE))) {			
//			reader.lines().forEach(l -> {
//				if (l != null) {
//					if (l.contains(BAR)) {
//						barcodeList.add(l.substring(BAR.length()));
//					}else if (l.contains(NAME)) {
//						nameList.add(l.substring(NAME.length()));
//					}else if (l.contains(QTY)) {
//						quantityList.add(Integer.valueOf(l.substring(QTY.length())));
//					}else if (l.contains(PRICE)) {
//						unitPriceList.add(Double.valueOf(l.substring(PRICE.length())));
//					}else if (l.contains(RECEIVED)) {
//						try {
//							receivedDateList.add(dateFormatter.parse(l.substring(RECEIVED.length())));
//						} catch (ParseException e) {
//							e.printStackTrace();
//						}
//					}else if (l.contains(EXPIRATION)) {
//						try {
//							expirationDateList.add(dateFormatter.parse(l.substring(EXPIRATION.length())));
//						} catch (ParseException e) {
//							e.printStackTrace();
//						}
//					}else if (l.contains(CAT)) {
//						String cat = l.substring(CAT.length());
//						ItemCategory[] allCats = ItemCategory.values();
//						for(var c : allCats) {
//							if(c.toString().equals(cat)) {
//								categoryList.add(c);
//							}
//						}						
//					}
//				}
//			});
//			for (int i = 0; i < barcodeList.size(); i++) {
//                this.itemC.addItem(new ItemImpl(barcodeList.get(i), nameList.get(i), quantityList.get(i),
//                		unitPriceList.get(i), receivedDateList.get(i), expirationDateList.get(i), categoryList.get(i)));
//            }
//    	} catch (final IOException e) {
//    		e.printStackTrace();
//    	}
//    }
    
    private File createFile() {
    	try {
    	      File myObj = new File(ITEM_FILE);
    	      myObj.createNewFile();
    	      return myObj;
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	      return null;
    	    }		
	}
    
	@Override
	public Set<String> fileReader() {
		try(BufferedReader reader = new BufferedReader(new FileReader(ITEM_FILE))) {
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
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(ITEM_FILE, true))) {
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
        try(PrintWriter writer = new PrintWriter(ITEM_FILE)) {
            writer.print("");
            writer.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
	}

}
