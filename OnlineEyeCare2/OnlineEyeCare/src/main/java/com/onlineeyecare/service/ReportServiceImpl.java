package com.onlineeyecare.service;

import java.time.LocalDate;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.IReportRepository;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.Report;
import com.onlineeyecare.dto.Spectacles;
import com.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.onlineeyecare.exceptions.ReportIdNotFoundException;


@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private IReportRepository Ireportrepository;

	
	@Override
	public Report addReport(Report report) {
		// TODO Auto-generated method stub
		return Ireportrepository.saveAndFlush(report);
	}
	
	@Override
	public Report updateReport(Report report) throws ReportIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Report> result=Ireportrepository.findById(report.getReportId());
		if(result.isPresent())
		{
			return Ireportrepository.saveAndFlush(report);
		}
		else
		{
			throw new ReportIdNotFoundException("please enter valid report id");
		}
	}
	
	@Override
	public Report removeReport(int reportId) throws ReportIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Report> result=Ireportrepository.findById(reportId);
		if(result.isPresent())
		{
			Ireportrepository.deleteById(reportId);
			return result.get();
		}
		else
		{
			throw new ReportIdNotFoundException("please enter valid report id");
		}
	}

	
	@Override
	public List<Spectacles> viewSpetacles() {
		// TODO Auto-generated method stub
		return Ireportrepository.findAllSpectacles();
	}
	
	@Override
	public List<Report> viewAllReport(LocalDate date) {
		// TODO Auto-generated method stub
		return Ireportrepository.findAll().stream().filter(report->(date.compareTo(report.getDateOfReport().toLocalDate())==0)).collect(Collectors.toList());
	}
	
	@Override
	public Report viewReport(int reportId, int patientId) throws ReportIdNotFoundException, PatientIdFoundNotException {
		
		Optional<Report> result1=Ireportrepository.findById(reportId);
		Patient result2=Ireportrepository.findById(reportId).get().getPatientId();
		if(result1.isPresent())
		{
			if(result2.getPatientId()==patientId)
			{
				return result1.get();
			}
			else
			{
				throw new PatientIdFoundNotException("Please enter valid patient id!");
			}
		}
		else
		{
			throw new ReportIdNotFoundException("Please enter valid report id!");
		}

	}

}
