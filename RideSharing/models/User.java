package models;

import java.util.ArrayList;

import repository.Gender;

public class User {
	private String aadhar;
	private String name;
	private int age;
	private Gender gender;
	private ArrayList<Ride> ridesOffer;
	private ArrayList<Ride> ridesShare;
	
	public ArrayList<Ride> getRidesOffer() {
		return ridesOffer;
	}
	public void setRidesOffer(ArrayList<Ride> ridesOffer) {
		this.ridesOffer = ridesOffer;
	}
	public ArrayList<Ride> getRidesShare() {
		return ridesShare;
	}
	public void setRidesShare(ArrayList<Ride> ridesShare) {
		this.ridesShare = ridesShare;
	}
	
	public String getName() {
		return name;
	}
	public User(String aadhar, String name, int age, Gender gnder) {
		this.aadhar = aadhar;
		this.age = age;
		this.gender = gnder;
		this.name = name;
		this.ridesOffer = new ArrayList<Ride>();
		this.ridesShare = new ArrayList<Ride>();
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}
