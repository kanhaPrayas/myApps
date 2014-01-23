package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
public class daoGetDiscussionComment {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanGetDiscussionComment create(beanGetDiscussionComment bean) {
		   boolean flag = false;
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   String sql="select id, name, email, fbUserName, message, CONVERT_TZ(postDateTime, '+00:00', '+05:30') as postDateTime from discussionComment where appId='"+bean.getAppId()+"' and topicId='"+bean.getTopicId()+"' order by postDateTime asc;";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      while(rs.next()){
		    	    JSONObject obj = new JSONObject();
		    	    obj.put("commentId",rs.getString(1));
		    	    obj.put("name",rs.getString(2));
		    	    obj.put("email",rs.getString(3));
		    	    obj.put("fbUserName",rs.getString(4));
		    	    obj.put("message",rs.getString(5));
		    	    obj.put("postDateTime",rs.getString(6));
		    	  	bean.setResultSetList(obj); 
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