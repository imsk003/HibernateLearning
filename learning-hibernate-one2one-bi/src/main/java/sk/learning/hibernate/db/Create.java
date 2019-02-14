package sk.learning.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.learning.hibernate.entity.Instructor;
import sk.learning.hibernate.entity.InstructorDetail;

public class Create {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor =	new Instructor("SelvaKumar", "T", "sk@gmail.com");
			
			InstructorDetail instructorDetail =	new InstructorDetail("https://www.youtube.com", "Browsing");		
			
			session.beginTransaction();
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.save(instructor);	
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
