package models;

import java.util.ArrayList;

public class User {
		private String userId;
		private String userName;
		private ArrayList<String> stories;
		private ArrayList<String> defects;
		
		public User(String userId, String userName) {
			this.defects = new ArrayList<String>();
			this.stories = new ArrayList<String>();
			this.userId = userId;
			this.userName = userName;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public ArrayList<String> getStories() {
			return stories;
		}
		public void setStories(ArrayList<String> stories) {
			this.stories = stories;
		}
		public ArrayList<String> getDefects() {
			return defects;
		}
		public void setDefects(ArrayList<String> defects) {
			this.defects = defects;
		}
		
		
		
}
