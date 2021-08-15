package models;

import java.util.UUID;

import database.DB;
import repository.BookingStatus;

public class Booking {
private Object bookingID;
private String movieName;
private String start_time;
private int seatNo;
private String email;
private BookingStatus status;
private String screenNo;

//booking Id, status(failure, success), email , screenNo , ShowName, start-time, seatNo;
	
	public BookingStatus getStatus() {
	return status;
}

public void setStatus(BookingStatus status) {
	this.status = status;
}

	public Booking( String screenNo , String movieName, String startTime ,  int seatNo) {
		this.bookingID = UUID.randomUUID();
		this.email = DB.email;
		this.movieName = movieName;
		this.start_time = startTime;
		this.seatNo = seatNo;
		this.screenNo = screenNo;
	}

	public String getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
	}

	/**
	 * @return the bookingID
	 */
	public Object getBookingID() {
		return bookingID;
	}

	/**
	 * @param bookingID the bookingID to set
	 */
	public void setBookingID(Object bookingID) {
		this.bookingID = bookingID;
	}

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * @return the start_time
	 */
	public String getStart_time() {
		return start_time;
	}

	/**
	 * @param start_time the start_time to set
	 */
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	/**
	 * @return the seatNo
	 */
	public int getSeatNo() {
		return seatNo;
	}

	/**
	 * @param seatNo the seatNo to set
	 */
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
