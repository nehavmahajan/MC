package repository;
import models.User;

import java.util.ArrayList;
import java.util.HashMap;

import models.Ride;
import models.Vehicle;

public class DB {
	private static DB dbService= null;
	private HashMap<String, User> userMap = null;
	private HashMap<String,Vehicle> vehicleMap = null;
	private HashMap<String,Ride> driverMap = null;
	
	

	private DB() {
		userMap = new HashMap<String, User>();
		vehicleMap = new HashMap<String, Vehicle>();
		driverMap = new HashMap<String,Ride>();
	}
	
	public static DB getInstance() {
		if(dbService == null) {
			return dbService = new DB();
		}
		else {
			return dbService;
		}
	}
	
	public HashMap<String, User> getUserMap() {
		return userMap;
	}

	public void setUserMap(HashMap<String, User> userMap) {
		this.userMap = userMap;
	}

	public HashMap<String, Vehicle> getVehicleMap() {
		return vehicleMap;
	}

	public void setVehicleMap(HashMap<String, Vehicle> vehicleMap) {
		this.vehicleMap = vehicleMap;
	}

	public HashMap<String, Ride> getDriverMap() {
		return driverMap;
	}

	public void setDriverMap(HashMap<String, Ride> driverMap) {
		this.driverMap = driverMap;
	}
}
