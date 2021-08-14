package services;

import repository.DB;

public class SnakeService {

	private static  SnakeService snakeSvc = null;
	DB db = DB.getInstance();
	
	private SnakeService() {}
	
	public static SnakeService getInstance() {
		if(snakeSvc == null) {
			return snakeSvc = new SnakeService();
		}
		return snakeSvc;
	}
	
	
	public void addSnake(Integer a, Integer b) {
		db.getSnake().put(a, b);
	}
	
	public boolean isSnakePresent(int targetMove) {
		if(db.getSnake().containsKey(targetMove)) {
			return true;
		}
		
		return false;
	}
}
