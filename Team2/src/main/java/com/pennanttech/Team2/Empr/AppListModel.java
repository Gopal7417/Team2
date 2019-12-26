package com.pennanttech.Team2.Empr;

import java.sql.Date;

public class AppListModel {
	
	private int empid;
	private String ApplicantName;
	private String Job_Title;
	private int WorkExperience;
	private String Status;
	private Date Applied_On;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getApplicantName() {
		return ApplicantName;
	}
	public void setApplicantName(String applicantName) {
		ApplicantName = applicantName;
	}
	public int getWorkExperience() {
		return WorkExperience;
	}
	public void setWorkExperience(int workExperience) {
		WorkExperience = workExperience;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getJob_Title() {
		return Job_Title;
	}
	public void setJob_Title(String job_Title) {
		Job_Title = job_Title;
	}
	public Date getApplied_On() {
		return Applied_On;
	}
	public void setApplied_On(Date applied_On) {
		Applied_On = applied_On;
	}
	

}
