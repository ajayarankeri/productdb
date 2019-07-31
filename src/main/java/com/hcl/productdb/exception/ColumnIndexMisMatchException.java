package com.hcl.productdb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class ColumnIndexMisMatchException extends Exception{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6918380002317192604L;

	public ColumnIndexMisMatchException(String message) {
		super(message);
	}

}
