
import models.Theater;
import services.BookingService;
import services.ScreenService;
import services.ShowService;
import services.UserService;

public class DriverClass {
	
	public static void main(String arg[]) throws Exception {
		
		 BookingService bookingSvc = BookingService.getInstance();
		 ShowService showSvc = ShowService.getInstance();
		 UserService userSvc = UserService.getInstance();
		 ScreenService screenSvc = ScreenService.getInstance();
		
		Theater t = new Theater("Divya", "nashik" );
		screenSvc.addScreen(t, "1");
		screenSvc.addScreen(t, "2");
		
		screenSvc.addShow("ABCD" , "11.30am", "3 hrs","1");
		screenSvc.addShow("Agnipath" , "11.30pm", "3 hrs","2");
		screenSvc.addShow("Mimi" , "11.30am", "3 hrs","1");
		
		userSvc.registerUser("nehamahajan@gmail.com", "neha", 21, "3284744874");
		userSvc.registerUser("nm@gmail.com", "Sneha", 21, "3648759457");
		
		userSvc.checkBookings("nm@gmail.com");
	
		
		bookingSvc.selectShow("ABCD", "1","11.30am","nm@gmail.com", "3648759457", 1,2,3 );
		showSvc.ShowVacantSeats("ABCD");
		bookingSvc.selectShow("ABCD", "1","11.30am","nehamahajan@gmail.com", "3284744874", 3,4,5,6 );
		userSvc.checkBookings("nm@gmail.com");
		
		showSvc.ShowVacantSeats("ABCD");
		bookingSvc.selectShow("ABCD", "1","11.30am","nehamahajan@gmail.com", "3284744874",8 );
		showSvc.ShowVacantSeats("ABCD");
		
		userSvc.checkBookings("nehamahajan@gmail.com");
		
	}
}
