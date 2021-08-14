package models;

import repository.TaskStatus;
import repository.Type;

public class Task {
	private TaskStatus status;
	private String sprintId;
	private String assignedTo;
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public String getSprintId() {
		return sprintId;
	}

	public void setSprintId(String sprintId) {
		this.sprintId = sprintId;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Task(TaskStatus status, String sprintId , String assignedTo ) {
		this.status = status;
		this.sprintId = sprintId;
		this.assignedTo = assignedTo;
	}

	public Task(TaskStatus status) {
		this.status = status;
	}
}
