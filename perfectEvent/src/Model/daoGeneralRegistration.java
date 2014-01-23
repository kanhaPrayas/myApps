package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


public class daoGeneralRegistration {
	public beanGeneralRegistration create(beanGeneralRegistration bean) 
	{
		Connection con=null;
		String sql="insert into register (appId,Name,registrationDate,registrationStatus,registrationUuid,feeReceived,feeStatus,email,year,branch,college,mobileNo,mobileOs,mobileImei,mobileSim,deviceId,fbUserName,userName,salt,password)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		hash hs=new hash();
		int salt=hs.getSalt();
		int hashed=hs.getHash(bean.getPassword(), salt);
		PreparedStatement ps=null;
		ConnectionManager cm=new ConnectionManager();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();		   
	    String dt=dateFormat.format(date);
	    UUID id = UUID.randomUUID();
	    sendMail sm=new sendMail();
		try
		{
			con=cm.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2,bean.getName());
			ps.setString(3,dt);
			ps.setInt(4, 0);
			ps.setString(5, String.valueOf(id));
			ps.setDouble(6,Double.parseDouble(bean.getFeeReceived()));
			ps.setInt(7, 0);
			ps.setString(8, bean.getEmail());
			ps.setInt(9,Integer.parseInt(bean.getYear()));
			ps.setString(10, bean.getBranch());
			ps.setString(11, bean.getCollege());
			ps.setString(12, bean.getMobileNo());
			ps.setString(13, bean.getMobileOs());
			ps.setString(14, bean.getMobileImei());
			ps.setString(15, bean.getMobileSim());
			ps.setString(16, bean.getDeviceId());
			ps.setString(17, bean.getFbUserName());
			ps.setString(18, bean.getUserName());
			ps.setInt(19, salt);
			ps.setInt(20, hashed);
			Boolean flag=true;
			flag=ps.execute();
			if(!flag)
			{
				bean.setValid(true);
				String to =bean.getEmail();
				 String subject = "ADVAITA`14 Registration Successful";
				 String body="Congratulations !!! "+bean.getName()+",\n\n"+ 
				 "Your ADVAITA'14 account has been created successfully and we are pleased to count you among our community.\n"+
				 "We recommend you to keep this email to check your credentials, in case you forgot.\nUserName: "+bean.getUserName()+"\nPassword: "+bean.getPassword()+"\n\n"+
				 "\n Click on the link below, to validate your email id with your Advaita Account.\n http://advaita.iiit-bh.ac.in:8080/perfectEvent/Servlet/validateEmail?aswert="+String.valueOf(id)+"\n\nRegards,\nTeam Advaita !";
				 sm.sendValidateMail(subject, body, to);
				pushAndroid push = new pushAndroid();
				ArrayList<String> androidDevicesList = new ArrayList<String>();
				androidDevicesList.add(bean.getDeviceId());
				push.push(androidDevicesList,"Thank you for registering with advaita2k14 mobile \napp!! Enjoy forum and Rosei Quiz !!!!!");
			}
			else
				bean.setValid(false);
			
			
		}
		catch(SQLException se){
			  //Handle errors for JDBC
		   	  bean.setException(se.toString());
		      se.printStackTrace();
		   }catch(Exception e){
			   //Handle errors for Class.forName
			   bean.setException(e.toString());
			   e.printStackTrace();
		   }finally {
		        try {
		          con.close();
		        } catch (SQLException e) {}  
		   }
		
		
		
		return bean;
	}

}
