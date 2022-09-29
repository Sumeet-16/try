package com.onlineeyecare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.onlineeyecare.exceptions.InvalidAppointmentException;
import com.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.onlineeyecare.exceptions.TestIdNotFoundException;
import com.onlineeyecare.exceptions.UserNotFoundException;


@RestControllerAdvice
public class OnlineeyecareControllerAdvice {
	
	@ExceptionHandler({AppointmentIdNotFoundException.class, DoctorIdNotFoundException.class, InvalidAppointmentException.class,
		PatientIdFoundNotException.class,ReportIdNotFoundException.class,TestIdNotFoundException.class,UserNotFoundException.class
		,TestIdNotFoundException.class})
	public ResponseEntity<String> onlineeyecare(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
