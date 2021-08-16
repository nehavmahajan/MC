package services;

import java.util.ArrayList;
import java.util.Collections;

import database.DB;
import exception.PostNotFoundException;
import models.Post;

public class PostService {
	private static PostService postSvc = null;
	private DB dbInstance = DB.getInstance();
	
	private PostService() {
	}
	
	public static PostService getInstance() {
		if(postSvc == null ) {
			postSvc =  new PostService();
		}
		return postSvc;
	}
	
	public void showPictures() throws PostNotFoundException {
		ArrayList<Post> posts = new ArrayList<Post> ();
		
		for(Post p : dbInstance.getPostMap().values()) {
			posts.add(p);
		}
		Collections.sort(posts,new DatewiseSorter());
		if(dbInstance.getPostMap().size() == 0) {
			throw new PostNotFoundException("NO posts found");
		}
		for(Post post : dbInstance.getPostMap().values())  {
			System.out.println("Post Name :" +post.getPictureName() +" Posted By :" +post.getUserName()+ " Likes :" +post.getLikes().size());
		}
		return;	
	}
	
	
}
