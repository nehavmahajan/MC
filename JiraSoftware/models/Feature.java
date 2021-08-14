package models;

import java.util.ArrayList;

import repository.TaskStatus;

public class Feature extends Task{

	private Object featureId;
	private String featureName;
	private ArrayList<String> stories;

	
	public Feature( String featureID, String featureName , TaskStatus status, String sprintId, String AssignedTo) {
		super(status, sprintId, AssignedTo);
		this.featureId = featureID;
		this.featureName = featureName;
		this.stories = new ArrayList<String>();
	
	}
	public Feature(String id, String name, TaskStatus status) {
		super(status);
		this.featureId = id;
		this.featureName = name;
		this.stories = new ArrayList<String>();
	}

	public Object getFeatureId() {
		return featureId;
	}

	public void setFeatureId(Object featureId) {
		this.featureId = featureId;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public ArrayList<String> getStories() {
		return stories;
	}

	public void setStories(ArrayList<String> stories) {
		this.stories = stories;
	}

}
