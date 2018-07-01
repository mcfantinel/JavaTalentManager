package service;

import java.util.List;

import model.JobOffers;

public interface JobOffersService {
	public void addJobOffer(JobOffers jobOffer);

	public void updateJobOffer(JobOffers jobOffer);

	public List<JobOffers> listJobOffers();

	public JobOffers getJobOfferById(int id);

	public void removeJobOffer(int id);
}
