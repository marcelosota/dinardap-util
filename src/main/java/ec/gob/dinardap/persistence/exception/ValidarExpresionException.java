/**
 * 
 */
package ec.gob.dinardap.persistence.exception;

/**
 * @author 
 *
 */
public class ValidarExpresionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5499755350481530879L;

	/**
	 * 
	 */
	public ValidarExpresionException() {
	}

	/**
	 * @param message
	 */
	public ValidarExpresionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ValidarExpresionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ValidarExpresionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ValidarExpresionException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
