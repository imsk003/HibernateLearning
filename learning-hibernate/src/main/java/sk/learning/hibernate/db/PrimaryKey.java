package sk.learning.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.learning.hibernate.entity.Student;

public class PrimaryKey {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {		
			Student student1 = new Student("Arun", "Kumar", "arun@gmail.com");
			Student student2 = new Student("Siva", "U", "siva@gmail.com");
			Student student3 = new Student("Karthi", "S", "karthi@gmail.com");
			
			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}
}
