package services;

import database.DB;

public class InterationOperations {
	private static InterationOperations interationOper = null;
	private DB dbInstance = DB.getInstance();
	
	private InterationOperations() {
	}
	
	public static InterationOperations getInstance() {
		if(interationOper == null ) {
			interationOper =  new InterationOperations();
		}
		return interationOper;
	}
	
	public void likePicture(String user, String picture) {
		if(DB.getInstance().getPostMap().get(picture).getLikes().contains(user)) {
			System.out.println(user + " has already liked post , cant like again");
			return;
		}
		dbInstance.getPostMap().get(picture).getLikes().add(user);
		System.out.println("Like added to  " +picture);
		return;
	}

	public void unFollowUser(String param1, String param2) {
		if(!dbInstance.getUserMap().get(param2).getFollowers().contains(param1)) {
			System.out.println(param1 +" is not following "+ param2);
			return;
		}
		dbInstance.getUserMap().get(param2).getFollowers().remove(param1);
	}

	public void followUser(String param1, String param2) {
		if(dbInstance.getUserMap().get(param2).getFollowers().contains(param1)) {
			System.out.println(param1 +" is already following "+ param2);
			return;
		}
		dbInstance.getUserMap().get(param2).getFollowers().add(param1);
	}
	
	public void getPictureLikes(String picture) {
		int count = dbInstance.getPostMap().get(picture).getLikes().size();
		System.out.println("Count of Likes : "+ count);
	}

	public void getfollowedUsers(String param1) {
		int count = dbInstance.getUserMap().get(param1).getFollowers().size();
		System.out.println("Count of Followers : "+ count);
		System.out.println(dbInstance.getUserMap().get(param1).getFollowers());
	}
}
