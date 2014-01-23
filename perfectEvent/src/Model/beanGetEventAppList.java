package Model;
import org.json.simple.*;
public class beanGetEventAppList {
	JSONObject obj = new JSONObject();
	String appId, exception;
	boolean valid;
    public void setAppId(String bAppId)
	  {
   	 appId=bAppId;
	  }
    public void setResultSet(String key, String value)
	  {
    	obj.put(key,value);
	  }
    public void setValid(boolean bValid)
	  {
   	 valid=bValid;
	  }
    public void setException(String bException)
	  {
   	 exception=bException;
	  }
    public String getAppId()
	  {
    	return appId;
	  }
    public  JSONObject getResultSet()
 	  {
    	 
    	 return obj;
 	  }
    public boolean getValid()
	  {
   	 return valid;
	  } 
    public String getException()
	  {
   	 return exception;
	  }
	  
	  
}