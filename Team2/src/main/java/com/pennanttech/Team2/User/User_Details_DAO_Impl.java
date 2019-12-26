package com.pennanttech.Team2.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.zkoss.zk.ui.Executions;


import com.pennanttech.Team2.Jobmodel;
import com.pennanttech.Team2.model;
import com.pennanttech.Team2.Empr.Job_Tbl;

public class User_Details_DAO_Impl implements User_Details_DAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	protected DataFieldMaxValueIncrementer taskIncer;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setTaskIncer(DataFieldMaxValueIncrementer taskIncer) {
		this.taskIncer = taskIncer;
	}
	  public int validuser(Jobmodel m) {
		// TODO Auto-generated method stub		
		String a = m.getJob_Title();
		int b = m.getSalary();
		int c = m.getNo_of_Openings();
		String d = m.getJob_Location();
		String e = m.getMinimum_Qualification();
		int f = m.getExperince();
		String g = m.getJob_Role();
		System.out.println(g);
		String h = m.getJob_Description();
		String i =m.getCompany_Name();
		String j =m.getRecruiter_Name();
		long k = m.getPhone_Number();
		String l =m.getEmail_Id();
		String n = m.getJob_Address();
		String sql = "insert into job values(NEXT VALUE FOR empr_id,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { a, b, c, d, e, f, g, h, i,j, k, l, n };
		int types[] = new int[] {Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
				Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT, Types.VARCHAR,
				Types.VARCHAR };
		jdbcTemplate.update(sql, params, types);
		//Executions.sendRedirect("");
		return 0;
	}

	public int users(UserdetailsModel f) {
		// TODO Auto-generated method stub
		
				String z = f.getName();
				String y = f.getEmail_Id();
				String x = f.getCreate_Password();
				long w = f.getMobile_Number();
				Date d12= f.getDate_Of_Birth();
				String v = f.getGender();
				String u  = f.getHighest_Qualification();
				/* String t = f.getCourse(); */
				String s = f.getSpecialization();
				String r =f.getUniversity();
				int q=f.getPassing_Year();
				String p= f.getSkills();
				String o=f.getCompany_Name();
				int p1=f.getNo_of_Years();
				String p2=f.getJob_Role();
				String sql = "insert into emp( emp_id,Name,Email_Id,Create_Password,Mobile_Number,Date_Of_Birth,Gender,Highest_Qualification,Specialization,University,Passing_Year,Skills,Company_Name,No_of_Years,Job_Role) values(NEXT VALUE FOR emp_id,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				Object[] params = new Object[] {z,y,x,w,d12,v,u,s,r,q,p,o,p1,p2 };
				int types[] = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT,Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.NUMERIC, Types.VARCHAR,
						Types.VARCHAR,Types.INTEGER,Types.VARCHAR};
				jdbcTemplate.update(sql, params, types);
				//Executions.sendRedirect("");
				return 0;
	}		     
		
	
	

		 
		 public int valid(Job_Tbl j) {
				// TODO Auto-generated method stub
				System.out.println("1");
				String j71=j.getJob_Role();
				String j72=j.getJob_Description();
				int j73=j.getSalary();
				int j74=j.getExperience();	
				int j75=j.getNo_of_Openings();				
				String j76=j.getMinimum_Qualification();		
				System.out.println("12");
				Date j77=j.getLast_Date();
			
				 String j78=j.getJob_Location(); 
				 String j79=j.getAddress(); 
				 String j80=j.getSkills();
				 String sql=" insert into Job_tbl(Company_Id,Job_Id,Job_Role,Job_Description,Salary,Experience,No_of_Openings,Minimum_Qualification,last_Date,Job_Location,Address,Skills) values(7,NEXT VALUE FOR Job_Id,?,?,?,?,?,?,?,?,?,?)"; 
				 Object[] params = new Object[] {j71,j72,j73,j74,j75,j76,j77,j78,j79,j80 };
				  int types[] = new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
				  Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				  Types.VARCHAR, Types.VARCHAR }; 
				  jdbcTemplate.update(sql, params, types);
				 
				
				return 0;
			}
		 
		 
	
			
			
		
		protected class TaskMapper implements RowMapper {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		model m = new model();
			m.setJob_id(rs.getInt(5));
	        m.setCompany_Name(rs.getString(2));
	       m.setJob_Role(rs.getString(1));
	       m.setJob_Location(rs.getString(3));
	       m.setSalary(rs.getInt(4));
	       return m;
			}
	}			
	public List JobSearch(String Role, String Location) {
	String sql = "select Job_Role,Company_Name,Job_Location,salary,job_id from job where job_Location = 'vizag' and Job_Role = 'developer'";
      return jdbcTemplate.query(sql, new TaskMapper());
}
	
	protected class JobDataMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			model m = new model();
			m.setJob_Description(rs.getString(1));
			m.setExperince(rs.getInt(2));
			m.setCompany_Name(rs.getString(3));			
			m.setJob_Location(rs.getString(4));
			    
			return m;
		}}
	
	public List Job_Data(int jobid) {
		System.out.println(jobid);
	String sql = "  select b.Job_Description,b.Experience,a.Company_Name,b.Job_Location from Company_tbl a,"
			+ "(select Job_Description,Experience,Company_Id,Job_Location from job_tbl where Job_Id = "+jobid+")b "
			+ "where a.Company_Id = b.Company_Id;";			
	return jdbcTemplate.query(sql, new JobDataMapper());
	}



	public List profile(int profileid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int valid(com.pennanttech.Team2.Job_Tbl jt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	

	

}

