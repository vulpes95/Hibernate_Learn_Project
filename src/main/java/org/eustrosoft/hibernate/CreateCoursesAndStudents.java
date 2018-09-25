package org.eustrosoft.hibernate;


import org.eustrosoft.entity.Course;
import org.eustrosoft.entity.Instructor;
import org.eustrosoft.entity.InstructorDetail;
import org.eustrosoft.entity.Review;
import org.eustrosoft.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudents {
	
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
			
			Course curse = new Course("Pacman");
			session.save(curse);
			
			Student student1 = new Student ("John","Doe","john@luv2code.com");
			Student student2 = new Student ("Mary","Public","mary@luv2code.com");
			curse.addStudent(student1);
			curse.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
