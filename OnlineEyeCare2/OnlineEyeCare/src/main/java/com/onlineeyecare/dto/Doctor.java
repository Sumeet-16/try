package com.onlineeyecare.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


/*Description    It is a entity class that provides the details of the doctor*/

@Entity

public class Doctor {
	@Id
	@GeneratedValue
	public Integer doctorId;
	@NotEmpty(message="OOPS... Doctor Name cannot be empty")
	private String doctorName;
	private String doctorConsultationTime;
	

	private long doctorMobile;
	
	@Email(message= "OOPS...Email Format is not Corrected")
	@NotEmpty(message="Email cannot be empty")
	private String doctorEmail;
	
	@NotEmpty(message = "OOPS...username is mandatory")
	@Size(min=6)
	private String doctorUsername;
	@Size(min =6,max=15,message="OOPS...Size must be between 6 to 15")
	private String doctorPassword;
	private String doctorAddress;
	
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "doctorId")
	public List<TestModule> tests;

	/*getDoctorId -It is used to get the doctor Id by getter method. */
	public Integer getDoctorId() {
		return doctorId;
	}
	/*setDoctorId -It is used to set the doctor Id by setter method. */
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	/*getDoctorName -It is used to get the doctor name by getter method. */
	
	public String getDoctorName() {
		return doctorName;
	}
	
	/*setDoctorName -It is used to set the doctor Name by setter method. */

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/*getDoctorConsultatationTime -It is used to get the doctor Consultation Time by getter method. */

	public String getDoctorConsultationTime() {
		return doctorConsultationTime;
	}

	/*setDoctorConsultatationTime -It is used to set the doctor Consultation Time by setter method. */
	
	public void setDoctorConsultationTime(String doctorConsultationTime) {
		this.doctorConsultationTime = doctorConsultationTime;
	}

	/*getDoctorMobile -It is used to get the doctor mobile by getter method. */

	public long getDoctorMobile() {
		return doctorMobile;
	}
	/*setDoctorMobile -It is used to set the doctor mobile by setter method. */

	public void setDoctorMobile(long doctorMobile) {
		this.doctorMobile = doctorMobile;
	}
	
	/*getDoctorEmail -It is used to get the doctor mail by getter method. */

	public String getDoctorEmail() {
		return doctorEmail;
	}

	/*setDoctorEmail -It is used to set the doctor mail by setter method. */

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	/*getDoctorUsername -It is used to get the doctor userName by getter method. */

	public String getDoctorUsername() {
		return doctorUsername;
	}
	
	/*setDoctorUsername -It is used to set the doctor userName by setter method. */

	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}
	
	
	/*getDoctorpassword -It is used to get the doctor password by getter method. */
	
	public String getDoctorPassword() {
		return doctorPassword;
	}
	/*setDoctorpassword -It is used to set the doctor password by setter method. */

		public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}

		/*getDoctorAddress -It is used to get the doctor address by getter method. */
	
	public String getDoctorAddress() {
		return doctorAddress;
	}
	
	/*setDoctorAddress -It is used to set the doctor address by setter method. */

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	

	/* It is used to initialize the empty constructor.*/
	
	public List<TestModule> getTests() {
		return tests;
	}
	public void setTests(List<TestModule> tests) {
		this.tests = tests;
	}
	public Doctor() {
		super();
	}
	
	/* It is used to initialize the parameterized constructor.	 */

	public Doctor(Integer doctorId, String doctorName, String doctorConsultationTime, long doctorMobile,
			String doctorEmail, String doctorUsername, String doctorPassword, String doctorAddress, List<TestModule> tests) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorConsultationTime = doctorConsultationTime;
		this.doctorMobile = doctorMobile;
		this.doctorEmail = doctorEmail;
		this.doctorUsername = doctorUsername;
		this.doctorPassword = doctorPassword;
		this.doctorAddress = doctorAddress;
		this.tests = tests;
	}


}