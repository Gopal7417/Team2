package com.pennanttech.Team2.Login;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.*;

public class UserSetPwd_Ctrl extends Window{
	LoginDAO db1;
	
	
	public void onSubmit() {
		
		Window win = (Window)this.getFellow("set");
		String mail = (String) win.getAttribute("email");
		ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)getDesktop().getWebApp().getNativeContext());
		db1=(LoginDAO)ctx.getBean("Login");	
		db1.UserPwdChange(mail, ((Textbox)this.getFellow("pwd1")).getValue());
		
	}
	
}
