package Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
 
public class configApp 
{
    public static void main( String[] args )
    {
    	Properties prop = new Properties();
    	System.out.println("Java is working");
    	try {
  		//set the properties value
    		prop.setProperty("dbString", "jdbc:mysql://isg.ckxeqppuynxw.us-east-1.rds.amazonaws.com/eventApp?");
    		prop.setProperty("dbUser", "amaya");
    		prop.setProperty("dbPassword", "amayaRanjanDas");
    		prop.setProperty("gcmSenderId", "AIzaSyAe-qzrCLMXg3e3DRYN5uVwtuRrFjXDn0c");
    		
    		//save properties to project root folder
    		prop.store(new FileOutputStream("/Users/MaaBapa/Documents/workspace/perfectEvent/src/Model/config.properties"), null); 
    		prop.store(new FileOutputStream("/Users/MaaBapa/Documents/workspace/perfectEvent/WebContent/WEB-INF/config.properties"), null); 
    	}catch (IOException ex) {
   		ex.printStackTrace();
        }
    }
}