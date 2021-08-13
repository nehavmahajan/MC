package services;

import exceptions.InvalidPrimaryDetails;
import models.User;
import repository.DB;
import repository.Gender;

public class UserService {
	private static UserService userService= null;
	private DB dbInstance = DB.getInstance();
	private UserService() {}
	
	public static UserService getInstance() {
		if(userService == null) {
			return userService = new UserService();
		}
		else {
			return userService;
		}
	}
	
	public void registerUser(String aadhar, String name,Gender gender , int age) {
		if(aadhar.length() != 12) {
			throw new InvalidPrimaryDetails("Aadhar is Invalid");
		}
		User u = new User(aadhar, name, age,gender);
		dbInstance.getUserMap().put(name, u);
		System.out.println("User added!");
		return;
	}
	
	
}
