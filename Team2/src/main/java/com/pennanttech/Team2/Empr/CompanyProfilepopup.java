package com.pennanttech.Team2.Empr;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.pennanttech.Team2.Login.EmprDetailsModel;
import com.pennanttech.Team2.Session.AuthenticationServiceEmpr;
import com.pennanttech.Team2.Session.AuthenticationServiceImplEmpr;

public class CompanyProfilepopup extends Window{
	  
	EmprDAO db1;
	List popup1;
	private Component click;
	AuthenticationServiceEmpr  as= new AuthenticationServiceImplEmpr();
	EmprDetailsModel e= new EmprDetailsModel();
	public void onCreate() {
		e=as.getLoginCredential();
	  	
		ApplicationContext ctx = 
			WebApplicationContextUtils.getRequiredWebApplicationContext(
				(ServletContext)getDesktop().getWebApp().getNativeContext());
		db1=(EmprDAO)ctx.getBean("Empr");
		int x=e.getCompany_Id();
		popup1=db1.companyProfile(x);
		for (Iterator it = popup1.iterator(); it.hasNext();) {
			Empr_Model em=(Empr_Model) it.next();
			Textbox a=(Textbox)this.getFellow("Company_Name");
			a.setValue(em.getCompany_Name());
			Longbox b=(Longbox)this.getFellow("Phone_number");
			b.setValue(em.getPhone_number()); 
			Textbox c=(Textbox)this.getFellow("Email_Id");
			c.setValue(em.getEmail_Id());
			Textbox d=(Textbox)this.getFellow("Recruiter_Name");
			d.setValue(em.getRecruiter_Name());
			Textbox e=(Textbox)this.getFellow("Desg");
			e.setValue(em.getDesg());
			
		}
	}
		 
		 public void update() {
		 
			 e=as.getLoginCredential();
			 int x=e.getCompany_Id();
		 Empr_Model em=new Empr_Model();
		 
		 Textbox a=(Textbox)this.getFellow("Company_Name");
		 Longbox b=(Longbox)this.getFellow("Phone_number");
		 Textbox c=(Textbox)this.getFellow("Email_Id");
		 Textbox d=(Textbox)this.getFellow("Recruiter_Name");
		 Textbox e=(Textbox)this.getFellow("Desg");
		 
		 
		 em.setCompany_Name(a.getValue());
		 em.setPhone_number(b.getValue());
		 em.setEmail_Id(c.getValue());
		 em.setRecruiter_Name(d.getValue());
		 em.setDesg(e.getValue());
		 em.setCompany_Id(x);
		 db1.companyupdate(em);
		 this.setAttribute("OK",Boolean.TRUE);
			this.detach();
		 
	}
}
