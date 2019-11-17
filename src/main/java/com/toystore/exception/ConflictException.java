package com.toystore.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseExceptionHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConflictException(String message) {
		super(message);
	}

	@Override
	public HttpStatus getStausCode() {
		return HttpStatus.CONFLICT;
	}

}
