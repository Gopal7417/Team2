package com.pennanttech.Team2.Login;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class EmprSetPwd_Ctrl extends Window{
	LoginDAO db1;
	public void onSubmit() {
		
		Window win = (Window)this.getFellow("set");
		String mail = (String) win.getAttribute("email");
		System.out.println(mail);
		ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
		db1=(LoginDAO)ctx.getBean("Login");	
		db1.EmprPwdChange(mail, ((Textbox)this.getFellow("pwd1")).getValue());
		
	}
	
}
