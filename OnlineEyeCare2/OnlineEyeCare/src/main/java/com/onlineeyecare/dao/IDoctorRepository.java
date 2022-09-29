package com.onlineeyecare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineeyecare.dto.Doctor;

/*	it is a doctor repository interface that extends JPA repository that contains inbuilt methods for various operations
*/
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	public Doctor getDoctorByDoctorId(int id); 
}
