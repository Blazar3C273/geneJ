package ru.Blazar3C273.geneJ.Exeptions;
/**
 * @author Stepanenko Anatoliy
 * Lab1EvM&GA
 * 1:16:20
 * 11.04.2013
 * TODO
 */

/**
 * 
 */
public class WrongFocusBand extends Error {

	/**
	 * TODO
	 * 2:31:23
	 * long
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public WrongFocusBand() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param paramMessage
	 */
	public WrongFocusBand(String paramMessage) {
		super(paramMessage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param paramCause
	 */
	public WrongFocusBand(Throwable paramCause) {
		super(paramCause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param paramMessage
	 * @param paramCause
	 */
	public WrongFocusBand(String paramMessage, Throwable paramCause) {
		super(paramMessage, paramCause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param paramMessage
	 * @param paramCause
	 * @param paramEnableSuppression
	 * @param paramWritableStackTrace
	 */
	public WrongFocusBand(String paramMessage, Throwable paramCause,
			boolean paramEnableSuppression, boolean paramWritableStackTrace) {
		super(paramMessage, paramCause, paramEnableSuppression,
				paramWritableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
