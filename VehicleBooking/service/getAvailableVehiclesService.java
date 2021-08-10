package service;

import java.util.HashMap;
import java.util.Vector;
import model.Vehicle;

public class getAvailableVehiclesService {
	private adminService adminService = null;
	public static Vector<Vehicle> available ;
	
	static {
		available = new Vector<Vehicle>();
	}
	
	public getAvailableVehiclesService() {
		adminService = new adminService();
	}
	/*-----------------------------------------------------------------------------------*/
	
	public Vector<Vehicle> getAvailableVehicles() {
		
		HashMap<Integer , Vehicle> vehicleMap = adminService.getVehicleMap();
		
		for(Vehicle v : vehicleMap.values()) {
			if(v.getAvailability() > 0) {
				getAvailableVehiclesService.available.add(v);
			}
		}
		return available;
	}
}
