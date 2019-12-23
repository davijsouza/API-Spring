package br.com.udemy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FaultOperationException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public FaultOperationException(String exception) {
		super(exception);
	}
	
	

}
