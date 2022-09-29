package com.onlineeyecare.exceptions;


import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
	
  @ExceptionHandler(DoctorIdNotFoundException.class)
	    public ResponseEntity<?> resourceNotFoundException(DoctorIdNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

		
		  @ExceptionHandler(Exception.class) 
		  public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) { ErrorDetails
		  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
		  return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); 
		  }
//		  
		  @ExceptionHandler(MethodArgumentNotValidException.class)
		  public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception)
		  {
		         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), "Validation Error" ,
		        		 exception.getBindingResult().getFieldError().getDefaultMessage());
		         return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		  }
		  
		  @ExceptionHandler(ResourceNotFoundException.class)
			public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
				ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}
		  
		  @ExceptionHandler(AppointmentIdNotFoundException.class)
			public ResponseEntity<?> resourceNotFoundException(AppointmentIdNotFoundException ex, WebRequest request){
				ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}
		  
		  @ExceptionHandler(TestIdNotFoundException.class)
			public ResponseEntity<?> resourceNotFoundException(TestIdNotFoundException ex, WebRequest request){
				ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}
		  
		  @ExceptionHandler(PasswordNotMatchException.class)
			public ResponseEntity<?> resourceNotFoundException(PasswordNotMatchException ex, WebRequest request){
				ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}
		  
		  @ExceptionHandler(ReportIdNotFoundException.class)
			public ResponseEntity<?> resourceNotFoundException(ReportIdNotFoundException ex, WebRequest request){
				ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}
		  
		  @ExceptionHandler(UserNotFoundException.class)
			public ResponseEntity<?> resourceNotFoundException(UserNotFoundException ex, WebRequest request){
				ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
			}
}
