package database.dao;

import java.util.List;

import model.JobOffers;

public interface JobOffersDAO {
	public void addJobOffer(JobOffers jobOffer);
	public void updateJobOffer(JobOffers jobOffer);
	public List<JobOffers> listJobOffers();
	public JobOffers getJobOfferById(int id);
	public void removeJobOffer(int id);
}
