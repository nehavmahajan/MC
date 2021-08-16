package models;

import java.util.ArrayList;
import java.util.Date;

public class Post {
	private String pictureName;
	private String userName;
	private Date date;
	private ArrayList<String> likes;

	//Post = pictureName, date , ArrayList<userid> like
	
	public Post(String pictureName,String userName) {
		this.setPictureName(pictureName);
		this.setUserName(userName);
		this.setDate(new Date());
		this.setLikes(new ArrayList<String>());
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<String> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
