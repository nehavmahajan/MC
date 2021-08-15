package models;

import java.util.ArrayList;

public class User {
	
	private String email;
	private String uname;
	private String paymentDetail;
	private ArrayList<Booking> myBooking;
	private int age;

	public User(String email, String uname,int age,  String paymentDetail) {
		this.email = email;
		this.uname = uname;
		this.age = age;
		this.paymentDetail = paymentDetail;
		this.myBooking = new ArrayList<Booking>();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public ArrayList<Booking> getMyBooking() {
		return myBooking;
	}

	public void setMyBooking(ArrayList<Booking> myBooking) {
		this.myBooking = myBooking;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
}
