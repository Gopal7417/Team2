package com.pennanttech.Team2.Empr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.pennanttech.Team2.Login.EmprDetailsModel;
import com.pennanttech.Team2.Session.AuthenticationServiceEmpr;
import com.pennanttech.Team2.Session.AuthenticationServiceImplEmpr;
import com.pennanttech.Team2.User.LocationModel;
import com.pennanttech.Team2.User.UserPagesDAO;
import com.pennanttech.Team2.User.User_Details_DAO;


public class Job_TblCtrl extends Div{

private static Logger logger = Logger.getLogger(Job_TblCtrl.class);
	
	EmprDAO db1;
	private Component click;
	protected List LocList;
	protected UserPagesDAO UDAO;
	AuthenticationServiceEmpr as= new AuthenticationServiceImplEmpr();
	EmprDetailsModel e=new EmprDetailsModel();
	 public void onCreate() throws Exception {
		 ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
			UDAO = (UserPagesDAO)ctx.getBean("UserDAO");
				//fDAO =(FormDAO)ctx.getBean("fDAO");;
		
			LocList = UDAO.Locations();
		 
		 Combobox com2 = (Combobox)this.getFellow("Job_Location");
		 
		  for (Iterator it = LocList.iterator(); it.hasNext();) 
        	{
        		LocationModel lm = (LocationModel) it.next();
        		com2.appendItem(lm.getLocation());	
        			//System.out.print(lm.getLocation());
        	}
		 
	 }
	
	public void verifyJob() {
		
		 e=as.getLoginCredential();
		logger.info("enter");
		ApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(
					(ServletContext)getDesktop().getWebApp().getNativeContext());
		db1=(EmprDAO)ctx.getBean("Empr");	
		System.out.println("enter");	   
		Textbox j=(Textbox)this.getFellow("Job_Role");
		String j1=j.getValue();
		Textbox j2=(Textbox)this.getFellow("Job_Description");
		String j3=j.getValue();
		Intbox j4=(Intbox)this.getFellow("Salary");
		int j5=j4.getValue();
		Intbox j6=(Intbox)this.getFellow("Experience");
		int j7=j6.getValue();
		Intbox j8=(Intbox)this.getFellow("No_of_Openings");
		int j9=j8.getValue();
		Textbox j10=(Textbox)this.getFellow("Minimum_Qualification");
		String j11=j10.getValue();
		Datebox j12=(Datebox)this.getFellow("last_Date");
		
	
		  Date j13=j12.getValue(); 
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String strDate= formatter.format(j13);
		 System.out.println(strDate);
		 java.sql.Date jdate=java.sql.Date.valueOf(strDate); 
		 System.out.println(jdate);
		 
		Textbox j14=(Textbox)this.getFellow("Job_Location");
		String j15=j14.getValue();

		Textbox j18=(Textbox)this.getFellow("Skills");
		String j19=j18.getValue();
		Job_Tbl jt=new Job_Tbl();
		 jt.setCompany_Id(e.getCompany_Id());
		 jt.setJob_Role(j1); 
		 jt.setJob_Description(j3); 
		 jt.setSalary(j5);
		 logger.info(j5);
		 jt.setExperience(j7);
		 jt.setNo_of_Openings(j9);
		 jt.setMinimum_Qualification(j11);
		 jt.setLast_Date(jdate);
		 jt.setJob_Location(j15); 
		
		 logger.info(j7);
		 jt.setSkills(j19); 
		 db1.valid(jt);
		 Messagebox.show("You have Successfully Posted New Job");
		 Executions.sendRedirect("EmprHome.zul");
		 logger.info("end");
		 
		 

}
}
	