package repository;

import java.util.Comparator;

import models.Restaurant;

public class sortRestaurantByRating implements Comparator<Restaurant> {

	public sortRestaurantByRating() {}
	public int compare(Restaurant o1, Restaurant o2) {
		if(o1.getRating() < o2.getRating()) {
			return 1;
		}
		else if(o1.getRating() == o2.getRating()) {
			return 0;
		}
		return -1;
	}
}
