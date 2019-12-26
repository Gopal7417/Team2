package com.pennanttech.Team2;


import java.text.Normalizer.Form;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import com.pennanttech.Team2.User.User_Details_DAO;
public class Job_descCtrl extends Window {
	
	protected TaskDAO taskDAO;
	protected List JobData;
	protected User_Details_DAO fDAO;
	
	public void onCreate() throws Exception {
		ApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(
					(ServletContext)getDesktop().getWebApp().getNativeContext());
			ID_Model id  = new ID_Model();
			
		//	System.out.println(id.getIndex());
			fDAO = (User_Details_DAO)ctx.getBean("task");
			JobData =fDAO.Job_Data(id.getIndex());
			System.out.println("m.getJob_Description()");
			for (Iterator it = JobData.iterator(); it.hasNext();) {
				model m = (model) it.next();	
				Label lb1 = (Label)this.getFellow("desc");
                Label lb2 = (Label)this.getFellow("Exp");
                Label lb3 = (Label)this.getFellow("Cmpy");
                Label lb4 = (Label)this.getFellow("loc");
                lb1.setValue(m.getJob_Description());
                Integer sn = m.getExperince();
				lb2.setValue(sn.toString());
				lb3.setValue(m.getCompany_Name());
				lb4.setValue(m.getJob_Location());
				System.out.println(m.getJob_Description());
				
			
		           }
		
		}			

}
