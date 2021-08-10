package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import models.Order;
import models.Rating;
import models.Restaurant;
import models.User;

public class DB {
	private static HashMap<String, User> userMap = null;
	private static HashMap<String,ArrayList<Rating>> ratingMap = null;
	private static Vector<Order> orders ;
	public static HashMap<String,Restaurant> restoMap = null;
	
	static {
		userMap = new HashMap<String,User>();
		ratingMap = new HashMap<String, ArrayList<Rating>>();
		orders = new Vector<Order>();
		restoMap= new HashMap<String,Restaurant>();
	}
	
	public static HashMap<String, User> getUserMap() {
		return userMap;
	}
	public static void setUserMap(HashMap<String, User> userMap) {
		DB.userMap = userMap;
	}
	public static HashMap<String, ArrayList<Rating>> getRatingMap() {
		return ratingMap;
	}
	public static void setRatingMap(HashMap<String, ArrayList<Rating>> ratingMap) {
		DB.ratingMap = ratingMap;
	}
	public static Vector<Order> getOrders() {
		return orders;
	}
	public static void setOrders(Vector<Order> orders) {
		DB.orders = orders;
	}
	public static HashMap<String, Restaurant> getRestoMap() {
		return restoMap;
	}
	public static void setRestoMap(HashMap<String, Restaurant> restoMap) {
		DB.restoMap = restoMap;
	}
}
