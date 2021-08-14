package models;

import repository.TaskStatus;

public class Story extends Task{

	private String storyId;
	private String title;

	public Story(String  storyId , String title ,TaskStatus status, String sprintId, String assignedTo) {
		super(status, sprintId, assignedTo);
		this.storyId = storyId;
		this.title = title;
	}

	public Story(String id, String storyName, TaskStatus status) {
		super(status);
		this.storyId = id;
		this.title = storyName;
		// TODO Auto-generated constructor stub
	}

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	} 

}
