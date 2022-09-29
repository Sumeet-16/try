package com.onlineeyecare.dto;

import java.time.LocalDate;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment {
@Id
private Integer appointmentId;
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate dateOfAppointment;
@JsonFormat (shape = JsonFormat.Shape.STRING,pattern="hh:mm:ss a")
LocalTime timeOfAppointment;
Double consultationFee;
@ManyToOne(cascade=CascadeType.MERGE)
@JoinColumn(name="doctor_Id")
Doctor doctor_Id;
@ManyToOne(cascade=CascadeType.MERGE)
@JoinColumn(name="patient_Id")
@JsonIgnore
Patient patient_Id;

public Appointment() {
	super();
}

public Integer getAppointmentId() {
	return appointmentId;
}
public Appointment(Integer appointmentId, LocalDate dateOfAppointment, LocalTime timeOfAppointment,
		Double consultationFee, Doctor doctorId, Patient patientId) {
	super();
	this.appointmentId = appointmentId;
	this.dateOfAppointment = dateOfAppointment;
	this.timeOfAppointment = timeOfAppointment;
	this.consultationFee = consultationFee;
	this.doctor_Id = doctorId;
	this.patient_Id = patientId;
}

public void setAppointmentId(Integer appointmentId) {
	this.appointmentId = appointmentId;
}

@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
public LocalDate getDateOfAppointment() {
	return dateOfAppointment;
}

public void setDateOfAppointment(LocalDate dateOfAppointment) {
	this.dateOfAppointment = dateOfAppointment;
}

@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss a")
public LocalTime getTimeOfAppointment() {
	return timeOfAppointment;
}

public void setTimeOfAppointment(LocalTime timeOfAppointment) {
	this.timeOfAppointment = timeOfAppointment;
}

public Double getConsultantFee() {
	return consultationFee;
}

public void setConsultantFee(Double consultantFee) {
	this.consultationFee = consultantFee;
}
public Doctor getDoctorId() {
	return doctor_Id;
}
public void setDoctorId(Doctor doctorId) {
	this.doctor_Id = doctorId;
}
public Patient getPatientId() {
	return patient_Id;
}
public void setPatientId(Patient patientId) {
	this.patient_Id = patientId;
}

@Override
public String toString() {
	return "Appointment [appointmentId=" + appointmentId + ", dateOfAppointment=" + dateOfAppointment
			+ ", timeOfAppointment=" + timeOfAppointment + ", consultationFee=" + consultationFee + ", doctorId="
			+ doctor_Id + ", patientId=" + patient_Id + "]";
}



}
