package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
public class daoGetDiscussionTopic {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanGetDiscussionTopic create(beanGetDiscussionTopic bean) {
		   boolean flag = false;
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   String sql="select id, appId, name, email, fbUserName, topicTitle, topicSummary, CONVERT_TZ(updatedDateTime, '+00:00', '+05:30') as updatedDateTime from discussionTopic where appId='"+bean.getAppId()+"' order by updatedDateTime desc;";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      while(rs.next()){
		    	    JSONObject obj = new JSONObject();
		    	    obj.put("discussionId",rs.getString(1));
		    	    obj.put("appId",rs.getString(2));
		    	    obj.put("name",rs.getString(3));
		    	    obj.put("email",rs.getString(4));
		    	    obj.put("fbUserName",rs.getString(5));
		    	    obj.put("topicTitle",rs.getString(6));
		    	    obj.put("topicSummary",rs.getString(7));
		    	    obj.put("updatedDateTime",rs.getString(8));
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