package com.pennanttech.Team2.Login;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

public class UserForgetPassword_Ctrl extends SelectorComposer<Window> 
	{
	@Wire
    Textbox input;
    @Wire
    Textbox input2;
    @Wire
    Vlayout result;
    String s;
    String s2 = new String();
    
    @Listen("onClick=#retrieve")
     public void submit(Event event) 
 	    {
 	        String prop = input.getValue();     
 	        String me = input.getValue();
 	        Mail nw = new Mail();     
 	       s = nw.main(me);     
 	    }
     @Listen("onClick=#submit")
     public void submit2(Event event) 
 	    {
 	    	s2 = input2.getValue(); 
     		if(s.equals(s2))
 			     {
 			            result.appendChild(new Label("Success"));
 			     }
 		    else 
 			     {
 			    	 result.appendChild(new Label("Enter correct OTP"));
 			     }
 	    }
	
	}
