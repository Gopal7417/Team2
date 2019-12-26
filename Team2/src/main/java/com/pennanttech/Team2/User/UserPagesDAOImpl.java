package com.pennanttech.Team2.User;

import java.util.List;
import java.sql.*;
import javax.sql.*;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

import com.pennanttech.Team2.model;
import com.pennanttech.Team2.Login.UserDetailsModel;
import com.pennanttech.Team2.User.User_Details_DAO_Impl.JobDataMapper;





public class UserPagesDAOImpl implements UserPagesDAO {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	protected DataFieldMaxValueIncrementer taskIncer;
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setJdbcTemplate(JdbcTemplate  jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setTaskIncer(DataFieldMaxValueIncrementer taskIncer) {
		this.taskIncer = taskIncer;
	}

	public int validuser(String username,String password){
		System.out.println("entered");
		

		String sql="select Create from admin_login where user_name= ?";

		try{
		String pass=jdbcTemplate.queryForObject(sql,new Object[]{username}, String.class);
			if(password.equals(pass)){
				return 1;
			}else{
				return 2;
			}
		
			}catch(EmptyResultDataAccessException e){
				
		return 3;
			}catch(Exception e2){
				return 4;
			}
		
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
				String sql = "insert into emp( emp_id,Name,Email_Id,Password,Mobile_Number,Date_Of_Birth,Gender,Highest_Qualification,Specialization,University,Passing_Year,Skills,Resume,Company_Name,No_of_Years,Job_Role) values(NEXT VALUE FOR emp_id,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				Object[] params = new Object[] {z,y,x,w,d12,v,u,s,r,q,p,f.getResume(),o,p1,p2 };
				int types[] = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT,Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.NUMERIC, Types.VARCHAR,Types.LONGVARBINARY,
						Types.VARCHAR,Types.INTEGER,Types.VARCHAR};
				jdbcTemplate.update(sql, params, types);
				//Executions.sendRedirect("");
				return 0;
	}	
	
	public int freshuser(UserdetailsModel f) {
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
		String sql ="insert into emp( emp_id,Name,Email_Id,Password,Mobile_Number,Date_Of_Birth,Gender,Highest_Qualification,Specialization,University,Passing_Year,Skills,Resume) values(NEXT VALUE FOR emp_id,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {z,y,x,w,d12,v,u,s,r,q,p,f.getResume() };
		int types[] = new int[]  {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT,Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.NUMERIC, Types.VARCHAR,Types.LONGVARBINARY};
		jdbcTemplate.update(sql, params, types);
		//Executions.sendRedirect("");
		return 0;
	}
	
	protected class JobProfileMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserdetailsModel m1 = new UserdetailsModel();
			m1.setName(rs.getString(1));
		    m1.setDate_Of_Birth(rs.getDate(2));
			 m1.setHighest_Qualification(rs.getString(3));			
			m1.setSkills(rs.getString(4));
			m1.setNo_of_Years(rs.getInt(5));
			m1.setResume(rs.getBytes(6));
			m1.setMobile_Number(rs.getLong(7));
			m1.setEmail_Id(rs.getString(8));
			    
