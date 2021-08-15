package services;

import database.DB;
import exceptions.SeatAlreadyBookedException;
import repository.Seat;

public class ShowService {
	private static ShowService showSvc = null;
	private DB db= DB.getInstance();
	private ShowService() {
		
	}
	
	public static ShowService getInstance() {
		if( showSvc == null) {
			return showSvc = new ShowService();
		}
		else {
			return showSvc;
		}
	}
	
	public void ShowVacantSeats(String movieName) {
		if(db.getShowMap().get(movieName).equals(null) ) {
			System.out.println("No match found");
		}
		System.out.println("\nFor movie "+movieName+" , Time : "+db.getShowMap().get(movieName).getStartTime()+" , Seats :");
		int i = 0;
		for(Seat s : db.getShowMap().get(movieName).getSeats()) {
			System.out.print(i+" - "+s +"\t");
			i++;
		}
	}
	
	public synchronized void blockSeat(String movieName, String screenNo, int SeatNo ) throws SeatAlreadyBookedException {
		if(db.getScreenMap().get(screenNo).getShows().get(movieName).getSeats().get(SeatNo) != Seat.AVAILABLE) {
			throw new SeatAlreadyBookedException("Seat is already booked .");
			
		}
		else {
			db.getScreenMap().get(screenNo).getShows().get(movieName).getSeats().set(SeatNo, Seat.TEMPORARY_AVAILABLE);
			return;
		}
	}
}
