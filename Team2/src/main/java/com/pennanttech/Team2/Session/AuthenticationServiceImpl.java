package com.pennanttech.Team2.Session;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;


import com.pennanttech.Team2.Login.UserDetailsModel;


public class AuthenticationServiceImpl implements AuthenticationService{

	
	public UserDetailsModel getLoginCredential(){
		Session sess = Sessions.getCurrent();
		UserDetailsModel l=(UserDetailsModel)sess.getAttribute("login_Credential");
		return l;
	}
	
	public void setLoginCredential(UserDetailsModel lm){
		Session ses=Sessions.getCurrent();
		ses.setAttribute("login_Credential",lm);
		
	}

	
}
