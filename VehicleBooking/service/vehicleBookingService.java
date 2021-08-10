package service;

import java.util.HashMap;
import java.util.Vector;
import exceptions.VehicleNotPresentException;
import model.Booking;
import model.Vehicle;

public class vehicleBookingService {
	private adminService adminService = null;
	private accountsService accountService = null;
	static HashMap<String, Booking> bookingList;
	static {
		bookingList = new HashMap<String, Booking>();
	}
	public vehicleBookingService() {
		adminService = new adminService();
		accountService = new accountsService();
	}
	/*-------------------------------------------------------------------------------------------------------*/
	
	public void bookVehicle(Booking b) {
		b.getVehicle().setAvailability(b.getVehicle().getAvailability()-1);
		Vector<Booking> v = b.getUser().getBooking();
		bookingList.put(b.getBookingId(),b);
		v.add(b);	
		b.getUser().setBooking(v);
	}
	/*---------------------------------------------------------------------------------------------------------*/
	
	public void returnVehicle(String bookingId ,int userId) throws VehicleNotPresentException {
		HashMap<Integer , Vehicle > vehicleMap = adminService.getVehicleMap();
		
			if(!bookingList.containsKey(bookingId)) {
				throw new VehicleNotPresentException("\nEntry is not in the booking list\n");
			}
			else {
				Vehicle v = bookingList.get(bookingId).getVehicle();
				Integer availability = vehicleMap.get(v.getVehicleId()).getAvailability()+1;
				bookingList.remove(bookingId);
				vehicleMap.get(v.getVehicleId()).setAvailability(availability);
				adminService.setVehicleMap(vehicleMap);
				Vector<Booking> booking = accountService.getUserMap().get(userId).getBooking();
				for( Booking b : booking) {
					if(b.getBookingId().equals(bookingId) ) {
						booking.remove(b);
						break;
					}
				}
			}
		} 
	}
	
	

