package com.student;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentAPP {

	public static void main(String[] args) {
	 EntityManagerFactory factory =null;	
  try {
	factory=Persistence.createEntityManagerFactory("bhavana");
	
	EntityManager em = factory.createEntityManager();
	
	Student s1 = new Student(1,"bhavana","vijay","vijay@gmail.com","9875643231","female");
	Student s2 = new Student(2,"chandra","bathini","chandu@gmail.com","7739955228","male");
	Student s3 = new Student(3,"karithk","lokesh","loki@gmail.com","9912794443","male");
	Student s4 = new Student(4,"nirma","bathini","nimmu@gmail.com","9993728144","female");
	Student s5 = new Student(5,"nani","prasad","prasad@gmail.com","9087657854","male");
	StudentDAO s=new StudentDAO(em);
	s.createStudent(s1);
	s.createStudent(s2);
	s.createStudent(s3);
	s.createStudent(s4);
	s.createStudent(s5);
	System.out.println("Student details successfully added");
	System.out.println("----------------------------------------------------------------");
	System.out.println("updating studeent details");
	int  newid = 5;
	String newfirstName ="yadagiri" ;
	String newLastName = "bathini" ;
	String newemail = "bathini@gmail.com";
	String newphoneNum = "9640007205" ;
	String newgender  ="male";
	
	s.updateStudent(newid, newfirstName, newLastName, newemail, newphoneNum, newgender);
	System.out.println("------------------------------------------------------------");
	System.out.println("student details based on id");
	Optional<Student> details = s.getById(2);
	System.out.println(details);
	
	System.out.println("------------------------------------------------------------");
	System.out.println("All students details");	 
	List<Student> all = s.getAll();
	System.out.println(all);
	System.out.println("------------------------------------------------------------");
	System.out.println("Removing student details based on id");	
	s.removeById(4);
  
  
  course c1 = new course();
  c1.setCourseName("Java Programming");
  c1.setCourseCode("CS101");

  course c2 = new course();
  c2.setCourseName("Database Management");
  c2.setCourseCode("DB101");

  course c3 = new  course();
  c3.setCourseName("Web Development");
  c3.setCourseCode("WD101");

  courseDAO courseDAO = new courseDAO(em);

  // Adding courses
  courseDAO.createCourse(c1);
  courseDAO.createCourse(c2);
  courseDAO.createCourse(c3);

  System.out.println("Course details successfully added");
  System.out.println("----------------------------------------------------------------");

  // Updating course details
  int newCourseId = 3;
  String newCourseName = "Advanced Web Development";
  String newCourseCode = "AWD101";
  courseDAO.updateCourse(newCourseId, newCourseName, newCourseCode);
  System.out.println("------------------------------------------------------------");

  // Retrieving course details based on ID
  System.out.println("Course details based on ID");
  Optional<course> courseDetails = courseDAO.getById(2);
  System.out.println(courseDetails);
  System.out.println("------------------------------------------------------------");

  // Retrieving all courses
  System.out.println("All course details");
  List<course> allCourses = courseDAO.getAll();
  System.out.println(allCourses);
  System.out.println("------------------------------------------------------------");

  // Removing a course by ID
  System.out.println("Removing 1st course based on ID");
  System.out.println("Data removed successfully");
  courseDAO.removeById(1);
}

catch (HibernateException e) {
	 e.printStackTrace();
}
}
}
