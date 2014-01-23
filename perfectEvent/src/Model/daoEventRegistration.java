package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

import org.json.simple.JSONObject;


public class daoEventRegistration {
	public beanEventRegistration create(beanEventRegistration bean) 
	{
		Connection con=null;
		int eventRegistrationId=0;
		String sql="insert into eventRegistration (eventId,feeReceived,feeStatus, registrationDate)values('"+bean.getEventId()+"','"+Double.parseDouble(bean.getFeeReceived())+"',"+00+",'"+bean.getRegistrationDate()+"')";
		Statement stmt = null;
		ConnectionManager cm=new ConnectionManager();
		System.out.println("1");
		try
		{
			System.out.println("2");
			con=cm.getConnection();
			stmt = con.createStatement();
	        int flg = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
	        
	        ResultSet rs = stmt.getGeneratedKeys();
	        System.out.println("3");
	        if (rs.next()){
	        	eventRegistrationId=rs.getInt(1);
	        	System.out.println("4"+eventRegistrationId);
	        }
			if(flg == 1)
			{	System.out.println("5");
				String sql1="insert into eventRegistered (eventRegistrationId,registrationId) values(?,?)";
				PreparedStatement ps1=null;

				try
				{
					System.out.println("6");
					PreparedStatement stmt1=null;
					stmt1=con.prepareStatement(sql1);
					stmt1.setInt(1, eventRegistrationId);
					stmt1.setString(2,bean.getUserId());
					boolean flag=stmt1.execute();
					System.out.println("7");
					if(!flag)
					{
						bean.setValid(true);
					}
					else
						bean.setValid(false);					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			}
			else
				bean.setValid(false);
			
			
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
		           con.close();
		        } catch (SQLException e) {}  
		   }
		return bean;
	}

}
