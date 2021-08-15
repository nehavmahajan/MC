package database;

import java.util.HashMap;

import models.Screen;
import models.Show;
import models.User;

public class DB {
	public static String email = null;
	private static DB db = null;
	private HashMap<String,User> userMap = null;
	private HashMap<String, Screen> screenMap =null;
	private HashMap<String, Show > showMap = null;
	
	
	private DB () {
		userMap = new HashMap<String, User>();
		screenMap = new HashMap<String, Screen> ();
		showMap = new HashMap<String,Show>();
	}
	public static DB getInstance() {
		if(db == null) {
			return db = new DB();
		}
		else {
			return db;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		DB.email = email;
	}
	public HashMap<String, User> getUserMap() {
		return userMap;
	}
	public void setUserMap(HashMap<String, User> userMap) {
		this.userMap = userMap;
	}
	public HashMap<String, Screen> getScreenMap() {
		return screenMap;
	}
	public void setScreenMap(HashMap<String, Screen> screenMap) {
		this.screenMap = screenMap;
	}
	public HashMap<String, Show> getShowMap() {
		return showMap;
	}
	public void setShowMap(HashMap<String, Show> showMap) {
		this.showMap = showMap;
	}
	
}
