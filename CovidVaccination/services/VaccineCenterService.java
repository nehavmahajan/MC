package services;


import java.util.ArrayList;
import java.util.Vector;

import models.Booking;
import models.Slot;
import models.VaccineCenter;
import repository.DB;
import repository.Price;
import repository.VaccineType;

public class VaccineCenterService {
	private static VaccineCenterService vaccineCenterService = null;
	private DB db  = DB.getInstance();
	private VaccineCenterService() {
		
	}
	
	public static VaccineCenterService getInstance() {
		if( vaccineCenterService == null) {
			return vaccineCenterService = new VaccineCenterService();
		}
		else {
			return vaccineCenterService;
		}
	}
	
	public void addSlots(String state, String district, String ward, String center, VaccineType vaccineType, int count,int age, String date, Price price) {
		Slot s = new Slot(state, district, ward, center, date, vaccineType,count , age, price);
		ArrayList<VaccineCenter> centers = db.getWardMap().get(ward);
		if(!db.getCenterMap().containsKey(center)) {
			System.out.println("Center is not added");
			return;
		}
		for(VaccineCenter v : centers) {
			if(v.getSlotMap().containsKey(vaccineType)) {
				int count1 = v.getSlotMap().get(vaccineType)+count;
				v.getSlotMap().put(vaccineType, (Integer)count1);
			}else {
				v.getSlotMap().put(vaccineType, (Integer)count);
			}
		}
		db.getCenterMap().get(center).add(s);
		System.out.println("Slots added in - "+center);
	}

	public void showCenterBookingData(String state, String district, String ward, String center) {
		System.out.println("My bookings:");
		Vector<Booking> bookings  = db.getBookings();
		int flag = 0;
		for(Booking b : bookings) {
			
			if(b.getVaccineCenter().equals(center)) {
				flag = 1;
				System.out.println("Date:"+b.getDate()+" VaccineType :"+b.getVaccinetype() +" Patient :" +b.getAadhar() +" Fee"+b.getPrice());
			}
		}
		if(flag == 0) {
			System.out.println("No data found");
		}
		
	}
	
}
