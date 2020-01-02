package com.pennanttech.Team2.Login;
import javax.mail.*;
import javax.activation.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


	public class Mail 
		{
			public String sendMail(String email)
				{
					int randomPin   =(int) (Math.random()*9000)+1000; 
				    String otp  = String.valueOf(randomPin); 
				    
					final String uname="dhruvaece2k18@gmail.com";
					final String pwd="jayvnbhar";
					Properties props= new Properties();
					props.put("mail.smtp.auth","true");
					props.put("mail.smtp.starttls.enable","true");
					props.put("mail.smtp.ssl.trust","smtp.gmail.com");
					props.put("mail.smtp.host","smtp.gmail.com");
					props.put("mail.smtp.port","587");
					int i=0;
					Session ss = Session.getInstance(props,new javax.mail.Authenticator()
						{
						protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(uname,pwd);
						}
						});
					try
				      { 
				         String s = new String();
				         s= email;
				         Message message = new MimeMessage(ss);
				         message.setFrom(new InternetAddress(uname));
				         message.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
				         message.setSubject("MAIL");
				         MimeMultipart multipart= new  MimeMultipart("related") ;
				         BodyPart messageBodyPart = new MimeBodyPart();
				         String bdy = "<h1 style=\"color:red\">"+otp+"</h1><br><br>";
				         messageBodyPart.setContent(bdy,"text/html");
				         multipart.addBodyPart(messageBodyPart);
				         message.setContent(multipart);
				         Transport.send(message);
				       }
					     catch(Exception e)
					  {
						  System.out.println(e);
					  }
					return otp;
				}
		}

