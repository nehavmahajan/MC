package services;

import models.Defect;
import models.Feature;
import models.Story;
import models.Task;
import models.User;
import repository.DB;
import repository.TaskStatus;

public class UserService {
		public static UserService userSvc= null;
		private DB db = DB.getInstance();
		private UserService() {
			
		}
		
		public static UserService getInstance() {
			if(userSvc == null) {
				return userSvc = new UserService();
			}
			else {
				return userSvc;
			}
		}
		/*--------------------------------------------------------------------------------*/
		public void addUserToSystem(String userID, String userName) {
			if(db.getUserMap().containsKey(userID)) {
				System.out.println("User is present in System");
				return;
			}
			User u = new User(userID,userName);
			db.getUserMap().put(userID, u);
		}
		
		/*-----------------------------------------------------------------------------------*/
		
		public void assignStory(String taskId, String userID) {
			if(!db.getUserMap().containsKey(userID)) {
				System.out.println("User is not present in System");
				return;
			}
			if(db.getUserMap().get(userID).getStories().contains(taskId)) {
				System.out.println("User is already onwer of that Story");
				return;
			}
			db.getUserMap().get(userID).getStories().add(taskId);
			db.getStoryMap().get(taskId).setAssignedTo(userID);
		}
		
		/*--------------------------------------------------------------------------------*/
		
		public void printMyTasks() {
			System.out.println("Tasks assigned to - "+DB.userId);
			if(db.getUserMap().get(DB.userId).getStories().size() == 0) {
				System.out.println("No Stories Found");
				
			}
			else {
				for(String task : db.getUserMap().get(DB.userId).getStories()) {
					Story s = db.getStoryMap().get(task);
					System.out.println("Story ID :"+s.getSprintId() +" Story Title: "+s.getTitle()+ " Story Sprint :"+s.getSprintId() +" Status :"+s.getStatus());
				}
			}
			if(db.getUserMap().get(DB.userId).getDefects().size() == 0) {
				System.out.println("No Defects Found");
			}
			else {
				for(String task : db.getUserMap().get(DB.userId).getDefects()) {
					Story s = db.getStoryMap().get(task);
					System.out.println("Story ID :"+s.getSprintId() +" Story Title: "+s.getTitle()+ " Story Sprint :"+s.getSprintId() +" Status :"+s.getStatus());
				}
			}
		}
		
		/*--------------------------------------------------------------------------------*/
		
		public void printSprintTasks(String SprintName) {
			String sprintID = db.getSprintMap().get(SprintName);
			
			for(Feature f : db.getFeatureMap().values()) {
				if(f.getSprintId() != null) {
				if(f.getSprintId().equals(sprintID)) {
					System.out.println("Feature :"+f.getFeatureName());
					System.out.println("Stories under this Sprint");
					for(String s: f.getStories()) {
						if(db.getStoryMap().get(s).getSprintId().equals(sprintID)) {
							System.out.println(" Story Id :"+s+"Title: "+db.getStoryMap().get(s).getTitle());
						}
					}
				}}
			}
			System.out.println("Defects under this Sprint :");
			for(Defect d : db.getDefectMap().values()) {
				if(d.getSprintId().equals(sprintID)) {
					System.out.println("Defect ID : "+d.getDefectId()+" Title :"+d.getDefectTitle()+" Status :"+d.getStatus());
				}
			}
		}
		
		/*--------------------------------------------------------------------------------*/
		
		public void getDelayedTasks(String SprintName) {
			
			String sprintID = db.getSprintMap().get(SprintName);
			
			for(Feature f : db.getFeatureMap().values()) {
				if(f.getSprintId()!= null) {
					
				if(f.getSprintId().equals(sprintID)) {
				
					System.out.println("For feature :"+f.getFeatureName());
					for(String s: f.getStories()) {
						if(db.getStoryMap().get(s).getSprintId().equals(sprintID) && !db.getStoryMap().get(s).getStatus().equals(TaskStatus.CLOSED)) {
							System.out.println("Story Id :"+s+"Title: "+db.getStoryMap().get(s).getTitle()+"Status :"+db.getStoryMap().get(s).getStatus());
						}
					}
				}
				}
			}
			System.out.println("Defects Delayed under this Sprint :");
			for(Defect d : db.getDefectMap().values()) {
				if(d.getSprintId().equals(sprintID) && !d.getStatus().equals(TaskStatus.CLOSED)) {
					System.out.println("ID : "+d.getDefectId()+" Title :"+d.getDefectTitle()+" Status :"+d.getStatus());
				}
			}
		}
		
		/*---------------------------------------------------------------------------------------*/
		
		public void createSprint(String id, String name) {
			if(db.getSprintMap().containsKey(id)) {
				System.out.println("Sprint already added");
				return;
			}
			db.getSprintMap().put(id, name);
			System.out.println("Sprint - "+name+" added");
			return;
		}
		
		/*----------------------------------------------------------------------------------------*/
		
