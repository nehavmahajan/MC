package repository;

import java.util.Comparator;

import models.Restaurant;

public class sortRestaurantByPrice implements Comparator<Object>{
	public sortRestaurantByPrice() {}
	@Override
	public int compare(Object o1, Object o2) {
		if(((Restaurant) o1).getFoodItemPrice() < ((Restaurant) o2).getFoodItemPrice()) {
			return 1;
		}
		else if(((Restaurant) o1).getFoodItemPrice() == ((Restaurant) o2).getFoodItemPrice()) {
			return 0;
		}
		return -1;
	}
}
