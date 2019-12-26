package com.pennanttech.Team2;

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

import com.pennanttech.Team2.User.User_Details_DAO;


public class HomeCtrl  extends Window{
	private static Logger logger = Logger.getLogger(HomeCtrl.class);
	protected int grp_id;
	protected TaskDAO taskDAO;
	protected List tasks;
	protected List LocList;
	protected List JobList;
	protected User_Details_DAO fDAO;
	protected model m2 = null;
	public void render() {
		logger.info("Entering");
		Combobox com1= (Combobox)this.getFellow("combo1");
		Combobox com2 = (Combobox)this.getFellow("combo2");

		for (Iterator it = tasks.iterator(); it.hasNext();) {
		model m = (model) it.next();
	//	System.out.println(m.getJob_Title());
		
		com1.appendItem(m.getJob_Title());	
           }
        for (Iterator it = LocList.iterator(); it.hasNext();) {
		LocationModel lm = (LocationModel) it.next();
		
		com2.appendItem(lm.getLocation());	
		//System.out.print(lm.getLocation());
		
}
}
	public void onCreate() throws Exception {
		logger.info("Entering");
		ApplicationContext ctx = 
			WebApplicationContextUtils.getRequiredWebApplicationContext(
				(ServletContext)getDesktop().getWebApp().getNativeContext());
		taskDAO = (TaskDAO)ctx.getBean("taskDAO");
		//fDAO =(FormDAO)ctx.getBean("fDAO");
		tasks = taskDAO.findAll();
		LocList = taskDAO.Locations();
		render();
	}			
		public void search() {
		Combobox com1= (Combobox)this.getFellow("combo1");
		Combobox com2 = (Combobox)this.getFellow("combo2");			 
		Vbox VB = (Vbox)this.getFellow("vb");
		ApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(
					(ServletContext)getDesktop().getWebApp().getNativeContext());
		taskDAO = (TaskDAO)ctx.getBean("taskDAO");
		fDAO = (User_Details_DAO)ctx.getBean("task");			
		JobList = fDAO.JobSearch(com1.getValue(),com2.getValue());	
		//Div divtag= (Div)this.getFellow("Home");			
		for (Iterator it = JobList.iterator(); it.hasNext();) {
		model m = (model) it.next();				
		final Groupbox gb = new Groupbox();
		gb.setTabindex(m.getJob_id());
		gb.setContentStyle("width: 369px;margin-left: 97px; border-left: 6px solid #34445a; margin-top: 39px;");
		final Button bt = new Button("Apply");
		gb.addEventListener("onClick", new EventListener() {
			public void onEvent(Event e) throws Exception {
				
                        seeMore(gb.getTabindex());  
				
			}
		});		
		Vbox vbox = new Vbox();
		Label lb1 = new Label();		
		Label lb2 = new Label();
		Intbox IB = new Intbox();
		bt.setStyle("margin-left: 254px; background-color: #f91c45;");
		lb1.setStyle("font-size: 30pxcolor: #34445a;"); 
		lb1.setValue(m.getCompany_Name());
		lb2.setValue(m.getJob_Role());
		IB.setValue(m.getSalary());
		vbox.appendChild(lb1);
		vbox.appendChild(lb2);
		vbox.appendChild(IB);
		vbox.appendChild(bt);
		gb.appendChild(vbox);
		VB.appendChild(gb);
		}		
       }				
		public void seeMore(int More) {	
			logger.info("Entering");			
			Executions.sendRedirect("Job_desc.zul");						 	
		}
	}