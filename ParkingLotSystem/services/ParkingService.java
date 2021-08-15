package services;

import database.ParkingSlot;
import exceptions.IllegalLotSizeException;
import exceptions.SlotsOutOFBoundException;
import models.Car;
import models.Slot;


public class ParkingService {
	private static ParkingService parkingSvc = null;
	private SlotService slotSvc = SlotService.getInstance();
	private ParkingSlot parkingSlot = ParkingSlot.getInstance();;
	private ParkingService() {}
	
	public static ParkingService getInstance() {
		if(parkingSvc == null) {
			parkingSvc = new ParkingService();
		}
		return parkingSvc;
	}
	
	/*----------------------------------------------------------------------------------------------*/
	
	public void createParkingLot(int parkingLotSize) throws IllegalLotSizeException {
		if(parkingLotSize == 0 ) {
			throw new IllegalLotSizeException("Gievn size is invalid");
		}
		parkingSlot.initializeSlots(parkingLotSize);
		
		System.out.println("\nCreated a Parking with " +parkingLotSize);
	}

	/*----------------------------------------------------------------------------------------------*/
	
	public void parkCar(String carNo, String colorCar) throws SlotsOutOFBoundException {
		
		int slotPos = slotSvc.getFreeSlot();
		if(slotPos == -1) {
			throw new SlotsOutOFBoundException("No space left");
		}
		Car  car = new Car(carNo, colorCar);
		parkingSlot.getSlots().get(slotPos).setSlot(car);
		System.out.println("Car "+carNo +" parked at : "+slotPos);
	}
	
	/*----------------------------------------------------------------------------------------------*/
	
	public void leaveSlot(int slotIndex) {
		try {
			slotSvc.removeCarFromSlot(slotIndex);
			System.out.println("\nSlot " +slotIndex + " is empty now\n");
		} catch (SlotsOutOFBoundException e) {
			
			e.printStackTrace();
		}
	}

	/*----------------------------------------------------------------------------------------------*/
	
	public void displayStatus() {
		for( Slot slot : parkingSlot.getSlots()) {
			if(!slot.isSlotEmpty()) {
				System.out.println(" Slot No :" +parkingSlot.getIndex(slot) +" , Car : "+ slot.getCar().getCarNo() + " , color : " +slot.getCar().getColor());
			}
		}
	}

	/*----------------------------------------------------------------------------------------------*/
	
	public void getRegistrationNumbersForCarWithColor(String color) {
		int count  = 0;
		System.out.println("\nCars Parked with "+ color+ " Color :\n");
		for(Slot s : parkingSlot.getSlots()) {
			if(s.getCar().getColor().equals(color) ) {
				count++;
				System.out.print(s.getCar().getCarNo()+" , ");
			}
		}
		if(count  == 0 ) {
			System.out.println("No cars found");
		}
	}

	/*----------------------------------------------------------------------------------------------*/
	
	public void getSlotNumbersWithColor(String color) {
		int count  = 0;
		System.out.println("\nSlots Booked with "+ color+ " Cars : \n");
		for(Slot s : parkingSlot.getSlots()) {
			if(s.getCar().getColor().equals(color) ) {
				count++;
				System.out.print(parkingSlot.getIndex(s)+" , ");
			}
		}
		if(count  == 0 ) {
			System.out.println("No Slots found");
		}
	}

	/*----------------------------------------------------------------------------------------------*/
	
	public void getSlotNumbersWithRegNumber(String carNumber) {
		
		System.out.println("\nSlot Booked with "+ carNumber+ " Car : ");
		for(Slot s : parkingSlot.getSlots()) {
			if(s.getCar().getCarNo().equals(carNumber)) {
				System.out.print(parkingSlot.getIndex(s));
				return;
			}
		}
		
		System.out.println("Car with this number not found");
	}
	
}
