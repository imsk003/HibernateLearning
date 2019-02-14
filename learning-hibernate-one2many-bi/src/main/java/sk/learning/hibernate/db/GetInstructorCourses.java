package sk.learning.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.learning.hibernate.entity.Course;
import sk.learning.hibernate.entity.Instructor;
import sk.learning.hibernate.entity.InstructorDetail;

public class GetInstructorCourses {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);		
			
			System.out.println("Instructor: " + instructor);
			
			System.out.println("Courses: " + instructor.getCourses());
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}





