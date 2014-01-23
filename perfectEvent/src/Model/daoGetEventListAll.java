package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class daoGetEventListAll {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanGetEventListAll create(beanGetEventListAll bean) {
		   boolean flag = false;
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   JSONObject tempObj = new JSONObject();
		   String sql="select id, name, about, contact, imgUrl, rules, appId from eventGroupMeta where appId='"+bean.getAppId()+"'";
		   System.out.println(sql);
		   try 
		   {
			  currentCon = connectionManager.getConnection();
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      while(rs.next()) {
		    	  	System.out.println("ID is "+rs.getString(1));
		    	  	JSONArray subList = new JSONArray();
		    	  	JSONObject obj = new JSONObject();
		    	    obj.put("eventGroupId", rs.getString(1));
		    	    obj.put("name", rs.getString(2));
		    	    obj.put("about", rs.getString(3));
		    	    obj.put("contact", rs.getString(4));
		    	    obj.put("imgUrl", rs.getString(5));
		    	    obj.put("rules", rs.getString(6));
		    	    obj.put("appId", rs.getString(7));
		    	    obj.put("head", true);
		    			   try 
		    			   {
		    				  ResultSet rs1;
		    				  String sql1="select id, name, about, contact, imgUrl, rules, appId, problemStatement, prizes, groupNo, leaderBoard from eventMeta where appId='"+bean.getAppId()+"' and eventGroupId='"+rs.getString(1)+"';";
		    				  currentCon = connectionManager.getConnection();
		    				  stmt=currentCon.prepareStatement(sql1);
		    			      rs1=stmt.executeQuery();
		    			      bean.setValid(!flag);
		    			     
		    			      while(rs1.next()){
		    			    	    JSONObject subObj = new JSONObject();
		    			    	    subObj.put("eventId", rs1.getString(1));
		    			    	    subObj.put("name", rs1.getString(2));
		    			    	    subObj.put("about", rs1.getString(3));
		    			    	    subObj.put("contact", rs1.getString(4));
		    			    	    subObj.put("imgUrl", rs1.getString(5));
		    			    	    subObj.put("rules", rs1.getString(6));
		    			    	    subObj.put("appId", rs1.getString(7));
		    			    	    subObj.put("problemStatement", rs1.getString(8));
		    			    	    subObj.put("prizes", rs1.getString(9));
		    			    	    subObj.put("groupNo", rs1.getString(10));
		    			    	    subObj.put("leaderBoard", rs1.getString(11));
		    			    	    subObj.put("leaf", true);
		    			    	    subList.add(subObj);
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
		    				   }
		    	  	 obj.put("items", subList);	
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