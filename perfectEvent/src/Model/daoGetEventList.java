package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoGetEventList {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanGetEventList create(beanGetEventList bean) {
		   boolean flag = false;
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   String sql="select id, name, about, contact, imgUrl, rules, appId, problemStatement, prizes, groupNo, leaderBoard from eventMeta where appId='"+bean.getAppId()+"' and eventGroupId='"+bean.getEventGroupId()+"';";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      while(rs.next()){
		    	  	bean.setResultSet("eventId", rs.getString(1));
		    	  	bean.setResultSet("name", rs.getString(2));
		    	  	bean.setResultSet("about", rs.getString(3));
		    	  	bean.setResultSet("contact", rs.getString(4));
		    	  	bean.setResultSet("imgUrl", rs.getString(5));
		    	  	bean.setResultSet("rules", rs.getString(6));
		    	  	bean.setResultSet("appId", rs.getString(7));
		    	  	bean.setResultSet("problemStatement", rs.getString(8));
		    	  	bean.setResultSet("prizes", rs.getString(9));
		    	  	bean.setResultSet("groupNo", rs.getString(10));
		    	  	bean.setResultSet("leaderBoard", rs.getString(11));
		    	  	bean.setResultSetList();
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