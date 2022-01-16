package main.java.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import main.java.model.User;
import main.java.model.file.FileShopImpl;
import main.java.model.file.FileStrategy;

public class ShopControllerImpl implements ShopController {

	private FileStrategy fileShop = new FileShopImpl();
	private UserController userController = new UserControllerImpl();

	@Override
	public boolean addPayment(int userId, Double tot) {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm:ss")
				.withZone(ZoneId.from(ZoneOffset.UTC));
		String time = formatter.format(Instant.now());
		User u = userController.searchUser(userId);
		String paymentLine = time + "\t" + userId + "\t" + u.getName() + " " + u.getLastname() + "\t" + tot + "\n";
		return fileShop.writeInFile(paymentLine);
	}

	@Override
	public Set<String> showPayments() {
		Set<String> payments = fileShop.fileReader();
		return payments;
	}
}
