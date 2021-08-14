package models;

import repository.TaskStatus;

public class Defect extends Task{

	private String defectId;
	private String defectTitle;

	public Defect(String defectID, String defectTitle, TaskStatus status, String sprintId, String assignedTo) {
		super(status, sprintId, assignedTo);
		this.defectId = defectID;
		this.defectTitle = defectTitle;
	}

	public Defect(String id, String defectName, TaskStatus status) {
		super(status);
		this.defectId= id;
		this.defectTitle = defectName;
	}

	public String getDefectId() {
		return defectId;
	}

	public void setDefectId(String defectId) {
		this.defectId = defectId;
	}

	public String getDefectTitle() {
		return defectTitle;
	}

	public void setDefectTitle(String defectTitle) {
		this.defectTitle = defectTitle;
	}

}
