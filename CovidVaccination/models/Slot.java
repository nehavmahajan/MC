package models;

import repository.Price;
import repository.VaccineType;

public class Slot extends VaccineCenter {

//	<vaccine type, date, slot(1/2), age ,price (paid\free) >
	private String date;
	private int age;
	private Price price;

	
	public Slot(String stateName, String districtName, String wardName, String vaccineCenter, String date, VaccineType vaccineType,int count, int age, Price price ) {
		super(stateName, districtName, wardName, vaccineCenter);
		this.date = date;
		this.age = age;
		this.price = price;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	
	
	
}
