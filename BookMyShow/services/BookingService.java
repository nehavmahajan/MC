package services;

import database.DB;
import exceptions.SeatAlreadyBookedException;
import models.Booking;
import repository.BookingStatus;
import repository.Seat;

public class BookingService {
	private static BookingService bookingSvc = null;
	private ShowService showSvc = ShowService.getInstance();
	private DB db= DB.getInstance();
	private BookingService() {
		
	}
	
	public static BookingService getInstance() {
		if( bookingSvc == null) {
			return bookingSvc = new BookingService();
		}
		else {
			return bookingSvc;
		}
	}
	
	public void selectShow(String movieName,String screenID,String startTime, String umail,  String payment,int... seats ) {
		
		System.out.println("\nBooking by User :"+umail+ ", Movie -"+movieName+", seat : "+seats);
		for(int i = 0 ; i< seats.length ; i++) {
			int index = seats[i];
		
			try {
				showSvc.blockSeat(movieName, screenID, index);
			} catch (SeatAlreadyBookedException e) {
				e.printStackTrace();
				return;
			}
			Booking b = new Booking(screenID , movieName,startTime, index);
			db.getUserMap().get(umail).getMyBooking().add(b);
			Boolean bookingStatus = processPayment(b.getBookingID(), payment ,umail);
			if( bookingStatus == true) {
				int indexBooking = db.getUserMap().get(umail).getMyBooking().indexOf(b);
				db.getUserMap().get(umail).getMyBooking().get(indexBooking).setStatus(BookingStatus.SUCCESS);
				db.getShowMap().get(movieName).getSeats().set(index, Seat.BOOKED);
				System.out.println("Booking Successful");
			}
			else {
				int indexBooking = db.getUserMap().get(umail).getMyBooking().indexOf(b);
				db.getUserMap().get(umail).getMyBooking().get(indexBooking).setStatus(BookingStatus.FAIL);
				db.getShowMap().get(movieName).getSeats().set(index, Seat.AVAILABLE);
				System.out.println("Booking Failed");
			}
		}
	}

		

	private Boolean processPayment(Object bookingID, String payment,String umail) {
		if(db.getUserMap().get(umail).getPaymentDetail().equals(payment)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
