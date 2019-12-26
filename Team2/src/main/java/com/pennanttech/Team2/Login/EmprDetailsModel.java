package com.pennanttech.Team2.Login;

public class EmprDetailsModel {
private String Email_Id;
private String Password;
private int Company_Id;

public int getCompany_Id() {
	return Company_Id;
}
public void setCompany_Id(int x) {
	Company_Id = x;
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
}
