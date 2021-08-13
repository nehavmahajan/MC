import repository.Gender;
import repository.VehicleType;
import services.RideService;
import services.UserService;
import services.VehicleService;

public class Driver {
	public static void main(String[] args) {
		UserService userService = UserService.getInstance();
		VehicleService vehicleService = VehicleService.getInstance();
		RideService rideService = RideService.getInstance();
		
		userService.registerUser("235467891222", "Rohan", Gender.MALE, 36);
		vehicleService.addVehicle("Rohan", VehicleType.SWIFT, "KA-01-12345");
		
		userService.registerUser("234567891222", "Shashank", Gender.MALE, 36);
		vehicleService.addVehicle("Shashank", VehicleType.BALENO, "TS-05-62395");
		
		userService.registerUser("123456789012", "nandini", Gender.FEMALE, 36);
		
		userService.registerUser("123567891222", "shipra", Gender.FEMALE, 36);
		vehicleService.addVehicle("shipra", VehicleType.POLO, "KA-05-41491");
		vehicleService.addVehicle("shipra", VehicleType.ACTIVA, "KA-12-12332");
		
		userService.registerUser("234674891222", "gaurav", Gender.MALE, 36);
		
		userService.registerUser("234567891232", "rahul", Gender.MALE, 36);
		vehicleService.addVehicle("rahul", VehicleType.XUV, "KA-12-12332");
		
		rideService.offerRide("Rohan", "Hyderabad","Bangalore", 1, VehicleType.SWIFT, "KA-01-12345");
		rideService.offerRide("shipra", "Bangalore","Mysore", 1, VehicleType.ACTIVA, "KA-12-12332");
		rideService.offerRide("shipra", "Bangalore","Mysore", 2, VehicleType.POLO, "KA-05-41491");
		rideService.offerRide("Shashank", "Hyderabad","Bangalore", 2, VehicleType.BALENO, "TS-05-62395");
		
		rideService.offerRide("rahul", "Hyderabad","Bangalore", 5, VehicleType.XUV, "KA-05-1234");
		rideService.offerRide("Rohan", "Banglore","Pune", 1, VehicleType.SWIFT, "KA-01-12345");
		
		rideService.selectRide("nandini", "Bangalore", "Mysore", 1, "Most Vacant");
		rideService.selectRide("gaurav", "Bangalore", "Mysore", 1, "Preferred Vehicle=POLO");
		rideService.selectRide("Shashank", "Mumbai", "Bangalore", 1, "Most Vacant");
		rideService.selectRide("Rohan", "Hyderabad", "Bangalore", 1, "Preferred Vehicle=Baleno");
		rideService.endRide("KA-05-41491", "nandini", "Bangalore", "Mysore", 1);
		rideService.selectRide("Shashank", "Bangalore", "Mysore", 1, "Preferred Vehicle=Polo");
		rideService.printTotalRides();
		rideService.endRide("KA-05-41491", "nandini", "Bangalore", "Mysore", 1);
	}
}
