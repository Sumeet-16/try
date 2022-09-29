package com.onlineeyecare.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.IAppointmentRepository;
import com.onlineeyecare.dao.IDoctorRepository;
import com.onlineeyecare.dao.ITestRepository;
import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;

/*It is a doctor service implementation class that defines the methods mentioned in its interface.*/


@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Autowired
	private ITestRepository testRepository;
	@Autowired
	private IAppointmentRepository appointmentrepo;
	

	/*	viewDoctorsList	-To display all the Doctors */
	
	@Override
	public Doctor addDoctor(Doctor doctor) {

		return doctorRepository.saveAndFlush(doctor);
	}
	

	/*	deleteDoctor	- To display the doctor by Id (Primary key) */
	
	
	@Override
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException {

	Optional<Doctor> result=doctorRepository.findById(doctorId);
		if(result.isPresent())
		{
			doctorRepository.deleteById(doctorId);
			return result.get();
		}
		else
		{
			throw new DoctorIdNotFoundException("please enter valid doctor id");
		}
	
		
	}
	

	/* viewDoctorList -	To display all the Doctors */
	
	
	@Override
	public List<Doctor> viewDoctorsList() {
		return doctorRepository.findAll();
	}

	/*viewDoctor- It is used to view doctor details from doctor table.*/

	@Override
	public Doctor viewDoctor(int doctorId) throws DoctorIdNotFoundException {
		java.util.Optional<Doctor> result = doctorRepository.findById(doctorId); 
		if(result.isPresent()) {
			doctorRepository.findById(doctorId);
			return result.get();
		}
		else {
			throw new DoctorIdNotFoundException("please enter valid doctor id");
		}
	}
	
	/*updateDoctor- It is used to update doctor details into doctor table.*/

	@Override
	public Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException {

		Optional<Doctor> result=doctorRepository.findById(doctor.getDoctorId());
		if(result.isPresent())
		{
			return doctorRepository.saveAndFlush(doctor);
		}
		else
		{
			throw new DoctorIdNotFoundException("please enter valid doctor id");
		}
	}

	/*viewAllAppointments- It is used to view Appointment details..*/


	@Override
	public List<Appointment> viewAllAppointments() {

		return appointmentrepo.findAll();
	}

	/*createTest- It is used to create test details into test table..*/

	
	@Override
	public TestModule createTest(TestModule test) {
		return testRepository.saveAndFlush(test);
		
	}
	

}
