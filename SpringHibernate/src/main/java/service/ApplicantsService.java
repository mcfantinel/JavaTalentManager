package service;

import java.util.List;

import model.Applicants;

public interface ApplicantsService {
	public void addApplicant(Applicants applicant);

	public void updateApplicant(Applicants applicant);

	public List<Applicants> listApplicants();

	public Applicants getApplicantById(int id);

	public void removeApplicant(int id);
}
