package services;

import java.util.ArrayList;

import models.Slot;
import models.VaccineCenter;
import repository.DB;

public class WardService {
	
	private static WardService wardService = null;
	private static DB db = DB.getInstance();
	private WardService() {
		
	}
	
	public static WardService getInstance() {
		if( wardService == null) {
			return wardService = new WardService();
		}
		else {
			return wardService;
		}
	}

	public void addCenter(String state, String district, String ward,String center) {
		if(db.getStateMap().containsKey(state) && db.getDistrictMap().containsKey(district) && db.getWardMap().containsKey(ward)) {
			if(db.getCenterMap().containsKey(center)) {
				System.out.println("Center is already added");
				return;
			}
			if(db.getWardMap().get(ward) == null) {
				db.getWardMap().put(ward, new ArrayList<VaccineCenter>());
			}
			VaccineCenter d = new VaccineCenter(state,district, ward,center);
			db.getWardMap().get(ward).add(d);
			db.getCenterMap().put(center, new ArrayList<Slot>());
			System.out.println("accination center added - "+center);
		}
		else {
			System.out.println("District\\ward is not exist");
		}
		// TODO Auto-generated method stub
		
	}
}
