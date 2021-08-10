package service;

import java.util.HashMap;

import exceptions.VehicleNotPresentException;
import model.Vehicle;


public class adminService {
	public static HashMap<Integer , Vehicle> vehicleMap;
	static {
		vehicleMap = new HashMap<Integer, Vehicle>();
	}
	public adminService() {
		
	}
	public void addVehicle(Vehicle v) {
		vehicleMap.put(v.getVehicleId(), v);
	}
	
	public HashMap<Integer,Vehicle> getVehicleMap(){
		return vehicleMap;
	}
	public void setVehicleMap(HashMap<Integer, Vehicle> vehicleMap) {
		adminService.vehicleMap = vehicleMap;
	}
	
	public void removeVehicle(int vehicleId) throws Exception {
		Integer key = (Integer)vehicleId;
		if(vehicleMap.containsKey(key)){
			vehicleMap.remove(key);
		}
		else {
			throw new VehicleNotPresentException("Vehicle is not added to remove it");
		}
	}
	
	
}
