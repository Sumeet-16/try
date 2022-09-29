package com.onlineeyecare.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.Report;
import com.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.onlineeyecare.exceptions.PatientIdFoundNotException;


@Service
public interface IPatientService {

	Patient addPatient(Patient tempPatient);
	Patient updatePatient(Patient patient);
	Patient deletePatient(int patientId)throws PatientIdFoundNotException;
	List<Patient> viewPatientList();
	Patient viewPatient(int patientId)throws PatientIdFoundNotException;
	Appointment bookAppointment(Appointment appointment);
	Appointment viewAppointmentDetail(int appointmentid)throws AppointmentIdNotFoundException;
	Report viewReport(int patientId)throws PatientIdFoundNotException;
	
}
