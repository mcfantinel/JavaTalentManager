package database.dao.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import database.dao.ApplicantsDAO;
import model.Applicants;
import model.JobOffers;

@Repository
public class ApplicantsDAOImpl implements ApplicantsDAO {
	
	private static final Logger logger = Logger.getLogger(ApplicantsDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addApplicant(Applicants applicant) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(applicant);
		logger.info("Applicants saved successfully, Applicants Details="+applicant);
	}

	@Override
	public void updateApplicant(Applicants applicant) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(applicant);
		logger.info("Applicants updated successfully, Applicants Details="+applicant);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Applicants> listApplicants() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Applicants> applicantsList = session.createQuery("from Applicants").list();
		for(Applicants applicant : applicantsList){
			logger.info("Applicants List:"+applicant);
		}
		return applicantsList;
	}

	@Override
	public Applicants getApplicantById(long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Applicants applicant = (Applicants) session.load(Applicants.class, new Long(id));
		logger.info("Applicants loaded successfully, Applicants details="+applicant);
		return applicant;
	}

	@Override
	public void removeApplicant(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Applicants applicant = (Applicants) session.load(Applicants.class, new Long(id));
		if(null != applicant){
			session.delete(applicant);
		}
		logger.info("Applicants deleted successfully, person details="+applicant);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Applicants> getApplicantsBySalaryAndAcademicDegree(float maxSalary, Long acadmicDegreeId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Applicants> applicantsList = session.createQuery("from Applicants AP"
				+ " WHERE AP.academicDegree.id = :acad_deg_id " + 
				" AND AP.minSalary <= :maxSalary ")
				.setParameter("acad_deg_id", acadmicDegreeId)
				.setParameter("maxSalary", maxSalary)
				.list();
		for(Applicants applicant : applicantsList){
			logger.info("Applicants List:"+applicant);
		}
		return applicantsList;
	}

}
