package sk.learning.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.learning.hibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {								
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			Student student = (Student) session.get(Student.class, studentId);
			
			student.setEmail("selva@gmail.com");
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





