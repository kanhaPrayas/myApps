package Model;
import java.sql.*;
import java.util.ArrayList;

import org.json.simple.JSONObject;

public class daoUploadQuiz {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanUploadQuiz create(beanUploadQuiz bean) {
		   boolean flag = false;
		   PreparedStatement ps=null;
		   System.out.println("here inside dao");
		   String q ="insert into roseiQuiz(appId, question, comment, answer, positiveCash, negativeCash,questionImage, postDateTime, expiryDateTime) values(?,?,?,?,?,?,?,?,?)";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
		      ps=currentCon.prepareStatement(q);
		      ps.setString(1, bean.getAppId());
		      ps.setString(2, bean.getQuestion());
		      ps.setString(3, bean.getComment());
		      ps.setString(4, bean.getAnswer());
		      ps.setString(5, bean.getPositiveCash());
		      ps.setString(6, bean.getNegativeCash());
		      ps.setString(7, bean.getQuestionImage());
		      ps.setString(8, bean.getPostDateTime());
		      ps.setString(9, bean.getExpiryTime());
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
	
		   }
		   PreparedStatement stmt=null;
		   ResultSet rs;
		   String sql="select deviceId from register where appId='"+bean.getAppId()+"'";
		   try 
		   {
			  stmt=currentCon.prepareStatement(sql);
		      rs=stmt.executeQuery();
		      bean.setValid(!flag);
		      pushAndroid push = new pushAndroid();
			  ArrayList<String> androidDevicesList = new ArrayList<String>();
		      while(rs.next()){
		    	  androidDevicesList.add(rs.getString(1));
		      }
			  push.push(androidDevicesList,"Check new Rosei Quiz of cost Rs."+bean.getPositiveCash());

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
