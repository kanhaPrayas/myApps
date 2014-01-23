package Model;

import java.sql.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConnectionManager {

   Connection con;
   String url;
         
   public Connection getConnection()
   {
     
      try
      {

         Class.forName("com.mysql.jdbc.Driver");
         
         try
         {  
        	Properties prop = new Properties();
        	prop.load(new FileInputStream("/usr/share/tomcat6/webapps/perfectEvent/WEB-INF/config.properties"));
        	 //prop.load(new FileInputStream("/Users/MaaBapa/Documents/workspace/perfectEvent/src/Model/config.properties"));
            con = DriverManager.getConnection(prop.getProperty("dbString")
                     + "user="+prop.getProperty("dbUser")+"&password="+prop.getProperty("dbPassword"));
             								
         // assuming your SQL Server's	username is "username"               
         // and password is "password"
              
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}