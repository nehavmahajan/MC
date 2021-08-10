package model;

import java.time.LocalDateTime;
import java.util.UUID;
import repository.BookingDuration;
import repository.BookingMode;

public class Booking {
	private String bookingId;
	private String bookingTitle;
	private LocalDateTime bookedDateTime;
	private String bookAppointmentDate;
	private String src;
	private String dest;
	private BookingDuration bookingDuration;
	private Vehicle vehicle;
	private User user;
	private BookingMode bookingMode;
	
	public Booking(String bookingTitle, LocalDateTime bookedDateTime, String appointmentDate,String src, String dest, 
			BookingDuration bookingDuration, Vehicle vehicle, User user, BookingMode bookingMode) {
		this.bookingId = UUID.randomUUID().toString();
		this.bookingTitle = bookingTitle;
		this.bookedDateTime = bookedDateTime;
		this.bookAppointmentDate = appointmentDate;
		this.setSrc(src);
		this.setDest(dest);
		this.setBookingDuration(bookingDuration);
		this.vehicle = vehicle;
		this.user= user;
		this.bookingMode = bookingMode;
		
	}
	
	public String getBookingId() {
		return bookingId;
	}
	
	public String getBookingTitle() {
		return bookingTitle;
	}
	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}
	public String getBookAppointmentDate() {
		return bookAppointmentDate;
	}
	public void setBookAppointmentDate(String bookAppointmentDate) {
		this.bookAppointmentDate = bookAppointmentDate;
	}
	public LocalDateTime getBookedDateTime() {
		return bookedDateTime;
	}
	public void setBookedDateTime(LocalDateTime bookedDateTime) {
		this.bookedDateTime = bookedDateTime;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BookingMode getBookingMode() {
		return bookingMode;
	}
	public void setBookingMode(BookingMode bookingMode) {
		this.bookingMode = bookingMode;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public BookingDuration getBookingDuration() {
		return bookingDuration;
	}

	public void setBookingDuration(BookingDuration bookingDuration) {
		this.bookingDuration = bookingDuration;
	}
	

}
