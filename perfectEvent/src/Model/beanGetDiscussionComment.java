package Model;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class beanGetDiscussionComment {
	JSONArray list = new JSONArray();
	JSONObject obj = new JSONObject();
	String appId, topicId, exception;
	boolean valid;
    public void setAppId(String bAppId)
	  {
   	 	appId=bAppId;
	  }
    public void setTopicId(String bTopicId)
	  {
   	 	topicId=bTopicId;
	  }
    public void setResultSetList(JSONObject obj)
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
    public String getTopicId()
	  {
    	return topicId;
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