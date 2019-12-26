package com.pennanttech.Team2.User;

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


public class UserHome_Ctrl  extends Window
	{
		private static Logger logger = Logger.getLogger(UserHome_Ctrl.class);
		
		protected List TitleList;
		protected List LocList;
		protected List JobList;
		
		protected UserPagesDAO UDAO;
		protected Job_Details m2 = null;
		public void render() 
			{
				logger.info("Entering");
				Combobox com1= (Combobox)this.getFellow("combo1");
				Combobox com2 = (Combobox)this.getFellow("combo2");
				for (Iterator it = TitleList.iterator(); it.hasNext();) 
					{
						Job_Details m = (Job_Details) it.next();
							//	System.out.println(m.getJob_Title());
						com1.appendItem(m.getJob_Title());	
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
						Job_Details m = (Job_Details) it.next();				
						final Groupbox gb = new Groupbox();
						
						gb.setContentStyle("width: 375px;margin-left: 97px; border-left: 6px solid #34445a; margin-top: 75px;");
						final Button bt = new Button("View More");
						bt.setTabindex(m.getJob_id());
						bt.addEventListener("onClick", new EventListener() 
							{
								public void onEvent(Event e) throws Exception 
									{
										seeMore(bt.getTabindex());  
									}
							});	
						
						Vbox vbox = new Vbox();
						Hbox hbox1 =new Hbox();
						Hbox hbox2 =new Hbox();
						Hbox hbox3 =new Hbox();						
						bt.setStyle("margin-left: 222px; background-color: #f91c45;");						
						Label c = new Label();
						Label lb1 = new Label();
						Label r = new Label();
						Label lb2 = new Label();
						Label s = new Label();
						Integer i= m.getSalary() ;
						Label lb3 = new Label();
						
						c.setValue("COMPANY");
						lb1.setValue(m.getCompany_Name());
						lb1.setStyle("font-size: 30px;color: #34445a;"); 
						r.setValue("ROLE");
						lb2.setValue(m.getJob_Role());
						lb2.setStyle("font-size: 20px;color: #9a4949;");
						s.setValue("SALARY");
						lb3.setValue(i.toString());
						lb3.setStyle("font-size: 20px;color: #da8080;"); 
						
						
						
						
			/*
			 * vbox.appendChild(lb1); vbox.appendChild(lb2); vbox.appendChild(lb3);
			 */
						hbox1.appendChild(c);
						hbox1.appendChild(lb1);
						vbox.appendChild(hbox1);
						hbox2.appendChild(r);
						hbox2.appendChild(lb2);
						vbox.appendChild(hbox2);
						hbox3.appendChild(s);
						hbox3.appendChild(lb3);
						vbox.appendChild(hbox3);
						vbox.appendChild(bt);
						gb.appendChild(vbox);
						VB.appendChild(gb);
					}		
	       }				
		public void seeMore(int id) 
			{	
				logger.info(id);				
				String URL = "JobDesc.zul?job_id="+id;
				Executions.sendRedirect(URL);						 	
			}
		
		
	
		
		
		
	}