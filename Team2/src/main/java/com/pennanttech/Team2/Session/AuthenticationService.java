package com.pennanttech.Team2.Session;


import com.pennanttech.Team2.Login.UserDetailsModel;

public interface AuthenticationService 
{
public UserDetailsModel getLoginCredential();
public void setLoginCredential(UserDetailsModel l);
}
