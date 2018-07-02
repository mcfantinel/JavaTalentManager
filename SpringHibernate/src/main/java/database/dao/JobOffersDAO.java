package database.dao;

import java.util.List;

import model.JobOffers;

public interface JobOffersDAO {
	public void addJobOffer(JobOffers jobOffer);
	public void updateJobOffer(JobOffers jobOffer);
	public List<JobOffers> listJobOffers();
	public JobOffers getJobOfferById(long id);
	public void removeJobOffer(long id);
	public List<JobOffers> getJobOfferBySalaryAndAcademicDegree(float salary, long acadmicDegreeId);
}
