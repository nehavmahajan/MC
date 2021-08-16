package database;

import java.util.HashMap;

import models.Post;
import models.User;

//UserMap<userid, User>
//PostMap<pctureName, post> 

public class DB {
	private static DB dbInstance = null;
	private HashMap<String,User > userMap = null;
	private HashMap<String, Post> postMap  = null;
	
	
	private DB() {
		setUserMap(new HashMap<String, User> ());
		setPostMap(new HashMap<String, Post> ());
	}
	
	public static DB getInstance() {
		if(dbInstance == null ) {
			dbInstance =  new DB();
		}
		return dbInstance;
	}

	public HashMap<String,User > getUserMap() {
		return userMap;
	}

	public void setUserMap(HashMap<String,User > userMap) {
		this.userMap = userMap;
	}

	public HashMap<String, Post> getPostMap() {
		return postMap;
	}

	public void setPostMap(HashMap<String, Post> postMap) {
		this.postMap = postMap;
	}

	public boolean isUserPresent(String userName) {
		return this.userMap.containsKey(userName);
	}
	
	public boolean isPicturePresent(String pictName) {
		return this.postMap.containsKey(pictName);
	}
	
	
}	
