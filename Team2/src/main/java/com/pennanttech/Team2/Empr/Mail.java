package com.pennanttech.Team2.Empr;
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
import javax.servlet.*;





public class Mail {

	
	
public void main(String email) {
	
final String uname="***";
	final String pwd="***";
	
	
	Properties props= new Properties();
	props.put("mail.smtp.auth","true");
	props.put("mail.smtp.starttls.enable","true");
	props.put("mail.smtp.ssl.trust","smtp.gmail.com");
	props.put("mail.smtp.host","smtp.gmail.com");
	props.put("mail.smtp.port","587");
	int i=0;
	Session ss = Session.getInstance(props,new javax.mail.Authenticator(){
	protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(uname,pwd);
	}
	});
	
	  try
      { 
         String s = new String();
         s= email ;
       
                  Message message = new MimeMessage(ss);
                  message.setFrom(new InternetAddress(uname));
                  message.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
                  message.setSubject("MAIL");
                  MimeMultipart multipart= new  MimeMultipart("related") ;
                  BodyPart messageBodyPart = new MimeBodyPart();
                  String bdy = "<h1 style=\"color:red\">You have been Shortlisted</h1><br><br>";
                  messageBodyPart.setContent(bdy,"text/html");
                  multipart.addBodyPart(messageBodyPart);
                  message.setContent(multipart);
                  Transport.send(message);
          }
    
         
      
     
      catch(Exception e)
  {
	  System.out.println(e);
  }
	
	

	  

}}

