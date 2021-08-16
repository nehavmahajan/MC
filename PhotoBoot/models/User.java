package models;

import java.util.ArrayList;
import java.util.TreeSet;

public class User {

		private String uName;
		private String uID;
		private ArrayList<Post> posts;
		private ArrayList<String> followers;

		//User = username, uid , TreeSet<Post> posts, ArrayList<uid > followers
		
	public User(String uName, String uID) {
		this.setuName(uName);
		this.setuID(uID);	
		this.posts = new ArrayList<Post> ();
		this.followers = new ArrayList<String>();
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}

	public ArrayList<String> getFollowers() {
		return followers;
	}

	public void setFollowers(ArrayList<String> followers) {
		this.followers = followers;
	}

	
}
