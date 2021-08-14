package repository;

import java.util.HashMap;

import models.User;

public class DB {
	private static DB db = null;
	public static final Integer N = 100;
	public static Integer move ;
	private HashMap<Integer, Integer> snake = null;
	private HashMap<Integer, Integer> ladder = null;
	private HashMap<Integer, User>  userMap = null;
	
	private DB() {
		snake = new HashMap<Integer, Integer>();
		ladder = new HashMap<Integer, Integer> ();
		userMap = new HashMap<Integer,User>();
	}
	
	public HashMap<Integer, User> getUserMap() {
		return userMap;
	}

	public void setUserMap(HashMap<Integer, User> userMap) {
		this.userMap = userMap;
	}

	public static DB getInstance() {
		if(db == null) {
			return db = new DB();
		}
		else {
			return db;
		}
	}

	public HashMap<Integer, Integer> getSnake() {
		return snake;
	}

	public void setSnake(HashMap<Integer, Integer> snake) {
		this.snake = snake;
	}

	public HashMap<Integer, Integer> getLadder() {
		return ladder;
	}

	public void setLadder(HashMap<Integer, Integer> ladder) {
		this.ladder = ladder;
	}
	
}
