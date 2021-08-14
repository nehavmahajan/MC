package repository;

import java.util.HashMap;

import models.Defect;
import models.Feature;
import models.Sprint;
import models.Story;
import models.User;

public class DB {
	public static DB db= null;
	public static String userId = null;
	private HashMap<String, User> userMap;
	private HashMap<String, String> sprintMap;
	private HashMap<String, Feature> featureMap;
	private HashMap<String, Story> storyMap;
	private HashMap<String, Defect> defectMap;
	
	private DB() {
		userMap = new HashMap<String, User> ();
		sprintMap = new HashMap<String,String>();
		featureMap = new HashMap<String,Feature> ();
		storyMap = new HashMap<String, Story> ();
		defectMap = new HashMap<String, Defect>();
	}
	
	
	public HashMap<String, User> getUserMap() {
		return userMap;
	}

	public void setUserMap(HashMap<String, User> userMap) {
		this.userMap = userMap;
	}

	public HashMap<String, String> getSprintMap() {
		return sprintMap;
	}

	public void setSprintMap(HashMap<String, String> sprintMap) {
		this.sprintMap = sprintMap;
	}

	public HashMap<String, Feature> getFeatureMap() {
		return featureMap;
	}

	public void setFeatureMap(HashMap<String, Feature> featureMap) {
		this.featureMap = featureMap;
	}

	public HashMap<String, Story> getStoryMap() {
		return storyMap;
	}

	public void setStoryMap(HashMap<String, Story> storyMap) {
		this.storyMap = storyMap;
	}

	public HashMap<String, Defect> getDefectMap() {
		return defectMap;
	}

	public void setDefectMap(HashMap<String, Defect> defectMap) {
		this.defectMap = defectMap;
	}

	public static DB getInstance() {
		if(db == null) {
			return db = new DB();
		}
		else {
			return db;
		}
	}
}
