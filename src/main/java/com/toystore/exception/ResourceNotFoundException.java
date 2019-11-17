package com.toystore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends BaseExceptionHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String message){
    	super(message);
    }
	@Override
	public HttpStatus getStausCode() {
		return HttpStatus.NOT_FOUND;
	}
}
