package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import model.TestEntity;

public class TestConnection {
	private static final Logger logger = Logger.getLogger(TestConnection.class);

	public static void main(String[] args) {

//		List<Users> users = UsersDao.getUsers();
//
//		for (Users user : users) {
//			System.out.println(user.getUsername());
//		}

		logger.debug("starting application....");

		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HBPersistenceUnit");

		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		try {
			TestEntity testEntity = new TestEntity();
			testEntity.setName("super foo");

			entityManager.persist(testEntity);
			tx.commit();
		} catch (Exception e) {
			logger.error("cannot commit transaction", e);
			tx.rollback();
		} finally {
			entityManager.close();
		}

		emf.close();
	}
}
