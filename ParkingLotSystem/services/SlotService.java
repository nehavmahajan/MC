package services;

import database.ParkingSlot;
import exceptions.SlotsOutOFBoundException;
import models.Slot;
import repository.Status;

public class SlotService {
	private static SlotService slotSvc = null;
	private ParkingSlot parkingSlot = ParkingSlot.getInstance();
	private SlotService() {}
	
	public static SlotService getInstance() {
		if(slotSvc == null) {
			slotSvc = new SlotService();
		}
		return slotSvc;
	}

	public int getFreeSlot() {
		//int sizeSlot = ParkingSlot.getSize();
		for(Slot s : parkingSlot.getSlots()) {
			if(s.isSlotEmpty()) {
				return parkingSlot.getIndex(s);
			}
		}
		return -1;
	}
	
	/*----------------------------------------------------------------------------------------------*/
	
	public void removeCarFromSlot(int slotIndex) throws SlotsOutOFBoundException {
		if(slotIndex < 0 || slotIndex >= parkingSlot.getSize()) {
			throw new SlotsOutOFBoundException("Not valid Slot");
		}
		Slot slot = parkingSlot.getSlot(slotIndex);
		slot.setCar(null);
		slot.setStatus(Status.AVAILABLE);
		parkingSlot.setSlot(slot, slotIndex);
	}
	
}
