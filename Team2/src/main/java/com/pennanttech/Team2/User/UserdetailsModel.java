package com.pennanttech.Team2.User;

import java.sql.Date;
import java.util.List;

public class UserdetailsModel {
	private int emp_id;
	private String Name;
	private String Email_Id;
	private String Create_Password;
	private long Mobile_Number;
	private Date Date_Of_Birth;
	private String Gender;
	private String Highest_Qualification;
	/* private String Course; */
	private String Specialization;
	private String University;
	private int Passing_Year;
	private String Skills;
	private String Company_Name;
	private int No_of_Years;
	private String Job_Role;
	private byte[] Resume;
	private List Ls;
	
	public List getLs() {
		return Ls;
	}
	public void setLs(List ls) {
		Ls = ls;
	}
	public Date getDate_Of_Birth() {
		return Date_Of_Birth;
	}
	public void setDate_Of_Birth(Date date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public String getCreate_Password() {
		return Create_Password;
	}
	public void setCreate_Password(String create_Password) {
		Create_Password = create_Password;
	}
	public long getMobile_Number() {
		return Mobile_Number;
	}
	public void setMobile_Number(long mobile_Number) {
		Mobile_Number = mobile_Number;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getHighest_Qualification() {
		return Highest_Qualification;
	}
	public void setHighest_Qualification(String highest_Qualification) {
		Highest_Qualification = highest_Qualification;
	}

	/*
	 * public String getCourse() { return Course; } public void setCourse(String
	 * course) { Course = course; }
	 */
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public String getUniversity() {
		return University;
	}
	public void setUniversity(String university) {
		University = university;
	}
	public int getPassing_Year() {
		return Passing_Year;
	}
	public void setPassing_Year(int passing_Year) {
		Passing_Year = passing_Year;
	}
	public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		Skills = skills;
	}
	public String getCompany_Name() {
		return Company_Name;
	}
	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}
	public int getNo_of_Years() {
		return No_of_Years;
	}
	public void setNo_of_Years(int no_of_Years) {
		No_of_Years = no_of_Years;
	}
	public String getJob_Role() {
		return Job_Role;
	}
	public void setJob_Role(String job_Role) {
		Job_Role = job_Role;
	}
	public byte[] getResume() {
		return Resume;
	}
	public void setResume(byte[] resume) {
		Resume = resume;
	}
	
}
