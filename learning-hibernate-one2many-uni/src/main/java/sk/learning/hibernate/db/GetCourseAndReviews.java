package sk.learning.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.learning.hibernate.entity.Course;
import sk.learning.hibernate.entity.Instructor;
import sk.learning.hibernate.entity.InstructorDetail;
import sk.learning.hibernate.entity.Review;

public class GetCourseAndReviews {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();

			int id = 10;
			Course course = session.get(Course.class, id);
			
			System.out.println(course);
			
			System.out.println(course.getReviews());
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
		
			session.close();
			
			factory.close();
		}
	}

}





