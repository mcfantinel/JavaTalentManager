package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICANTS")
public class Applicants {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "fullName", nullable = false, length = 80)
	private String fullName;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;
	
	@Column(name = "min_salary", nullable = false)
	private float minSalary;
	
	@Column(name = "working_time", nullable = false)
	private WorkingTime workingTime;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "academic_degree_id", nullable = false)
	private AcademicDegrees academicDegree;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "applicant_id", nullable = false)
	private List<ApplicantsSkills> applicantSkills;
	
	public Applicants() {
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(float minSalary) {
		this.minSalary = minSalary;
	}

	public WorkingTime getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(WorkingTime workingTime) {
		this.workingTime = workingTime;
	}

	public AcademicDegrees getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(AcademicDegrees academicDegree) {
		this.academicDegree = academicDegree;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ApplicantsSkills> getApplicantSkills() {
		return applicantSkills;
	}

	public void setApplicantSkills(List<ApplicantsSkills> applicantSkills) {
		this.applicantSkills = applicantSkills;
	}
	
	

}
