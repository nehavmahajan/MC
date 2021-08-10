package service;

import java.time.LocalDateTime;

import model.Booking;
import model.User;
import model.Vehicle;
import repository.BookingDuration;
import repository.BookingMode;
import repository.VehicleType;

public class modelObjectsCreationService {
	private accountsService accountService = null;
	private adminService adminService = null;
	private vehicleBookingService vehicleBookingSvc =null;
	
	public modelObjectsCreationService() {
		accountService = new accountsService();
		adminService = new adminService();
		vehicleBookingSvc = new vehicleBookingService();
	}
	/*-------------------------------------------------------------------------------------*/
	
	public void addUser(int i, String string, String string2, String string3, int j, String string4) throws Exception {
		User u1 = new User(i,string, string2,string3,j,string4);
		accountService.registerUser(u1);
		System.out.println("User :"+ u1.getUid()+" - "+u1.getuName()+" Registered Sucessfully");
	}
	
	/*------------------------------------------------------------------------------------*/
	
	public void addVehicles(int vehicleId, VehicleType vehicleType, User user, int availability) {
		Vehicle v1 = new Vehicle(vehicleId, vehicleType, user, availability);
		adminService.addVehicle(v1);
		System.out.println("Vehicle :"+ v1.getVehicleId()+" - "+v1.getVehicleType()+" Registered Sucessfully");
	}
	
	/*---------------------------------------------------------------------------------------*/
	
	public void pickVehicle(int vehicleId,int userId, String bookingTitle, String appointmentDate, String src, String dest,
			BookingDuration bookingDuration, BookingMode bookingMode) {
		
		LocalDateTime currDate = java.time.LocalDateTime.now();
		Vehicle vehicle = adminService.getVehicleMap().get(vehicleId);
		User user = accountService.getUserMap().get(userId);
		Booking b1 = new Booking(bookingTitle,currDate, appointmentDate, src, dest, bookingDuration, vehicle, user, bookingMode);
		vehicleBookingService.bookingList.put(b1.getBookingId(),b1);
		vehicleBookingSvc.bookVehicle(b1);
		System.out.println("\nBooking Successful!\n");
	}
}
