package sk.learning.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.learning.hibernate.entity.Course;
import sk.learning.hibernate.entity.Instructor;
import sk.learning.hibernate.entity.InstructorDetail;
import sk.learning.hibernate.entity.Review;
import sk.learning.hibernate.entity.Student;

public class CreateCourseAndStudents {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
						
			Course course = new Course("Python");
						
			session.save(course);
			System.out.println("course saved: " + course);
			
			Student student1 = new Student("Karthik", "R", "kr@gmail.com");
			Student student2 = new Student("Mani", "M", "mm@gmail.com");
						
			course.addStudent(student1);
			course.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			System.out.println("students saved: " + course.getStudents());
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}





