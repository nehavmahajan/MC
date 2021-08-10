package exceptions;

public class VehicleNotPresentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2720958903370761282L;

	public VehicleNotPresentException(String msg ) {
		super(msg);
	}
}
