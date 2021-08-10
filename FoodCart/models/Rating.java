package models;

public class Rating {
	private String restaurantName;
	private int ratingnumber;
	private String comment;
	private String userId;
	
	public Rating() {}
	
	public Rating(String restaurantName, int ratingnumber, String comment, String userId) {
		this.setRestaurantName(restaurantName);
		this.setRatingnumber(ratingnumber);
		this.setComment(comment);
		this.setUserId(userId);
	}
	public int getRatingnumber() {
		return ratingnumber;
	}
	public void setRatingnumber(int ratingnumber) {
		this.ratingnumber = ratingnumber;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
