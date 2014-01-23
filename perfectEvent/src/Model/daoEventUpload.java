package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class daoEventUpload {

	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanEventUpload create(beanEventUpload bean) {
		   boolean flag = false;
		   PreparedStatement ps=null;
		   String q ="insert into eventMeta(name, imgUrl, about, contact, appId, rules, eventGroupId, problemStatement, prizes, groupNo, leaderBoard, scheduleFrom, scheduleTo) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
		      ps=currentCon.prepareStatement(q);
		      ps.setString(1, bean.getName());
		      ps.setString(2, bean.getImgUrl());
		      ps.setString(3, bean.getAbout());
		      ps.setString(4, bean.getContact());
		      ps.setString(5, bean.getAppId());
		      ps.setString(6, bean.getRules());
		      ps.setString(7, bean.getEventGroupId());
		      ps.setString(8, bean.getProblemStatement());
		      ps.setString(9, bean.getPrizes());
		      ps.setString(10, bean.getGroupNo());
		      ps.setString(11, bean.getLeaderBoard());
		      ps.setString(12, bean.getFromDate());
		      ps.setString(13, bean.getToDate());
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
