package com.pennanttech.Team2.User;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.pennanttech.Team2.Login.UserDetailsModel;
import com.pennanttech.Team2.Session.AuthenticationService;
import com.pennanttech.Team2.Session.AuthenticationServiceImpl;
public class ProfilePopupCtrl extends Window{
		
	    UserPagesDAO db1;
		List popup;
		List popup2;
		public Component click;
		AuthenticationService as= new AuthenticationServiceImpl();
		UserDetailsModel e= new UserDetailsModel();
		public void onCreate() {
			e=as.getLoginCredential();
		  	
			ApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(
					(ServletContext)getDesktop().getWebApp().getNativeContext());
			db1=(UserPagesDAO)ctx.getBean("UserDAO");
			int x= e.getEmp_Id();
			popup=  db1.Profile(x);
		for (Iterator it = popup.iterator(); it.hasNext();) {
			UserdetailsModel m = (UserdetailsModel) it.next();	
             
			Textbox b=(Textbox)this.getFellow("Name");
			b.setValue(m.getName());
			Datebox j12=(Datebox)this.getFellow("Date_Of_Birth");
			
			 Date dt=(Date) m.getDate_Of_Birth();
			/* j12.setValue(dt.toString()); */
			 j12.setValue(m.getDate_Of_Birth());
			 System.out.println(j12);
			/*
			 * Intbox p1=(Intbox)this.getFellow("No_of_Years");
			 * p1.setValue(m.getNo_of_Years());
			 */
				
			 Textbox g=(Textbox)this.getFellow("Highest_Qualification");
			 
                g.setValue(m.getHighest_Qualification());
				Textbox l=(Textbox)this.getFellow("Skills");
				l.setValue(m.getSkills());
				Longbox e=(Longbox)this.getFellow("Mobile_Number");
			/*
			 * Integer in = (int) m.getMobile_Number();
			 * 
			 * e.setValue(in.toString());
			 */
			 e.setValue(m.getMobile_Number()); 
				Textbox c=(Textbox)this.getFellow("Email_Id");
				c.setValue(m.getEmail_Id());
			
		}
		
}		//// for Insertion
		public void update() {
			System.out.print("update---");
			e=as.getLoginCredential();
			int x= e.getEmp_Id();
		
			
			
			UserdetailsModel m1=new UserdetailsModel();
			
			Textbox b=(Textbox)this.getFellow("Name");
			String b1=b.getValue();
			
			Textbox g=(Textbox)this.getFellow("Highest_Qualification");
				String g1=g.getValue();
				
			Textbox l=(Textbox)this.getFellow("Skills");
				String l1=l.getValue();
				
			Longbox e=(Longbox)this.getFellow("Mobile_Number");
				long e1=e.getValue();
				
			Textbox c=(Textbox)this.getFellow("Email_Id");
			
			Datebox j12=(Datebox)this.getFellow("Date_Of_Birth");
				
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String strDate= formatter.format(j12.getValue());
				System.out.println(strDate);
				m1.setDate_Of_Birth(Date.valueOf(strDate));
				
				
			
				m1.setEmail_Id(c.getValue());/* c.getValue(); */
				System.out.println(m1.getEmail_Id());
				
				m1.setName(b1);
				System.out.println(m1.getName());
				m1.setHighest_Qualification(g1);
				System.out.println(m1.getEmp_id());
				m1.setSkills(l1);
				System.out.println(strDate);
				m1.setMobile_Number(e1);
				System.out.println(strDate);
				 m1.setEmp_id(x);
				 db1.Profileupdate(m1); 
				 System.out.println(strDate);
				
				this.setAttribute("OK",Boolean.TRUE);
				this.detach();
				}
	 
		}
		
		
