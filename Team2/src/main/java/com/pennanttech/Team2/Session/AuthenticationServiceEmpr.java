package com.pennanttech.Team2.Session;

import com.pennanttech.Team2.Login.EmprDetailsModel;


public interface AuthenticationServiceEmpr {
	
	public EmprDetailsModel getLoginCredential();
	public void setLoginCredential(EmprDetailsModel l);

}
