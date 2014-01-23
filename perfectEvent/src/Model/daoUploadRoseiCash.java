package Model;
import java.sql.*;
import java.util.ArrayList;

public class daoUploadRoseiCash {
	Connection currentCon = null;
	ConnectionManager connectionManager = new ConnectionManager();
	
	   public beanUploadRoseiCash create(beanUploadRoseiCash bean) {
		   boolean flag = false;
		   PreparedStatement ps=null;
		   String q1 ="update register set roseiCash = '"+bean.getCash()+"' where id = '"+bean.getUserId()+"';";
			   try 
			   {
				  currentCon = connectionManager.getConnection();
				  Statement statement  = currentCon.createStatement();
			      int val =statement.executeUpdate(q1);
			      if(val !=1)
			    	  bean.setValid(false);
			      else
			    	  bean.setValid(true);
			      statement.close();
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
