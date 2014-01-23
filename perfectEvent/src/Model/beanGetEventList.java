package Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class beanGetEventList {
	JSONArray list = new JSONArray();
	JSONObject obj = new JSONObject();
	String appId, eventGroupId, exception;
	boolean valid;
    public void setAppId(String bAppId)
	  {
   	 appId=bAppId;
	  }
    public void setEventGroupId(String bEventGroupId)
	  {
    	eventGroupId=bEventGroupId;
	  }
    public void setResultSet(String key, String value)
	  {
    	obj.put(key,value);
	  }
    public void setResultSetList()
	  {
    	list.add(obj);
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
    public String getEventGroupId()
	  {
    	return eventGroupId;
	  }
    public  JSONArray getResultSetList()
 	  { 
    	 return list;
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