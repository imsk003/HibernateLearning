package sk.learning.hibernate.db;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.learning.hibernate.entity.Instructor;
import sk.learning.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetailOnly {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();

			int id = 3;
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}