			return m1;
		}}
	
	public List Profile(String profileid) 
		{
		System.out.println("p");
		System.out.println(profileid);
		String sql = "select Name,Date_Of_Birth,Highest_Qualification,Skills,No_of_Years,Resume,Mobile_Number,Email_Id from emp where Email_Id='"+profileid+"'";			
		return jdbcTemplate.query(sql, new JobProfileMapper());
		}
	
	protected class AppliedJobMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("Impl");
			Appliedid_Model ap=new Appliedid_Model();
			ap.setCompany_Name(rs.getString("Company_Name"));
			ap.setJob_Role(rs.getString("Job_Role"));
			ap.setJob_Location(rs.getString("Job_Location"));
			ap.setStatus(rs.getString("status"));
			ap.setD(rs.getDate("Applied_On"));
			System.out.println("imp");
			return ap;
		}
	}

	public List Applied(int empid) 
		{
		System.out.println(empid);
		String sql=" select b.Company_Name,Job_Role,a.Job_Location,b.Status,b.Applied_On from job_tbl a,(select c.Company_id,c.Job_Id,d.Company_Name,c.Status,c.Applied_On from "
				+ "(select * from Applied_Jobs_tbl where emp_id="+empid+" )c ,Company_tbl d where c.Company_Id= d.Company_Id) b where a.Job_Id = b.Job_Id"; 
		return jdbcTemplate.query(sql, new AppliedJobMapper());
		}
	
	
	
	

	protected class jobsTitleMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Job_Details m = new Job_Details();
			m.setJob_Title(rs.getString(1));
			return m;
		}}
		
	public List jobsTitle() throws Exception {
		String sql = "select Job_Role from Job_tbl";
		return jdbcTemplate.query(sql, new  jobsTitleMapper());
	}
	
	protected class LocMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	    LocationModel lm = new LocationModel();	    
	    lm.setLocId(rs.getString(1));
	    lm.setLocation(rs.getString(2));
		return lm;
		}}
	
	public List Locations() throws Exception{		
		String sql = "SELECT * FROM Location";
		return jdbcTemplate.query(sql, new LocMapper());		
	}
	
	
	
	protected class JobSearchMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Job_Details m = new Job_Details();
		m.setJob_id(rs.getInt(5));
        m.setCompany_Name(rs.getString(2));
       m.setJob_Role(rs.getString(1));
       m.setJob_Location(rs.getString(3));
       m.setSalary(rs.getInt(4));
       return m;
		}
}			
	public List JobSearch(String Role, String Location) {
		String sql = "  select Job_Role,Company_Name,Job_Location,salary,Job_Id from Company_tbl a,"
				+ "( select Job_Role,Company_Id,Job_Location,salary,Job_Id from Job_tbl where job_Location = 'vizag' and Job_Role = 'developer')b "
				+ "where a.Company_Id = b.Company_Id";
		return jdbcTemplate.query(sql, new JobSearchMapper());
	}

	protected class JobDataMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Job_Details m = new Job_Details();
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

	public int apply(int jobid,int empid) {
		String sql="select Company_id from Job_tbl where Job_Id = ?  ";
		
		int cmpid =jdbcTemplate.queryForObject(sql,new Object[]{jobid}, Integer.class);
		
		String sql2 ="insert into Applied_Jobs_tbl(emp_id,job_id,Company_id,Status) values(?,?,?,'Pending')";
		
		
		Object[] params = new Object[]{empid,jobid,cmpid};
		int types[] = new int[]  {Types.INTEGER, Types.INTEGER, Types.INTEGER};
		
				jdbcTemplate.update(sql2, params, types);
		
		return 1;
	}
	

	public int login(UserDetailsModel e) {				
		//get the password for the given user
		String qry = "select password from "
				+ "emp where Email_Id=?";
		System.out.println(e.getEmail_Id());
		try {
		String pwd = (String)jdbcTemplate.queryForObject(qry,new Object[]{e.getEmail_Id()}, String.class );
		
		//verify the password
		if (pwd != null) {
			if (e.getPassword().equals(pwd)) {
				
				return 0;	//success
			}else {
				return 1;	//wrong password  
			}
		}else {
			return 2;
		}
		
		}catch(Exception ex) {
			return 2;	//user itself wrong
		}
		
	}
	
	public int applyCheck(int jobid,int empid) {
		try {
		
		String sql = "select @@ROWCOUNT from Applied_Jobs_tbl where emp_id = "+empid+"and Job_Id ="+jobid;						
		Integer count = (Integer)jdbcTemplate.queryForObject(sql,Integer.class);
		
		if (count != null) {	
				return 0;	//success
			}else {
				return 1;	//wrong password  
			}
		}
		catch(EmptyResultDataAccessException e) 
		{
			return 3;
		}
		
	}

	
}
