package com.pennanttech.Team2.Session;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import com.pennanttech.Team2.Login.EmprDetailsModel;


public class Verify_loginCredentials_Empr implements Initiator {

	
	
	AuthenticationServiceImplEmpr as=new AuthenticationServiceImplEmpr();
	
	 public void doInit(Page page, Map<String, Object> args) throws Exception {

		 EmprDetailsModel l = as.getLoginCredential();
	        if(l==null){
	            Executions.sendRedirect("EmprLogin.zul");
	            return;
	        }
	    }
}
