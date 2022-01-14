package main.java.controller;

import java.util.Set;

public interface ShopController {
	
	boolean addPayment(int userId, Double tot);
	
	Set<String> searchByUser(String target);
	
	Set<String> searchByDate(String target);
}
