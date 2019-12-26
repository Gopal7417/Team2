package com.pennanttech.Team2.Login;

import com.pennanttech.Team2.Session.*;
import com.pennanttech.Team2.User.UserPagesDAO;

import java.util.HashMap;
import java.util.List;
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
 


public class UserLogin_Ctrl extends Window {
	private static Logger logger = Logger.getLogger(UserLogin_Ctrl.class);
	ApplicationContext ctx ;
	public void popup() 
		{
			Window window = (Window)Executions.createComponents("popup.zul", null, null);
			window.doModal();      
		}
	LoginDAO db1;
	UserPagesDAO db2;
	private Component login;
	UserDetailsModel l=new UserDetailsModel();
	AuthenticationService As=new AuthenticationServiceImpl();
	Component click;
	public void verifyLogin() 
		{
			logger.info("entered into cntrl");
			ctx = WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
			db1=(LoginDAO)ctx.getBean("Login");	
		
			Textbox b=(Textbox)this.getFellow("Email_Id");
			String b1=b.getValue();
			Textbox c=(Textbox)this.getFellow("Password");
			String c1=c.getValue();
			logger.info(c1);
			UserDetailsModel e=new UserDetailsModel();
			e.setEmail_Id(b1);
			int val=db1.validuser(b1, c1);
			db2=(UserPagesDAO)ctx.getBean("UserDAO");
			if(val==1) 
				{
					logger.info("if");
					l.setEmail_Id(b1);
					l.setPassword(c1);
					l.setId(db1.empid(b1));
					logger.info(b1);
					List ls= db2.Profile(b1);
					l.setLs(ls);
					logger.info("5");
					/*List al = db2.Applied(empid);
					l.setAppiled(al);*/
					As.setLoginCredential(l);
					showNotify("Login Sucessfull","info",login);
					Executions.sendRedirect("UserHome.zul");
				}
			else if(val==2) 
				{
					showNotify("Username Or Password Wrong","error",login); } else if(val==3) {
					showNotify("Username Or Password Wrong","error",login); } else {
					showNotify("Please Try Agian","error",login); }
				}
			public char[] getEmail_Id() 
				{
					return null;
				}
			
			private void showNotify(String msg,String type, Component ref)
				{
			        Clients.showNotification(msg, type, ref, "middle_center", 2000);
			    }
 }
	
	


