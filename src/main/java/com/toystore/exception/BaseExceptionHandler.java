package com.toystore.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseExceptionHandler extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseExceptionHandler(String message) {
		super(message);
	}
	public abstract HttpStatus getStausCode();

	

}
