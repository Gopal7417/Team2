package com.pennanttech.Team2.Empr;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.*;

import com.pennanttech.Team2.User.UserdetailsModel;

public class ApplicantList_Ctrl extends Window {
	EmprDAO EDAO;
	public List Applist;
	public List Profile;
	public static int j;
	private static Logger logger = Logger.getLogger(ApplicantList_Ctrl.class);

	public void onCreate() {
	String par = Executions.getCurrent().getParameter("test");
	            System.out.println(par);
	            j = Integer.parseInt(par);      
ApplicationContext ctx =
					  WebApplicationContextUtils.getRequiredWebApplicationContext(
							  (ServletContext)getDesktop().getWebApp().getNativeContext());
		  EDAO = (EmprDAO)ctx.getBean("Empr"); 			
		render();
	}
public void render() {
	ApplicationContext ctx = WebApplicationContextUtils
			.getRequiredWebApplicationContext((ServletContext) getDesktop().getWebApp().getNativeContext());
	EDAO = (EmprDAO) ctx.getBean("Empr");

	
	
	Applist = EDAO.ApplicantsList(j);
	
	final Div win2 = (Div) (this).getFellow("win2");
	Listbox lb = (Listbox) this.getFellow("AppList");
	lb.getItems().clear();
	for (Iterator it = Applist.iterator(); it.hasNext();) {
		AppListModel ap = (AppListModel) it.next();
		Listitem lt = new Listitem();
		
	if(!(ap.getStatus().equals("Rejected"))) {
		lt.setTabindex(ap.getEmpid());
		
		lb.addEventListener("onClick", new EventListener() {
			public void onEvent(Event e) throws Exception {
				win2.setVisible(true);
				call();
			}
		});
		
		lt.setValue(ap);
		lt.appendChild(new Listcell(ap.getJob_Title()));
		lt.appendChild(new Listcell(ap.getApplicantName()));
		Date Applied_On = ap.getApplied_On();
		lt.appendChild(new Listcell(Applied_On.toLocaleString()));
		Integer exp = ap.getWorkExperience();
		lt.appendChild(new Listcell(exp.toString()));
		lt.appendChild(new Listcell(ap.getStatus()));
		lb.appendChild(lt);				
}
}	
}
	
	public void call() {		
	
		Listbox lb = (Listbox) this.getFellow("AppList");
	ApplicationContext ctx =
				  WebApplicationContextUtils.getRequiredWebApplicationContext(
						  (ServletContext)getDesktop().getWebApp().getNativeContext());
	  EDAO = (EmprDAO)ctx.getBean("Empr"); 	
	  
	   
	  Profile = EDAO.Profile(lb.getSelectedItem().getTabindex()); 
	  
	  Listcell lc1 = (Listcell) lb.getSelectedItem().getChildren().get(4);
	  Button b1 = (Button) this.getFellow("approve");
	  Button b2 = (Button) this.getFellow("reject");
	 
	  if(lc1.getLabel().equals("Approved")) {
		  		b1.setVisible(false);
			  b2.setVisible(false);
 }
	  else {
		  b1.setVisible(true);
		  b2.setVisible(true);
	  	}
	
	  
	  for (Iterator it =  Profile.iterator(); it.hasNext();) 
	   { 
	 UserdetailsModel m = (UserdetailsModel) it.next(); 	   
	  Label lb1 =(Label) this.getFellow("lb1");
	  Label lb2 =(Label) this.getFellow("lb2");
	  Label lb3 =(Label) this.getFellow("lb3");
	  Label lb4 =(Label) this.getFellow("lb4");
	  Label lb5 =(Label) this.getFellow("lb5");
	  Label lb6 =(Label) this.getFellow("lb6");
	  Label lb7 =(Label) this.getFellow("lb7");
	  Label lb8 =(Label) this.getFellow("lb8");
	  lb1.setValue(m.getName());
	  Date DOB = m.getDate_Of_Birth();
	  lb2.setValue(DOB.toLocaleString());
	  lb3.setValue(m.getHighest_Qualification());
	  lb4.setValue(m.getSkills());
	  if(m.getNo_of_Years() == 0 ) {
	  Integer noY = m.getNo_of_Years();
	  lb5.setValue("F");
	  
	  } else lb5.setValue("Experienced");
		  
	  lb6.setValue(m.getGender());
	  Long number = m.getMobile_Number();
	  lb7.setValue(number.toString());
	  lb8.setValue(m.getEmail_Id());	  
	   }
	}
	  
