package database;

import java.util.ArrayList;

import models.Slot;

public class ParkingSlot {
	private ArrayList<Slot> slots = null;
	private static ParkingSlot parkingSlot = null;
	
	private ParkingSlot() {
		slots = new ArrayList<Slot>();
	}
	
	public static ParkingSlot getInstance() {
		if(parkingSlot == null ) {
			parkingSlot = new ParkingSlot();
		}
		return parkingSlot;
	}
	
	public void initializeSlots(int PARKING_LOT_SIZE) {
		
		for(int index = 0 ; index < PARKING_LOT_SIZE; index++) {
			this.slots.add(new Slot());
		}	
	}
	public int getIndex(Slot slot ) {
		return this.slots.indexOf(slot);
	}
	

	public Slot getSlot(int index) {
		return this.slots.get(index);
	}
	
	public void setSlot(Slot s,int slotIndex) {
		this.slots.set(slotIndex , s);
	}
	
	public ArrayList<Slot> getSlots() {
		return slots;
	}

	public void setSlots(ArrayList<Slot> slots) {
		this.slots = slots;
	}
	
	public int getSize() {
		return this.slots.size();
	}
}
