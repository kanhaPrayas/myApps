package Model;
import java.sql.*;
import java.util.ArrayList;

public class daoUploadDiscussionComment {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanUploadDiscussionComment create(beanUploadDiscussionComment bean) {
		   boolean flag = false;
		   PreparedStatement ps=null;
		   String q ="insert into discussionComment(appId, name, email, fbUserName, topicId, message, postDateTime) values(?,?,?,?,?,?,?)";
		   String q1 ="update discussionTopic set updatedDateTime = '"+bean.getPostDateTime()+"' where id = '"+bean.getTopicId()+"';";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
		      ps=currentCon.prepareStatement(q);
		      ps.setString(1, bean.getAppId());
		      ps.setString(2, bean.getName());
		      ps.setString(3, bean.getEmail());
		      ps.setString(4, bean.getFbUserName());
		      ps.setString(5, bean.getTopicId());
		      ps.setString(6, bean.getMessage());
		      ps.setString(7, bean.getPostDateTime());
		      flag =ps.execute();
		      System.out.println("Flag is"+flag);
		      bean.setValid(!flag);
		      ps.close();
			   try 
			   {
				  currentCon = connectionManager.getConnection();
				  Statement statement  = currentCon.createStatement();
			      int val =statement.executeUpdate(q1);
			      if(val !=1)
			    	  bean.setValid(false);
			      statement.close();
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
		        
		   }
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   String sql="select name, deviceId, email from register where email=(select email from discussionTopic where id="+bean.getTopicId()+");";
		   try 
		   {
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      pushAndroid push = new pushAndroid();
		      sendMail sm=new sendMail();
			  ArrayList<String> androidDevicesList = new ArrayList<String>();
			  String name = "";
			  String email = "";
		      while(rs.next()){
		    	  name = bean.getName();
		    	  androidDevicesList.add(rs.getString(2));
		    	  email = rs.getString(3);
		      }
			  push.push(androidDevicesList,name+" has just commented on your post in advaita forum.");
			  String subject = name+" has just commented on your post in advaita forum.";
			  String body = name+" has just commented on your post. \n Login into app to view the comments.\n\nhttp://advaita.iiit-bh.ac.in\n\nRegards\n Team Advaita";
			  sm.sendValidateMail(subject, body, email);

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
