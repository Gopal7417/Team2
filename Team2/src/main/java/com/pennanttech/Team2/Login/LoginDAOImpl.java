package com.pennanttech.Team2.Login;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.zkoss.zk.ui.Executions;


import com.pennanttech.Team2.Empr.Job_Tbl;

public class LoginDAOImpl implements LoginDAO {

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
		public int login2(EmprDetailsModel e1) {
				// TODO Auto-generated method stub
				
				
				String qry = "select Create_Password from emp where Email_Id=?";
				System.out.println(e1.getEmail_Id());
				try {
				String pwd = (String)jdbcTemplate.queryForObject(qry,new Object[]{e1.getEmail_Id()}, String.class );
				
				//verify the password
				if (pwd != null) {
					if (e1.getPassword().equals(pwd)) {
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
		
		public int validuser(String username,String password)
			{
				System.out.println("entered into impl");
				System.out.println(username);
				String sql=" select Password from emp where Email_Id = ?";
				try
					{
						System.out.println("entered into try");
						String pass=jdbcTemplate.queryForObject(sql,new Object[]{username}, String.class);
						System.out.println(pass);
						if(password.equals(pass)) 
							{ 
							
							
							
								return 1;
							} 
						else
							{
								return 2;
					  		} 
			  
					}
				catch(EmptyResultDataAccessException e) 
					{
						return 3;
					}
				catch(Exception e2)
					{
						return 4;
					}
			}
		public int validempr(String username,String password) 
		{
			System.out.println("entered into impl");
			System.out.println(username);
			String sql=" select Password from Company_tbl where Email_Id = ?";
			try
				{
					System.out.println("entered into try");
					String pass=jdbcTemplate.queryForObject(sql,new Object[]{username}, String.class);
					System.out.println(pass);
					if(password.equals(pass)) 
						{ 
							return 1;
						} 
					else
						{
							return 2;
				  		} 
		  
				}
			catch(EmptyResultDataAccessException e) 
				{
					return 3;
				}
			catch(Exception e2)
				{
					return 4;
				}
		}

		public int cmpnyid(String b1) {
			String sql="select Company_Id from Company_tbl where Email_Id = ?";
			int pass=jdbcTemplate.queryForObject(sql,new Object[]{b1}, Integer.class);
			return pass;
		
		}
		
		
		
		public int empid(String b1) {
			String sql="select emp_id from emp where Email_Id = ?";
			int pass=jdbcTemplate.queryForObject(sql,new Object[]{b1}, Integer.class);
			return pass;
		
		}

		public int Emprmailcheck(String b1) {
			String sql="select Email_Id from Company_tbl where Email_Id = ?";
			try {
			String s= jdbcTemplate.queryForObject(sql, new Object[] {b1},String.class);
			if(b1.equals(s))
			{ 
				return 1;
			} 
			else
			{
				return 0;
	  		} 

			}
			
			catch(EmptyResultDataAccessException e){
				
				return 0;
			
			}
	}
		
		public void EmprPwdChange(String mail,String pwd) {
			String sql="update Company_tbl set Password = ? where Email_Id = ?";
			
			jdbcTemplate.update(sql, new Object[] {pwd,mail});
			
	
		}


		public int Usermailcheck(String b1) {
			String sql="select Email_Id from emp where Email_Id = ?";
			try {
			String s= jdbcTemplate.queryForObject(sql, new Object[] {b1},String.class);
			if(b1.equals(s))
			{ 
				return 1;
			} 
			else
			{
				return 0;
	  		} 

			}
			
			catch(EmptyResultDataAccessException e){
				
				return 0;
			
			}
	}
		
		public void UserPwdChange(String mail,String pwd) {
			String sql="update emp set Password = ? where Email_Id = ?";
			
			jdbcTemplate.update(sql, new Object[] {pwd,mail});
			
	
		}
		
}

