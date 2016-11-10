package com.smdev.hib;

/**
 * @author Ireth
 */
public class AppException extends Exception {

	/** */
	private static final long serialVersionUID = 2126079741679276329L;

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable cause) {
		super(cause);
	}

}
