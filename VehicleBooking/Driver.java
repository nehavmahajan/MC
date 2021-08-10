import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

import model.Booking;
import model.Vehicle;
import repository.BookingDuration;
import repository.BookingMode;
import repository.VehicleType;
import service.accountsService;
import service.getAvailableVehiclesService;
import service.modelObjectsCreationService;
import service.vehicleBookingService;


public class Driver {
	private modelObjectsCreationService mocs;
	private getAvailableVehiclesService getAvailableVehicleSvc;
	private vehicleBookingService vehicleService ;
	private accountsService accountService ;
	
	public Driver() {
		mocs= new modelObjectsCreationService();
		getAvailableVehicleSvc = new getAvailableVehiclesService();
		vehicleService = new vehicleBookingService();
		accountService = new accountsService();
	}
	
	public static void main(String[] args) throws Exception	{
		int userId = 0;
		Driver d = new Driver();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		d.mocs.addUser( 1,"nehamahajan@gmail.com","Neha","Nashik",763457, "ABC");
		d.mocs.addUser( 2,"nm@gmail.com","Nm","Nashik",764568,"nm");
		d.mocs.addVehicles(1,VehicleType.SUV, null, 2 );
		d.mocs.addVehicles(2,VehicleType.SEDAN, null, 3);
		/*-----------------------------------------------------------------------------------------------------------------------*/
		
		/*-----------------------------------------------------------------------------------------------------------------------*/
		
		do {
		
			System.out.println(" \n\n OPERATIONS ");
			System.out.println("1.Login \n2.Reset Password \n3.Delete account \n4.Check Available vehicles \n5.Book a Vehicle \n6.Check my bookings \n7.cancel or Delete Booking\n8.LogOut\nEnter choice\n");
			int ch = Integer.parseInt(br.readLine());
			switch(ch) {
			case 1 :
				System.out.println("Enter Uid for Login :");
				userId = Integer.parseInt(br.readLine());
				d.accountService.checkLogin(userId);
				break;
			
			case 2:
				if(userId == 0) {
					System.out.println("Please Log in first");
					break;
				}
				System.out.println("Enter new password : ");
				String pwd = br.readLine();
				d.accountService.resetPassword(userId, pwd);
				break;
			case 3:
				if(userId == 0) {
					System.out.println("Please Log in first");
					break;
				}
				int uid = Integer.parseInt(br.readLine());
				d.accountService.deleteUser(uid);
				System.out.println("Account deleted Successfully");
				break;
			case 4:
				if(userId == 0) {
					System.out.println("Please Log in first");
					break;
				}
				System.out.println("Available for Booking are :");
				Vector<Vehicle> vehicle = d.getAvailableVehicleSvc.getAvailableVehicles();
				for(Vehicle v : vehicle ) {
					System.out.println("Type :"+ v.getVehicleType()+", Available count : "+v.getAvailability()+", Vehicle ID: "+ v.getVehicleId());
				}
				break;
			case 5:
				if(userId == 0) {
					System.out.println("Please Log in first");
					break;
				}
				System.out.println("Enter Details to Book Your Vehicle :");
				int vehicleId;
				String bookingTitle;
				String appointmentDate;
				String src;
				String dest;
				BookingDuration bookingDuration;
				BookingMode bookingMode;
				
				vehicleId = Integer.parseInt(br.readLine());
				bookingTitle = br.readLine();
				appointmentDate = br.readLine();
				src = br.readLine();
				dest = br.readLine();
				bookingDuration = BookingDuration.valueOf(br.readLine().toUpperCase());
				bookingMode = BookingMode.valueOf(br.readLine().toUpperCase());
				
				d.mocs.pickVehicle(vehicleId,userId, bookingTitle, appointmentDate, src, dest,bookingDuration, bookingMode);
				break;
			case 6:
				if(userId == 0) {
					System.out.println("Please Log in first");
					break;
				}
				System.out.println("Your Bookings are :");
				Vector<Booking> bookings = d.accountService.getBookingDetails(userId);
				for(Booking b : bookings ) {
					System.out.println("ID :"+ b.getBookingId()+", Appointment Date :"+b.getBookAppointmentDate()+", Title :"+ b.getBookingTitle() +",BookedAt : "+b.getBookedDateTime()+", Mode of Booking:"
							+b.getBookingMode()+", VehicleId booked: "+b.getVehicle().getVehicleId()+",Source : "+b.getSrc()+",Destination: "+b.getDest());
				}
				break;
			case 7:
				if(userId == 0) {
					System.out.println("Please Log in first");
					break;
				}
				System.out.println("Cancel or delete booking- enter Vehicle ID");
				String bId = br.readLine();
				d.vehicleService.returnVehicle(bId, userId);
				System.out.println("vehicle removed from your bookings");
				break;
			case 8:
				if(userId == 0) {
					System.out.println("Please Log in first");
					break;
				}
				userId = 0;
				System.out.println("logged out");
				
				
		}
		}while(true);
		
	

	}	
}
