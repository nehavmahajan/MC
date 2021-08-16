package services;

import database.DB;
import models.Post;
import models.User;

public class UserService {
		
	private static UserService userSvc = null;
	private DB dbInstance = DB.getInstance();
	
	private UserService() {
	}
	
	public static UserService getInstance() {
		if(userSvc == null ) {
			userSvc =  new UserService();
		}
		return userSvc;
	}
	
	public void registerUser(String uName, String uId ) {
		if(uName.equals(null) || uId.equals(null)) {
			System.out.println("ENter Valid Details");
			return;
		}
		if(dbInstance.getUserMap().containsKey(uName)) {
			System.out.println("User already exists with System");
			return;
		}
		
		User user =  new User(uName, uId) ;
		
		dbInstance.getUserMap().put(uName, user);
		System.out.println("User registred SUccessfully");
	}
	
	
	public void postPicture(String uName, String picture) {
		if(uName.equals(null) || picture.equals(null)) {
			System.out.println("either Username or picture is null");
			return;
		}
		if(!dbInstance.getUserMap().containsKey(uName)) {
			System.out.println("User is not exists,post cant be added");
			return;
		}
		User user = dbInstance.getUserMap().get(uName);
		Post  post = new Post(picture, uName );
		user.getPosts().add(post);
		dbInstance.getPostMap().put(picture, post);
		return ;
	}
	

}
