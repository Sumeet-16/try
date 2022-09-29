//package com.onlineeyecare.dto;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//import org.springframework.stereotype.Component;
//
//
//@Entity
//public class Test implements Serializable{
//	
//	private static final long serialVersionUID = 1L;
//	@Id
//	private int testId;
//	private String testName;
//	private String testType;
//	private String testDescription;;
//	private double testCost;
//
//	public Test() {
//		super();
//	}
//	
//	public Test(int testId, String testName, String testType, String testDescription, double testCost) {
//		super();
//		this.testId = testId;
//		this.testName = testName;
//		this.testType = testType;
//		this.testDescription = testDescription;
//		this.testCost = testCost;
//	}
//	
//	public int getTestId() {
//		return testId;
//	}
//	
//	public void setTestId(int testId) {
//		this.testId = testId;
//	}
//
//	public String getTestName() {
//		return testName;
//	}
//	
//	public void setTestName(String testName) {
//		this.testName = testName;
//	}
//	
//	public String getTestType() {
//		return testType;
//	}
//
//	public void setTestType(String testType) {
//		this.testType = testType;
//	}
//	
//	
//	public String getTestDescription() {
//		return testDescription;
//	}
//	
//	public void setTestDescription(String testDescription) {
//		this.testDescription = testDescription;
//	}
//	
//	public double getTestCost() {
//		return testCost;
//	}
//	
//	public void setTestCost(double testCost) {
//		this.testCost = testCost;
//	}
//	
//	
//	@Override
//	public String toString() {
//		return "test [testId=" + testId + ", testName=" + testName + ", testType=" + testType + ", testDescription="
//				+ testDescription + ", testCost=" + testCost + "]";
//	}
//	
//}
