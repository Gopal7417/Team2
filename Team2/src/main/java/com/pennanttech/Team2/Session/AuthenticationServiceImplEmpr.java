package com.pennanttech.Team2.Session;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.pennanttech.Team2.Login.EmprDetailsModel;


public class AuthenticationServiceImplEmpr implements AuthenticationServiceEmpr {

	
	public EmprDetailsModel getLoginCredential()
		{
			Session sess = Sessions.getCurrent();
			EmprDetailsModel l=(EmprDetailsModel)sess.getAttribute("login_Credential");
			return l;
		}
	public void setLoginCredential(EmprDetailsModel lm) 
		{
			Session ses=Sessions.getCurrent();
			ses.setAttribute("login_Credential",lm);
		}
	
}
