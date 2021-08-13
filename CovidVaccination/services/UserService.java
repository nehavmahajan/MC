package services;


import java.util.ArrayList;
import java.util.Vector;

import exceptions.UserNotFoundException;
import models.Booking;
import models.Slot;
import models.User;
import models.VaccineCenter;
import repository.DB;
import repository.Price;
import repository.Status;
import repository.VaccineType;
public class UserService {
	private static UserService userService = null;
	private static DB db = DB.getInstance();
	private UserService() {
		
	}
	
	public static UserService getInstance() {
		if( userService == null) {
			return userService = new UserService();
		}
		else {
			return userService;
		}
	}
	
	public void registerUser(String aadhar, String mail, String name, int age, String state, String district, String ward ) {
		if(aadhar.length() != 12) {
			System.out.println("AADHAR invalid");
			return;
		}
		User u  = new User(aadhar, name , mail, age, state,district,ward );
		db.getUserMap().put(aadhar, u);
		return;
	}

	public void loginUser(String string) throws UserNotFoundException {
		
		if(db.getUserMap().containsKey(string)) {
			DB.userId = string;
			System.out.println("login Success");
		}
		else {
			throw new UserNotFoundException("User is Invalid");
		}
	}

	public void showBookingData() {
		Vector<Booking> slot = db.getUserMap().get(DB.userId).getSlots();
		if(slot.size() == 0 ) {
			System.out.println("No Slot booked yet");
			return;
		}
		for(Booking s: slot) {
			System.out.println("Date :"+s.getDate()+"Center: "+s.getVaccineCenter()+"Type :"+s.getVaccinetype() +" Fees : "+s.getPrice());
		}
		
		
	}
	
	public void checkSlot(String state, String dist, String ward, VaccineType vaccinetype, String date, int age,
			 Price price) {
		if(db.getWardMap().size() == 0 ) {
			System.out.println("No data found");
		}
		else {
			ArrayList<VaccineCenter> centers = db.getWardMap().get(ward);
			int count  = 0;
			for(VaccineCenter v : centers ) {
				ArrayList<Slot> slot = db.getCenterMap().get(v.getVaccineCenter());
				for(Slot s : slot) {
					if(s.getStateName().equals(state) && s.getDistrictName().equals(dist) && s.getWardName().equals(ward) && s.getDate().equals(date) && v.getSlotMap().containsKey(vaccinetype) 
							&& v.getStatus() != Status.BOOKED ) {
						count++;
						System.out.println(count+") Center :"+v.getVaccineCenter() +" Date:"+s.getDate()+ " VaccineType :"+vaccinetype +" Count: "+v.getSlotMap().get(vaccinetype));
					}
				}
					
			}
			System.out.println("Total Found :" + count);
		}
		
	}

	public void bookSlot(String ward, String center, VaccineType covishield, String string, int i, Price free,String date) {
		
		for (VaccineCenter v : db.getWardMap().get(ward)) {
			if(v.getVaccineCenter().equals(center)) {
				if(v.getSlotMap().containsKey(covishield) && v.getSlotMap().get(covishield)>0 ) {
					int count1 = v.getSlotMap().get(covishield)-1;
					v.getSlotMap().put(covishield, (Integer)count1);
					v.setStatus(Status.PARTIALBOOKED);
					if(v.getSlotMap().get(covishield) == 0) {
						v.setStatus(Status.BOOKED);
					}
					Booking b = new Booking(DB.userId,date,covishield,free,center);
					db.getBookings().add(b);
					db.getUserMap().get(DB.userId).getSlots().add(b);
					return;
				}
				
			}
		}
		// TODO Auto-generated method stub
		
	}
}
