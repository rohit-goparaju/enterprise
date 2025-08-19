package daos;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enterprise.Person;

public class PersonDAO {
	private static final Logger log = LoggerFactory.getLogger(PersonDAO.class);
	
	private Configuration config;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private boolean allowConnection = true;
	
	private void connectDb() {
		if(allowConnection) {			
			config = new Configuration().configure();
			factory = config.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			allowConnection = false;
			log.info("connected to database");
		}else {
			log.warn("previous connection still open");
		}
	}
	
	public void addPerson(Person person) {
		connectDb();
		session.persist(person);
		commitAndClose();
		log.info(person+ " person added successfully");
	}
	
	public Person getPerson(int id) {
		connectDb();
		Person person = new Person();
		session.load(person, id);
		commitAndClose();
		log.info(person+ " person loaded successfully");
		return person;
	}
	
	public void removePerson(Person person) {
		connectDb();
		session.remove(person);
		commitAndClose();
		log.info(person + " person removed successfully");
	}
	
	private void close() {
		session.close();
		factory.close();
		allowConnection = true;
		log.info("Database connection closed");
	}

	private void commitAndClose() {
		transaction.commit();
		log.info("Transaction committed");
		close();
	}
	
	private void rollbackAndClose() {
		transaction.rollback();
		log.info("Transaction rolled back");
		close();
	}
	
}
