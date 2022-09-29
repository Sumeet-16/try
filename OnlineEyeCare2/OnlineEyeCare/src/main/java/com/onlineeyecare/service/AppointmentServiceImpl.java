package com.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.IAppointmentRepository;
import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.onlineeyecare.exceptions.InvalidAppointmentException;



@Service
public class AppointmentServiceImpl implements IAppointmentService{
	@Autowired
	IAppointmentRepository appointmentRepo;
	
	@Override
	public Appointment bookAppointment(Appointment appointment) {

		
		return appointmentRepo.saveAndFlush(appointment);
	}
	
	@Override
	public Appointment updateAppointment(Appointment appointment) throws InvalidAppointmentException {
	
		Optional<Appointment> result=appointmentRepo.findById(appointment.getAppointmentId());
		if(result.isPresent())
		{
			return appointmentRepo.saveAndFlush(appointment);
		}
		else
		{
			throw new InvalidAppointmentException("please enter valid appointment id");
		}
	}
	
	@Override
	public Appointment cancelAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		
		Optional<Appointment> result=appointmentRepo.findById(appointmentId);
		if(result.isPresent())
		{
			appointmentRepo.deleteById(appointmentId);
			return result.get();
		}
		else
		{
			throw new AppointmentIdNotFoundException("please enter valid appointment id");
		}
		
	}

	@Override
	public Appointment viewAppointment(int appointmentId) throws AppointmentIdNotFoundException {

		Optional<Appointment> result=appointmentRepo.findById(appointmentId);
		if(result.isPresent())
		{
			appointmentRepo.findById(appointmentId);
			return result.get();
		}
		else
		{
			throw new AppointmentIdNotFoundException("please enter valid appointment id");
		}
	}
	
	@Override
	public List<Appointment> viewAllAppointments() {

		return appointmentRepo.findAll();
	}

	
	@Override
	public List<Appointment> viewAppointments(LocalDate date) {
		
		return appointmentRepo.findAll().stream().filter(app->(date.compareTo(app.getDateOfAppointment())==0)).collect(Collectors.toList());
	}
	
}
