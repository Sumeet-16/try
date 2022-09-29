package com.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.onlineeyecare.exceptions.InvalidAppointmentException;






public interface IAppointmentService {
	Appointment bookAppointment(Appointment appointment);

	Appointment updateAppointment(Appointment appointment) throws InvalidAppointmentException;

	Appointment cancelAppointment(int appointmentId) throws AppointmentIdNotFoundException;

	Appointment viewAppointment(int appointmentId) throws AppointmentIdNotFoundException;

	List<Appointment> viewAllAppointments();

	List<Appointment> viewAppointments(LocalDate date);
}
