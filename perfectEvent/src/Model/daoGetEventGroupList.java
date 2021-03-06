package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
public class daoGetEventGroupList {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanGetEventGroupList create(beanGetEventGroupList bean) {
		   boolean flag = false;
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   String sql="select id, name, about, contact, imgUrl, rules, appId from eventGroupMeta where appId='"+bean.getAppId()+"'";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      while(rs.next()){
		    	    JSONObject obj = new JSONObject();
		    	    obj.put("eventId",rs.getString(1));
		    	    obj.put("name",rs.getString(2));
		    	    obj.put("about",rs.getString(3));
		    	    obj.put("contact",rs.getString(4));
		    	    obj.put("imgUrl",rs.getString(5));
		    	    obj.put("rules",rs.getString(6));
		    	    obj.put("appId",rs.getString(7));
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