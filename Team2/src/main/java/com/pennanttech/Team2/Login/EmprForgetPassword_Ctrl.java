package com.pennanttech.Team2.Login;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.w3c.dom.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

public class EmprForgetPassword_Ctrl extends Window
	{
	LoginDAO db1;
	private static String otp;
	public Component login;

public void mailcheck() {
	Textbox mail =  (Textbox)this.getFellow("email");
	ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
	db1=(LoginDAO)ctx.getBean("Login");	
	if(db1.Emprmailcheck(mail.getValue()) ==1){
	Mail m = new Mail();
	otp =m.sendMail(mail.getValue());
		
	
	}
	
	else {
		showNotify("Login Sucessfull","info",login);
	}
	
	
	
}
public void onSubmit() {
	Textbox mail =  (Textbox)this.getFellow("email");
	String Entered_otp = ((Textbox)this.getFellow("otp")).getValue();
	System.out.println(otp);	
	if(Entered_otp.equals(otp)) 		
			setPassword(mail.getValue());

	
	}

private void showNotify(String msg,String type, Component ref)
{
    Clients.showNotification(msg, type, ref, "middle_center", 2000);
}
	
	

	
	public void setPassword(String mail) {
		
		
		Window window = (Window)Executions.createComponents("EmprsetPassword.zul", null, null);
		window.setAttribute("email", mail);
		 window.setClosable(true);
		 window.setTitle("Set new Password");
		 window.doModal();
		 Window win = (Window)this.getFellow("check");
			win.setVisible(false);
	}
	
	}
