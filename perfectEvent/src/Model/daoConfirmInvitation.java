package Model;
import java.sql.*;

public class daoConfirmInvitation {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanConfirmInvitation create(beanConfirmInvitation bean) {
		   boolean flag = false;
		   PreparedStatement ps=null;
		   String q ="insert into eventRegistered(eventRegistrationId, registrationId) values(?,?)";
		   try 
		   {
			  currentCon = connectionManager.getConnection();
		      ps=currentCon.prepareStatement(q);
		      ps.setString(1, bean.getEventRegistrationId());
		      ps.setString(2, bean.getRegistrationId());
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
