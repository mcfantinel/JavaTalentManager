package service;

import java.util.List;

import model.Applicants;
import model.JobOffers;
import model.QualifiedApplicants;

public interface ApplicantsService {
	public void addApplicant(Applicants applicant);

	public void updateApplicant(Applicants applicant);

	public List<Applicants> listApplicants();

	public Applicants getApplicantById(long id);
	
	public List<QualifiedApplicants> getApplicantsForJobOffer(JobOffers jobOffers);

	public void removeApplicant(long id);
}
