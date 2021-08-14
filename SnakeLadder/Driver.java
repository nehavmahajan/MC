import repository.DB;
import services.LadderService;
import services.SnakeService;
import services.UserService;

public class Driver {
	public static void main(String[] args) {
		SnakeService snakeSvc = SnakeService.getInstance();
		UserService userSvc = UserService.getInstance();
		
		int diceCount = 1;
		DB.move = diceCount*6+1;
		
		snakeSvc.addSnake(94, 5);
		snakeSvc.addSnake(73, 50);
		snakeSvc.addSnake(45, 20);
		snakeSvc.addSnake(67, 2);
		snakeSvc.addSnake(78, 31);
		snakeSvc.addSnake(98, 61);
		snakeSvc.addSnake(51, 29);
		
		
		LadderService ladderSvc = LadderService.getInstance();
		ladderSvc.addLadder(3,46);
		ladderSvc.addLadder(37,91);
		ladderSvc.addLadder(4,50);
		ladderSvc.addLadder(37,91);
		ladderSvc.addLadder(34,53);
		ladderSvc.addLadder(81,90);
		ladderSvc.addLadder(28,84);
		
		userSvc.addPlayer(1,"Neha");
		userSvc.addPlayer(2,"Shweta");
		userSvc.addPlayer(3, "Komal");
		userSvc.addPlayer(4, "Anjali");
		
		userSvc.startGame();
		
	}
}
