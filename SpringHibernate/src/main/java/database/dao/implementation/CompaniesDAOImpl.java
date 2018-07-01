package database.dao.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import database.dao.CompaniesDAO;
import model.Companies;

public class CompaniesDAOImpl implements CompaniesDAO {
	
	private static final Logger logger = Logger.getLogger(SkillsDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Companies> listCompanies() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Companies> companiesList = session.createQuery("from Companies").list();
		for(Companies company : companiesList){
			logger.info("Companies List:"+company);
		}
		return companiesList;
	}
}
