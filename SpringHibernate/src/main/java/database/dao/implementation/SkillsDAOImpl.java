package database.dao.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import database.dao.SkillsDAO;
import model.Skills;

public class SkillsDAOImpl implements SkillsDAO {
	
	private static final Logger logger = Logger.getLogger(SkillsDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Skills> listSkills() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Skills> skillsList = session.createQuery("from Skills").list();
		for(Skills skill : skillsList){
			logger.info("Skills List:"+skill);
		}
		return skillsList;
	}
}
