package models;

import repository.Status;

public class User {
	private int id;
	private String uName;
	private Integer move;
	private Status status;
	private int winSequenceNo;
	
	public int getWinSequenceNo() {
		return winSequenceNo;
	}

	public void setWinSequenceNo(int winSequenceNo) {
		this.winSequenceNo = winSequenceNo;
	}

	public User(int  id, String uName) {
		this.id = id;
		this.uName = uName;
		this.move = 0;
		this.status = Status.PLAYING;
		this.winSequenceNo = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public Integer getMove() {
		return move;
	}

	public void setMove(Integer move) {
		this.move = move;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
