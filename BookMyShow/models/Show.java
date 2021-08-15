package models;

import java.util.Vector;

import repository.Seat;

public class Show {
	
	private Vector<Seat> seats;
	private String screenNo;
	private String duration;
	private String startTime;
	private String movieName;

	public Show(String movieName, String startTime, String duration, String screenNo) {
		this.movieName=  movieName;
		this.startTime= startTime;
		this.duration = duration;
		this.screenNo = screenNo;
		this.seats = new Vector<Seat>();
		this.initializeSeats();
	}
	
	public void initializeSeats() {
		Vector<Seat> seats2 = this.seats;
		for (int i = 0; i < 10; i++) {
			seats2.add(Seat.AVAILABLE);
		}
		this.setSeats(seats2);
	}

	public Vector<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Vector<Seat> seats) {
		this.seats = seats;
	}

	public String getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
}
