package service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.dao.ApplicantsDAO;
import model.Applicants;
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
	public Applicants getApplicantById(int id) {
		return this.applicantDAO.getApplicantById(id);
	}

	@Override
	@Transactional
	public void removeApplicant(int id) {
		this.applicantDAO.removeApplicant(id);
	}
}
