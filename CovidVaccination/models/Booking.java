package models;

import repository.Price;
import repository.VaccineType;

public class Booking {
	private String aadhar;
	private String date;
	private VaccineType vaccinetype;
	private Price price;
	private String VaccineCenter;
	
	public Booking(String aadhar, String date, VaccineType vaccinetype, Price price, String vaccineCenter) {
		this.aadhar = aadhar;
		this.date = date;
		this.price= price;
		this.VaccineCenter = vaccineCenter;
		this.vaccinetype = vaccinetype;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public VaccineType getVaccinetype() {
		return vaccinetype;
	}
	public void setVaccinetype(VaccineType vaccinetype) {
		this.vaccinetype = vaccinetype;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public String getVaccineCenter() {
		return VaccineCenter;
	}
	public void setVaccineCenter(String vaccineCenter) {
		VaccineCenter = vaccineCenter;
	}
}
