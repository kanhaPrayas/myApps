package Model;
import java.sql.*;

import org.json.simple.JSONObject;

public class daoUploadDiscussionTopic {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanUploadDiscussionTopic create(beanUploadDiscussionTopic bean) {
		   boolean flag = false;
		   PreparedStatement ps=null;
		   System.out.println("here inside dao");
		   currentCon = connectionManager.getConnection();
		   String q ="insert into discussionTopic(appId, name, email, fbUserName, topicTitle, topicSummary, postDateTime, updatedDateTime) values(?,?,?,?,?,?,?,?)";
		   try 
		   {
		      ps=currentCon.prepareStatement(q);
		      ps.setString(1, bean.getAppId());
		      ps.setString(2, bean.getName());
		      ps.setString(3, bean.getEmail());
		      ps.setString(4, bean.getFbUserName());
		      ps.setString(5, bean.getTopicTitle());
		      ps.setString(6, bean.getTopicSummary());
		      ps.setString(7, bean.getPostDateTime());
		      ps.setString(8, bean.getUpdatedDateTime());
		      flag =ps.execute();
		      System.out.println("Flag is"+flag);
		      bean.setValid(!flag);
		      ps.close();
			   PreparedStatement stmt=null;
			   ResultSet rs;
			   String sql="select max(id) as id from discussionTopic;";
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      while(rs.next()){
		    	  bean.setTopicId(rs.getString(1));
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
