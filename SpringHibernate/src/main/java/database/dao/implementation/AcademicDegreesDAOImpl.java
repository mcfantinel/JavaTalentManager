package database.dao.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import database.dao.AcademicDegreesDAO;
import model.AcademicDegrees;

public class AcademicDegreesDAOImpl implements AcademicDegreesDAO {
	
	private static final Logger logger = Logger.getLogger(SkillsDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AcademicDegrees> listAcademicDegrees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<AcademicDegrees> academicDegreesList = session.createQuery("from AcademicDegrees").list();
		for(AcademicDegrees academicDegree : academicDegreesList){
			logger.info("AcademicDegrees List:"+academicDegree);
		}
		return academicDegreesList;
	}
}
