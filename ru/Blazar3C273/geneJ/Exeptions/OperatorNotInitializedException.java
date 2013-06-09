/**
 * @author Stepanenko Anatoliy
 * geneJ
 * 18:34:45
 * 09.06.2013
 * TODO
 */
package ru.Blazar3C273.geneJ.Exeptions;

/**
 * 
 */
public class OperatorNotInitializedException extends Throwable {

	/**
	 * TODO
	 * 18:35:05
	 * long
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4277947520613539825L;

	/**
	 * 
	 */
	public OperatorNotInitializedException() {
		super("Operator Not Initialized. Initialize it befor using it");
	}

	/**
	 * @param paramMessage
	 */
	public OperatorNotInitializedException(String paramMessage) {
		super(paramMessage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param paramCause
	 */
	public OperatorNotInitializedException(Throwable paramCause) {
		super(paramCause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param paramMessage
	 * @param paramCause
	 */
	public OperatorNotInitializedException(String paramMessage,
			Throwable paramCause) {
		super(paramMessage, paramCause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param paramMessage
	 * @param paramCause
	 * @param paramEnableSuppression
	 * @param paramWritableStackTrace
	 */
	public OperatorNotInitializedException(String paramMessage,
			Throwable paramCause, boolean paramEnableSuppression,
			boolean paramWritableStackTrace) {
		super(paramMessage, paramCause, paramEnableSuppression,
				paramWritableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
