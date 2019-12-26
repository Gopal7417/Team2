package com.pennanttech.Team2;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.pennanttech.Team2.User.User_Details_DAO;

public class JobCtrl extends Div {

	User_Details_DAO db;

	private Component click;

	public void verifyRegister() {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext((ServletContext) getDesktop().getWebApp().getNativeContext());
		db = (User_Details_DAO) ctx.getBean("taskDAO");

		System.out.println("enter");

		Textbox a = (Textbox) this.getFellow("Job_Title");
		String a1 = a.getValue();
		Intbox b = (Intbox) this.getFellow("Salary");
		int b1 = b.getValue();
		Intbox c = (Intbox) this.getFellow("No_of_Openings");
		int c1 = c.getValue();
		Textbox d = (Textbox) this.getFellow("Job_Location");
		String d1 = d.getValue();
		Textbox e = (Textbox) this.getFellow("Minimum_Qualification");
		String e1 = e.getValue();
		Intbox f = (Intbox) this.getFellow("Experince");
		int f1 = f.getValue();
		Textbox g = (Textbox) this.getFellow("Job_Role");
		String g1 = g.getValue();
		System.out.println(g1);
		Textbox h = (Textbox) this.getFellow("Job_Description");
		String h1 = h.getValue();
		Textbox i = (Textbox) this.getFellow("Company_Name");
		String i1 = i.getValue();
		Textbox j = (Textbox) this.getFellow("Recruiter_Name");
		String j1 = j.getValue();
		Longbox k = (Longbox) this.getFellow("Phone_Number");
		long k1 = k.getValue();
		Textbox l = (Textbox) this.getFellow("Email_Id");
		String l1 = l.getValue();
		Textbox n = (Textbox) this.getFellow("Job_Address");
		String n1 = n.getValue();

		try {
			Jobmodel m = new Jobmodel();
			m.setJob_Title(a1);
			m.setSalary(b1);
			m.setNo_of_Openings(c1);
			m.setJob_Location(d1);
			m.setMinimum_Qualification(e1);
			m.setExperince(f1);
			m.setJob_Role(g1);
			m.setJob_Description(h1);
			m.setCompany_Name(i1);
			m.setRecruiter_Name(j1);
			m.setPhone_Number(k1);
			m.setEmail_Id(l1);
			m.setJob_Address(n1);
			int val = db.validuser(m);
		} catch (Exception et) {
			System.out.println(et);
		}

		
		  
		  /*public void onOK() throws Exception { if (task == null) { //new task = new
		  Task();
		  
		  Textbox ctrl = (Textbox) this.getFellow("title");
		  task.setTitle(ctrl.getValue()); ctrl = (Textbox)
		  this.getFellow("description"); task.setDescription(ctrl.getValue());
		  
		  taskDAO.insert(task); } else { //update Textbox ctrl = (Textbox)
		  this.getFellow("title"); task.setTitle(ctrl.getValue()); ctrl = (Textbox)
		  this.getFellow("description"); task.setDescription(ctrl.getValue());
		  
		  taskDAO.update(task); }
		  
		  this.setAttribute("OK", Boolean.TRUE); this.detach(); }
		  
		  public void onCancle() { this.detach(); }*/
		 
	}

}
