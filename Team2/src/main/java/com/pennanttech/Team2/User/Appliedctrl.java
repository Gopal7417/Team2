package com.pennanttech.Team2.User;

import java.util.List;
import java.sql.Date;
import java.util.Iterator;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zul.*;


import com.pennanttech.Team2.Login.UserDetailsModel;
import com.pennanttech.Team2.Session.AuthenticationService;
import com.pennanttech.Team2.Session.AuthenticationServiceImpl;

public class Appliedctrl extends Window {
	int a;
	AuthenticationService as= new AuthenticationServiceImpl();
	UserDetailsModel e= new UserDetailsModel();
	private static Logger logger = Logger.getLogger(Appliedctrl.class);

	public void onCreate() {
		logger.info("enter");
	 	e=as.getLoginCredential();
		UserPagesDAO db1;
		 List Applied;
		 ApplicationContext ctx = 
					WebApplicationContextUtils.getRequiredWebApplicationContext(
						(ServletContext)getDesktop().getWebApp().getNativeContext());
			db1=(UserPagesDAO)ctx.getBean("UserDAO");			
			Applied=db1.Applied(e.getId());
			
			
			
			for (Iterator it = Applied.iterator(); it.hasNext();) 
			{
				Appliedid_Model ap = (Appliedid_Model) it.next();	
				System.out.println(ap.getCompany_Name());
				System.out.println(ap.getJob_Role());
				System.out.println(ap.getJob_Location());
				System.out.println(ap.getStatus());
				System.out.println(ap.getD());
				System.out.println("end");
						
		  Groupbox gb=new Groupbox();
		  gb.setContentStyle("width:300px; height:140px");	 
		  Vbox v=(Vbox)this.getFellow("v"); 
		  Vbox vb=new Vbox();		  		 
		  Label l=new Label(ap.getCompany_Name());
		  	vb.appendChild(l);	
		  Label l2=new Label(ap.getJob_Role());
		  	vb.appendChild(l2);
		  Label l3=new Label(ap.getJob_Location());
		  	vb.appendChild(l3); 
		  Label l4=new Label(ap.getStatus());
		  	vb.appendChild(l4);		  	
		  	Date dd = ap.getD();		  	
		  Label l5=new Label(dd.toString());
		  	vb.appendChild(l5);
		  	 Progressmeter pm = new Progressmeter();
		  	  pm.setValue(50);
		  	  pm.setWidth("240px");
		  	  pm.setStyle("margin-left:10px");

		  	  vb.appendChild(pm);  
		  	  
		  	  Label l6=new Label("Applied");
		  	  l6.setStyle("font-size: 13px");
		  	  Label l7=new Label("Pending");
		  	  l7.setStyle("font-size: 13px;margin-left:60px");
		  	  Label l8=new Label("Approved");
		  	  l8.setStyle("font-size: 13px;margin-left:60px");
		  	  Hbox hb = new Hbox();
		  	  hb.appendChild(l6);
		  	  hb.appendChild(l7);
		  	  hb.appendChild(l8);
		  	  vb.appendChild(hb);
		  gb.appendChild(vb);		  
		  v.appendChild(gb);
		  }
		 
	}

}
