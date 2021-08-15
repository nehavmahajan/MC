package exceptions;

public class SeatAlreadyBookedException extends Exception {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public SeatAlreadyBookedException(String msg) {
		super(msg);
	}

}
