package services;

import repository.DB;

public class LadderService {
	private static  LadderService ladderSvc = null;
	DB db = DB.getInstance();
	
	private LadderService() {}
	
	public static LadderService getInstance() {
		if(ladderSvc == null) {
			return ladderSvc = new LadderService();
		}
		return ladderSvc;
	}
	
	
	public void addLadder(Integer a, Integer b) {
		db.getLadder().put(a, b);
	}
	
	public boolean isLadderPresent(int targetMove) {
		if(db.getLadder().containsKey(targetMove)) {
			return true;
		}
		
		return false;
	}
}
