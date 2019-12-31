package com.pennanttech.Team2.User;

import java.sql.Date;
import java.text.Normalizer.Form;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import com.pennanttech.Team2.Empr.Job_Tbl;
import com.pennanttech.Team2.Login.UserDetailsModel;
import com.pennanttech.Team2.Session.AuthenticationService;
import com.pennanttech.Team2.Session.AuthenticationServiceImpl;


public class UserHome_Ctrl  extends Window
	{
		private static Logger logger = Logger.getLogger(UserHome_Ctrl.class);
		
		protected List TitleList;
		protected List LocList;
		protected List JobList;
		protected List JobData;
		public int ApplyCheck;
		public static  int job_id;
		AuthenticationService as= new AuthenticationServiceImpl();
		UserDetailsModel e= new UserDetailsModel();
		
		protected UserPagesDAO UDAO;
		
		public void render() 
			{
				logger.info("Entering");
				Combobox com1= (Combobox)this.getFellow("combo1");
				Combobox com2 = (Combobox)this.getFellow("combo2");
				for (Iterator it = TitleList.iterator(); it.hasNext();) 
					{
					Job_Tbl m = (Job_Tbl) it.next();
							//	System.out.println(m.getJob_Title());
						com1.appendItem(m.getJob_Role());	
			         }
		        for (Iterator it = LocList.iterator(); it.hasNext();) 
		        	{
		        		LocationModel lm = (LocationModel) it.next();
		        		com2.appendItem(lm.getLocation());	
		        			//System.out.print(lm.getLocation());
		        	}
			}
		public void onCreate() throws Exception 
			{
				logger.info("Entering");
				ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
				UDAO = (UserPagesDAO)ctx.getBean("UserDAO");
					//fDAO =(FormDAO)ctx.getBean("fDAO");;
				TitleList = UDAO.jobsTitle();
				LocList = UDAO.Locations();
				render();
			}			
		public void search() 
			{
				Combobox com1= (Combobox)this.getFellow("combo1");
				Combobox com2 = (Combobox)this.getFellow("combo2");			 
				Vbox VB = (Vbox)this.getFellow("vb");
				ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
				UDAO = (UserPagesDAO)ctx.getBean("UserDAO");
				JobList = UDAO.JobSearch(com1.getValue(),com2.getValue());	
					//Div divtag= (Div)this.getFellow("Home");			
				for (Iterator it = JobList.iterator(); it.hasNext();) 
					{
					Job_Tbl m= (Job_Tbl) it.next();				
						final Groupbox gb = new Groupbox();
						gb.setContentSclass("gb");
						gb.setContentStyle("width: 375px;margin-left: 97px; border-left: 6px solid #34445a; margin-top: 10px;");
						final Button bt = new Button("View More");
						bt.setStyle("background-color:#34445a");
						bt.setTabindex(m.getJob_Id());
						bt.addEventListener("onClick", new EventListener() 
							{
								public void onEvent(Event e) throws Exception 
									{
										seeMore(bt.getTabindex());  
									}
							});	
						
						Vbox vbox = new Vbox();
						Label lb1 = new Label(m.getCompany_Name());
						lb1.setStyle("font-size: 26px;line-height: 20px;");
						Label lb2 = new Label(m.getJob_Role());
						lb2.setStyle("font-weight: bold;line-height: 20px;");
						Span lb3i = new Span();
						lb3i.setSclass("z-icon-map-marker");
						Label lb3 = new Label(m.getJob_Location());
						Span lb4i = new Span();
						lb4i.setSclass("z-icon-money");
						Label lb4 = new Label("Salary:");
						Integer money = m.getSalary();
						Label lb5 = new Label(money.toString());
						vbox.appendChild(lb1);
						vbox.appendChild(lb2);
						Hbox hb2 = new Hbox();
						hb2.appendChild(lb3i);
						hb2.appendChild(lb3);
						hb2.appendChild(lb4i);
						hb2.appendChild(lb4);
						
						hb2.appendChild(lb5);
						vbox.appendChild(hb2);
						vbox.appendChild(bt);
						
						gb.appendChild(vbox);
						VB.appendChild(gb);
					}		
	       }				
		public void seeMore(int id) 
			{	
			job_id=id;
			Div d = (Div)this.getFellow("div");
			d.setTabindex(id);
			d.setVisible(true);
			e=as.getLoginCredential();			
			ApplyCheck = UDAO.applyCheck(id,e.getId());
			System.out.println(ApplyCheck+"CHECK");
			Vbox vb = (Vbox) this .getFellow("vbox");
			JobData =UDAO.Job_Data(id);
			System.out.println("enter into desc");						
			for (Iterator it = JobData.iterator(); it.hasNext();) {
				Job_Tbl m = (Job_Tbl) it.next();	
				Label lb1 = (Label)this.getFellow("desc");
                Label lb2 = (Label)this.getFellow("Exp");
                Label lb3 = (Label)this.getFellow("Cmpy");
                Label lb4 = (Label)this.getFellow("loc");
                Label lb5 = (Label)this.getFellow("role");
                Label lb6 = (Label)this.getFellow("salary");
                Label lb7 = (Label)this.getFellow("qual");
                Label lb8 = (Label)this.getFellow("skills");
                Label lb9 = (Label)this.getFellow("ldate");
                
                lb1.setValue(m.getJob_Description());
                Integer sn = m.getExperience();
				lb2.setValue(sn.toString());
				lb3.setValue(m.getCompany_Name());
				lb4.setValue(m.getJob_Location());
				System.out.println(m.getSalary()+m.getMinimum_Qualification()+m.getCompany_Name()+m.getJob_Role()+m.getExperience());
				lb5.setValue(m.getJob_Role());
				Integer sl = m.getSalary();
				lb6.setValue(sl.toString());
				lb7.setValue(m.getMinimum_Qualification());
				lb8.setValue(m.getSkills());
				Date d1 = m.getLast_Date();
				lb9.setValue(d1.toLocalDate().toString());
				
			}

			if (ApplyCheck == 3) {
				Label lb = (Label)this.getFellow("Applied");
				Button b = (Button)this.getFellow("Apply");
				b.setVisible(true);
				lb.setVisible(false);
				
			}
				else 
				{
					Button b = (Button)this.getFellow("Apply");
					b.setVisible(false);
					Label lb = (Label)this.getFellow("Applied");
					lb.setVisible(true);
				}
				
								 	
			}
		

		public void ApplyJob(int jid)
		{
			
			logger.info("enter");	
			e=as.getLoginCredential();
			
			UDAO.apply(jid, e.getId());
			 Button b = (Button) this.getFellow("Apply");		 
			 b.setVisible(false);
			 Label lb = (Label)this.getFellow("Applied");
				lb.setVisible(true);
		}
		
		
	
		
		
		
	}