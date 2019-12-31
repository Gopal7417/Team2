package com.pennanttech.Team2.Empr;

import java.sql.Date;

public class Job_Tbl {

	private int Company_Id;
	private String Company_Name;
	private int Job_Id;
	private String Job_Role;
	private String Job_Description;
	private int Salary;
	private int Experience;
	private int No_of_Openings;
	private String Minimum_Qualification ;
	private Date Register_Date;
	private Date last_Date;
	private String Job_Location;
	private String Address;
	private String Skills ;
	public int getCompany_Id() {
		return Company_Id;
	}
	public void setCompany_Id(int company_Id) {
		Company_Id = company_Id;
	}
	public int getJob_Id() {
		return Job_Id;
	}
	public void setJob_Id(int job_Id) {
		Job_Id = job_Id;
	}
	public String getJob_Role() {
		return Job_Role;
	}
	public void setJob_Role(String job_Role) {
		Job_Role = job_Role;
	}
	public String getJob_Description() {
		return Job_Description;
	}
	public void setJob_Description(String job_Description) {
		Job_Description = job_Description;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public int getExperience() {
		return Experience;
	}
	public void setExperience(int experience) {
		Experience = experience;
	}
	public int getNo_of_Openings() {
		return No_of_Openings;
	}
	public void setNo_of_Openings(int no_of_Openings) {
		No_of_Openings = no_of_Openings;
	}
	public String getMinimum_Qualification() {
		return Minimum_Qualification;
	}
	public void setMinimum_Qualification(String minimum_Qualification) {
		Minimum_Qualification = minimum_Qualification;
	}
	public Date getLast_Date() {
		return last_Date;
	}
	public void setLast_Date(Date last_Date) {
		this.last_Date = last_Date;
	}
	public String getJob_Location() {
		return Job_Location;
	}
	public void setJob_Location(String job_Location) {
		Job_Location = job_Location;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		Skills = skills;
	}
	public Date getRegister_Date() {
		return Register_Date;
	}
	public void setRegister_Date(Date register_Date) {
		Register_Date = register_Date;
	}
	public String getCompany_Name() {
		return Company_Name;
	}
	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}
	
	
}
