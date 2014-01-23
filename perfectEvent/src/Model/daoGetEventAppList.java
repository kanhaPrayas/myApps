package Model;
import java.sql.*;

public class daoGetEventAppList {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanGetEventAppList create(beanGetEventAppList bean) {
		   boolean flag = false;
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   String sql="select id, name, about, contact, imgUrl, schedule from eventApp where id='"+bean.getAppId()+"'";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      while(rs.next()){
		    	  	bean.setResultSet("appId", rs.getString(1));
		    	  	bean.setResultSet("name", rs.getString(2));
		    	  	bean.setResultSet("about", rs.getString(3));
		    	  	bean.setResultSet("contact", rs.getString(4));
		    	  	bean.setResultSet("imgUrl", rs.getString(5));
		    	  	bean.setResultSet("schedule", rs.getString(6));
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
