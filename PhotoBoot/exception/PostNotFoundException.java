package exception;

public class PostNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostNotFoundException(String msg) {
		super(msg);
	}
}
