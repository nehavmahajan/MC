package model;

import repository.VehicleType;

public class Vehicle {
	private int vehicleId;
	private VehicleType vehicleType;
	private User user;
	private int availability;
	
	public Vehicle() {
		
	}
	public Vehicle(int vehicleId, VehicleType vehicleType, User user, int availability) {
		this.user = user;
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.setAvailability(availability);
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
}
