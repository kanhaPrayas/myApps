package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
public class daoInviteFriends {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanInviteFriends create(beanInviteFriends bean) {
		   boolean flag = false;
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   String sql="select id from register where appId='"+bean.getAppId()+"' and email = '"+bean.getEmail()+"';";
		   System.out.println(sql);
		   try 
		   {
			  currentCon = connectionManager.getConnection();
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      System.out.println(sql);
		      while(rs.next()){
		    	  	System.out.println("Id is"+rs.getString(1));
		    	  	bean.setId(rs.getString(1));
		      }
			   boolean flag1 = false;
			   PreparedStatement stmt1=null;
			   ResultSet rs1;
			   String sql1="select eventRegistered.eventRegistrationId from eventRegistered INNER JOIN eventRegistration ON eventRegistered.eventRegistrationId=eventRegistration.id where eventRegistered.registrationId="+bean.getInviterId()+" and eventRegistration.eventId="+bean.getEventId()+";";
			   try 
			   {
				  System.out.println(sql1);
				  stmt1=currentCon.prepareStatement(sql);
			      rs=stmt1.executeQuery();
			      bean.setValid(!flag);
			      while(rs.next()){
			    	  	bean.setEventRegistrationId(rs.getString(1));
			      }
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
			           currentCon.close();
			        } catch (SQLException e) {}  
			   }

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
		           currentCon.close();
		        } catch (SQLException e) {}  
		   }
		   return bean;
	   }
		
	

}