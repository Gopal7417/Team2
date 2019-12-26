package com.pennanttech.Team2;

import java.util.LinkedHashMap;
import java.util.Map;
 
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

public class NavigationViewModel {
	
	 NavigationPage currentPage;
	    private Map<String, Map<String, NavigationPage>> pageMap;
	     
	    @Init
	    public void init() {
	        initPageMap();
	        currentPage = pageMap.get("ZK's Pizza").get("About Us");
	    }
	 
	    @Command
	    public void navigatePage() {
	    	System.out.println("dgffdxg");
	        BindUtils.postNotifyChange(null, null, currentPage, "selected");
	      
	        BindUtils.postNotifyChange(null, null, this, "currentPage");
	    }
	     
	    public NavigationPage getCurrentPage() {
	        return currentPage;
	    }
	 
	    public Map<String, Map<String, NavigationPage>> getPageMap() {
	        return pageMap;
	    }
	     
	    private void initPageMap() {
	        pageMap = new LinkedHashMap<String, Map<String, NavigationPage>>();
	         
	        addPage("ZK's Pizza", "a.zul",null);
	       
	        addPage("Customers", "/customers/customers.zul", "inactive");
	 
	        addPage("Orders", "/orders/orders.zul", "in-preparation");
	       
	        addPage("Fan Service",  "/fan_service/promotion.zul",null);
	    }
	 
	    private void addPage(String title,  String includeUri) {
	        addPage(title,  includeUri, null);
	    }
	     
	    private void addPage(String title,  String includeUri, String data) {
	        String folder = "/";
	        Map<String, NavigationPage> subPageMap = pageMap.get(title);
	        if(subPageMap == null) {
	            subPageMap = new LinkedHashMap<String, NavigationPage>();
	            pageMap.put(title, subPageMap);
	        }
	        NavigationPage navigationPage = new NavigationPage(title, 
	                folder + includeUri + "?random=" + Math.random(), data) {
	            @Override
	            public boolean isSelected() {
	                return currentPage == this;
	            }
	        };
	        subPageMap.put(title, navigationPage);
	    }

}
