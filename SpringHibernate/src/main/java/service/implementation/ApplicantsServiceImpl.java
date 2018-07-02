package service.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.dao.ApplicantsDAO;
import model.Applicants;
import model.JobOffers;
import model.QualifiedApplicants;
import model.QualifiedJobOffers;
import service.ApplicantsService;

@Service
public class ApplicantsServiceImpl implements ApplicantsService {
	private ApplicantsDAO applicantDAO;

	public void setApplicantsDAO(ApplicantsDAO applicantDAO) {
		this.applicantDAO = applicantDAO;
	}

	@Override
	@Transactional
	public void addApplicant(Applicants applicant) {
		this.applicantDAO.addApplicant(applicant);
	}

	@Override
	@Transactional
	public void updateApplicant(Applicants applicant) {
		this.applicantDAO.updateApplicant(applicant);
	}

	@Override
	@Transactional
	public List<Applicants> listApplicants() {
		return this.applicantDAO.listApplicants();
	}

	@Override
	@Transactional
	public Applicants getApplicantById(long id) {
		return this.applicantDAO.getApplicantById(id);
	}
	
	@Override
	@Transactional
	public List<QualifiedApplicants> getApplicantsForJobOffer(JobOffers jobOffer) {
		List<QualifiedApplicants> qualifiedApplicants = new ArrayList<>();
		List<Applicants> applicantsForJobOffer = this.applicantDAO
				.getApplicantsBySalaryAndAcademicDegree(jobOffer.getMaxSalary(), jobOffer.getAcademicDegree().getId());
		
		for(Applicants applicant : applicantsForJobOffer) {
			QualifiedApplicants qualifiedApplicant = jobOffer.verifyIfApplicantIsValidForJobOffer(applicant);
			if(qualifiedApplicant != null) {
				qualifiedApplicants.add(qualifiedApplicant);
			}
		}
		
		qualifiedApplicants.sort(Comparator.comparing(QualifiedApplicants::getTotalPoints));
		Collections.reverse(qualifiedApplicants);
		
		return qualifiedApplicants;
	}

	@Override
	@Transactional
	public void removeApplicant(long id) {
		this.applicantDAO.removeApplicant(id);
	}
}
