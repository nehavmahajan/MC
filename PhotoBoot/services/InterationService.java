package services;

import database.DB;
import exception.InValidArgumentException;
import repo.OperationType;

public class InterationService {
	private static InterationService interationSvc = null;
	private InterationOperations interationOper = InterationOperations.getInstance();
	private DB dbInstance = DB.getInstance();
	
	private InterationService() {
	}
	
	public static InterationService getInstance() {
		if(interationSvc == null ) {
			interationSvc =  new InterationService();
		}
		return interationSvc;
	}
	
	public void Interation(String param1, String param2, OperationType operationType) throws InValidArgumentException {
		if(operationType == OperationType.Follow) {
			//both params should be usernames
			if(!dbInstance.isUserPresent(param1) || !dbInstance.isUserPresent(param2)) {
				throw new InValidArgumentException("Arguments are not valid for Follow operation");
			}
			interationOper.followUser(param1 , param2);
		}
		else if(operationType == OperationType.Like) {
			//first - username second = picture
			if(!dbInstance.isUserPresent(param1) || !dbInstance.isPicturePresent(param2)) {
				throw new InValidArgumentException("Arguments are not valid for like operation");
			}
			interationOper.likePicture(param1, param2);
		}
		else if(operationType == OperationType.Unfollow) {
			//both are usernames
			if(!dbInstance.isUserPresent(param1) || !dbInstance.isUserPresent(param2)) {
				throw new InValidArgumentException("Arguments are not valid for UnFollow operation");
			}
			interationOper.unFollowUser(param1, param2);
		}
	}

		
	public void getInterations(String param1, OperationType operationType) throws InValidArgumentException {
		if(operationType == OperationType.Follow) {
			
			if(!dbInstance.isUserPresent(param1)) {
				throw new InValidArgumentException("Given User is invalid for Follow operation");
			}
			interationOper.getfollowedUsers(param1);
		}
		else if(operationType == OperationType.Like) {
			//first - username second = picture
			if(!dbInstance.isPicturePresent(param1) ) {
				throw new InValidArgumentException("GIven picture is not valid for Like operation");
			}
			interationOper.getPictureLikes(param1);
		}
		else if(operationType == OperationType.Unfollow) {
			System.out.println("Invalid choice given");
		}
	}

	
	
}
