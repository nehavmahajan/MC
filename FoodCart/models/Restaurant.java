package models;

import java.util.ArrayList;

public class Restaurant {
	private String resturantName;
	private ArrayList<String> pinCodes;
	private String foodItem;
	private int foodItemPrice;
	private int quantity;
	private int rating;
	private String userId;
	
	public Restaurant() {
		
	}

	public Restaurant(String resturantName,ArrayList<String> pinCodes, String foodItem, int foodItemPrice , int quantity,String userId2 ) {
		this.resturantName = resturantName;
		this.pinCodes = pinCodes;
		this.foodItem = foodItem;
		this.foodItemPrice = foodItemPrice;
		this.quantity = quantity;
		this.rating = 0;
		this.userId = userId2;
	}
	public String getResturantName() {
		return resturantName;
	}

	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}

	public ArrayList<String> getPinCodes() {
		return pinCodes;
	}

	public void setPinCodes(ArrayList<String> pinCodes) {
		this.pinCodes = pinCodes;
	}

	public String getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}

	public int getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodItemPrice(int foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
