/**
 * 
 */
package com.coding.exception;

/**
 * @author Bharat.Khandelwal
 * 
 */
public class FileProcessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public FileProcessException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FileProcessException(String message, Throwable cause) {
		super(message, cause);
	}
}
