package Model;
import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDAO 	
{
   Connection currentCon = null;
   ResultSet rs = null;  

   ConnectionManager connectionManager = new ConnectionManager();
  
	
   public  UserBean login(UserBean bean) {
	   bean.setValid(false);
	   currentCon = connectionManager.getConnection();
      //preparing some objects for connection 
	   boolean flag = true;
      Statement stmt = null;    
      boolean firstLoginMobile = bean.getFirstLoginMobile();
      System.out.println("User dao says firstLoginMobile is "+firstLoginMobile);
      String userName = bean.getUserName();    
      System.out.println("User name is"+userName);
      
      String searchQuery =
            "select * from register where userName='"
                     + userName
                     
                     + "' and registrationStatus = 1";
                     
	    
   // "System.out.println" prints in the console; Normally used to trace the process
   System.out.println("Your user name is " + userName);          
  
   System.out.println("Query: "+searchQuery);
   
	    
   try 
   {
      //connect to DB 
	  
      
      stmt=currentCon.createStatement();
      rs = stmt.executeQuery(searchQuery);	        
      boolean more = rs.next();
	       
      // if user does not exist set the isValid variable to false
      if (!more) 
      {
         System.out.println("Sorry, you are not a registered user! Please sign up first");
        
      } 
	        
      //if user exists set the isValid variable to true
      else if (more) 
      {
         String name = rs.getString("name");
	     String id=rs.getString("id");	
	     String appId=rs.getString("appId");
	     String email=rs.getString("email");
	     String fbUserName = rs.getString("fbUserName");;
         System.out.println("Welcome " + name);
         bean.setName(name);
         bean.setUserId(id);
         bean.setEmail(email);
         bean.setAppId(appId);
         bean.setFbUserName(fbUserName);
      }
   } 
  
   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
   } 
	
   //some exception handling
   finally 
   {

   }
   bean.setValid(flag);
   System.out.println("flag is "+bean.getFirstLoginMobile());
   if(bean.getFirstLoginMobile()) {
	   System.out.println("flag is "+bean.getFirstLoginMobile());
	   String sql="update register set deviceId ='"+bean.getDeviceId()+"' where userName='"+bean.getUserName()+"'" ;
	   try 
	   {
		   Statement statement  = currentCon.createStatement();
		   int x=statement.executeUpdate(sql);
		   if(x==1){
			   bean.setValid(true);
			   pushAndroid push = new pushAndroid();
				ArrayList<String> androidDevicesList = new ArrayList<String>();
				androidDevicesList.add(bean.getDeviceId());
				push.push(androidDevicesList,"Thank you for using with advaita2k14 mobile app!! Enjoy Events,updates, forum and Rosei Quiz on your finger tip!!!!!");
		   } 
		   else
		   {
			   bean.setValid(false);
		   }
	
	   }
	   
	   catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally {
		        try {
		            if (rs == null)	{
		                try {
		                   rs.close();
		                } catch (Exception e) {}
		                  
		                }
		       	
		             if (stmt != null) {
		                try {
		                   stmt.close();
		                } catch (Exception e) {}
		                   stmt = null;
		                }
		       	
		             if (currentCon != null) {
		                try {
		                   currentCon.close();
		                } catch (Exception e) {
		                }

		                currentCon = null;
		             }
		        } catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
		        }
		  
		  }
   }
   return bean;
	
   }
   public int getSalt(UserBean bean)
   {
	   currentCon = connectionManager.getConnection();
	   int salt=0;
	   Statement stmt = null; 
	   String userName = bean.getUserName();
	   String searchQuery =
	            "select salt from register where userName ='"
	                     + userName
	                     + "' and registrationStatus = 1";
	   System.out.println("Query is "+searchQuery);
	                     
	   try 
	   {
	      //connect to DB 
		   
	      stmt=currentCon.createStatement();
	     
	      rs = stmt.executeQuery(searchQuery);	
	      
	      boolean more = rs.next();
	      System.out.println("More"+more);  
	      // if user does not exist set the isValid variable to false
	      if (!more) 
	      {
	         System.out.println("Sorry, you are not a registered user! Please sign up first");
	         
	      } 
	           
	      //if user exists set the isValid variable to true
	      else if (more) 
	      {
	        salt=rs.getInt("salt");
	        System.out.println("Salt is"+salt);
	      }
	   } 

	   catch (Exception ex) 
	   {
	      System.out.println("Log In failed: An Exception has occurred! " + ex);
	   } 
		    
	   //some exception handling
	   finally 
	   {
	      if (rs == null)	{
	         try {
	            rs.close();
	         } catch (Exception e) {}
	           
	         }
		
	      if (stmt != null) {
	         try {
	            stmt.close();
	         } catch (Exception e) {}
	            stmt = null;
	         }
		
	      if (currentCon != null) {
	         try {
	            currentCon.close();
	         } catch (Exception e) {
	         }

	         currentCon = null;
	      }
	   }


	   
	  return salt; 
   }
   public int getHash(UserBean bean)
   {
	   currentCon = connectionManager.getConnection();
	   int hval=0;
	   Statement stmt = null; 
	   String userName = bean.getUserName(); 
	   String searchQuery =
	            "select password from register where userName='"
	                     + userName
	                     + "' and registrationStatus = 1";
	                     
	   try 
	   {
	      //connect to DB 
	      stmt=currentCon.createStatement();
	      rs = stmt.executeQuery(searchQuery);	        
	      boolean more = rs.next();
		       
	      // if user does not exist set the isValid variable to false
	      if (!more) 
	      {
	         System.out.println("Sorry, you are not a registered user! Please sign up first");
	         
	      } 
		        
	      //if user exists set the isValid variable to true
	      else if (more) 
	      {
	        hval=rs.getInt("password");
	      }
	   } 

	   catch (Exception ex) 
	   {
	      System.out.println("Log In failed: An Exception has occurred! " + ex);
	   } 
		    
	   //some exception handling
	   finally 
	   {
	      if (rs == null)	{
	         try {
	            rs.close();
	         } catch (Exception e) {}
	           
	         }
		
	      if (stmt != null) {
	         try {
	            stmt.close();
	         } catch (Exception e) {}
	            stmt = null;
	         }
		
	      if (currentCon != null) {
	         try {
	            currentCon.close();
	         } catch (Exception e) {
	         }

	         currentCon = null;
	      }
	   } 
	  return hval; 
   }
}
