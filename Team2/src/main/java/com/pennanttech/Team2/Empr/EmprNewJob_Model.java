package com.pennanttech.Team2.Empr;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class EmprNewJob_Model 
	{
	
	private int Company_Id;
	private int Job_Id;
	private String Job_Role;
	private String Job_Description;
	private BigDecimal Salary;
	private int No_of_Openings;
	private int Experience;
	private String Minimum_Qualification ;
	private Date last_Date;
	private String Job_Location;
	private String Address;
	private String Skills ;
	private String Venue;
	private String I_Date;

	private Time I_Time;
	private String Rounds;
	
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
	
	public BigDecimal getSalary() {
		return Salary;
	}
	public void setSalary(BigDecimal salary) {
		Salary = salary;
	}
	public int getNo_of_Openings() {
		return No_of_Openings;
	}
	public void setNo_of_Openings(int no_of_Openings) {
		No_of_Openings = no_of_Openings;
	}
	public int getExperience() {
		return Experience;
	}
	public void setExperience(int experience) {
		Experience = experience;
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
	public String getVenue() {
		return Venue;
	}
	public void setVenue(String venue) {
		Venue = venue;
	}
	
	public Time getI_Time() {
		return I_Time;
	}
	public void setI_Time(Time i_Time) {
		I_Time = i_Time;
	}
	public String getRounds() {
		return Rounds;
	}
	public void setRounds(String rounds) {
		Rounds = rounds;
	}
	
	public String getI_Date() {
		return I_Date;
	}
	public void setI_Date(String i_Date) {
		I_Date = i_Date;
	}
	
		
		
	}
