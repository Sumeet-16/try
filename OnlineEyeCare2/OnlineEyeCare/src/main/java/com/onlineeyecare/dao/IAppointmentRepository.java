package com.onlineeyecare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Appointment;



@Repository
public interface IAppointmentRepository extends  JpaRepository<Appointment,Integer> {

}
