package Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
public class pushAndroid {
    public  void push(ArrayList<String> androidDevicesList, String msg){
    //public static void main(String args[]) {
    	//ArrayList<String> androidDevicesList = new ArrayList<String>();
    	//androidDevicesList.add("APA91bEAgLsC-WE6hPmDRlby8fWuuer535BPtRciJ9nA5jgWuAg4WPBU4WkrmtlBhXWxH5SGa3myPdHAjtquAG4I4ujwtnvi7yQkcX3PfFn8bGX_SQKfdLjOiGgNX-iHaW6PB0ip6Z4t");
    	//androidDevicesList.add("APA91bEqNhWvVjIOjwLblvwv8tGxEbN6Uo51NuNQDOrqPL3lXODlHPp-ZrbsbltS6AqP5o39ktkRVrzFuGXqV4gXJ92Yg7FUIJ3D-b6Dh9RDGTHSVwvswhg-VzIv_aKbssUmlbVmgG5E");

    	//String msg = "Chua kana karuchu kie class nauchi ...... This is called notification. Every body will get such on using the app. AND I will communicate with neha through this :)";
    	try {
    		System.out.println("In Push Android");
    		
    		Properties prop = new Properties();
    		prop.load(new FileInputStream("/usr/share/tomcat6/webapps/perfectEvent/WEB-INF/config.properties"));
       	 	//prop.load(new FileInputStream("/Users/MaaBapa/Documents/workspace/perfectEvent/src/Model/config.properties"));
       	    Sender sender = new Sender(prop.getProperty("gcmSenderId"));
       	    //Sender sender = new Sender("AIzaSyAe-qzrCLMXg3e3DRYN5uVwtuRrFjXDn0c");
			Message message = new Message.Builder()
					.collapseKey("1")
					.timeToLive(30000)
					.delayWhileIdle(true)
					.addData("message",
							msg)
					.build();
			System.out.println("android payload: " + message+"   "+androidDevicesList);
			MulticastResult result = sender.send(message, androidDevicesList, 1);
			sender.send(message, androidDevicesList, 1);
	
			System.out.println("result = " + result.toString());
			if (result.getResults() != null) {
				int canonicalRegId = result.getCanonicalIds();
				if (canonicalRegId != 0) {
					
				}
			} else {
				int error = result.getFailure();
				System.out.println("error = " + error);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
