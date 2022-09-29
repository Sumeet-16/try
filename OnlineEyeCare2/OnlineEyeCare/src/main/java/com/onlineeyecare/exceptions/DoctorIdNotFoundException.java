package com.onlineeyecare.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class DoctorIdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
public DoctorIdNotFoundException()
{
	super();
}
public DoctorIdNotFoundException(String message) {
	super(message);
}
}
