package sk.learning.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.learning.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student  student = new Student("SELVAKUMAR", "THANGARAJ", "sk@gmail.com");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
