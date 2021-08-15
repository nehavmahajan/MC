package models;

import repository.Status;

public class Slot {
		
	private Status status;
	private Car car;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Slot() {
		this.status = Status.AVAILABLE;
		this.car = null;
	}
	
	public boolean isSlotEmpty() {
		if(this.getStatus() == Status.AVAILABLE) {
			return true;
		}
		return false;
	}
	
	public Car getCarParked() {
		if(this.getCar() == null ) {
			return null;
		}
		return this.getCar();
	}
	public Slot setSlot(Car car) {
		this.car = car;
		this.status = Status.BLOCKED;
		return this;
	}
}
