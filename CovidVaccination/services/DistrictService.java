package services;

import java.util.ArrayList;

import models.Ward;
import repository.DB;

public class DistrictService {
	private static DistrictService districtService = null;
	private static DB db = DB.getInstance();
	private DistrictService() {
		
	}
	
	public static DistrictService getInstance() {
		if( districtService == null) {
			return districtService = new DistrictService();
		}
		else {
			return districtService;
		}
	}
	
	public void addWard(String state,String district, String ward) {
		if(db.getStateMap().containsKey(state) && db.getDistrictMap().containsKey(district)) {
			if(db.getWardMap().get(district) == null) {
				db.getDistrictMap().put(district, new ArrayList<Ward>());
			}
			Ward d = new Ward(state,district, ward);
			db.getDistrictMap().get(district).add(d);
			db.getWardMap().put(ward, null);
		}
		else {
			System.out.println("District is not exist");
		}
		// TODO Auto-generated method stub
		
	}
}
