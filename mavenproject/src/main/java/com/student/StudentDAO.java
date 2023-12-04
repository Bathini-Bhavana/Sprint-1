package com.student;

	import java.util.List;
	import java.util.Optional;

	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityTransaction;
	public class StudentDAO {
	
	private EntityManager em;
	public StudentDAO(final EntityManager em) {
		this.em=em;
	}
	//method to add the student details
	public void createStudent(final Student student) {
		EntityTransaction et=null;
		try {
			et=em.getTransaction();
			if(!et.isActive()) {
				et.begin();
			}
			Student mergedStudent = em.merge(student);
			et.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//method to update a row
	public void updateStudent( int id, String newFirstName, String newLastName, String newemail, String newphoneNum, String newgender) {
		EntityTransaction et = null; 
		try {
			et = em.getTransaction(); 

			if (!et.isActive()) {
				et.begin();
			}
			Student student = em.find(Student.class, id) ;
			if(student !=null) {
				student.setSfirtname(newFirstName);
				student.setSlastname(newLastName);
				student.setSemail(newemail);
				student.setPhonenumber(newphoneNum);
				student.setGender(newgender);		
				em.merge(student); 
				et.commit(); 
			}
			
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
	}
	//method to get details of specific row
	public Optional<Student> getById(int id) {

		Student s = em.find(Student.class, id);

		if (s != null) {
			return Optional.of(s);
		} else {
			return Optional.empty();
		}

	}
	//method to get all details in the table
	public List<Student> getAll() {

		List<Student> s1 = em.createQuery("from Student", Student.class).getResultList();

		return s1;

	}
	//remove specific row details using id
	public void removeById(int id) {   
		EntityTransaction et = null; 
		
		Student s = em.find(Student.class, id);  
		
		try {
			et = em.getTransaction(); 

			if (!et.isActive()) {
				et.begin();
			}
			em.remove(s);
			et.commit();
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
	}
	}

