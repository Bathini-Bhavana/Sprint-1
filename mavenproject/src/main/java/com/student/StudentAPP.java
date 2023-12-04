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
  }
  
   
  
  catch (HibernateException e) {
		 e.printStackTrace();
	}
  catch (Exception e) {
	 e.printStackTrace();
	}

	}
}


