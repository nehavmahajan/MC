package services;

import java.util.ArrayList;
import java.util.HashMap;

import models.Rating;
import repository.DB;

public class RatingServiceImpl {
	private static RatingServiceImpl ratingServiceImpl =null;
	
	private RatingServiceImpl() {
		
	}
	
	public static RatingServiceImpl getInstance() {
		if(ratingServiceImpl == null) {
			return new RatingServiceImpl();
		}
		else {
			return ratingServiceImpl;
		}
	}
	
	/*------------------------------------------------------------------------------------*/
	
	public void createReview(String restoName, int ranking, String comment,String userId) {
		if(ranking< 0 || ranking>5) {
			System.out.println("Rating is wrongly provided");
			return;
		}
		Rating r = new Rating(restoName, ranking,comment,userId);
		if(!DB.getRatingMap().containsKey(restoName)) {
			HashMap<String,ArrayList<Rating>> ratingMap = DB.getRatingMap();
			ratingMap.put(restoName, new ArrayList<Rating>());
			DB.setRatingMap(ratingMap);
			
		}else {
			DB.getRatingMap().get(restoName).add(r);
		}
		
		ArrayList<Rating> ratingsList= DB.getRatingMap().get(restoName);
		int sum = 0;
		for (Rating r1 : ratingsList ) {
			sum+=r1.getRatingnumber();
		}
		if(ratingsList.size() == 0 ) {
			DB.getRestoMap().get(restoName).setRating(0);
		}else {
			DB.getRestoMap().get(restoName).setRating(sum/ratingsList.size());
		}
		
	}
	/*------------------------------------------------------------------------------------*/
	
}
