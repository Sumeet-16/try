package com.onlineeyecare.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Report;
import com.onlineeyecare.dto.Spectacles;


@Repository
public interface IReportRepository extends  JpaRepository<Report,Integer>{
	
	@Query("SELECT Spec FROM Spectacles Spec")
	List<Spectacles> findAllSpectacles();

}
