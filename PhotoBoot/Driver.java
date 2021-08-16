import services.PostService;
import services.UserService;
import exception.InValidArgumentException;
import exception.PostNotFoundException;
import repo.OperationType;
import services.InterationService;

public class Driver {

	public static void main(String[] args) {
		UserService userSvc = UserService.getInstance();
		PostService postSvc = PostService.getInstance();
		InterationService interationSvc= InterationService.getInstance();

		userSvc.registerUser("n1", "29834");
		userSvc.registerUser("n2", "19834");
		userSvc.registerUser("n3", "49834");
		userSvc.registerUser("n4", "69834");
		
		userSvc.postPicture("n1", "picture1");
		userSvc.postPicture("n1", "picture2");
		
		try {
			interationSvc.Interation("n1", "picture5", OperationType.Like);
		} catch (InValidArgumentException e) {
			e.printStackTrace();
		}
		
		try {
			interationSvc.Interation("n2", "n1", OperationType.Follow);
		} catch (InValidArgumentException e) {
			e.printStackTrace();
		}
		
		userSvc.postPicture("n2","picture3");
		
		try {
			postSvc.showPictures();
		} catch (PostNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			interationSvc.getInterations("picture1", OperationType.Like);
		} catch (InValidArgumentException e) {
			e.printStackTrace();
		}
		try {
			interationSvc.getInterations("n1", OperationType.Follow);
		} catch (InValidArgumentException e) {
			e.printStackTrace();
		}
	}

}
