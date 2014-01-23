package Model;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class beanGetEventListAll {
	JSONArray list = new JSONArray();
	JSONArray subList = new JSONArray();
	JSONObject subObj = new JSONObject();
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
    public void setResultSetSubList(JSONObject subObj)
	  {
    	subList.add(subObj);
	  }
    public void setResultSetList(JSONObject obj)
	  {
    	list.add(obj);
	  }
   public void setResultSetSubListToList(String key, JSONObject subObj) {
	   obj.put(key,subObj);
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