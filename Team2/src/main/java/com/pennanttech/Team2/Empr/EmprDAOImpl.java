package com.pennanttech.Team2.Empr;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import com.pennanttech.Team2.User.UserdetailsModel;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

import com.pennanttech.Team2.Empr.*;;


public class EmprDAOImpl implements EmprDAO
	{
		private static Logger logger = Logger.getLogger(EmprHome_Ctrl.class);
		private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		private JdbcTemplate jdbcTemplate;
		protected DataFieldMaxValueIncrementer taskIncer;
		public void setDataSource(DataSource dataSource){	this.jdbcTemplate = new JdbcTemplate(dataSource);}
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
		public void setTaskIncer(DataFieldMaxValueIncrementer taskIncer) {this.taskIncer = taskIncer;}
		protected class EmprJob_DataMap implements RowMapper 
			{
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						Job_Tbl jb = new Job_Tbl();
						jb.setJob_Role(rs.getString(1));
						jb.setLast_Date(rs.getDate(2));
						jb.setRegister_Date(rs.getDate(3));
						jb.setJob_Location(rs.getString(4));
						jb.setJob_Id(rs.getInt(5));
						return jb;
					}
			}	
		public List EmprJob_Data(int cmpid) 
			{		
				logger.info("enter");		
				String  sql="select Job_Role , last_Date ,Register_Date ,Job_Location,job_id from Job_tbl where Company_Id ="+cmpid ;		
				return jdbcTemplate.query(sql, new EmprJob_DataMap());
			}
	
		public int emprreg(Empr_Model c) 
			{
				String c1=c.getCompany_Name();
				String c2=c.getRecruiter_Name();
				String c3=c.getEmail_Id();
				String c4=c.getPassword();
				long c5=c.getPhone_number();
				String c6=c.getDesg();
				String sql="insert into Company_tbl(Company_Id,Company_Name,Recruiter_Name,Email_Id,Password,Phone_Number,Current_Designation) values(NEXT VALUE FOR Company_Id,?,?,?,?,?,?)";
				Object[] params = new Object[] {c1,c2,c3,c4,c5,c6};
				int types[] = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						  					Types.VARCHAR, Types.BIGINT,Types.VARCHAR }; 
				jdbcTemplate.update(sql, params, types);
				return 0;
			}
		public int newjob(EmprNewJob_Model j) 
			{
				// TODO Auto-generated method stub
				System.out.println("11");
				String j71=j.getJob_Role();
				String j72=j.getJob_Description();
				System.out.println(j72);
				BigDecimal j73=j.getSalary();
				int j74=j.getExperience();	
				int j75=j.getNo_of_Openings();				
				String j76=j.getMinimum_Qualification();
				System.out.println("77");
				Date j77=j.getLast_Date();
				String j78=j.getJob_Location(); 
				String j80=j.getSkills();
				String j81=j.getVenue();
				String j82=j.getI_Date();
				String j84=j.getRounds();
				
				String sql=" insert into Job_tbl(Company_Id,Job_Id,Job_Role,Job_Description,Salary,Experience,No_of_Openings,Minimum_Qualification,last_Date,Job_Location,Skills,Venue,I_Date,Rounds) values(?,NEXT VALUE FOR Job_Id,?,?,?,?,?,?,?,?,?,?,?,?)"; 
				Object[] params = new Object[] {j.getCompany_Id(),j71,j72,j73,j74,j75,j76,j77,j78,j80,j81,j82,j84 };
				int types[] = new int[] {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.DECIMAL,
						 					Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						 						 Types.VARCHAR,Types.VARCHAR, Types.VARCHAR,Types.VARCHAR }; 
				jdbcTemplate.update(sql, params, types);
				return 0;
			}
		
		protected  class CompanyProfMapper implements RowMapper {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Empr_Model em=new Empr_Model();
				em.setCompany_Name(rs.getString(1));
				em.setPhone_number(rs.getLong(2));
				em.setEmail_Id(rs.getString(3));
				em.setRecruiter_Name(rs.getString(4));
				em.setDesg(rs.getString("Desg"));
			
				
				return em;

			}}
		public List  companyProfile(int Company_Id) {
		    System.out.println(Company_Id);
		    String sql="select Company_Name,Phone_Number,Email_Id,Recruiter_Name,Desg from Company_tbl where Company_Id="+Company_Id;
		    return jdbcTemplate.query(sql,new CompanyProfMapper());
		   
		}

		public void companyupdate(Empr_Model em) {
			int x=em.getCompany_Id();
			String sql="Update Company_tbl SET Company_Name=?,Phone_Number=?,Email_Id=?,Recruiter_Name=?,Desg=? WHERE Company_Id="+x;
			  Object[] params = new Object[]{em.getCompany_Name(),em.getPhone_number(),em.getEmail_Id(),em.getRecruiter_Name(),em.getDesg()};
			  int types[] = new int[]{Types.VARCHAR, Types.BIGINT, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR}; 
			  jdbcTemplate.update(sql, params,types);
		}

		protected class ApplicantsMap implements RowMapper {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				AppListModel ap = new AppListModel();
				ap.setJob_Title(rs.getString(1));
				ap.setApplicantName(rs.getString(2));
				ap.setEmpid(rs.getInt(3));
				ap.setWorkExperience(rs.getInt(4));
				ap.setStatus(rs.getString(5));
				ap.setApplied_On(rs.getDate(6));;
				return ap;
				}
	}
	   
		public List ApplicantsList(int jobid) {
			String  sql="select b1.Job_Role,Name,b1.emp_id,No_Of_Years, b1.Status,b1.Applied_on from emp a1,\r\n" + 
					"  (select emp_id,Status,Job_Role,Applied_on from Applied_Jobs_tbl a,(select * from Job_tbl where Job_Id= "+jobid+")b\r\n" + 
					"   where  a.job_id = b.Job_Id)b1 where a1.emp_id = b1.emp_id ";
	       return jdbcTemplate.query(sql, new ApplicantsMap());	
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
				m1.setGender(rs.getString(9));
				
				return m1;
			}}

	public List Profile(int profileid) {

	String sql = "select Name,Date_Of_Birth,Highest_Qualification,Skills,No_of_Years,Resume,Mobile_Number,Email_Id,Gender from emp where emp_id = "+profileid;			
	return jdbcTemplate.query(sql, new JobProfileMapper());
		}
	
	
		public String Approve(int empid) {
			
			String sql = "update Applied_Jobs_tbl set Status = 'Approved' where emp_id = ?";
			jdbcTemplate.update(sql,empid);
			String sql2 = " select Email_id from emp where emp_id = ?";
			String mail = jdbcTemplate.queryForObject(sql2,new Object[]{empid}, String.class);
			
		return mail;	
		}


		public int Reject(int empid) {
			
			String sql = "update Applied_Jobs_tbl set Status = 'Rejected' where emp_id = ?";
			
			jdbcTemplate.update(sql,empid);
			
			
		return 1;	
		}
		public int valid(Job_Tbl j) {
			
			
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
		
			 String j80=j.getSkills();
			 String sql=" insert into Job_tbl(Company_Id,Job_Id,Job_Role,Job_Description,Salary,Experience,No_of_Openings,Minimum_Qualification,last_Date,Job_Location,Skills) values(?,NEXT VALUE FOR Job_Id,?,?,?,?,?,?,?,?,?)"; 
			 Object[] params = new Object[] {j.getCompany_Id(),j71,j72,j73,j74,j75,j76,j77,j78,j80 };
			  int types[] = new int[] {Types.INTEGER,Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
			  Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
			  Types.VARCHAR, Types.VARCHAR }; 
			  jdbcTemplate.update(sql, params, types);
			  return 0;
		}

		
	

}
