package Model;
import java.sql.*;

public class daoEventAppUpload {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanEventAppUpload create(beanEventAppUpload bean) {
		   boolean flag = false;
		   PreparedStatement ps=null;
		   String q ="insert into eventApp(name, imgUrl, about, contact, scheduleFrom, scheduleTo, fee) values(?,?,?,?,?,?,?)";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
		      ps=currentCon.prepareStatement(q);
		      ps.setString(1, bean.getName());
		      ps.setString(2, bean.getImgUrl());
		      ps.setString(3, bean.getAbout());
		      ps.setString(4, bean.getContact());
		      ps.setString(5, bean.getFromDate());
		      ps.setString(6, bean.getToDate());
		      ps.setString(7, bean.getFee());
		      flag =ps.execute();
		      System.out.println("Flag is"+flag);
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
