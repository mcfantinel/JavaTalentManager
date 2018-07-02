package service.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.dao.JobOffersDAO;
import model.Applicants;
import model.JobOffers;
import model.QualifiedJobOffers;
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
	public JobOffers getJobOfferById(long id) {
		return this.jobOfferDAO.getJobOfferById(id);
	}
	
	@Override
	@Transactional
	public List<QualifiedJobOffers> getJobOffersForApplicant(Applicants applicant) {
		List<QualifiedJobOffers> qualifiedJobOffers = new ArrayList<>();
		List<JobOffers> jobOffersForApplicant = this.jobOfferDAO
				.getJobOfferBySalaryAndAcademicDegree(applicant.getMinSalary(), applicant.getAcademicDegree().getId());
		
		for(JobOffers jobOffer : jobOffersForApplicant) {
			QualifiedJobOffers qualifiedJobOffer = jobOffer.verifyIfJobOfferIsValidForApplicant(applicant.getApplicantSkills());
			if(qualifiedJobOffer != null) {
				qualifiedJobOffers.add(qualifiedJobOffer);
			}
		}
		
		qualifiedJobOffers.sort(Comparator.comparing(QualifiedJobOffers::getTotalPoints));
		Collections.reverse(qualifiedJobOffers);
		
		return qualifiedJobOffers;
	}

	@Override
	@Transactional
	public void removeJobOffer(long id) {
		this.jobOfferDAO.removeJobOffer(id);
	}
}
