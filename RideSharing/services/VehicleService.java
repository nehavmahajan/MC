package services;

import exceptions.InvalidPrimaryDetails;
import models.Vehicle;
import repository.DB;
import repository.VehicleType;

public class VehicleService {
	private static VehicleService vehicleService= null;
	private DB dbInstance = DB.getInstance();
	private VehicleService() {}
	
	public static VehicleService getInstance() {
		if(vehicleService == null) {
			return vehicleService = new VehicleService();
		}
		else {
			return vehicleService;
		}
	}
	
	public void addVehicle(String owner, VehicleType type, String vehicleNo) {
		if(vehicleNo == null ) {
			throw new InvalidPrimaryDetails("Vehicle Number is incorrect");
		}
		Vehicle v = new Vehicle(owner, type, owner);
		dbInstance.getVehicleMap().put(vehicleNo, v);
		System.out.println("vehicle added ");
		return;
	}
}
