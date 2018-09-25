package org.eustrosoft.hibernate;


import org.eustrosoft.entity.Course;
import org.eustrosoft.entity.Instructor;
import org.eustrosoft.entity.InstructorDetail;
import org.eustrosoft.entity.Review;
import org.eustrosoft.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMary {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate_cong.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			int theId = 2;
			Student student = session.get(Student.class, theId);
			
			System.out.println("Courses: "+student.getCourses());
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
