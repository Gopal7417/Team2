package com.pennanttech.Team2.Empr;

public class Empr_Model {

	 private int Company_Id;
	 private String Company_Name;
	 private String Recruiter_Name;
	 private String Email_Id;
	 private String Password;
	 private long   Phone_number;
	 private String Desg;
	 
	 public String getDesg() {
		return Desg;
	}
	public void setDesg(String desg) {
		Desg = desg;
	}
	public String getRecruiter_Name() {
		return Recruiter_Name;
	}
	public void setRecruiter_Name(String recruiter_Name) {
		Recruiter_Name = recruiter_Name;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getCompany_Id() {
		return Company_Id;
	}
	public void setCompany_Id(int company_Id) {
		Company_Id = company_Id;
	}
	public String getCompany_Name() {
		return Company_Name;
	}
	public long getPhone_number() {
		return Phone_number;
	}
	public void setPhone_number(long phone_number) {
		Phone_number = phone_number;
	}
	
	
	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}
}
	