package service;

import java.util.List;

import model.Applicants;
import model.JobOffers;
import model.QualifiedJobOffers;

public interface JobOffersService {
	public void addJobOffer(JobOffers jobOffer);

	public void updateJobOffer(JobOffers jobOffer);

	public List<JobOffers> listJobOffers();

	public JobOffers getJobOfferById(long id);
	
	public List<QualifiedJobOffers> getJobOffersForApplicant(Applicants applicant);

	public void removeJobOffer(long id);
}
