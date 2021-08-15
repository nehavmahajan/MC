package services;

import database.DB;
import exceptions.UserAlreadyExistsException;
import models.Booking;
import models.User;

public class UserService {
	private static UserService userSvc = null;
	private DB db= DB.getInstance();
	private UserService() {
		
	}
	
	public static UserService getInstance() {
		if( userSvc == null) {
			return userSvc = new UserService();
		}
		else {
			return userSvc;
		}
	}
	
	public void registerUser(String email, String name, int age, String payment) throws UserAlreadyExistsException {
		if(db.getUserMap().containsKey(email)) {
			throw new UserAlreadyExistsException("User is already present with this mail");
		}
		User u  = new User(email, name, age, payment);
		db.getUserMap().put(email, u);
		return;
	}
	
	public void login(String email) {
		if(db.getUserMap().containsKey(email)) {
			db.setEmail( email);
			System.out.println("\nlogin Success");
		}
		else {
			System.out.println("\nLogin failed . Please enter correct Details");
			return;
		}
	}
	
	public void checkBookings(String umail) {
		String mail  = umail;
		System.out.println("\nMy Bookings: (User : "+umail+")");
		if(db.getUserMap().get(mail).getMyBooking().size() == 0) {
			System.out.println("NO DATA FOUND");
			return;
		}
		
		for (Booking b : db.getUserMap().get(mail).getMyBooking()) {
			System.out.println("Movie - "+b.getMovieName()+", Seat : "+b.getSeatNo()+" Time : "+b.getStart_time());
		}
	}
	
	
}
