package com.pennanttech.Team2.Empr;

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
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.*;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

import com.pennanttech.Team2.HomeCtrl;
import com.pennanttech.Team2.TaskDAO;
import com.pennanttech.Team2.model;
import com.pennanttech.Team2.Login.EmprDetailsModel;
import com.pennanttech.Team2.Session.AuthenticationServiceEmpr;
import com.pennanttech.Team2.Session.AuthenticationServiceImplEmpr;
import com.pennanttech.Team2.User.User_Details_DAO;

public class EmprHome_Ctrl extends Window{
	protected EmprDAO EDAO;
	protected List JobsList;
	AuthenticationServiceEmpr as= new AuthenticationServiceImplEmpr();
	EmprDetailsModel e=new EmprDetailsModel();
	
	
	private static Logger logger = Logger.getLogger(EmprHome_Ctrl.class);
	
public void onCreate() {	
	 e=as.getLoginCredential();
	logger.info("enter");	
	ApplicationContext ctx = 
			WebApplicationContextUtils.getRequiredWebApplicationContext(
				(ServletContext)getDesktop().getWebApp().getNativeContext());
	EDAO = (EmprDAO)ctx.getBean("Empr");
	logger.info("end1");
	JobsList = EDAO.EmprJob_Data(e.getCompany_Id());
	Vbox vb = (Vbox)this.getFellow("vb");	
	for (Iterator it = JobsList.iterator(); it.hasNext();)
	{
	Job_Tbl jb = (Job_Tbl) it.next();
	final Groupbox gb = new Groupbox();
	gb.setTabindex(jb.getJob_Id());
	 gb.addEventListener("onClick", new EventListener() {
		public void onEvent(Event e) throws Exception {			
			ApplicantList(gb.getTabindex());  		
		}
	});		
	Vbox vb1 = new Vbox();
	gb.setContentStyle("width: 666px;height:150px; margin-top:30px; margin-left: 30%; margin-right: 102%;");
	Label lb1 = new Label(jb.getJob_Role());
	lb1.setStyle("font-size: 22px; font-weight:bold;line-height:23px;");
	Hbox hb1 = new Hbox();
	Span sp = new Span();
	sp.setClass("z-icon-map-marker");	
	Label lb2 = new Label(jb.getJob_Location());
	Label lb2i = new Label("|");
	lb2.setStyle("font-size: 20px; line-height: 50px; margin-left: 10px; color: #5d5d5d;");
	lb2i.setStyle("font-size: 20px; margin-left: 80px; line-height:50px; ");
	hb1.appendChild(sp);
	hb1.appendChild(lb2);
	hb1.appendChild(lb2i);
	Label lb3 = new Label("No. of Applicants :");
    Label lb3i = new Label("4");
    lb3i.setStyle("font-size: 20px; line-height: 50px; color: #5d5d5d");
	lb3.setStyle("margin-left: 50px; font-size: 20px; line-height:50px; color: #34445a;");
	hb1.appendChild(lb3);
	hb1.appendChild(lb3i);
	Hbox hb2 = new Hbox();
	Span sp2 = new Span();
	sp2.setClass("z-icon-calendar");
	Label lb4 = new Label("Posted on:");
	Label lb5 = new Label(jb.getRegister_Date().toString());
	lb4.setStyle("font-size: 20px; line-height:50px; margin-left: 16px; color: #34445a;");
	lb5.setStyle("font-size: 16px; line-height:50px; margin-left: 2px; color: #5d5d5d");
	hb2.appendChild(sp2);
	hb2.appendChild(lb4);
	hb2.appendChild(lb5);
	gb.appendChild(lb1);
	gb.appendChild(hb1);
	gb.appendChild(hb2);
	vb.appendChild(gb);
	}			
}

public void ApplicantList(int job_id) {
	
System.out.println(job_id);

String URL = "ApplicantList.zul?test="+job_id;
	Executions.sendRedirect(URL);
	 
	

	
	  
	
	
}
}
