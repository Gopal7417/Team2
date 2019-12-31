package com.pennanttech.Team2.Empr;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.*;
import org.zkoss.zk.ui.ext.*;
import org.zkoss.zk.au.*;
import org.zkoss.zk.au.out.*;
import org.zkoss.zul.*;
import java.util.*;

public class TestComposer extends GenericForwardComposer{

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

	}

	public void onClick$btn(Event e) throws InterruptedException{
		Map<String, Object> args = new HashMap<String, Object>();
                Window window = (Window) Executions.createComponents("FresherRegistration.zul", self, args);
	}
}
