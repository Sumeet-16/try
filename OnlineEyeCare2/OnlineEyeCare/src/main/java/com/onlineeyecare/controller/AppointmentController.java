package com.onlineeyecare.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.onlineeyecare.exceptions.InvalidAppointmentException;
import com.onlineeyecare.service.IAppointmentService;


@RestController
@RequestMapping("/v1")
public class AppointmentController {
	@Autowired
	IAppointmentService appointmentRepo;
	

	@PostMapping("/bookappointment")
	public Appointment bookAppointment(@RequestBody Appointment appointment) {
		return appointmentRepo.bookAppointment(appointment);
	}
	
	@PutMapping("/updateappointment")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws InvalidAppointmentException {
		return appointmentRepo.updateAppointment(appointment);
	}
	

	@DeleteMapping("/cancelappointment/{id}")
	public Appointment cancelAppointment(@PathVariable int id) throws AppointmentIdNotFoundException {
		return appointmentRepo.cancelAppointment(id);
	}
	

	@GetMapping("/viewallappointments")
	public List<Appointment> listallappointments() {
		return appointmentRepo.viewAllAppointments();
	}
	  
	@GetMapping("/viewappointment/{id}")
	public Appointment viewAppointment(@PathVariable int id) throws AppointmentIdNotFoundException {
		return appointmentRepo.viewAppointment(id);
	}
	
	@GetMapping("/viewallappointmentbydate")
	public List<Appointment> listallappointments(@RequestParam(value="date")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate date) {
		return appointmentRepo.viewAppointments(date);
	}

}
