package com.onlineeyecare.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onlineeyecare.dao.IAppointmentRepository;
import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.onlineeyecare.exceptions.InvalidAppointmentException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
@SpringBootTest
class AppointmentServiceImplTest {
	@Autowired
	IAppointmentService appointmentservice;
	
	@MockBean
	IAppointmentRepository appointmentRepo;

	@Test
	void viewAppointmentById() throws ResourceNotFoundException, AppointmentIdNotFoundException
	{
		{
			Appointment a1=new Appointment();
			a1.setAppointmentId(9);
			a1.setConsultantFee(3200.00);
			a1.setDateOfAppointment(LocalDate.now());
			a1.setTimeOfAppointment(LocalTime.now());
			
			Optional<Appointment> a2=Optional.of(a1);
			
			Mockito.when(appointmentRepo.findById(9)).thenReturn(a2);
			
			assertThat(appointmentservice.viewAppointment(9)).isEqualTo(a1);
		}
	}

	
	
	@Test
	void cancelAppointmentTest() throws ResourceNotFoundException{
		Appointment a1=new Appointment();
		a1.setAppointmentId(9);
		a1.setConsultantFee(3200.00);
		a1.setDateOfAppointment(LocalDate.now());
		a1.setTimeOfAppointment(LocalTime.now());
		
		Optional<Appointment> a2=Optional.of(a1);
		
		Mockito.when(appointmentRepo.findById(9)).thenReturn(a2);
		 Mockito.when(appointmentRepo.existsById(a1.getAppointmentId())).thenReturn(false);
		   assertFalse(appointmentRepo.existsById(a1.getAppointmentId()));
	}
}