		public void createFeature(String id, String featureName, TaskStatus status) {
			if(db.getFeatureMap().containsKey(id)) {
				System.out.println("Feature is already exists");
				return;
			}
			Feature f = new Feature(id, featureName, status);
			db.getFeatureMap().put(id, f);
			System.out.println("Feature - "+featureName+"added");
		}
		
		public void createFeature(String id, String featureName, TaskStatus status, String sprintId, String assignedTo) {
			if(db.getFeatureMap().containsKey(id)) {
				System.out.println("Feature is already exists");
				return;
			}
			Feature f = new Feature(id, featureName, status,sprintId, assignedTo);
			db.getFeatureMap().put(id, f);
			System.out.println("Feature - "+featureName+"added");
		}
		/*-------------------------------------------------------------------------------------------*/
		
		public void createStory(String id, String storyName, TaskStatus status) {
			if(db.getStoryMap().containsKey(id)) {
				System.out.println("Story is already exists");
				return;
			}
			Story s = new Story(id, storyName, status);
			db.getStoryMap().put(id, s);
			System.out.println("Story - "+storyName+"added");
		}
		
		public void createStory(String id, String storyName, TaskStatus status, String sprintId, String assignedTo) {
			if(db.getFeatureMap().containsKey(id)) {
				System.out.println("Feature is already exists");
				return;
			}
			Story s = new Story(id, storyName, status,sprintId, assignedTo);
			db.getStoryMap().put(id, s);
			System.out.println("Story - "+storyName+"added");
		}
		/*--------------------------------------------------------------------------------------------------*/
		
		public void createDefect(String id, String defectName, TaskStatus status) {
			if(db.getDefectMap().containsKey(id)) {
				System.out.println("Defect is already exists");
				return;
			}
			Defect s = new Defect(id, defectName, status);
			db.getDefectMap().put(id, s);
			System.out.println("Defect - "+defectName+"added");
		}
		
		public void createDefect(String id, String defectName, TaskStatus status, String sprintId, String assignedTo) {
			if(db.getDefectMap().containsKey(id)) {
				System.out.println("Feature is already exists");
				return;
			}
			Defect s = new Defect(id, defectName, status,sprintId, assignedTo);
			db.getDefectMap().put(id, s);
			System.out.println("Defect - "+defectName+"added");
		}
		
		/*-------------------------------------------------------------------------------------------------------*/
		
		public void setStatus(String id , TaskStatus status) {
			Task t = getTaskDetails(id);
			if(t == null) {
				System.out.println("Given task is Not present in System");
				return;
			}
			if(t.getStatus() == TaskStatus.CLOSED) {
				System.out.println("Given task was already closed. You can create new followUp task");
				
			}
			t.setStatus(status);
			System.out.println("Status Changed to - "+status);
			return;
		}
		
		public void addStoryToFeature(String storyID ,String featureID) {
			db.getFeatureMap().get(featureID).getStories().add(storyID);
			String sprint = db.getFeatureMap().get(featureID).getSprintId();
			db.getStoryMap().get(storyID).setSprintId(sprint);
			System.out.println("Story added to  - "+featureID);
		}
		/*--------------------------------------------------------------------------------------------------------*/
		
		public void addTaskToSprint(String id, String sprintName) {
			String sprintID = db.getSprintMap().get(sprintName);
			if(sprintID == null) {
				System.out.println("Given Sprint is invalid");
				return;
			}
			Task t = getTaskDetails(id);
			if(t == null) {
				System.out.println("Given task is Not present in System");
				return;
			}
			if(t.getStatus() == TaskStatus.CLOSED) {
				System.out.println("Given task is already closed");
			}
			t.setSprintId(sprintID);
			System.out.println("Task - "+id+" added to "+sprintName);
			return;
		}

		public void removeTaskFromSprint(String id, String sprintName) {
			String sprintID = db.getSprintMap().get(sprintName);
			if(sprintID == null) {
				System.out.println("Given Sprint is invalid");
				return;
			}
			Task t = getTaskDetails(id);
			if(t == null) {
				System.out.println("Given task is Not present in System");
				return;
			}
			
			if(t.getSprintId().equals(sprintName)) {
				System.out.println("Invalid data received!");
				return;
			}
			if(t.getStatus() == TaskStatus.CLOSED) {
				System.out.println("Given task is already closed");
			}
			t.setSprintId(null);
			return;
		}
		/*--------------------------------------------------------------------------------------------------------------*/
		
		private Task getTaskDetails(String id) {
			if(db.getFeatureMap().containsKey(id)) {
				return db.getFeatureMap().get(id);	
			}
			if(db.getStoryMap().containsKey(id)) {
				return db.getStoryMap().get(id);
			}
			if(db.getDefectMap().containsKey(id)) {
				return db.getDefectMap().get(id);
			}
			return null;
		}

		public void login(String string) {
			if(db.getUserMap().containsKey(string)) {
				DB.userId = string;
				System.out.println("Current logged in as - "+string);
			}
			else {
				System.out.println("User is not present in System");
				return;
			}
			// TODO Auto-generated method stub
			
		}
		
		
		
}