	  public void showResume() throws Exception {
		  Listbox lb = (Listbox) this.getFellow("AppList"); 			   
			  Profile = EDAO.Profile(lb.getSelectedItem().getTabindex()); 
			  for (Iterator it =  Profile.iterator(); it.hasNext();) 
			   { 
				  UserdetailsModel m = (UserdetailsModel) it.next(); 		  	
			  Filedownload.save(m.getResume(), m.getResume().toString(), m.getName()+"'s Resume.pdf");
			   }
			  
		  
		  
		  /*ApplicationContext ctx = WebApplicationContextUtils
	    			.getRequiredWebApplicationContext((ServletContext) getDesktop().getWebApp().getNativeContext());
	    	EDAO = (EmprDAO) ctx.getBean("Empr");
	    	EDAO.retrieve();
	        Filedownload.save(EDAO.retrieve(), EDAO.retrieve().toString(), "Resume.pdf");*/
			
			
			
		}  
/*	  
	  
	  Hbox hb = (Hbox)this.getFellow("del");	
		Button b1 = new Button();
		b1.setLabel("Approve");
		b1.setId("App");
		Button b2 = new Button();
		b2.setLabel("Reject");
		b2.setId("Reject");
		b1 .addEventListener("onClick", new EventListener() {
			public void onEvent(Event e) throws Exception {
				StatusApprove();
				
			}
		});
		b2 .addEventListener("onClick", new EventListener() {
			public void onEvent(Event e) throws Exception {
				StatusReject();
				
			}
		});
		
		
		hb.appendChild(b1);
		hb.appendChild(b2);*/
			
public void StatusApprove() {
	logger.info("enter1");

		Listbox lb = (Listbox) this.getFellow("AppList");
		 String mail =EDAO.Approve(lb.getSelectedItem().getTabindex());
		 System.out.println(mail);
		 Button b1 = (Button) this.getFellow("approve");
		 b1.setVisible(false);
		 System.out.println(mail);
		 Button b2 = (Button) this.getFellow("reject");
		 b2.setVisible(false);
		 render();
	 /*Div win = (Div) (this).getFellow("win2");
			win.setVisible(false);*/
		Mail m = new Mail();			
		m.main(mail);
}
	  
public void StatusReject() {

	Div win2 = (Div) (this).getFellow("win2");
	win2.setVisible(false);
	
	Listbox lb = (Listbox) this.getFellow("AppList");
	lb.getSelectedItem().getTabindex();
	System.out.println("in");
	 
	  EDAO.Reject(lb.getSelectedItem().getTabindex());
	  
	  render();
	  
}
	
	
	
	
	
	
	
	/*  public void render() {
	  
	  Listbox lb = (Listbox)this.getFellow("AppList"); j =
	  lb.getSelectedItem().getTabindex(); Window win =
	  (Window)(this).getFellow("win"); Hbox hb = (Hbox)this.getFellow("hb");
	  Hlayout hl = (Hlayout)this.getFellow("hl"); hb.removeChild(hl); Hlayout hu =
	  new Hlayout(); hu.setId("hl"); Map<String, Integer> params = new
	  HashMap<String, Integer>(); params.put("task", j); Window window =
	  (Window)Executions.createComponents("ApplicantProfile.zul", null, params);
	  window.doEmbedded(); hu.appendChild(window); hb.appendChild(hu);
	  ApplicationContext ctx =
	  WebApplicationContextUtils.getRequiredWebApplicationContext(
	  (ServletContext)getDesktop().getWebApp().getNativeContext()); EDAO =
	  (EmprDAO)ctx.getBean("Empr"); Profile = EDAO.Profile(5);
	  
	  for (Iterator it = Profile.iterator(); it.hasNext();) { Experiencemodel m =
	  (Experiencemodel) it.next(); System.out.println(m.getName());
	  System.out.println(m.getDate_Of_Birth());
	  System.out.println(m.getHighest_Qualification());
	  System.out.println(m.getSkills()); System.out.println(m.getNo_of_Years());
	  System.out.println(m.getResume()); System.out.println(m.getMobile_Number());
	  System.out.println(m.getEmail_Id());
	  
	  } }
	  
	 */
	
	
	
	

}
