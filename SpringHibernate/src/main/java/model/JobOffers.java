package model;

import java.util.List;

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
@Table(name = "JOB_OFFERS")
public class JobOffers {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "description", nullable = false, length = 200)
	private String description;

	@Column(name = "min_salary", nullable = false)
	private float minSalary;

	@Column(name = "max_salary", nullable = false)
	private float maxSalary;

	@Column(name = "working_time", nullable = false, length = 20)
	private WorkingTime workingTime;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "academic_degree_id", nullable = false)
	private AcademicDegrees academicDegree;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", nullable = false)
	private Companies company;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_offer_id", nullable = false)
	private List<JobOffersSkills> jobOfferSkills;

	public JobOffers() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(float minSalary) {
		this.minSalary = minSalary;
	}

	public float getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(float maxSalary) {
		this.maxSalary = maxSalary;
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

	public List<JobOffersSkills> getJobOfferSkills() {
		return jobOfferSkills;
	}

	public void setJobOfferSkills(List<JobOffersSkills> jobOfferSkills) {
		this.jobOfferSkills = jobOfferSkills;
	}
	

	public Companies getCompany() {
		return company;
	}

	public void setCompany(Companies company) {
		this.company = company;
	}

	public QualifiedJobOffers verifyIfJobOfferIsValidForApplicant(List<ApplicantsSkills> applicantSkills) {
		int totalPoints = 0;
		
		for(JobOffersSkills jobOfferSkill : this.getJobOfferSkills()) {
			if(!applicantSkills.stream().anyMatch(a -> a.getSkill().getId() == jobOfferSkill.getSkill().getId() 
					&& a.getScale() >= jobOfferSkill.getScale())) {
				return null;
			} else {
				totalPoints += applicantSkills.stream().filter(a -> a.getSkill().getId() == jobOfferSkill.getSkill().getId())
						.findAny().orElse(null).getScale();
			}
		}
		
		return new QualifiedJobOffers(this, totalPoints);		
	}
	
	public QualifiedApplicants verifyIfApplicantIsValidForJobOffer(Applicants applicant) {
		int totalPoints = 0;
		
		List<ApplicantsSkills> applicantSkills = applicant.getApplicantSkills();
		
		for(JobOffersSkills jobOfferSkill : this.getJobOfferSkills()) {
			if(!applicantSkills.stream().anyMatch(a -> a.getSkill().getId() == jobOfferSkill.getSkill().getId() 
					&& a.getScale() >= jobOfferSkill.getScale())) {
				return null;
			} else {
				totalPoints += applicantSkills.stream().filter(a -> a.getSkill().getId() == jobOfferSkill.getSkill().getId())
						.findAny().orElse(null).getScale();
			}
		}
		
		return new QualifiedApplicants(applicant, totalPoints);		
	}
	

}
