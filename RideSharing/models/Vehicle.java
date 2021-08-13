package models;

import repository.VehicleType;

public class Vehicle {
	private String vehicleNo ; 
	private VehicleType vehicleType;
	private String owner;
	
	public Vehicle(String vehicleNo, VehicleType type, String owner) {
		this.owner = owner;
		this.vehicleNo = vehicleNo;
		this.vehicleType = type;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
