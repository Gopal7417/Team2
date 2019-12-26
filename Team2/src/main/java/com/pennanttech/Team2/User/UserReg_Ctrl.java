package com.pennanttech.Team2.User;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.*;


public class UserReg_Ctrl extends Div
	{
		
		UserPagesDAO db1;
		public static byte[] Resume;
		private Component click;
		public void verifyExperience() 
			{
				ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
				db1=(UserPagesDAO)ctx.getBean("UserDAO");
				System.out.println("enter");
				Textbox b=(Textbox)this.getFellow("Name");
				String b1=b.getValue();
				Textbox c=(Textbox)this.getFellow("Email_Id");
				String c1=c.getValue();
				Textbox d=(Textbox)this.getFellow("Create_Password");
				String d1=d.getValue();
				Longbox e=(Longbox)this.getFellow("Mobile_Number");
				long e1=e.getValue();
				Datebox j12=(Datebox)this.getFellow("Date_Of_Birth");
				Date j13=(Date) j12.getValue(); 
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String strDate= formatter.format(j13);
				java.sql.Date jdate=java.sql.Date.valueOf(strDate); 
				Radiogroup f=(Radiogroup)this.getFellow("Gender");
				String f1=f.getSelectedItem().getValue();
				Textbox g=(Textbox)this.getFellow("Highest_Qualification");
				String g1=g.getValue();
					/* Textbox h=(Textbox)this.getFellow("Course"); String h1=h.getValue();*/
				Textbox i=(Textbox)this.getFellow("Specialization");
				String i1=i.getValue();
				Textbox j=(Textbox)this.getFellow("University");
				String j1=j.getValue();
				Intbox k=(Intbox)this.getFellow("Passing_Year");
				int k1=k.getValue();
				Textbox l=(Textbox)this.getFellow("Skills");
				String l1=l.getValue();
				Textbox n=(Textbox)this.getFellow("Company_Name");
				String n1=n.getValue();
				Intbox p1=(Intbox)this.getFellow("No_of_Years");
				int n4=p1.getValue();
				Textbox p2=(Textbox)this.getFellow("Job_Role");
				String n5=p2.getValue();
					/* Textbox p3=(Textbox)this.getFellow("Resume"); String n6=p3.getValue();*/
				try
					{
						UserdetailsModel m1=new UserdetailsModel();
						m1.setName(b1);
						m1.setEmail_Id(c1);
						m1.setCreate_Password(d1);
						m1.setMobile_Number(e1);
						m1.setDate_Of_Birth(jdate);
						m1.setGender(f1);
						m1.setHighest_Qualification(g1);
							/* m1.setCourse(h1); */
						m1.setSpecialization(i1);
						m1.setUniversity(j1);
						m1.setPassing_Year(k1);
						m1.setSkills(l1);
						m1.setCompany_Name(n1);
						m1.setNo_of_Years(n4);
						m1.setJob_Role(n5);
						m1.setResume(Resume);
						int val=db1.users(m1);
					}
				catch(Exception et)
					{
						System.out.println(et);
					}}
				
				
				  public void UploadPDF() {
					  final Label lb  =(Label)this.getFellow("RName");
				        EventListener<UploadEvent> el = new EventListener<UploadEvent>() {
				            public void onEvent(UploadEvent event) throws Exception {
				         
				            	Media m = event.getMedia();
				            	Resume = m.getByteData();
				            	lb.setValue(m.getName());
				            	
				            }
				        };
				      
				        Fileupload.get(el);
				    
				    }
			
				
				
			
		public void verifyFresher() 
			{
				System.out.println("enter");
				ApplicationContext ctx = 
						WebApplicationContextUtils.getRequiredWebApplicationContext(
							(ServletContext)getDesktop().getWebApp().getNativeContext());
				db1=(UserPagesDAO)ctx.getBean("UserDAO");
				Textbox b=(Textbox)this.getFellow("Name");
				String b1=b.getValue();
				Textbox c=(Textbox)this.getFellow("Email_Id");
				String c1=c.getValue();
				Textbox d=(Textbox)this.getFellow("Create_Password");
				String d1=d.getValue();
				Longbox e=(Longbox)this.getFellow("Mobile_Number");
				long e1=e.getValue();
				Datebox j12=(Datebox)this.getFellow("Date_Of_Birth");
				Date j13=(Date) j12.getValue(); 
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String strDate= formatter.format(j13);
				java.sql.Date jdate=java.sql.Date.valueOf(strDate); 
				Radiogroup f=(Radiogroup)this.getFellow("Gender");
				String f2=f.getSelectedItem().getValue();
				Textbox g=(Textbox)this.getFellow("Highest_Qualification");
				String g1=g.getValue();
		/*
		 * Textbox h=(Textbox)this.getFellow("Course"); String h1=h.getValue();
		 */
				Textbox i=(Textbox)this.getFellow("Specialization");
				String i1=i.getValue();
				Textbox j=(Textbox)this.getFellow("University");
				String j1=j.getValue();
				Intbox k=(Intbox)this.getFellow("Passing_Year");
				int k1=k.getValue();
				Textbox l=(Textbox)this.getFellow("Skills");
				String l1=l.getValue();
				/*Textbox p3=(Textbox)this.getFellow("Resume"); String n6=p3.getValue();*/
				try
					{
					UserdetailsModel f1=new UserdetailsModel();
				      
						f1.setName(b1);
						f1.setEmail_Id(c1);
						f1.setCreate_Password(d1);
						f1.setMobile_Number(e1);
						f1.setDate_Of_Birth(jdate);
						f1.setGender(f2);
						f1.setHighest_Qualification(g1);
						/* f1.setCourse(h1); */
						f1.setSpecialization(i1);
						f1.setUniversity(j1);
						f1.setPassing_Year(k1);
						f1.setSkills(l1);
						f1.setResume(Resume);
						
					
					int val=db1.freshuser(f1);
					}
					catch(Exception et)
					{
						System.out.println(et);
					}

			}
}




