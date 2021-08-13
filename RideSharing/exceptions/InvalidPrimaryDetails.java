package exceptions;

public class InvalidPrimaryDetails extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidPrimaryDetails(String msg) {
		super(msg);
	}
	
}
