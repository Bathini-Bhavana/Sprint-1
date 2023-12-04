package com.student;


	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity  //Specifies that the class is an entity
	@Table(name="student")//Specifies the primary table for the annotated entity
	public class Student {
		

	@Id  //Specifies the primary key 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	@Column(name="first_name")
	private String sfirtname;
	@Column(name="last_name")
	private String slastname;
	@Column(name="email")
	private String semail;
	@Column(name="ph_no")
	private String phonenumber;
	@Column(name="gen")
	private String gender;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSfirtname() {
		return sfirtname;
	}
	public void setSfirtname(String sfirtname) {
		this.sfirtname = sfirtname;
	}
	public String getSlastname() {
		return slastname;
	}
	public void setSlastname(String slastname) {
		this.slastname = slastname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sfirtname=" + sfirtname + ", slastname=" + slastname + ", semail=" + semail
				+ ", phonenumber=" + phonenumber + ", gender=" + gender + "]";
	}
	public Student(int sid, String sfirtname, String slastname, String semail, String phonenumber, String gender) {
		super();
		this.sid = sid;
		this.sfirtname = sfirtname;
		this.slastname = slastname;
		this.semail = semail;
		this.phonenumber = phonenumber;
		this.gender = gender;
	}
	public Student() {
		super();
		
	}
	}


