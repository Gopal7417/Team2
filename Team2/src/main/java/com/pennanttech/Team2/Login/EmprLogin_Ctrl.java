package com.pennanttech.Team2.Login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.pennanttech.Team2.Empr.EmprHome_Ctrl;
import com.pennanttech.Team2.Session.AuthenticationService;
import com.pennanttech.Team2.Session.AuthenticationServiceEmpr;
import com.pennanttech.Team2.Session.AuthenticationServiceImpl;
import com.pennanttech.Team2.Session.AuthenticationServiceImplEmpr;

public class EmprLogin_Ctrl extends Window {
	private static Logger logger = Logger.getLogger(EmprLogin_Ctrl.class);
	public void popup() 
		{
			Window window = (Window)Executions.createComponents("popup.zul", null, null);
			window.doModal();
 		}
	LoginDAO db1;
	private Component login;
 	Component click;
 	EmprDetailsModel l=new EmprDetailsModel();
	AuthenticationServiceImplEmpr As=new AuthenticationServiceImplEmpr();
 	public void verifylogo() 
	 	{
	 		logger.info("enter");
			ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
			db1=(LoginDAO)ctx.getBean("Login");			
			System.out.println("enter");
			Textbox b=(Textbox)this.getFellow("Email_Id");
			String b1=b.getValue();
			Textbox c=(Textbox)this.getFellow("Password");
			String c1=c.getValue();
			EmprDetailsModel e1=new EmprDetailsModel();
			db1.login2(e1);	
			int val=db1.validempr(b1, c1);
			
			if(val==1) 
			{
				l.setEmail_Id(b1);
				l.setPassword(c1);
				int x=db1.cmpnyid(b1);
				l.setCompany_Id(x);
				As.setLoginCredential(l);
				showNotify("Login Sucessfull","info",login);
				Executions.sendRedirect("EmprHome.zul");
			}
		else if(val==2) 
			{
				showNotify("Username Or Password Wrong","error",login); } else if(val==3) {
				showNotify("Username Or Password Wrong","error",login); } else {
				showNotify("Please Try Agian","error",login); }
			}
	 	
		private void showNotify(String msg,String type, Component ref)
			{
			    Clients.showNotification(msg, type, ref, "middle_center", 2000);
			}
}
