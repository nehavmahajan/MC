package model;

import java.util.Vector;

public class User {
	private int uid;
	private String email;
	private String uName;
	private String city;
	private int mobNo;
	private String pwd;
	public Vector<Booking> booking;

	public User() {
	}
	public User(int uid, String email, String uName, String city, int mobNo, String pwd) {
		this.uid = uid;
		this.email = email;
		this.uName = uName;
		this.city = city;
		this.mobNo = mobNo;
		this.pwd= pwd;
		booking = new Vector<Booking>();
		
	}
	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getMobNo() {
		return mobNo;
	}
	public void setMobNo(int mobNo) {
		this.mobNo = mobNo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Vector<Booking> getBooking() {
		return booking;
	}
	public void setBooking(Vector<Booking> booking) {
		this.booking = booking;
	}
}
