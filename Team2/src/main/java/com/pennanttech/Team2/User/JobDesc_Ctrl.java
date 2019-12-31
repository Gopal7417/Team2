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

import com.pennanttech.Team2.Login.UserDetailsModel;
import com.pennanttech.Team2.Session.AuthenticationService;
import com.pennanttech.Team2.Session.AuthenticationServiceImpl;
public class JobDesc_Ctrl extends Div {
	private static Logger logger = Logger.getLogger(JobDesc_Ctrl.class);
	
	protected UserPagesDAO UDAO;
	protected List JobData;
	private static int id =0;
	public int ApplyCheck;
	AuthenticationService as= new AuthenticationServiceImpl();
	UserDetailsModel e= new UserDetailsModel();
	
	public void onCreate() throws Exception {
		e=as.getLoginCredential();
		System.out.println("enter into desc");	
		ApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(
					(ServletContext)getDesktop().getWebApp().getNativeContext());	
		//	System.out.println(id.getIndex());
			UDAO = (UserPagesDAO)ctx.getBean("UserDAO");				
			//String job_id =Executions.getCurrent().getParameter("job_id");			
		//	id = Integer.parseInt(job_id);
			logger.info(id);
			ApplyCheck = UDAO.applyCheck(id,e.getId());
			System.out.println(ApplyCheck+"CHECK");
			Vbox vb = (Vbox) this .getFellow("vbox");
			JobData =UDAO.Job_Data(id);
			System.out.println("enter into desc");						
			for (Iterator it = JobData.iterator(); it.hasNext();) {
				Job_Details m = (Job_Details) it.next();	
				Label lb1 = (Label)this.getFellow("desc");
                Label lb2 = (Label)this.getFellow("Exp");
                Label lb3 = (Label)this.getFellow("Cmpy");
                Label lb4 = (Label)this.getFellow("loc");
                Label lb5 = (Label)this.getFellow("Nmae");
                lb1.setValue(m.getJob_Description());
                Integer sn = m.getExperince();
				lb2.setValue(sn.toString());
				lb3.setValue(m.getCompany_Name());
				lb4.setValue(m.getJob_Location());
}

			if (ApplyCheck == 3) {
				
				Button b = new Button("Apply");
				b.setId("apply");
				vb.appendChild(b);
				b.addEventListener("onClick", new EventListener() 
				{
					public void onEvent(Event e) throws Exception 
						{
							ApplyJob();  
						}
				});	
				
			}
				else 
				vb.appendChild(new Label("Applied"));
				
		
		}
	
	
	public void ApplyJob()
	{
		logger.info("enter");	
		e=as.getLoginCredential();
		
		UDAO.apply(id, e.getId());
		 Button b = (Button) this.getFellow("apply");		 
		 b.setVisible(false);
			Vbox vb = (Vbox) this .getFellow("vbox");
		 vb.appendChild(new Label("Applied"));		
	}
	
	
	

}
