package models;

import java.util.UUID;

import repository.RideStatus;
import repository.VehicleStatus;
import repository.VehicleType;

public class Ride {
	private UUID uid;
	private String vehicleNo;
	
	private String driverName;
	private String src;
	private String dest;
	private int noOfSeats;
	private VehicleType vehicleType;
	private RideStatus rideStatus;
	private VehicleStatus vehicleStatus;
	
	public Ride (String vehicleNo,String driverName,String src, String dest,VehicleType vehicleType, int noOfSeats,RideStatus ridestatus, VehicleStatus vehiclestatus) {
		this.uid = UUID.randomUUID();
		this.dest = dest;
		this.driverName = driverName;
		this.noOfSeats = noOfSeats;
		this.src = src;
		this.vehicleType = vehicleType;
		this.vehicleNo = vehicleNo;
		this.rideStatus = RideStatus.OFFERED;
		this.vehicleStatus = VehicleStatus.AVAILABLE;
	}
	public UUID getUid() {
		return uid;
	}
	public void setUid(UUID uid) {
		this.uid = uid;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public RideStatus getRideStatus() {
		return rideStatus;
	}
	public void setRideStatus(RideStatus rideStatus) {
		this.rideStatus = rideStatus;
	}
	public VehicleStatus getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(VehicleStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
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
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	
}
