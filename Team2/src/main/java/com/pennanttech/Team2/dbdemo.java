 package com.pennanttech.Team2;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class dbdemo extends Window {
protected TaskDAO taskDAO;
protected List tasks;
public void render() {
	Textbox lb = (Textbox)this.getFellow("test");
	Textbox lb1 = (Textbox)this.getFellow("test2");
	Combobox com = (Combobox)this.getFellow("combo");
	for (Iterator it = tasks.iterator(); it.hasNext();) 
	{
	model m = (model) it.next();
	System.out.println(m.getJob_Title());
	com.appendItem(m.getJob_Title());				
	Textbox lb3 = new Textbox();
}
	
}

public void onCreate() throws Exception {
	ApplicationContext ctx = 
		WebApplicationContextUtils.getRequiredWebApplicationContext(
			(ServletContext)getDesktop().getWebApp().getNativeContext());
	taskDAO = (TaskDAO)ctx.getBean("taskDAO");
	tasks = taskDAO.findAll();
}	


}
