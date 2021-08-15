import services.ParkingService;

public class DriverClass {
	public static final int  PARKING_LOT_SIZE  = 6; 
	
	public static void main(String args[])  {
		ParkingService parkingSvc = ParkingService.getInstance();
		try {
			parkingSvc.createParkingLot(PARKING_LOT_SIZE);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			parkingSvc.parkCar ("KA-01-HH-1234","White");
			parkingSvc.parkCar ("KA-01-HH-9999","White");
			parkingSvc.parkCar ("KA-01-BB-0001","Black");
			parkingSvc.parkCar ("KA-01-HH-7777","Red");
			parkingSvc.parkCar ("KA-01-HH-2701","Blue");
			parkingSvc.parkCar ("KA-01-HH-3141","Black");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		parkingSvc.leaveSlot(4);
		
		parkingSvc.displayStatus();
		
		try {
			parkingSvc.parkCar ("KA-01-HH-1234","White");
			parkingSvc.parkCar ("KA-01-HH-1234","White");
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		parkingSvc.getRegistrationNumbersForCarWithColor("White");
		
		parkingSvc.getSlotNumbersWithColor("White");
		
		parkingSvc.getSlotNumbersWithRegNumber("KA-01-HH-3141");
		parkingSvc.getSlotNumbersWithRegNumber("MH-04-AY-1111");
		
		parkingSvc.displayStatus();
	}
}
