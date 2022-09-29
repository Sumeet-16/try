 package com.onlineeyecare.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.IAppointmentRepository;
import com.onlineeyecare.dao.IPatientRepository;
import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.Report;
import com.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.onlineeyecare.exceptions.PatientIdFoundNotException;

import java.util.List;


import java.util.Optional;

@Service
public  class PatientServiceImpl implements IPatientService{
	@Autowired
	private IPatientRepository patientRepo;
	@Autowired
	private IAppointmentRepository appointmentDao;
	
	@Override
	public Patient addPatient(Patient patient) {
		return patientRepo.saveAndFlush(patient);
		
	}
	
	@Override
	public Patient updatePatient(Patient patient) {

		return patientRepo.save(patient);
		
	}
	
	@Override
	public Patient deletePatient(int patientId) throws PatientIdFoundNotException {

	Optional<Patient> result=patientRepo.findById(patientId);
		if(result.isPresent())
		{
			patientRepo.deleteById(patientId);
			return  result.get();
		}
		else
		{
			throw new PatientIdFoundNotException("please enter valid patient id");
		}
	}
	
	@Override
	public List<Patient> viewPatientList() {

		return patientRepo.findAll();
	}
	
	@Override
	public Patient viewPatient(int patientId) throws PatientIdFoundNotException {

		java.util.Optional<Patient> result=patientRepo.findById(patientId);
		if(result.isPresent())
		{
			patientRepo.findById(patientId);
			return  result.get();
		}
		else
		{
			throw new PatientIdFoundNotException("please enter valid patient id");
		}
	}
	

	
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		 //TODO Auto-generated method stub
		return appointmentDao.saveAndFlush(appointment);
      }

	@Override
	public Appointment viewAppointmentDetail(int appointmentId) throws AppointmentIdNotFoundException {
		
		Optional<Appointment> result=appointmentDao.findById(appointmentId);
		if(result.isPresent())
		{
			return result.get();
		}
		else
		{
			throw new AppointmentIdNotFoundException("please enter valid appointment id");
		}
	}

	@Override
	public Report viewReport(int patientId) throws PatientIdFoundNotException {
		 //TODO Auto-generated method stub
		return patientRepo.viewReport(patientId);
	}

	}
