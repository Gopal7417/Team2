package com.pennanttech.Team2.Login;

import java.util.List;

public class UserDetailsModel {
 
  private String Email_Id;
  private String Password;
  private  int id;
  private List Ls;
  private List appiled;


public List getAppiled() {
	return appiled;
}
public void setAppiled(List appiled) {
	this.appiled = appiled;
}
public List getLs() {
	return Ls;
}
public void setLs(List ls) {
	Ls = ls;
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
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
