package service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.dao.JobOffersDAO;
import model.JobOffers;
import service.JobOffersService;

@Service
public class JobOffersServiceImpl implements JobOffersService {
	private JobOffersDAO jobOfferDAO;

	public void setJobOffersDAO(JobOffersDAO jobOfferDAO) {
		this.jobOfferDAO = jobOfferDAO;
	}

	@Override
	@Transactional
	public void addJobOffer(JobOffers jobOffer) {
		this.jobOfferDAO.addJobOffer(jobOffer);
	}

	@Override
	@Transactional
	public void updateJobOffer(JobOffers jobOffer) {
		this.jobOfferDAO.updateJobOffer(jobOffer);
	}

	@Override
	@Transactional
	public List<JobOffers> listJobOffers() {
		return this.jobOfferDAO.listJobOffers();
	}

	@Override
	@Transactional
	public JobOffers getJobOfferById(int id) {
		return this.jobOfferDAO.getJobOfferById(id);
	}

	@Override
	@Transactional
	public void removeJobOffer(int id) {
		this.jobOfferDAO.removeJobOffer(id);
	}
}
