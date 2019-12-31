package com.pennanttech.Team2.User;

import java.util.*;

public interface UserPagesDAO {
public List jobsTitle() throws Exception;
public List Locations() throws Exception;
public List JobSearch(String Role, String Location) ;
public List Job_Data(int jobid);
public int validuser(String username,String password);
public int users(UserdetailsModel m1);
public int freshuser(UserdetailsModel f1);
public List Profile(int b1);
public int apply(int jobid,int empid);
public List Applied(int empid);
public int applyCheck(int jobid,int empid);
public void Profileupdate(UserdetailsModel em);


}
