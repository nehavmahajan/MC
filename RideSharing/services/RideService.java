package services;

import java.util.ArrayList;
import java.util.Collections;

import models.Ride;
import models.User;
import repository.DB;
import repository.RideStatus;
import repository.VehicleStatus;
import repository.VehicleType;

public class RideService {
	private static RideService rideService= null;
	private DB dbInstance = DB.getInstance();
	private RideService() {}
	
	public static RideService getInstance() {
		if(rideService == null) {
			return rideService = new RideService();
		}
		else {
			return rideService;
		}
	}
	
	public void offerRide(String driverName, String src, String dest, int seats, VehicleType vehicleType , String vehicleNo ) {
		RideStatus ridestatus= RideStatus.OFFERED;
		VehicleStatus vehiclestatus = VehicleStatus.AVAILABLE;
		Ride r = new Ride(vehicleNo,driverName, src,  dest , vehicleType,  seats, ridestatus,  vehiclestatus);
		dbInstance.getDriverMap().put(vehicleNo,r);
		dbInstance.getUserMap().get(driverName).getRidesOffer().add(r);
	}
	
	public void selectRide(String passangerName, String src, String dest , int seats, String criteria) {
		
		ArrayList<Ride> rides = this.getValidVehicles(src,dest,seats);
		Ride r = null;
		if(criteria.equals("Most Vacant")) {
			Collections.sort(rides, new VacancySort());
			r = this.getRideByMostVacant(rides,seats);
			if(r == null) { return;}
			r.setRideStatus(RideStatus.TAKEN);
			r.setVehicleStatus(VehicleStatus.BLOCKED);
			dbInstance.getUserMap().get(passangerName).getRidesShare().add(r);
		}
		else {
			String inputs []= criteria.split("=");
			String vehicleName = inputs[1];
			r = this.getRideByVehicle(vehicleName, rides) ;
			if(r == null) { return;}
			r.setRideStatus(RideStatus.TAKEN);
			r.setVehicleStatus(VehicleStatus.BLOCKED);
			dbInstance.getUserMap().get(passangerName).getRidesShare().add(r);
		}
		System.out.println("Ride booked !" +r.getVehicleNo());
		dbInstance.getDriverMap().get(r.getVehicleNo()).setNoOfSeats(dbInstance.getDriverMap().get(r.getVehicleNo()).getNoOfSeats()-seats);
		dbInstance.getDriverMap().get(r.getVehicleNo()).setVehicleStatus((dbInstance.getDriverMap().get(r.getVehicleNo()).getNoOfSeats()==0)? VehicleStatus.BLOCKED : VehicleStatus.PARTIAL_AVAILABLE);
	}

	private Ride getRideByMostVacant(ArrayList<Ride> rides, int seats) {
		if(rides.size() == 0 ) {
			System.out.println("NO vehicle is vacant");
			return null;
		}
		else {
			return rides.get(0);
		}
		
	}

	private Ride getRideByVehicle(String vehicleName, ArrayList<Ride> rides) {
		for(Ride r : rides) {
			if(r.getVehicleType().toString().equals(vehicleName.toUpperCase())) {
				return r;
			}
		}
		System.out.println("There is no Ride for"+vehicleName+" Vehicle");
		return null;
	}

	private ArrayList<Ride> getValidVehicles(String src, String dest, int seats) {
		ArrayList<Ride> rides = new ArrayList<Ride>();
		
		for( Ride r : dbInstance.getDriverMap().values() ) 
		{
			if(r.getNoOfSeats() >= seats && !r.getRideStatus().equals(RideStatus.COMPLETED) && !r.getVehicleStatus().equals(VehicleStatus.BLOCKED) && r.getSrc().equals(src) && r.getDest().equals(dest) ) {
				rides.add(r);
			}
		};
		return rides;
	}
	
	public void endRide (String VehicleNumber, String passanger, String src, String dest, int seats) {
		dbInstance.getDriverMap().get(VehicleNumber).setNoOfSeats(seats + dbInstance.getDriverMap().get(VehicleNumber).getNoOfSeats());
		dbInstance.getDriverMap().get(VehicleNumber).setRideStatus(RideStatus.OFFERED);
		dbInstance.getDriverMap().get(VehicleNumber).setVehicleStatus((dbInstance.getDriverMap().get(VehicleNumber).getVehicleStatus() == VehicleStatus.BLOCKED)? VehicleStatus.AVAILABLE:VehicleStatus.PARTIAL_AVAILABLE);
		System.out.println("Ride ended");
	}
	
	public void printTotalRides() {
		for(User u : dbInstance.getUserMap().values()) {
			System.out.println("user  :" +u.getName());
			for(Ride r1 : u.getRidesOffer()) {
				System.out.println(r1.getSrc() +" Dest :" +r1.getDest() +" Vehicle :"+r1.getVehicleType());
			}
			for(Ride r1 : u.getRidesShare()) {
				System.out.println(r1.getSrc() +" Dest :" +r1.getDest() +" Vehicle :"+r1.getVehicleType());
			}
		}
	}
}
