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
			Applied=db1.Applied(e.getEmp_Id());
			
			
			
			for (Iterator it = Applied.iterator(); it.hasNext();) 
			{
				Appliedid_Model ap = (Appliedid_Model) it.next();	
			
		  Groupbox gb=new Groupbox();
		  gb.setContentStyle(" height: 173px;margin-top: -5px; width: 413px;margin-left: 80px;");	 
		  Vbox v=(Vbox)this.getFellow("v"); 
		  Vbox vb=new Vbox();		  		 
		  Label l=new Label(ap.getJob_Role());
		  	vb.appendChild(l);	
		  	l.setStyle("    font-size: 23px; color: #34445a;");
		  Label l2=new Label(ap.getCompany_Name());
		  	vb.appendChild(l2);
		  	l2.setStyle("margin-left:1px;margin-top:6px; font-weight:bold;");
		  	Hbox hb1 = new Hbox();
		  Label l3=new Label(ap.getJob_Location());
		 
		  Span sp = new Span();		  
		  sp.setStyle("margin-left:10px");
		  	sp.setSclass("z-icon-map-marker");
		  hb1.appendChild(sp);	
		  hb1.appendChild(l3);
		  	hb1.setStyle("margin-top:6px");
		  /*	.z-icon-calendar-o	
		  	.z-icon-map-marker			
		  	.z-icon-shopping-cart	
		  	<span sclass="z-icon-envelope" Style="color:#009090;"/> 
		  	Label sp1 = new Label();*/
		  	
		  
			Span sp2 = new Span();
			sp2.setSclass("z-icon-calendar-o");
			//sp2.setStyle("margin-left:80px;");
		  	Date dd = ap.getD();	
		  	Label l51=new Label("Applied on:");
		  	
		  	Label l5=new Label(dd.toString());
		  	 hb1.appendChild(sp2);
		  	hb1.appendChild(l51);	
		  hb1.appendChild(l5);
		  
		 
		  	vb.appendChild(hb1);
		  	 
		  	Vbox vb1 = new Vbox();
		  	Progressmeter pm = new Progressmeter();
		  	  
		  	 if(ap.getStatus().equals("pending"))
		  	 pm.setValue(50);
		  	 else if(ap.getStatus().equals("Approved"))
		  		pm.setValue(100);
		  	 
		  	 
		  	 
		  	  pm.setWidth("240px");
		  	  pm.setStyle("margin-left:10px");

		  	  vb1.appendChild(pm);  
		  	  
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
		  	  vb1.setStyle("margin-left:10px ; margin-top:20px");
		  	  vb1.appendChild(hb);
		  	 vb.appendChild(vb1);
		  	  
		  	  
		  gb.appendChild(vb);		  
		  v.appendChild(gb);
		  }
		 
	}

}
