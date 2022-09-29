package com.onlineeyecare.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.onlineeyecare.service.IPatientService;



@RestController
@RequestMapping("/v1/patient")
public class PatientController {
	
//	Log logger = LogFactory.getLog(DoctorController.class);
  @Autowired
  IPatientService patientRepo;



@PostMapping("/addpatient")
public Patient additionofPatient(@RequestBody Patient patient)
{
	return patientRepo.addPatient(patient);
}

@PutMapping("/updatepatient")
public Patient updatepatient(@RequestBody Patient patient)
{
	return patientRepo.updatePatient(patient);
}

@DeleteMapping("/delete/{id}")
public Patient deltePatient(@PathVariable int id) throws PatientIdFoundNotException
{
	return patientRepo.deletePatient(id);
}


@GetMapping("/viewpatientlist")
public List<Patient>listpatientlist()
{
	//logger.info("Get Coders successfully");
	return patientRepo.viewPatientList();
}

@GetMapping("/viewpatient/{id}")
public Patient viewPatient(@PathVariable int id) throws PatientIdFoundNotException
{
	return patientRepo.viewPatient(id);
}

@PostMapping("/bookappointment")
public Appointment bookAppointment(@RequestBody Appointment appointment) {
	return patientRepo.bookAppointment(appointment);
}
@GetMapping("/viewappointment/{id}")
public Appointment viewAppointmentIn(@PathVariable int id) throws AppointmentIdNotFoundException {
	return patientRepo.viewAppointmentDetail(id);
}
}