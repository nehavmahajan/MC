package models;

import java.util.Vector;

public class User {
	private String userName;
	private String email;
	private String aadhar;
	private int age;
	private String states;
	private String districts; 
	private String ward;
	private Vector<Booking> slots;
	
	public User(String aadhar,String userName,String email,int age, String state,String district,String ward ) {
		this.aadhar = aadhar;
		this.age = age;
		this.districts = district;
		this.email = email;
		this.slots = new Vector<Booking>();
		this.states = state;
		this.userName = userName;
		this.wards =ward;
	}
	
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Vector<Booking> getSlots() {
		return slots;
	}
	public void setSlots(Vector<Booking> slots) {
		this.slots = slots;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public String getDistricts() {
		return districts;
	}
	public void setDistricts(String districts) {
		this.districts = districts;
	}
	public String getWards() {
		return wards;
	}
	public void setWards(String wards) {
		this.wards = wards;
	}
	private String wards;
}
