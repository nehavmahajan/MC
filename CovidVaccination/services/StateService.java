package services;

import java.util.ArrayList;

import models.District;
import repository.DB;

public class StateService {
	private static StateService stateService = null;
	private static DB db = DB.getInstance();
	
	private StateService() {
		
	}
	
	public static StateService getInstance() {
		if( stateService == null) {
			return stateService = new StateService();
		}
		else {
			return stateService;
		}
	}

	public void addDistrict(String string, String string2) {
		if(db.getStateMap().containsKey(string)) {
			if(db.getStateMap().get(string) == null) {
				db.getStateMap().put(string, new ArrayList<District>());
			}
			District d = new District(string, string2);
			db.getStateMap().get(string).add(d);
			db.getDistrictMap().put(string2, null);
		}
		else {
			System.out.println("State is not exist");
		}
		// TODO Auto-generated method stub
		
	}

	public void addState(String string) {
		db.getStateMap().put(string, new ArrayList<District>());
		
	}
}
