package com.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;

import com.onlineeyecare.dto.Report;
import com.onlineeyecare.dto.Spectacles;
import com.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.onlineeyecare.exceptions.ReportIdNotFoundException;

public interface IReportService {
	Report addReport(Report report);

	Report updateReport(Report report)throws ReportIdNotFoundException;

	Report removeReport(int reportId)throws ReportIdNotFoundException;

	Report viewReport(int reportId, int patientId)throws ReportIdNotFoundException,PatientIdFoundNotException;

	List<Report> viewAllReport(LocalDate date);

	List<Spectacles>  viewSpetacles();


}
