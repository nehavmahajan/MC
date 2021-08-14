import repository.TaskStatus;
import services.UserService;

public class Driver {
	public static void main(String arg[]) {
		UserService userSvc= UserService.getInstance();
		
		userSvc.addUserToSystem("1","Neha");
		userSvc.addUserToSystem("2","Abc");
		userSvc.addUserToSystem("3","Pqr");
		userSvc.addUserToSystem("4","Stu");
		userSvc.login("1");
		
		userSvc.createSprint("PI2108", "Sprint-01");
		
		userSvc.createFeature("f01", "DHX Migration", TaskStatus.DRAFT);
		userSvc.addTaskToSprint("f01", "PI2108");
		
		userSvc.createStory("s01", "upgrade to 7.0-1", TaskStatus.DRAFT);
		userSvc.addStoryToFeature("s01", "f01");
		
		userSvc.createStory("s02", "upgrade to 7.0-Code Promotion", TaskStatus.DRAFT);
		userSvc.addStoryToFeature("s02", "f01");
		userSvc.createStory("s03", "upgrade to 7.0-AutoTests", TaskStatus.DRAFT);
		userSvc.addStoryToFeature("s03", "f01");
		userSvc.createStory("s04", "upgrade to 7.0-Performance Improvement", TaskStatus.DRAFT);
		userSvc.addStoryToFeature("s04", "f01");
		
		userSvc.createDefect("d01", "updations in bulk operation",TaskStatus.DRAFT,"PI2108","2");
		userSvc.createStory("s05", "Sustainment", TaskStatus.DRAFT);
		userSvc.assignStory("s04", "1");
		
		userSvc.setStatus("d01",TaskStatus.DEVELOP);
		userSvc.addTaskToSprint("d01", "PI2108");
		
		System.out.println("\n Delayed tasks for this sprint");
		userSvc.getDelayedTasks("PI2108");
		userSvc.setStatus("d01", TaskStatus.CLOSED);
		
		System.out.println("\n Delayed tasks for this sprint");
		userSvc.getDelayedTasks("PI2108");
		
		userSvc.printMyTasks();
		userSvc.setStatus("s01", TaskStatus.CLOSED);
		
		System.out.println("\n Delayed tasks for this sprint");
		userSvc.getDelayedTasks("PI2108");
		
		System.out.println("\n Tasks for this sprint");
		userSvc.printSprintTasks("PI2108");
		
	}
}
