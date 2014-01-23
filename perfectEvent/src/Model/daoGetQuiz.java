package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
public class daoGetQuiz {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanGetQuiz create(beanGetQuiz bean) {
		   boolean flag = false;
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   String sql="select id, appId, question, comment, answer, questionImage, positiveCash, negativeCash, postDateTime, expiryDateTime from roseiQuiz where appId='"+bean.getAppId()+"' order by id desc limit 1;";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      while(rs.next()){
		    	    JSONObject obj = new JSONObject();
		    	    obj.put("id",rs.getString(1));
		    	    obj.put("appId",rs.getString(2));
		    	    obj.put("question",rs.getString(3));
		    	    obj.put("comment",rs.getString(4));
		    	    obj.put("answer",rs.getString(5));
		    	    obj.put("questionImage",rs.getString(6));
		    	    obj.put("positiveCash",rs.getString(7));
		    	    obj.put("negativeCash",rs.getString(8));
		    	    obj.put("postDateTime",rs.getString(9));
		    	    obj.put("expiryDateTime",rs.getString(10));
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