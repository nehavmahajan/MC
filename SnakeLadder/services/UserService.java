package services;

import java.util.Random;

import models.User;
import repository.DB;
import repository.Status;

public class UserService {
	private static  UserService userSvc = null;
	private LadderService ladderSvc = LadderService.getInstance();
	private SnakeService snakeSvc = SnakeService.getInstance();
	Random r = new Random();
	
	DB db = DB.getInstance();
	
	private UserService() {}
	
	public static UserService getInstance() {
		if(userSvc == null) {
			return userSvc = new UserService();
		}
		return userSvc;
	}
	
	
	public void addPlayer(int id, String name) {
		User u = new User(id,name);
		db.getUserMap().put(id, u);
		
	}

	public void startGame() {
		int players = db.getUserMap().size();
		int move = 0;
		int countWins = 0;
		
		do {
			for(int i = 1; i <= players ; i++) {
				
				User currUser = db.getUserMap().get(i);
				
				if(currUser.getStatus() != Status.WIN) {
					
				System.out.println("\nTurn - "+currUser.getuName() + ", Curr position : "+currUser.getMove());
				move = r.nextInt(DB.move);
				int targetMove = 0;
				if(isValid(move, currUser)) {
					if(move == 0 ) {
						move = r.nextInt(DB.move);
					}
					
					if(move == DB.move-1 ) {
						move = checkAllPermutations(currUser, move);
					}
					if(move == 0) {
						continue;
					
					}else {
						targetMove = currUser.getMove()+move;
						if( snakeSvc.isSnakePresent(targetMove)) {
							
							currUser.setMove(db.getSnake().get(targetMove));
							System.out.println("User - "+currUser.getuName()+" diced :"+move+", caught by Snake, moved to "+currUser.getMove());
						}
						else if( ladderSvc.isLadderPresent(targetMove)) {
							currUser.setMove(db.getLadder().get(targetMove));
							System.out.println("User - "+currUser.getuName()+" diced :"+move+", caught by Ladder, moved to "+currUser.getMove());
						}
						else if(isValid(move,currUser)){
							currUser.setMove(targetMove);
							System.out.println("User - "+currUser.getuName()+" diced :"+move+" , moved to "+currUser.getMove());
						}	
					}
					
				}
				if(currUser.getMove() == 100 ) {
					System.out.println( currUser.getuName() +" Won " );
					currUser.setStatus(Status.WIN);
					countWins = countWins + 1;
					currUser.setWinSequenceNo(countWins);
				}
			}}
			System.out.println("-----------------------------");
			
		}while(countWins < players-1);
		
		for(int i = 1 ; i <= players ; i++) {
			if(db.getUserMap().get(i).getStatus() == Status.WIN) {
				System.out.println("Player : "+db.getUserMap().get(i).getuName()+" Won!!!  Rank : " + db.getUserMap().get(i).getWinSequenceNo());	
			}
		}
		
		System.out.println("Game Over!");
	}

	private int checkAllPermutations(User u, int move) {
		System.out.print(" Diced : "+move);
		int checkMove = r.nextInt(DB.move);
		if(checkMove == 0)
			checkMove = r.nextInt(DB.move);
		System.out.print(" Diced : "+checkMove);
		int totalMoves = move+checkMove;
		int count = 2;
		
		while(checkMove == 6 && count<3) {
			checkMove = r.nextInt(DB.move);
			if(checkMove == 0)
				checkMove = r.nextInt(DB.move);
			totalMoves += checkMove;
			count++;
		}
		
		if(totalMoves == (DB.move-1)*3) {
			System.out.print(" Diced : 6 again , lost All");
			return 0;
			}
		
			move = totalMoves;
		System.out.println();
		return move;
	}

	private boolean isValid(int move, User u) {
		if(u.getMove()+move <= DB.N) {
			return true;
		}
		return false;
	}
}
