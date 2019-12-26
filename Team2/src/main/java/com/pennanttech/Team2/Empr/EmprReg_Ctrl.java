package com.pennanttech.Team2.Empr;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Textbox;



public class EmprReg_Ctrl extends Div
	{
		
		private static Logger logger = Logger.getLogger(EmprReg_Ctrl.class);
		EmprDAO db1;
		Empr_Model ct=new Empr_Model();
		private Component click;
		public void verifyCompany() 
			{
				logger.info("enter");
				ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
				db1=(EmprDAO)ctx.getBean("Empr");		
				System.out.println("enter");
				Textbox j=(Textbox)this.getFellow("Company_Name");
				String j1=j.getValue();
				Textbox j2=(Textbox)this.getFellow("Recruiter_Name");
				String j3=j.getValue();
				Textbox j4=(Textbox)this.getFellow("Email_Id");
				String j5=j4.getValue();
				Textbox j6=(Textbox)this.getFellow("Password");
				String j7=j6.getValue();
				Longbox j8=(Longbox)this.getFellow("Phone_Number");
				long j9=j8.getValue();
				Textbox j11=(Textbox)this.getFellow("Current_Designation");
				String j12=j11.getValue();
				ct.setCompany_Name(j1);
				ct.setRecruiter_Name(j3);
				ct.setEmail_Id(j5);
				ct.setPassword(j7);
			    ct.setPhone_number(j9);
			    ct.setCurrent_Designation(j12);
			    db1.emprreg(ct);
				logger.info("enter77");
			}
		
	}
