package com.pennanttech.Team2.Empr;

import java.util.List;
import java.util.Iterator;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.pennanttech.Team2.Login.EmprDetailsModel;
import com.pennanttech.Team2.Session.AuthenticationService;
import com.pennanttech.Team2.Session.AuthenticationServiceEmpr;
import com.pennanttech.Team2.Session.AuthenticationServiceImpl;
import com.pennanttech.Team2.Session.AuthenticationServiceImplEmpr;



	public class CompanyProfileCtrl extends Div{
		
		
		AuthenticationServiceEmpr  as= new AuthenticationServiceImplEmpr();
		EmprDetailsModel e= new EmprDetailsModel();
	
			public void onCreate()
			   {
				e=as.getLoginCredential();
				EmprDAO db1;;
				List CompanyProfile;
				ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
				db1=(EmprDAO)ctx.getBean("Empr");
				int x=e.getCompany_Id();
				CompanyProfile=db1.companyProfile(x);
				
				for (Iterator it = CompanyProfile.iterator(); it.hasNext();) {
					Empr_Model em = (Empr_Model) it.next();
					System.out.println(em.getCompany_Name());
					System.out.println(em.getPhone_number());
					System.out.println(em.getEmail_Id());
					System.out.println(em.getRecruiter_Name());
					System.out.println(em.getDesg());
					
					Label lb1 = (Label)this.getFellow("CompanyName");
					lb1.setValue(em.getCompany_Name());
					Label lb2=(Label)this.getFellow("PhoneNumber");
					lb2.setValue((String.valueOf(em.getPhone_number())));
					Label lb3=(Label)this.getFellow("EmailID");
					lb3.setValue(em.getEmail_Id());
					Label lb4=(Label)this.getFellow("Recruiter");
					lb4.setValue(em.getRecruiter_Name());
					Label lb5=(Label)this.getFellow("Desg");
					lb5.setValue(em.getDesg());
				}
			   }
				
				public void popup1() {

						 Window window = (Window)Executions.createComponents("EditCompanyProfilePopup.zul", null, null);
						 window.setClosable(true);
						 window.setTitle("Title");
						 window.setBorder(true);
						 window.doModal();	 

					}
			  
			 
				  

      }

			
	
	
	
	
	
	

