package database.dao.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import database.dao.JobOffersDAO;
import model.JobOffers;

public class JobOffersDAOImpl implements JobOffersDAO {
	private static final Logger logger = Logger.getLogger(JobOffersDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addJobOffer(JobOffers jobOffer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(jobOffer);
		logger.info("JobOffers saved successfully, JobOffers Details="+jobOffer);
	}

	@Override
	public void updateJobOffer(JobOffers jobOffer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(jobOffer);
		logger.info("JobOffers updated successfully, JobOffers Details="+jobOffer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobOffers> listJobOffers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<JobOffers> jobOffersList = session.createQuery("from Job_Offers").list();
		for(JobOffers jobOffer : jobOffersList){
			logger.info("JobOffers List:"+jobOffer);
		}
		return jobOffersList;
	}

	@Override
	public JobOffers getJobOfferById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		JobOffers jobOffer = (JobOffers) session.load(JobOffers.class, new Integer(id));
		logger.info("JobOffers loaded successfully, JobOffers details="+jobOffer);
		return jobOffer;
	}

	@Override
	public void removeJobOffer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		JobOffers jobOffer = (JobOffers) session.load(JobOffers.class, new Integer(id));
		if(null != jobOffer){
			session.delete(jobOffer);
		}
		logger.info("JobOffers deleted successfully, person details="+jobOffer);
	}
}
