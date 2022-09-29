package com.onlineeyecare.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Spectacles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	private int spectaclesId;
	private String spectaclesModel;
	private String spectaclesDescription;
	private double spectaclesCost;
	
	public Spectacles() {
		super();
	}


	public Spectacles(int spectaclesId, String spectaclesModel, String spectaclesDescription, double spectaclesCost) {
		super();
		this.spectaclesId = spectaclesId;
		this.spectaclesModel = spectaclesModel;
		this.spectaclesDescription = spectaclesDescription;
		this.spectaclesCost = spectaclesCost;
	}
	
	public int getSpectaclesId() {
		return spectaclesId;
	}

	public void setSpectaclesId(int spectaclesId) {
		this.spectaclesId = spectaclesId;
	}

	public String getSpectaclesModel() {
		return spectaclesModel;
	}

	public void setSpectaclesModel(String spectaclesModel) {
		this.spectaclesModel = spectaclesModel;
	}

	public String getSpectaclesDescription() {
		return spectaclesDescription;
	}

	public void setSpectaclesDescription(String spectaclesDescription) {
		this.spectaclesDescription = spectaclesDescription;
	}

	public double getSpectaclesCost() {
		return spectaclesCost;
	}

	public void setSpectaclesCost(double spectaclesCost) {
		this.spectaclesCost = spectaclesCost;
	}
}
