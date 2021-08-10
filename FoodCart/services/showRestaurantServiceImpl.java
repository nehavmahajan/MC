package services;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

import models.Restaurant;
import repository.DB;
import repository.sortRestaurantByPrice;
import repository.sortRestaurantByRating;

public class showRestaurantServiceImpl {
	
	private static showRestaurantServiceImpl showRestaurantServiceImpl = null;
	private showRestaurantServiceImpl() {}
	
	public static showRestaurantServiceImpl getInstance() {
		if(showRestaurantServiceImpl == null ) {
			return new showRestaurantServiceImpl();
		}
		else {
			return showRestaurantServiceImpl;
		}
	}
	
	/*-----------------------------------------------------------------------------------------------*/
	
	public void showRestaurant(Vector<Restaurant> resto,String userId) {
		System.out.println("\nList of Restos in Your Area:\n");
		String pinCode = DB.getUserMap().get(userId).getPincode();
		for(Restaurant i : resto) {
			if(i.getQuantity() > 0 && i.getPinCodes().contains(pinCode)) {
				System.out.println(i.getResturantName() +", "+i.getFoodItem());
			}
		}
	}
	
	/*----------------------------------------------------------------------------------------------------*/
	
	public Vector<Restaurant> sortRestaurant(String param ) {
		Vector<Restaurant> resto = new Vector<Restaurant>();
		Collection<Restaurant> restoCollection =  DB.getRestoMap().values();
		for(Restaurant r : restoCollection) {
			resto.add(r);
		}
		if(param.equals("")) {
			System.out.println("Please take correct Choice");
		}
		if(param.equals("rating")) {
			Collections.sort(resto, new sortRestaurantByRating());
		}
		else {
			Collections.sort(resto, new sortRestaurantByPrice());
		}
		return resto;
	}
	
}
