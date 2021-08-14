package models;

public class Sprint {
	private String sprintID;
	private String sprintName;

	public Sprint(String sprintId, String name ) {
		this.sprintID = sprintId;
		this.sprintName = name;
	}

	public String getSprintID() {
		return sprintID;
	}

	public void setSprintID(String sprintID) {
		this.sprintID = sprintID;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}
}
