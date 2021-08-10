package services;

import java.util.ArrayList;
import java.util.List;
import exceptions.UserNotExistException;
import models.User;
import repository.DB;
import repository.Gender;

public class UserServiceImpl {
	private static UserServiceImpl userSvc = null;
	
	private UserServiceImpl() {
		
	}
	
	/*----------------------------------------------------------------------*/
	
	public static UserServiceImpl getInstance() {
		if(userSvc == null ) {
			return new UserServiceImpl();
		}
		else {
			return userSvc;
		}
	}
	
	/*------------------------------------------------------------------------*/
	
	public List<String> getPinCodes(String pincode) {
		String [] pincodes = pincode.split("\\");
		ArrayList<String> pins = new ArrayList<String>();
		for(String i : pincodes) {
			pins.add(i);
		}
		return pins;
	}
	
	/*--------------------------------------------------------------------------*/
	
	public void registerUser(String name, Gender gender ,String phoneNumber, String pincode ) {
		if(phoneNumber.length() > 10) {
			System.out.println("Invalid Phone Number");
			return;
		}
		if( name == "" || pincode == "") {
			System.out.println("Invalid Input Received");
			return;
		}
		User  u = new User(name, gender, phoneNumber, pincode);
		DB.getUserMap().put(phoneNumber, u);
	}
	
	/*------------------------------------------------------------------------*/
	
	public String login(String phoneNumber) throws UserNotExistException {
		if(!DB.getUserMap().containsKey(phoneNumber)) {
			throw new UserNotExistException("User is not present in System");
		}
		System.out.println("\nLogin Success"+phoneNumber);
		return phoneNumber;
	}
	
}
