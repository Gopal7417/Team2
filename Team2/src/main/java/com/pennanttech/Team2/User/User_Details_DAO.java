package com.pennanttech.Team2.User;

import java.util.List;


import com.pennanttech.Team2.Jobmodel;
import com.pennanttech.Team2.Empr.Job_Tbl;

public interface User_Details_DAO
	{
		public int validuser(Jobmodel m);
		public int users(UserdetailsModel m1);
		public List JobSearch(String Role, String Location) ;
		public List Job_Data(int jobid);
		
		public int valid(com.pennanttech.Team2.Job_Tbl jt);
		public List profile(int profileid);
	}
