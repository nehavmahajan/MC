package service;
import java.util.HashMap;
import java.util.Vector;

import exceptions.DuplicateUserException;
import exceptions.userNotFoundException;
import model.Booking;
import model.User;


public class accountsService {
	public static HashMap<Integer, User> userMap ;
	
	static {
		userMap = new HashMap<Integer, User>();
	}
	public accountsService() {
	}
	/*-------------------------------------------------------------------------*/
	
	public void registerUser(User u) throws Exception {
		if(userMap.containsKey(u.getUid())) {
			throw new DuplicateUserException("User already exists");
		}
		else {
			userMap.put(u.getUid(), u);
		}
	}
	/*----------------------------------------------------------------------------*/
	
	public void deleteUser(int uid) throws Exception {
		if(!userMap.containsKey(uid)) {
			throw new DuplicateUserException("User not Exist in Database");
		}
		else {
			userMap.remove(uid);
		}
	}
	/*-----------------------------------------------------------------------------*/
	
	public void checkLogin(int uid) throws userNotFoundException {
		if(!userMap.containsKey(uid)) {
			throw new userNotFoundException("User does not exist");
		}
		else {
			System.out.println ("login Successful");
		}
	}
	/*-------------------------------------------------------------------------------*/
	
	public HashMap<Integer, User> getUserMap(){
		return userMap;
	}
	
	public void setVehicleMap(HashMap<Integer, User> userMap) {
		accountsService.userMap = userMap;
	}
	
	/*--------------------------------------------------------------------------------*/
	
	public void resetPassword(int uid, String pwd) throws Exception {
		if(!userMap.containsKey(uid)) {
			throw new DuplicateUserException("User dont exist");
		}
		else {
			User u = userMap.get(uid);
			u.setPwd(pwd);
			userMap.put(uid, u);
		}
	}
	/*---------------------------------------------------------------------------------*/
	
	public Vector<Booking> getBookingDetails(int userId) {
		Vector<Booking> history = userMap.get((Integer)userId).getBooking();
		return history;
	}
}
