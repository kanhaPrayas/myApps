package Model;
import java.sql.*;

public class daoUploadSponsor {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanUploadSponsor create(beanUploadSponsor bean) {
		   boolean flag = false;
		   PreparedStatement ps=null;
		   String q ="insert into sponsors(name, imgUrl, about, contact, amount, status, appId) values(?,?,?,?,?,?,?)";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
		      ps=currentCon.prepareStatement(q);
		      ps.setString(1, bean.getName());
		      ps.setString(2, bean.getImgUrl());
		      ps.setString(3, bean.getAbout());
		      ps.setString(4, bean.getContact());
		      ps.setString(5, bean.getAmount());
		      ps.setString(6, bean.getStatus());
		      ps.setString(7, bean.getAppId());
		      flag =ps.execute();
		      bean.setValid(!flag);
		      ps.close();
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
