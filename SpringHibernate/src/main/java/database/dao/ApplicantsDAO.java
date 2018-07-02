package database.dao;

import java.util.List;

import model.Applicants;

public interface ApplicantsDAO {
	
	public void addApplicant(Applicants applicant);
	public void updateApplicant(Applicants applicant);
	public List<Applicants> listApplicants();
	public Applicants getApplicantById(long id);
	public void removeApplicant(long id);
	public List<Applicants> getApplicantsBySalaryAndAcademicDegree(float maxSalary, Long acadmicDegreeId);

}
