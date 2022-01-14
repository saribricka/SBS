package main.java.controller;

import java.io.File;
import java.time.Instant;
import java.util.Set;

import main.java.model.file.FileShopImpl;
import main.java.model.file.FileStrategy;

public class ShopControllerImpl implements ShopController {

	private static final char ATTR_SEP = File.pathSeparatorChar;
	private FileStrategy fileShop = new FileShopImpl();

	@Override
	public boolean addPayment(int userId, Double tot) {
		String time = Instant.now().toString();
		String paymentLine = "start" + ATTR_SEP + userId + ATTR_SEP + tot + ATTR_SEP + time + ATTR_SEP + "end" + "\n";
		return fileShop.writeInFile(paymentLine);
	}
	
	@Override
	public Set<String> searchByUser(String target){
		return null;
	}
	
	
	@Override
	public Set<String> searchByDate(String target){
		return null;
	}
}
