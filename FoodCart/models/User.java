package models;

import java.util.Vector;

import repository.Gender;

public class User {
	private  String name;
	private Gender gender;
	private String phoneNumber;
	private String pincode;
	private Vector<Order> order=null;

	public User() {
		
	}
	public User(String name, Gender gender, String phoneNumber, String pincode) {
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.pincode = pincode;
		this.order = new Vector<Order>();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Vector<Order> getOrder() {
		return order;
	}
	public void setOrder(Vector<Order> order) {
		this.order = order;
	}
}
