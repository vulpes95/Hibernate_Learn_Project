package org.eustrosoft.hibernate;


import org.eustrosoft.entity.Course;
import org.eustrosoft.entity.Instructor;
import org.eustrosoft.entity.InstructorDetail;
import org.eustrosoft.entity.Review;
import org.eustrosoft.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMary {
	
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
			
			Course course1 = new Course("Rubik's Cube");
			Course course2 = new Course("Atari 2600");
			course1.addStudent(student);
			course2.addStudent(student);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
