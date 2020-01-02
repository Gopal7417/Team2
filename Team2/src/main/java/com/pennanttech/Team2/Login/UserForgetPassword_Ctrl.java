package com.pennanttech.Team2.Login;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

public class UserForgetPassword_Ctrl extends Window
	{
	LoginDAO db1;
	private static String otp;

public void mailcheck() {
	Textbox mail =  (Textbox)this.getFellow("email");
	ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
	db1=(LoginDAO)ctx.getBean("Login");	
	if(db1.Usermailcheck(mail.getValue()) ==1){
	Mail m = new Mail();
	otp =m.sendMail(mail.getValue());
		
	
	}
	
	else {
		Label error =  (Label)this.getFellow("error");
		error.setValue("The email address you requested is not registered with us");
	}
	
	
	
}
public void onSubmit() {
	Textbox mail =  (Textbox)this.getFellow("email");
	String Entered_otp = ((Textbox)this.getFellow("otp")).getValue();
	System.out.println(otp);	
	if(Entered_otp.equals(otp)) 		
			setPassword(mail.getValue());

	
	}
	
	

	
	public void setPassword(String mail) {
		
		Window window = (Window)Executions.createComponents("EmpsetPassword.zul", null, null);
		window.setAttribute("email", mail);
		 window.setClosable(true);
		 window.doModal();
	}
	
	
	}
